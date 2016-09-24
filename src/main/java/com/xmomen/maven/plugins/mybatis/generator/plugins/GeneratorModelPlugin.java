package com.xmomen.maven.plugins.mybatis.generator.plugins;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by tanxinzheng on 16/8/28.
 */
public class GeneratorModelPlugin extends AbstractGeneratorPlugin {

    @Override
    public TemplatePropertyDefine generate(IntrospectedTable introspectedTable, TemplatePropertyDefine templatePropertyDefine) {
        // 指定模板文件
        templatePropertyDefine.setTemplateFileName(FreemarkerDefine.MODEL_TEMPLATE);
        // 输出目录
        templatePropertyDefine.setTargetFileName(templatePropertyDefine.getDomainObjectClassName()+"Model.java");
        // 模块包路径
        templatePropertyDefine.setTargetPackage(templatePropertyDefine.getModulePackage() + ".model");
        // 添加自定义参数
        return templatePropertyDefine;
    }
}
