package com.xmomen.maven.plugins.mybatis.generator.plugins;

import com.xmomen.maven.plugins.mybatis.generator.plugins.utils.FreemarkerUtils;
import com.xmomen.maven.plugins.mybatis.generator.plugins.utils.PluginUtils;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.util.JavaBeansUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tanxinzheng on 16/8/28.
 */
public class CommonPlugin extends PluginAdapter {

    protected String modulePackage;

    protected String getModulePackage(){
        return this.getContext().getProperties().getProperty("modulePackage");
    }

    public TemplatePropertyDefine getTemplatePropertyDefine(IntrospectedTable introspectedTable, TemplatePropertyDefine templatePropertyDefine){
        modulePackage = this.getContext().getProperties().getProperty("modulePackage");
        String tableName = introspectedTable.getTableConfiguration().getTableName();
        String camelTableName = JavaBeansUtil.getCamelCaseString(introspectedTable.getTableConfiguration().getTableName(), false);
        String domainObjectName = camelTableName;
        if(introspectedTable.getTableConfiguration().getDomainObjectName() != null){
            domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        }
        templatePropertyDefine.setTargetFileName(MessageFormat.format(templatePropertyDefine.getTargetFileName(), PluginUtils.getUpperCaseString(domainObjectName)));
        templatePropertyDefine.setDomainObjectName(domainObjectName);
        templatePropertyDefine.setTableName(tableName);
        templatePropertyDefine.setModulePackage(modulePackage);
        templatePropertyDefine.setTargetProject(this.context.getJavaModelGeneratorConfiguration().getTargetProject());
        return templatePropertyDefine;
    }

    public void commonGenerator(IntrospectedTable introspectedTable, TemplatePropertyDefine templatePropertyDefine, Map map){
        templatePropertyDefine = getTemplatePropertyDefine(introspectedTable, templatePropertyDefine);
        Template template = FreemarkerUtils.getTemplate(templatePropertyDefine.getTemplateFileName());
        if(map == null){
            map = new HashMap();
        }
        map.put("modulePackage", templatePropertyDefine.getModulePackage());
        map.put("targetPackage", templatePropertyDefine.getTargetPackage());
        map.put("basePackage", templatePropertyDefine.getTargetPackage());
        map.put("domainObjectName", PluginUtils.getLowerCaseString(templatePropertyDefine.getDomainObjectName()));
        map.put("domainObjectClassName", PluginUtils.getUpperCaseString(templatePropertyDefine.getDomainObjectName()));
        map.put("tableComment", introspectedTable.getTableConfiguration().getProperty("tableComment"));
        List<Map> columnListMap = new ArrayList<>();
        Map<String, String> javaType = new HashMap<>();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            String packageName = introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName();
            javaType.put(packageName, packageName);
            Map<String, String> column = new HashMap();
            column.put("shortName", introspectedColumn.getFullyQualifiedJavaType().getShortName());
            column.put("javaProperty", introspectedColumn.getJavaProperty());
            columnListMap.add(column);
        }
        map.put("columnList", columnListMap);
        map.put("columnImports", javaType);
        try {
            File file = new DefaultShellCallback(false).getDirectory(templatePropertyDefine.getTargetProject(), templatePropertyDefine.getTargetPackage().replace(".", "/"));
            Writer out = new FileWriter(new File(file, templatePropertyDefine.getTargetFileName()));
            template.process(map, out);
            out.flush();
            out.close();
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
