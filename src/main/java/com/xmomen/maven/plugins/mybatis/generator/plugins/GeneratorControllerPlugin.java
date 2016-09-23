//package com.xmomen.maven.plugins.mybatis.generator.plugins;
//
//import org.mybatis.generator.api.*;
//import java.text.MessageFormat;
//import java.util.*;
//import java.util.logging.Logger;
//
///**
// * controller类代码自动生成插件
// * Created by tanxinzheng on 16/8/27.
// */
//public class GeneratorControllerPlugin extends CommonPlugin {
//
//    private static Logger logger = Logger.getLogger(GeneratorQueryModelPlugin.class.getName());
//    // 模板文件（包含路径）
//    private String templateFile;
//    private String requestMapping;
//    // 目标包名
//    private String targetPackage;
//
//    @Override
//    public boolean validate(List<String> list) {
//        return true;
//    }
//
//    private void validateProperty(){
//        modulePackage = getModulePackage();
//        if(targetPackage == null && modulePackage == null){
//            throw new IllegalArgumentException(MessageFormat.format("The targetPackage property of the {0} must be not null", getClass().getSimpleName()));
//        }
//        if(requestMapping == null){
//            throw new IllegalArgumentException(MessageFormat.format("The requestMapping property of the {0} must be not null", "table for controller"));
//        }
//    }
//
//    private void setProperty(){
//        templateFile = this.getProperties().getProperty("templateFile");
//        targetPackage = this.getProperties().getProperty("targetPackage");
//    }
//
//    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
//        logger.info(MessageFormat.format("Generating Controller class for {0}", introspectedTable.getTableConfiguration().getTableName()));
//        requestMapping = introspectedTable.getTableConfiguration().getProperty("requestMapping");
//        setProperty();
//        validateProperty();
//        if(modulePackage != null && targetPackage == null){
//            targetPackage = modulePackage + ".controller";
//        }
//        TemplatePropertyDefine templatePropertyDefine = new TemplatePropertyDefine(
//                "{0}Controller.java",
//                targetPackage,
//                FreemarkerDefine.CONTROLLER_TEMPLATE);
//        if(templateFile != null){
//            templatePropertyDefine.setTemplateFileName(templateFile);
//        }
//        Map map = new HashMap();
//        map.put("requestMapping", requestMapping);
//        commonGenerator(introspectedTable, templatePropertyDefine, map);
//        return null;
//    }
//
//}
