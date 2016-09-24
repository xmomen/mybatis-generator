package com.xmomen.maven.plugins.mybatis.generator.plugins;

/**
 * Created by tanxinzheng on 16/8/28.
 */
public class FreemarkerDefine {

    private static String PREFIX = ".ftl";
    public static String CONTROLLER_TEMPLATE= "controller" + PREFIX;
    public static String SERVICE_TEMPLATE= "service" + PREFIX;
    public static String SERVICE_IMPL_TEMPLATE= "serviceImpl" + PREFIX;
    public static String MAPPER_TEMPLATE= "mapper" + PREFIX;
    public static String MAPPER_XML_TEMPLATE= "mapper-xml" + PREFIX;
    public static String MODEL_TEMPLATE= "model" + PREFIX;
    public static String CREATE_MODEL_TEMPLATE= "createModel" + PREFIX;
    public static String QUERY_MODEL_TEMPLATE= "queryModel" + PREFIX;
    public static String UPDATE_MODEL_TEMPLATE= "updateModel" + PREFIX;

    public static String JS_API_TEMPLATE= "js-api" + PREFIX;
    public static String LIST_JS_TEMPLATE= "list-js" + PREFIX;
    public static String LIST_HTML_TEMPLATE= "list-html" + PREFIX;
    public static String JS_NG_MODULE_TEMPLATE= "js-module" + PREFIX;
}
