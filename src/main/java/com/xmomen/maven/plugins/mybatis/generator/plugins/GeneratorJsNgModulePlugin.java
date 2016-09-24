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
public class GeneratorJsNgModulePlugin extends AbstractGeneratorPlugin {

    @Override
    public TemplatePropertyDefine generate(IntrospectedTable introspectedTable, TemplatePropertyDefine templatePropertyDefine) {
        // 指定模板文件
        templatePropertyDefine.setTemplateFileName(FreemarkerDefine.JS_NG_MODULE_TEMPLATE);
        // 输出目录
        templatePropertyDefine.setTargetFileName(templatePropertyDefine.getDomainObjectName() + "_module.js");
        // 模块包路径
        templatePropertyDefine.setWebTemplate(true);
        // 添加自定义参数
        return templatePropertyDefine;
    }
}
