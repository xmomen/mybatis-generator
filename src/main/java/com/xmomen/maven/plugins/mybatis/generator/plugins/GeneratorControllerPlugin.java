package com.xmomen.maven.plugins.mybatis.generator.plugins;

import org.mybatis.generator.api.*;

/**
 * controller类代码自动生成插件
 * Created by tanxinzheng on 16/8/27.
 */
public class GeneratorControllerPlugin extends AbstractGeneratorPlugin {

    @Override
    public TemplatePropertyDefine generate(IntrospectedTable introspectedTable, TemplatePropertyDefine templatePropertyDefine) {
        // 指定模板文件
        templatePropertyDefine.setTemplateFileName(FreemarkerDefine.CONTROLLER_TEMPLATE);
        // 输出目录
        templatePropertyDefine.setTargetFileName(templatePropertyDefine.getDomainObjectClassName() + "Controller.java");
        // 模块包路径
        templatePropertyDefine.setTargetPackage(templatePropertyDefine.getModulePackage() + ".controller");
        // 添加自定义参数
//        templatePropertyDefine.setRestMapping(introspectedTable.getTableConfiguration().getProperty("restMapping"));
        return templatePropertyDefine;
    }

}
