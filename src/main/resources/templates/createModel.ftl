package ${targetPackage};

import lombok.Data;

<#if columnImports?exists>
    <#list columnImports?keys as mykey>
    import ${mykey};
    </#list>
</#if>
import java.io.Serializable;

/**
 * Created by tanxinzheng on ${.now}.
 */
public @Data class Create${domainObjectClassName} implements Serializable {

<#if columnList?exists>
    <#list columnList as column>
    private ${column['shortName']} ${column['javaProperty']};
    </#list>
</#if>

}
