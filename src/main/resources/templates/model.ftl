package ${targetPackage};

import lombok.Data;

<#if columnImports?exists>
    <#list columnImports?keys as mykey>
import ${mykey};
    </#list>
</#if>
import java.io.Serializable;

/**
 * Created by Jeng on ${.now}.
 */
public @Data class ${domainObjectClassName}Model implements Serializable {

<#if columnList?exists>
    <#list columnList as column>
    private ${column['shortName']} ${column['javaProperty']};
    </#list>
</#if>

}
