package ${targetPackage};

import com.xmomen.framework.mybatis.page.Page;
import ${modulePackage}.model.Create${domainObjectClassName};
import ${modulePackage}.model.Query${domainObjectClassName};
import ${modulePackage}.model.Update${domainObjectClassName};
import ${modulePackage}.model.${domainObjectClassName}Model;
import org.apache.ibatis.exceptions.TooManyResultsException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tanxinzheng on ${.now}.
 */
public interface ${domainObjectClassName}Service {

    /**
     * 新增${tableComment}
     * @param  create${domainObjectClassName}   新增${tableComment}对象参数
     * @return  ${domainObjectClassName}Model    ${tableComment}领域对象
     */
    public ${domainObjectClassName}Model create${domainObjectClassName}(Create${domainObjectClassName} create${domainObjectClassName});

    /**
     * 更新${tableComment}
     * @param update${domainObjectClassName}    更新${tableComment}对象参数
     */
    public void update${domainObjectClassName}(Update${domainObjectClassName} update${domainObjectClassName});

    /**
     * 删除${tableComment}
     * @param ids   主键数组
     */
    public void delete${domainObjectClassName}(Serializable[] ids);

    /**
     * 查询${tableComment}分页对象（带参数条件）
     * @param query${domainObjectClassName} 查询参数
     * @param limit     每页最大数
     * @param offset    页码
     * @return Page<${domainObjectClassName}Model>   ${tableComment}参数对象
     */
    public Page<${domainObjectClassName}Model> get${domainObjectClassName}Page(int limit, int offset, Query${domainObjectClassName} query${domainObjectClassName});

    /**
     * 查询${tableComment}分页对象（无参数条件）
     * @param limit
     * @param offset
     * @return Page<${domainObjectClassName}Model>
     */
    public Page<${domainObjectClassName}Model> get${domainObjectClassName}Page(int limit, int offset);

    /**
     * 查询${tableComment}集合对象（带参数条件）
     * @param query${domainObjectClassName}
     * @return List<${domainObjectClassName}Model>
     */
    public List<${domainObjectClassName}Model> get${domainObjectClassName}List(Query${domainObjectClassName} query${domainObjectClassName});

    /**
     * 查询${tableComment}集合对象（无参数条件）
     * @return List<${domainObjectClassName}Model>
     */
    public List<${domainObjectClassName}Model> get${domainObjectClassName}List();

    /**
     * 根据主键查询单个对象
     * @param id
     * @return ${domainObjectClassName}Model
     */
    public ${domainObjectClassName}Model getOne${domainObjectClassName}(Serializable id);

    /**
     * 根据查询参数查询单个对象（此方法只用于提供精确查询单个对象，若结果数超过1，则会报错）
     * @param query${domainObjectClassName}
     * @return ${domainObjectClassName}Model
     */
    public ${domainObjectClassName}Model getOne${domainObjectClassName}(Query${domainObjectClassName} query${domainObjectClassName}) throws TooManyResultsException;
}
