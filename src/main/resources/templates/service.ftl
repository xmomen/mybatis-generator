package ${targetPackage};

import com.xmomen.framework.mybatis.page.Page;
import ${modulePackage}.model.Create${domainObjectClassName};
import ${modulePackage}.model.Query${domainObjectClassName};
import ${modulePackage}.model.Update${domainObjectClassName};
import ${modulePackage}.model.${domainObjectClassName}Model;
import ${modulePackage}.entity.${domainObjectClassName};
import org.apache.ibatis.exceptions.TooManyResultsException;

import java.io.Serializable;
import java.util.List;

<#include "header.ftl">
public interface ${domainObjectClassName}Service {

    /**
     * 新增${tableComment}
     * @param  create${domainObjectClassName}   新增${tableComment}对象参数
     * @return  ${domainObjectClassName}Model    ${tableComment}领域对象
     */
    public ${domainObjectClassName}Model create${domainObjectClassName}(Create${domainObjectClassName} create${domainObjectClassName});

    /**
     * 新增${tableComment}实体对象
     * @param   ${domainObjectName} 新增${tableComment}实体对象参数
     * @return  ${domainObjectClassName} ${tableComment}实体对象
     */
    public ${domainObjectClassName} create${domainObjectClassName}(${domainObjectClassName} ${domainObjectName});

    /**
     * 更新${tableComment}
     * @param update${domainObjectClassName}    更新${tableComment}对象参数
     */
    public void update${domainObjectClassName}(Update${domainObjectClassName} update${domainObjectClassName});

    /**
     * 更新${tableComment}实体对象
     * @param   ${domainObjectName} 新增${tableComment}实体对象参数
     * @return  ${domainObjectClassName} ${tableComment}实体对象
     */
    public void update${domainObjectClassName}(${domainObjectClassName} ${domainObjectName});

    /**
     * 删除${tableComment}
     * @param ids   主键数组
     */
    public void delete${domainObjectClassName}(Serializable[] ids);

    /**
     * 查询${tableComment}领域分页对象（带参数条件）
     * @param query${domainObjectClassName} 查询参数
     * @param limit     每页最大数
     * @param offset    页码
     * @return Page<${domainObjectClassName}Model>   ${tableComment}参数对象
     */
    public Page<${domainObjectClassName}Model> get${domainObjectClassName}ModelPage(int limit, int offset, Query${domainObjectClassName} query${domainObjectClassName});

    /**
     * 查询${tableComment}领域分页对象（无参数条件）
     * @param limit 每页最大数
     * @param offset 页码
     * @return Page<${domainObjectClassName}Model> ${tableComment}领域对象
     */
    public Page<${domainObjectClassName}Model> get${domainObjectClassName}ModelPage(int limit, int offset);

    /**
     * 查询${tableComment}领域集合对象（带参数条件）
     * @param query${domainObjectClassName} 查询参数对象
     * @return List<${domainObjectClassName}Model> ${tableComment}领域集合对象
     */
    public List<${domainObjectClassName}Model> get${domainObjectClassName}ModelList(Query${domainObjectClassName} query${domainObjectClassName});

    /**
     * 查询${tableComment}领域集合对象（无参数条件）
     * @return List<${domainObjectClassName}Model> ${tableComment}领域集合对象
     */
    public List<${domainObjectClassName}Model> get${domainObjectClassName}ModelList();

    /**
     * 查询${tableComment}实体对象
     * @param id 主键
     * @return ${domainObjectClassName} ${tableComment}实体对象
     */
    public ${domainObjectClassName} getOne${domainObjectClassName}(Serializable id);

    /**
     * 根据主键查询单个对象
     * @param id 主键
     * @return ${domainObjectClassName}Model ${tableComment}领域对象
     */
    public ${domainObjectClassName}Model getOne${domainObjectClassName}Model(Serializable id);

    /**
     * 根据查询参数查询单个对象（此方法只用于提供精确查询单个对象，若结果数超过1，则会报错）
     * @param query${domainObjectClassName} ${tableComment}查询参数对象
     * @return ${domainObjectClassName}Model ${tableComment}领域对象
     */
    public ${domainObjectClassName}Model getOne${domainObjectClassName}Model(Query${domainObjectClassName} query${domainObjectClassName}) throws TooManyResultsException;
}
