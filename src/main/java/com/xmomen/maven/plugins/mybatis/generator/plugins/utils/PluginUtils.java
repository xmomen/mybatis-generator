package com.xmomen.maven.plugins.mybatis.generator.plugins.utils;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;

/**
 * Created by jengt_000 on 2014/12/27.
 */
public class PluginUtils {

    public static boolean isPrimaryKeyColumn(IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable) {
        return introspectedColumn.getActualColumnName().equals(getPrimaryKeyColumn(introspectedTable).getActualColumnName());
    }

    public static IntrospectedColumn getPrimaryKeyColumn(IntrospectedTable introspectedTable) {
        IntrospectedColumn primaryKeyIntrospectedColumn = null;

        for (IntrospectedColumn introspectedColumn : introspectedTable.getPrimaryKeyColumns()) {
            primaryKeyIntrospectedColumn = introspectedColumn;
        }
        return primaryKeyIntrospectedColumn;
    }

    public static String getUpperCaseString(String inputString) {
        StringBuilder sb = new StringBuilder(inputString);

        if (inputString != null && inputString.length() > 0) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        return sb.toString();
    }

    public static String getLowerCaseString(String inputString) {
        StringBuilder sb = new StringBuilder(inputString);

        if (inputString != null && inputString.length() > 0) {
            sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
        }

        return sb.toString();
    }

}
