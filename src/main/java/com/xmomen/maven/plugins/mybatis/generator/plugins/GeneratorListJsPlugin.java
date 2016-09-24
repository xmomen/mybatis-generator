package com.xmomen.maven.plugins.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;

/**
 * Created by tanxinzheng on 16/8/28.
 */
public class GeneratorListJsPlugin extends AbstractGeneratorPlugin {

    @Override
    public TemplatePropertyDefine generate(IntrospectedTable introspectedTable, TemplatePropertyDefine templatePropertyDefine) {
        // 指定模板文件
        templatePropertyDefine.setTemplateFileName(FreemarkerDefine.LIST_JS_TEMPLATE);
        // 输出目录
        templatePropertyDefine.setTargetFileName(templatePropertyDefine.getDomainObjectName() + ".js");
        // 模块包路径
        templatePropertyDefine.setWebTemplate(true);
        // 添加自定义参数
        return templatePropertyDefine;
    }
}
