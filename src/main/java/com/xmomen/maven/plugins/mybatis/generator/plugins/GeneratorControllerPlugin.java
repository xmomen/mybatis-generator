package com.xmomen.maven.plugins.mybatis.generator.plugins;

import com.xmomen.maven.plugins.mybatis.generator.plugins.utils.FreemarkerUtils;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.DefaultJavaFormatter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.util.JavaBeansUtil;

import java.io.*;
import java.text.MessageFormat;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by tanxinzheng on 16/8/27.
 */
public class GeneratorControllerPlugin extends PluginAdapter {

    private static Logger logger = Logger.getLogger(GeneratorControllerPlugin.class.getName());

    private String targetPackage;
    private String targetProject;

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        logger.info(MessageFormat.format("Generating Controller class for {0}", introspectedTable.getTableConfiguration().getTableName()));

        String targetPackage = this.getProperties().getProperty("targetPackage");
        String targetProject = this.getProperties().getProperty("targetProject");
        String javaBeanName = JavaBeansUtil.getCamelCaseString(introspectedTable.getTableConfiguration().getDomainObjectName(), false);
        String javaBeanClassName = JavaBeansUtil.getCamelCaseString(introspectedTable.getTableConfiguration().getDomainObjectName(), true);
        String controllerClassName = MessageFormat.format("{0}Controller", javaBeanClassName);
        String targetFileName = MessageFormat.format("{0}.java", controllerClassName);
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        String tableComment = introspectedTable.getFullyQualifiedTable().getAlias();

        Template template = FreemarkerUtils.getTemplate("controller.ftl");
        Map map = new HashMap();
        map.put("javaBeanClassName", javaBeanClassName);
        map.put("javaBeanName", javaBeanName);
        map.put("targetPackage", targetPackage);
        map.put("domainObjectName", domainObjectName);
        map.put("controllerClassName", controllerClassName);
        try {
            File file = new DefaultShellCallback(false).getDirectory(targetProject, targetPackage);
            Writer out = new FileWriter(new File(file, targetFileName));
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

        // MyBatis Generator 生成方式（较为复杂）
        //GeneratedJavaFile generatedJavaFile = new GeneratedJavaFile(new TopLevelClass("controller"), targetProject, new DefaultJavaFormatter());
        List<GeneratedJavaFile> generatedJavaFileList = new ArrayList<>();
        //generatedJavaFileList.add(generatedJavaFile);
        return generatedJavaFileList;
    }

}
