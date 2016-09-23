package com.xmomen.maven.plugins.mybatis.generator.plugins;

import com.alibaba.fastjson.JSONObject;
import com.xmomen.maven.plugins.mybatis.generator.plugins.utils.FreemarkerUtils;
import com.xmomen.maven.plugins.mybatis.generator.plugins.utils.JSONUtils;
import com.xmomen.maven.plugins.mybatis.generator.plugins.utils.PluginUtils;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.mybatis.generator.api.GeneratedJavaFile;
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
import java.util.ArrayList;
import java.util.List;
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
        templatePropertyDefine.setDomainObjectClass(PluginUtils.getUpperCaseString(domainObjectName));
        templatePropertyDefine.setTableName(tableName);
        templatePropertyDefine.setModulePackage(introspectedTable.getTableConfiguration().getProperty("modulePackage"));
        templatePropertyDefine.setTargetProject(this.context.getJavaModelGeneratorConfiguration().getTargetProject());
        templatePropertyDefine.setTableComment(introspectedTable.getTableConfiguration().getProperty("tableComment"));
        templatePropertyDefine.setModuleName(introspectedTable.getTableConfiguration().getProperty("moduleName"));
        templatePropertyDefine.setWebappModuleRootDir(introspectedTable.getTableConfiguration().getProperty("webappModuleRootDir"));
        templatePropertyDefine.setWebappRootDir(introspectedTable.getTableConfiguration().getProperty("webappRootDir"));
        List<TemplatePropertyDefine.FieldDefine> fieldDefineList = new ArrayList<>();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            TemplatePropertyDefine.FieldDefine fieldDefine = templatePropertyDefine.new FieldDefine();
            fieldDefine.setFieldName(introspectedColumn.getFullyQualifiedJavaType().getShortName());
            fieldDefine.setJavaProperty(introspectedColumn.getJavaProperty());
            fieldDefine.setFieldComment(introspectedColumn.getRemarks());
            fieldDefine.setPrimaryKey(introspectedColumn.isIdentity());
            fieldDefineList.add(fieldDefine);
        }
        templatePropertyDefine.setFieldList(fieldDefineList);
        JSONUtils.printJson(JSONObject.toJSONString(templatePropertyDefine));
        return templatePropertyDefine;
    }

    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        setParameter(introspectedTable);
        generate(introspectedTable, templatePropertyDefine);
        mainGenerate();
        return null;
    }

    public abstract void generate(IntrospectedTable introspectedTable, TemplatePropertyDefine templatePropertyDefine);

    private void mainGenerate(){
        try {
            Template template = FreemarkerUtils.getTemplate(templatePropertyDefine.getTemplateFileName());
            File file = new DefaultShellCallback(false).getDirectory(templatePropertyDefine.getTargetProject(), templatePropertyDefine.getTargetPackage().replace(".", "/"));
            //String classpath = AbstractGeneratorPlugin.class.getClassLoader().getResource("").getPath();
//            ClassLoader classLoader = getClass().getClassLoader();
//            String path = classpath + templatePropertyDefine.getTargetPackage().replace(".", "/");
//            File file = new File(path);
            Writer out = new FileWriter(new File(file, templatePropertyDefine.getTargetFileName()));
            template.process(templatePropertyDefine, out);
            out.flush();
            out.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ShellException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validate(List<String> warnings){
        return true;
    }


}
