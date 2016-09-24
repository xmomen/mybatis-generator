package com.xmomen.maven.plugins.mybatis.generator.plugins;

import com.alibaba.fastjson.JSONObject;
import com.xmomen.maven.plugins.mybatis.generator.plugins.utils.FreemarkerUtils;
import com.xmomen.maven.plugins.mybatis.generator.plugins.utils.JSONUtils;
import com.xmomen.maven.plugins.mybatis.generator.plugins.utils.PluginUtils;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang.StringUtils;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.util.JavaBeansUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by tanxinzheng on 16/8/28.
 */
public abstract class AbstractGeneratorPlugin extends PluginAdapter {

    protected Logger logger = Logger.getLogger(AbstractGeneratorPlugin.class.getName());

    TemplatePropertyDefine templatePropertyDefine;

    protected String getModulePackage(){
        return this.getContext().getProperties().getProperty("modulePackage");
    }

    public TemplatePropertyDefine setParameter(IntrospectedTable introspectedTable){
        String tableName = introspectedTable.getTableConfiguration().getTableName();
        String camelTableName = JavaBeansUtil.getCamelCaseString(introspectedTable.getTableConfiguration().getTableName(), false);
        String domainObjectName = camelTableName;
        if(introspectedTable.getTableConfiguration().getDomainObjectName() != null){
            domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        }
        templatePropertyDefine = new TemplatePropertyDefine();
        templatePropertyDefine.setDomainObjectName(PluginUtils.getLowerCaseString(domainObjectName));
        templatePropertyDefine.setTableName(tableName);
        templatePropertyDefine.setClassName(camelTableName);
        templatePropertyDefine.setDomainObjectClassName(PluginUtils.getUpperCaseString(domainObjectName));
        templatePropertyDefine.setTableName(tableName);
        templatePropertyDefine.setModulePackage(introspectedTable.getTableConfiguration().getProperty("modulePackage"));
        templatePropertyDefine.setTargetProject(this.context.getJavaModelGeneratorConfiguration().getTargetProject());
        templatePropertyDefine.setTableComment(introspectedTable.getTableConfiguration().getProperty("tableComment"));
        templatePropertyDefine.setModuleName(introspectedTable.getTableConfiguration().getProperty("moduleName"));
        String restMapping = introspectedTable.getTableConfiguration().getProperty("restMapping");
        if(StringUtils.trimToNull(restMapping) == null){
            templatePropertyDefine.setRestMapping(templatePropertyDefine.getDomainObjectName());
        }else{
            templatePropertyDefine.setRestMapping(restMapping);
        }
        templatePropertyDefine.setTargetWebDir(introspectedTable.getContext().getProperty("targetWebDir"));
        templatePropertyDefine.setTargetWebModuleDir(introspectedTable.getTableConfiguration().getProperty("targetWebModuleDir"));
        templatePropertyDefine.setTargetWebJsDir(introspectedTable.getTableConfiguration().getProperty("targetWebJsDir"));
        templatePropertyDefine.setTargetWebHtmlDir(introspectedTable.getTableConfiguration().getProperty("targetWebHtmlDir"));
        List<TemplatePropertyDefine.FieldDefine> fieldDefineList = new ArrayList<>();
        Map<String, String> importList = new HashMap<>();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            TemplatePropertyDefine.FieldDefine fieldDefine = templatePropertyDefine.new FieldDefine();
            fieldDefine.setFieldName(introspectedColumn.getFullyQualifiedJavaType().getShortName());
            fieldDefine.setJavaProperty(introspectedColumn.getJavaProperty());
            fieldDefine.setFieldComment(introspectedColumn.getRemarks());
            fieldDefine.setPrimaryKey(introspectedColumn.isSequenceColumn());
            fieldDefine.setJavaType(introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName());
            fieldDefine.setMaxLength(introspectedColumn.getLength());
            fieldDefine.setNullable(introspectedColumn.isNullable());
            fieldDefineList.add(fieldDefine);
            importList.put(fieldDefine.getJavaType(), fieldDefine.getJavaType());
        }
        templatePropertyDefine.setImportClassList(importList);
        templatePropertyDefine.setFieldList(fieldDefineList);
        //JSONUtils.printJson(JSONObject.toJSONString(templatePropertyDefine));
        return templatePropertyDefine;
    }

    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        setParameter(introspectedTable);
        templatePropertyDefine = generate(introspectedTable, templatePropertyDefine);
        if(templatePropertyDefine.isWebTemplate()){
            webGenerate(templatePropertyDefine);
        }else{
            mainGenerate(templatePropertyDefine);
        }
        return null;
    }

    public abstract TemplatePropertyDefine generate(IntrospectedTable introspectedTable, TemplatePropertyDefine templatePropertyDefine);

    private static void mainGenerate(TemplatePropertyDefine templatePropertyDefine){
        try {
            Template template = FreemarkerUtils.getTemplate(templatePropertyDefine.getTemplateFileName());
            File file = new DefaultShellCallback(false).getDirectory(templatePropertyDefine.getTargetProject(), templatePropertyDefine.getTargetPackage().replace(".", "/"));
            Writer writer = new FileWriter(new File(file, templatePropertyDefine.getTargetFileName()));
            template.process(templatePropertyDefine, writer);
            writer.flush();
            writer.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ShellException e) {
            e.printStackTrace();
        }
    }

    private static void webGenerate(TemplatePropertyDefine templatePropertyDefine){
        try {
            Template template = FreemarkerUtils.getTemplate(templatePropertyDefine.getTemplateFileName());
            String targetDir = templatePropertyDefine.getTargetWebModuleDir() + File.separator + templatePropertyDefine.getModuleName();
            // 若出现目录不存在的情况，则说明目标目录必须先创建
            File file = new DefaultShellCallback(false).getDirectory(templatePropertyDefine.getTargetWebDir(), targetDir);
            Writer writer = new FileWriter(new File(file, templatePropertyDefine.getTargetFileName()));
            template.process(templatePropertyDefine, writer);
            writer.flush();
            writer.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ShellException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validate(List<String> warnings){
        return true;
    }


}
