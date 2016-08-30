package ${targetPackage};

import lombok.Data;

import java.io.Serializable;

<#include "header.ftl">
public @Data class Query${domainObjectClassName} implements Serializable {

    private String keyword;
    private Serializable id;
    private Serializable[] ids;
    private Serializable[] excludeIds;

}
