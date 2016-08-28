package com.xmomen.maven.plugins.mybatis.generator.plugins;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * QueryModel类代码自动生成插件
 * Created by tanxinzheng on 16/8/27.
 */
public class GeneratorCreateModelPlugin extends CommonPlugin {

    private static Logger logger = Logger.getLogger(GeneratorCreateModelPlugin.class.getName());
    // 模板文件（包含路径）
    private String templateFile;
    // 目标包名
    private String targetPackage;

    @Override
    public boolean validate(List<String> list) {
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

    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        logger.info(MessageFormat.format("Generating CreateModel class for {0}", introspectedTable.getTableConfiguration().getTableName()));
        setProperty();
        validateProperty();
        if(modulePackage != null && targetPackage == null){
            targetPackage = modulePackage + ".model";
        }
        TemplatePropertyDefine templatePropertyDefine = new TemplatePropertyDefine(
                "Create{0}.java",
                targetPackage,
                FreemarkerDefine.CREATE_MODEL_TEMPLATE);
        if(templateFile != null){
            templatePropertyDefine.setTemplateFileName(templateFile);
        }
        Map map = new HashMap();
        commonGenerator(introspectedTable, templatePropertyDefine, map);
        return null;
    }

}
