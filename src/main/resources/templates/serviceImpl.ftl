package ${targetPackage};

import com.xmomen.demo.entity.${domainObjectClassName};
import com.xmomen.demo.entity.${domainObjectClassName}Example;
import com.xmomen.demo.mapper.${domainObjectClassName}MapperExt;
import com.xmomen.demo.model.Create${domainObjectClassName};
import com.xmomen.demo.model.Query${domainObjectClassName};
import com.xmomen.demo.model.Update${domainObjectClassName};
import com.xmomen.demo.model.${domainObjectClassName}Model;
import com.xmomen.demo.service.${domainObjectClassName}Service;
import com.xmomen.framework.mybatis.dao.MybatisDao;
import com.xmomen.framework.mybatis.page.Page;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

<#include "header.ftl">
@Service
public class ${domainObjectClassName}ServiceImpl implements ${domainObjectClassName}Service {

    @Autowired
    MybatisDao mybatisDao;

    /**
     * 新增${tableComment}
     *
     * @param create${domainObjectClassName} 新增${tableComment}对象参数
     * @return ${domainObjectClassName}Model    ${tableComment}领域对象
     */
    @Override
    @Transactional
    public ${domainObjectClassName}Model create${domainObjectClassName}(Create${domainObjectClassName} create${domainObjectClassName}) {
        ${domainObjectClassName} ${domainObjectName} = create${domainObjectClassName}(create${domainObjectClassName}.getEntity());
        if(${domainObjectName} != null){
            return getOne${domainObjectClassName}Model(${domainObjectName}.getId());
        }
        return null;
    }

    /**
     * 新增${tableComment}实体对象
     *
     * @param ${domainObjectName} 新增${tableComment}实体对象参数
     * @return ${domainObjectClassName} ${tableComment}实体对象
     */
    @Override
    @Transactional
    public ${domainObjectClassName} create${domainObjectClassName}(${domainObjectClassName} ${domainObjectName}) {
        return mybatisDao.insertByModel(${domainObjectName});
    }

    /**
     * 更新${tableComment}
     *
     * @param update${domainObjectClassName} 更新${tableComment}对象参数
     */
    @Override
    @Transactional
    public void update${domainObjectClassName}(Update${domainObjectClassName} update${domainObjectClassName}) {
        mybatisDao.update(update${domainObjectClassName}.getEntity());
    }

    /**
     * 更新${tableComment}实体对象
     *
     * @param ${domainObjectName} 新增${tableComment}实体对象参数
     * @return ${domainObjectClassName} ${tableComment}实体对象
     */
    @Override
    @Transactional
    public void update${domainObjectClassName}(${domainObjectClassName} ${domainObjectName}) {
        mybatisDao.update(${domainObjectName});
    }

    /**
     * 删除${tableComment}
     *
     * @param ids 主键数组
     */
    @Override
    @Transactional
    public void delete${domainObjectClassName}(Serializable[] ids) {
        ${domainObjectClassName}Example ${domainObjectName}Example = new ${domainObjectClassName}Example();
        ${domainObjectName}Example.createCriteria().andIdIn(Arrays.<Integer>asList((Integer[]) ids));
        mybatisDao.deleteByExample(${domainObjectName}Example);
    }

    /**
     * 查询${tableComment}领域分页对象（带参数条件）
     *
     * @param limit     每页最大数
     * @param offset    页码
     * @param query${domainObjectClassName} 查询参数
     * @return Page<${domainObjectClassName}Model>   ${tableComment}参数对象
     */
    @Override
    public Page<${domainObjectClassName}Model> get${domainObjectClassName}ModelPage(int limit, int offset, Query${domainObjectClassName} query${domainObjectClassName}) {
        return (Page<${domainObjectClassName}Model>) mybatisDao.selectPage(${domainObjectClassName}MapperExt.${domainObjectClassName}MapperNameSpace + "get${domainObjectClassName}Model", query${domainObjectClassName}, limit, offset);
    }

    /**
     * 查询${tableComment}领域分页对象（无参数条件）
     *
     * @param limit  每页最大数
     * @param offset 页码
     * @return Page<${domainObjectClassName}Model> ${tableComment}领域对象
     */
    @Override
    public Page<${domainObjectClassName}Model> get${domainObjectClassName}ModelPage(int limit, int offset) {
        return (Page<${domainObjectClassName}Model>) mybatisDao.selectPage(${domainObjectClassName}MapperExt.${domainObjectClassName}MapperNameSpace + "get${domainObjectClassName}Model", null, limit, offset);
    }

    /**
     * 查询${tableComment}领域集合对象（带参数条件）
     *
     * @param query${domainObjectClassName} 查询参数对象
     * @return List<${domainObjectClassName}Model> ${tableComment}领域集合对象
     */
    @Override
    public List<${domainObjectClassName}Model> get${domainObjectClassName}ModelList(Query${domainObjectClassName} query${domainObjectClassName}) {
        return mybatisDao.getSqlSessionTemplate().selectList(${domainObjectClassName}MapperExt.${domainObjectClassName}MapperNameSpace + "get${domainObjectClassName}Model", query${domainObjectClassName});
    }

    /**
     * 查询${tableComment}领域集合对象（无参数条件）
     *
     * @return List<${domainObjectClassName}Model> ${tableComment}领域集合对象
     */
    @Override
    public List<${domainObjectClassName}Model> get${domainObjectClassName}ModelList() {
        return mybatisDao.getSqlSessionTemplate().selectList(${domainObjectClassName}MapperExt.${domainObjectClassName}MapperNameSpace + "get${domainObjectClassName}Model");
    }

    /**
     * 查询${tableComment}实体对象
     *
     * @param id 主键
     * @return ${domainObjectClassName} ${tableComment}实体对象
     */
    @Override
    public ${domainObjectClassName} getOne${domainObjectClassName}(Serializable id) {
        return mybatisDao.selectByPrimaryKey(${domainObjectClassName}.class, id);
    }

    /**
     * 根据主键查询单个对象
     *
     * @param id 主键
     * @return ${domainObjectClassName}Model ${tableComment}领域对象
     */
    @Override
    public ${domainObjectClassName}Model getOne${domainObjectClassName}Model(Serializable id) {
        Query${domainObjectClassName} query${domainObjectClassName} = new Query${domainObjectClassName}();
        query${domainObjectClassName}.setId(id);
        return mybatisDao.getSqlSessionTemplate().selectOne(${domainObjectClassName}MapperExt.${domainObjectClassName}MapperNameSpace + "get${domainObjectClassName}Model", query${domainObjectClassName});
    }

    /**
     * 根据查询参数查询单个对象（此方法只用于提供精确查询单个对象，若结果数超过1，则会报错）
     *
     * @param query${domainObjectClassName} ${tableComment}查询参数对象
     * @return ${domainObjectClassName}Model ${tableComment}领域对象
     */
    @Override
    public ${domainObjectClassName}Model getOne${domainObjectClassName}Model(Query${domainObjectClassName} query${domainObjectClassName}) throws TooManyResultsException {
        return mybatisDao.getSqlSessionTemplate().selectOne(${domainObjectClassName}MapperExt.${domainObjectClassName}MapperNameSpace + "get${domainObjectClassName}Model", query${domainObjectClassName});
    }
}
