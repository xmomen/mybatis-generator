package ${targetPackage};

import lombok.Data;
import ${modulePackage}.entity.${domainObjectClassName};
import org.springframework.beans.BeanUtils;

<#if columnImports?exists>
    <#list columnImports?keys as mykey>
    import ${mykey};
    </#list>
</#if>
import java.io.Serializable;

/**
 * Created by tanxinzheng on ${.now}.
 */
public @Data class Update${domainObjectClassName} implements Serializable {

<#if columnList?exists>
    <#list columnList as column>
    private ${column['shortName']} ${column['javaProperty']};
    </#list>
</#if>


    public ${domainObjectClassName} getEntity(){
        ${domainObjectClassName} ${domainObjectName} = new ${domainObjectClassName}();
        BeanUtils.copyProperties(this, ${domainObjectName});
        return ${domainObjectName};
    }
}