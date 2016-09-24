package com.xmomen.maven.plugins.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;

/**
 * Mapper 类代码自动生成插件
 * Created by tanxinzheng on 16/8/27.
 */
public class GeneratorMapperJavaPlugin extends AbstractGeneratorPlugin {

    @Override
    public TemplatePropertyDefine generate(IntrospectedTable introspectedTable, TemplatePropertyDefine templatePropertyDefine) {
        // 指定模板文件
        templatePropertyDefine.setTemplateFileName(FreemarkerDefine.MAPPER_TEMPLATE);
        // 输出目录
        templatePropertyDefine.setTargetFileName(templatePropertyDefine.getDomainObjectClassName()+"MapperExt.java");
        // 模块包路径
        templatePropertyDefine.setTargetPackage(templatePropertyDefine.getModulePackage() + ".mapper");
        // 添加自定义参数
        return templatePropertyDefine;
    }

}
