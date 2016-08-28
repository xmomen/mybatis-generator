package ${targetPackage};

import lombok.Data;

import java.io.Serializable;

/**
 * Created by tanxinzheng on ${.now}.
 */
public @Data class Query${DomainObjectName} implements Serializable {

    private String keyword;
    private Serializable id;
    private Serializable[] ids;
    private Serializable[] excludeIds;

}
