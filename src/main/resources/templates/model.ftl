package ${targetPackage};

import lombok.Data;

<#if importClassList?exists>
    <#list importClassList?keys as mykey>
import ${mykey};
    </#list>
</#if>
import java.io.Serializable;

<#include "header.ftl">
public @Data class ${domainObjectClassName}Model implements Serializable {

<#if fieldList?exists>
    <#list fieldList as field>
    private ${field['fieldName']} ${field['javaProperty']};
    </#list>
</#if>

}
