package ${targetPackage};

import com.xmomen.framework.mybatis.page.Page;
import com.xmomen.framework.web.exceptions.ArgumentValidException;
//import com.xmomen.module.logger.Log;
import ${modulePackage}.model.Create${domainObjectClassName};
import ${modulePackage}.model.Query${domainObjectClassName};
import ${modulePackage}.model.Update${domainObjectClassName};
import ${modulePackage}.model.${domainObjectClassName}Model;
import ${modulePackage}.service.${domainObjectClassName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;

<#include "header.ftl">
@RestController
public class ${domainObjectClassName}Controller {

    @Autowired
    ${domainObjectClassName}Service ${domainObjectName}Service;

    /**
     * ${tableComment}列表
     * @param   limit           每页结果数
     * @param   offset          页码
     * @param   id              主键
     * @param   ids             主键数组
     * @param   excludeIds      不包含主键数组
     * @param   keyword         关键字
     * @return  Page<${domainObjectClassName}Model>      ${tableComment}领域分页对象
     */
    @RequestMapping(value = "/${requestMapping}", method = RequestMethod.GET)
    //@Log(actionName = "查询${tableComment}列表")
    public Page<${domainObjectClassName}Model> get${domainObjectClassName}List(@RequestParam(value = "limit") Integer limit,
                                  @RequestParam(value = "offset") Integer offset,
                                  @RequestParam(value = "id", required = false) Serializable id,
                                  @RequestParam(value = "ids", required = false) Serializable[] ids,
                                  @RequestParam(value = "excludeIds", required = false) Serializable[] excludeIds,
                                  @RequestParam(value = "keyword", required = false) String keyword){
        Query${domainObjectClassName} query${domainObjectClassName} = new Query${domainObjectClassName}();
        query${domainObjectClassName}.setId(id);
        query${domainObjectClassName}.setExcludeIds(excludeIds);
        query${domainObjectClassName}.setIds(ids);
        query${domainObjectClassName}.setKeyword(keyword);
        return ${domainObjectName}Service.get${domainObjectClassName}ModelPage(limit, offset, query${domainObjectClassName});
    }

    /**
     * 查询单个${tableComment}
     * @param   id      主键
     * @return  ${domainObjectClassName}Model    ${tableComment}领域对象
     */
    @RequestMapping(value = "/${requestMapping}/{id}", method = RequestMethod.GET)
    //@Log(actionName = "查询${tableComment}")
    public ${domainObjectClassName}Model get${domainObjectClassName}ById(@PathVariable(value = "id") Serializable id){
        return ${domainObjectName}Service.getOne${domainObjectClassName}Model(id);
    }

    /**
     * 新增${tableComment}
     * @param   create${domainObjectClassName}          新增对象参数
     * @param   bindingResult       参数校验结果
     * @return  ${domainObjectClassName}Model                ${tableComment}领域对象
     */
    @RequestMapping(value = "/${requestMapping}", method = RequestMethod.POST)
    //@Log(actionName = "新增${tableComment}")
    public ${domainObjectClassName}Model create${domainObjectClassName}(@RequestBody @Valid Create${domainObjectClassName} create${domainObjectClassName}, BindingResult bindingResult) throws ArgumentValidException {
        if(bindingResult != null && bindingResult.hasErrors()){
            throw new ArgumentValidException(bindingResult);
        }
        return ${domainObjectName}Service.create${domainObjectClassName}(create${domainObjectClassName});
    }

    /**
     * 更新${tableComment}
     * @param id                            主键
     * @param update${domainObjectClassName}                    更新对象参数
     * @param bindingResult                 参数校验结果
     * @throws ArgumentValidException       参数校验异常类
     */
    @RequestMapping(value = "/${requestMapping}/{id}", method = RequestMethod.PUT)
    //@Log(actionName = "更新${tableComment}")
    public void update${domainObjectClassName}(@PathVariable(value = "id") Serializable id,
                           @RequestBody @Valid Update${domainObjectClassName} update${domainObjectClassName}, BindingResult bindingResult) throws ArgumentValidException {
        if(bindingResult != null && bindingResult.hasErrors()){
            throw new ArgumentValidException(bindingResult);
        }
        ${domainObjectName}Service.update${domainObjectClassName}(update${domainObjectClassName});
    }

    /**
     *  删除${tableComment}
     * @param id    主键
     */
    @RequestMapping(value = "/${requestMapping}/{id}", method = RequestMethod.DELETE)
    //@Log(actionName = "删除单个${tableComment}")
    public void delete${domainObjectClassName}(@PathVariable(value = "id") Serializable id){
        Serializable[] ids = {id};
        ${domainObjectName}Service.delete${domainObjectClassName}(ids);
    }

    /**
     *  删除${tableComment}
     * @param ids    主键
     */
    @RequestMapping(value = "/${requestMapping}", method = RequestMethod.DELETE)
    //@Log(actionName = "批量删除${tableComment}")
    public void delete${domainObjectClassName}s(@RequestParam(value = "ids") Serializable[] ids){
        ${domainObjectName}Service.delete${domainObjectClassName}(ids);
    }

}
