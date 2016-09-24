package com.xmomen.maven.plugins.mybatis.generator.plugins;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * controller类代码自动生成插件
 * Created by tanxinzheng on 16/8/27.
 */
public class GeneratorServiceImplPlugin extends AbstractGeneratorPlugin {

    @Override
    public TemplatePropertyDefine generate(IntrospectedTable introspectedTable, TemplatePropertyDefine templatePropertyDefine) {
        // 指定模板文件
        templatePropertyDefine.setTemplateFileName(FreemarkerDefine.SERVICE_IMPL_TEMPLATE);
        // 输出目录
        templatePropertyDefine.setTargetFileName(templatePropertyDefine.getDomainObjectClassName()+"ServiceImpl.java");
        // 模块包路径
        templatePropertyDefine.setTargetPackage(templatePropertyDefine.getModulePackage() + ".service.impl");
        // 添加自定义参数
        return templatePropertyDefine;
    }

}
