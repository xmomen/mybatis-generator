package ${targetPackage};

import com.xmomen.framework.mybatis.page.Page;
import ${modulePackage}.model.Create${DomainObjectName};
import ${modulePackage}.model.Query${DomainObjectName};
import ${modulePackage}.model.Update${DomainObjectName};
import ${modulePackage}.model.${DomainObjectName};
import org.apache.ibatis.exceptions.TooManyResultsException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tanxinzheng on ${.now}.
 */
public interface ${DomainObjectName}Service {

    /**
     * 新增${tableComment}
     * @param  create${DomainObjectName}   新增${tableComment}对象参数
     * @return  ${DomainObjectName}    ${tableComment}领域对象
     */
    public ${DomainObjectName} create${DomainObjectName}(Create${DomainObjectName} create${DomainObjectName});

    /**
     * 更新${tableComment}
     * @param update${DomainObjectName}    更新${tableComment}对象参数
     */
    public void update${DomainObjectName}(Update${DomainObjectName} update${DomainObjectName});

    /**
     * 删除${tableComment}
     * @param ids   主键数组
     */
    public void delete${DomainObjectName}(Serializable[] ids);

    /**
     * 查询${tableComment}分页对象（带参数条件）
     * @param query${DomainObjectName} 查询参数
     * @param limit     每页最大数
     * @param offset    页码
     * @return Page<${DomainObjectName}>   ${tableComment}参数对象
     */
    public Page<${DomainObjectName}> get${DomainObjectName}Page(int limit, int offset, Query${DomainObjectName} query${DomainObjectName});

    /**
     * 查询${tableComment}分页对象（无参数条件）
     * @param limit
     * @param offset
     * @return
     */
    public Page<${DomainObjectName}> get${DomainObjectName}Page(int limit, int offset);

    /**
     * 查询${tableComment}集合对象（带参数条件）
     * @param query${DomainObjectName}
     * @return
     */
    public List<${DomainObjectName}> get${DomainObjectName}List(Query${DomainObjectName} query${DomainObjectName});

    /**
     * 查询${tableComment}集合对象（无参数条件）
     * @return
     */
    public List<${DomainObjectName}> get${DomainObjectName}List();

    /**
     * 根据主键查询单个对象
     * @param id
     * @return
     */
    public ${DomainObjectName} getOne${DomainObjectName}(Serializable id);

    /**
     * 根据查询参数查询单个对象（此方法只用于提供精确查询单个对象，若结果数超过1，则会报错）
     * @param query${DomainObjectName}
     * @return
     */
    public ${DomainObjectName} getOne${DomainObjectName}(Query${DomainObjectName} query${DomainObjectName}) throws TooManyResultsException;
}
