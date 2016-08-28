package ${targetPackage};

import com.xmomen.framework.mybatis.page.Page;
import com.xmomen.framework.web.exceptions.ArgumentValidException;
import com.xmomen.module.logger.Log;
import ${modulePackage}.model.Create${DomainObjectName};
import ${modulePackage}.model.Query${DomainObjectName};
import ${modulePackage}.model.Update${DomainObjectName};
import ${modulePackage}.model.${DomainObjectName};
import ${modulePackage}.service.${DomainObjectName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * Created by tanxinzheng on ${.now}.
 */
@RestController
public class ${DomainObjectName}Controller {

    @Autowired
    ${DomainObjectName}Service ${domainObjectName}Service;

    /**
     * ${tableComment}列表
     * @param   limit           每页结果数
     * @param   offset          页码
     * @param   id              主键
     * @param   ids             主键数组
     * @param   excludeIds      不包含主键数组
     * @param   keyword         关键字
     * @return  Page<${DomainObjectName}>      ${tableComment}领域分页对象
     */
    @RequestMapping(value = "/${requestMapping}", method = RequestMethod.GET)
    @Log(actionName = "查询${tableComment}列表")
    public Page<${DomainObjectName}> get${DomainObjectName}List(@RequestParam(value = "limit") Integer limit,
                                  @RequestParam(value = "offset") Integer offset,
                                  @RequestParam(value = "id", required = false) Serializable id,
                                  @RequestParam(value = "ids", required = false) Serializable[] ids,
                                  @RequestParam(value = "excludeIds", required = false) Serializable[] excludeIds,
                                  @RequestParam(value = "keyword", required = false) String keyword){
        Query${DomainObjectName} query${DomainObjectName} = new Query${DomainObjectName}();
        query${DomainObjectName}.setId(id);
        query${DomainObjectName}.setExcludeIds(excludeIds);
        query${DomainObjectName}.setIds(ids);
        query${DomainObjectName}.setKeyword(keyword);
        return ${domainObjectName}Service.get${DomainObjectName}Page(limit, offset, query${DomainObjectName});
    }

    /**
     * 查询单个${tableComment}
     * @param   id      主键
     * @return  ${DomainObjectName}    ${tableComment}领域对象
     */
    @RequestMapping(value = "/${requestMapping}/{id}", method = RequestMethod.GET)
    @Log(actionName = "查询${tableComment}")
    public ${DomainObjectName} get${DomainObjectName}ById(@PathVariable(value = "id") Serializable id){
        return ${domainObjectName}Service.getOne${DomainObjectName}(id);
    }

    /**
     * 新增${tableComment}
     * @param   create${DomainObjectName}          新增对象参数
     * @param   bindingResult       参数校验结果
     * @return  ${DomainObjectName}                ${tableComment}领域对象
     */
    @RequestMapping(value = "/${requestMapping}", method = RequestMethod.POST)
    @Log(actionName = "新增${tableComment}")
    public ${DomainObjectName} create${DomainObjectName}(@RequestBody @Valid Create${DomainObjectName} create${DomainObjectName}, BindingResult bindingResult) throws ArgumentValidException {
        if(bindingResult != null && bindingResult.hasErrors()){
            throw new ArgumentValidException(bindingResult);
        }
        return ${domainObjectName}Service.create${DomainObjectName}(create${DomainObjectName});
    }

    /**
     * 更新${tableComment}
     * @param id                            主键
     * @param update${DomainObjectName}                    更新对象参数
     * @param bindingResult                 参数校验结果
     * @throws ArgumentValidException       参数校验异常类
     */
    @RequestMapping(value = "/${requestMapping}/{id}", method = RequestMethod.PUT)
    @Log(actionName = "更新${tableComment}")
    public void update${DomainObjectName}(@PathVariable(value = "id") Serializable id,
                           @RequestBody @Valid Update${DomainObjectName} update${DomainObjectName}, BindingResult bindingResult) throws ArgumentValidException {
        if(bindingResult != null && bindingResult.hasErrors()){
            throw new ArgumentValidException(bindingResult);
        }
        ${domainObjectName}Service.update${DomainObjectName}(update${DomainObjectName});
    }

    /**
     *  删除${tableComment}
     * @param id    主键
     */
    @RequestMapping(value = "/${requestMapping}/{id}", method = RequestMethod.DELETE)
    @Log(actionName = "删除单个${tableComment}")
    public void delete${DomainObjectName}(@PathVariable(value = "id") Serializable id){
        Serializable[] ids = {id};
        ${domainObjectName}Service.delete${DomainObjectName}(ids);
    }

    /**
     *  删除${tableComment}
     * @param ids    主键
     */
    @RequestMapping(value = "/${requestMapping}", method = RequestMethod.DELETE)
    @Log(actionName = "批量删除${tableComment}")
    public void delete${DomainObjectName}s(@RequestParam(value = "ids") Serializable[] ids){
        ${domainObjectName}Service.delete${DomainObjectName}(ids);
    }

}
