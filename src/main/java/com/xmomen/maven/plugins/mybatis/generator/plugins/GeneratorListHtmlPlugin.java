package com.xmomen.maven.plugins.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;

/**
 * Created by tanxinzheng on 16/8/28.
 */
public class GeneratorListHtmlPlugin extends AbstractGeneratorPlugin {

    @Override
    public TemplatePropertyDefine generate(IntrospectedTable introspectedTable, TemplatePropertyDefine templatePropertyDefine) {
        // 指定模板文件
        templatePropertyDefine.setTemplateFileName(FreemarkerDefine.LIST_HTML_TEMPLATE);
        // 输出目录
        templatePropertyDefine.setTargetFileName(templatePropertyDefine.getDomainObjectName() + ".html");
        // 模块包路径
        templatePropertyDefine.setWebTemplate(true);
        // 添加自定义参数
        return templatePropertyDefine;
    }
}
