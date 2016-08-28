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
public class GeneratorModelPlugin extends CommonPlugin {
    private static Logger logger = Logger.getLogger(GeneratorQueryModelPlugin.class.getName());
    // 模板文件（包含路径）
    private String templateFile;
    private String targetPackage;

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    private void validateProperty(){
        modulePackage = getModulePackage();
        if(targetPackage == null && modulePackage == null){
            throw new IllegalArgumentException(MessageFormat.format("The targetPackage property of the {0} must be not null", getClass().getSimpleName()));
        }
    }

    private void setProperty(){
        templateFile = this.getProperties().getProperty("templateFile");
        targetPackage = this.getProperties().getProperty("targetPackage");
    }


    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(
            IntrospectedTable introspectedTable) {
        logger.info(MessageFormat.format("Generating Model class for {0}", introspectedTable.getTableConfiguration().getTableName()));
        setProperty();
        validateProperty();
        if(modulePackage != null && targetPackage == null){
            targetPackage = modulePackage + ".model";
        }
        TemplatePropertyDefine templatePropertyDefine = new TemplatePropertyDefine(
                "{0}Model.java",
                targetPackage,
                FreemarkerDefine.MODEL_TEMPLATE);
        if(templateFile != null){
            templatePropertyDefine.setTemplateFileName(templateFile);
        }
        Map map = new HashMap();
        commonGenerator(introspectedTable, templatePropertyDefine, map);
        return null;
    }
}
