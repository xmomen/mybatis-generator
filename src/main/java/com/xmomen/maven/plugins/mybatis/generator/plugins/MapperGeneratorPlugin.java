package com.xmomen.maven.plugins.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

public class MapperGeneratorPlugin extends PluginAdapter {

    private String rootInterface;

    public boolean clientGenerated(Interface interfaze,
                                   TopLevelClass topLevelClass,
                                   IntrospectedTable introspectedTable) {
        this.rootInterface = this.properties.getProperty("rootInterface");
        if(this.rootInterface != null){
            interfaze.addSuperInterface(new FullyQualifiedJavaType(this.rootInterface));
            interfaze.addImportedType(new FullyQualifiedJavaType(this.rootInterface));
        }
        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
    }

    public boolean validate(List<String> warnings) {
        return true;
    }
}
