package com.xmomen.maven.plugins.mybatis.generator.plugins.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by tanxinzheng on 16/8/27.
 */
public class FreemarkerUtils {

    public static Template getTemplate(String name) {
        try {
            // 通过Freemaker的Configuration读取相应的ftl
            Configuration cfg = new Configuration();
            cfg.setDirectoryForTemplateLoading(new File("/Users/jeng/xmomen-repo/framework/mybatis-generator/src/main/resources/ftl"));
            // 设定去哪里读取相应的ftl模板文件
            //cfg.setClassForTemplateLoading(getClass(), "/ftl");
            // 在模板文件目录中找到名称为name的文件
            Template temp = cfg.getTemplate(name);
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 控制台输出
     *
     * @param name
     * @param root
     */
    public static void print(String name, Map<String, Object> root) {
        try {
            // 通过Template可以将模板文件输出到相应的流
            Template temp = getTemplate(name);
            temp.process(root, new PrintWriter(System.out));
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
