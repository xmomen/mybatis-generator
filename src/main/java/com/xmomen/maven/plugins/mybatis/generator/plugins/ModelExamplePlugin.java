package com.xmomen.maven.plugins.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * Created by jengt_000 on 2014/12/23.
 */
public class ModelExamplePlugin extends PluginAdapter {

    private String rootClass;

    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.rootClass = this.properties.getProperty("rootClass");
        if(this.rootClass != null){
            topLevelClass.setSuperClass(this.rootClass);
            topLevelClass.addImportedType(this.rootClass);
        }
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    public boolean validate(List<String> warnings) {
        return true;
    }
}
