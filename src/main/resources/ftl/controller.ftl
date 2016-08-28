package ${targetPackage}.controller;

import com.xmomen.framework.mybatis.page.Page;
import com.xmomen.framework.web.exceptions.ArgumentValidException;
import com.xmomen.module.logger.Log;
import ${targetPackage}.model.Create${javaBeanClassName};
import ${targetPackage}.model.Query${javaBeanClassName};
import ${targetPackage}.model.Update${javaBeanClassName};
import ${targetPackage}.model.${javaBeanClassName};
import ${targetPackage}.service.${javaBeanClassName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * Created by Jeng on 2016/1/5.
 */
@RestController
public class ${javaBeanClassName}Controller {

    @Autowired
    ${javaBeanClassName}Service ${javaBeanName}Service;

    /**
     * 用户列表
     * @param   limit           每页结果数
     * @param   offset          页码
     * @param   id              主键
     * @param   ids             主键数组
     * @param   excludeIds      不包含主键数组
     * @param   keyword         关键字
     * @return  Page<${javaBeanClassName}>      用户领域分页对象
     */
    @RequestMapping(value = "/${domainObjectName}", method = RequestMethod.GET)
    @Log(actionName = "查询用户列表")
    public Page<${javaBeanClassName}> get${javaBeanClassName}List(@RequestParam(value = "limit") Integer limit,
                                  @RequestParam(value = "offset") Integer offset,
                                  @RequestParam(value = "id", required = false) Serializable id,
                                  @RequestParam(value = "ids", required = false) Serializable[] ids,
                                  @RequestParam(value = "excludeIds", required = false) Serializable[] excludeIds,
                                  @RequestParam(value = "keyword", required = false) String keyword){
        Query${javaBeanClassName} query${javaBeanClassName} = new Query${javaBeanClassName}();
        query${javaBeanClassName}.setId(id);
        query${javaBeanClassName}.setExcludeIds(excludeIds);
        query${javaBeanClassName}.setIds(ids);
        query${javaBeanClassName}.setKeyword(keyword);
        return ${javaBeanName}Service.get${javaBeanClassName}Page(limit, offset, query${javaBeanClassName});
    }

    /**
     * 查询单个用户
     * @param   id      主键
     * @return  ${javaBeanClassName}    用户领域对象
     */
    @RequestMapping(value = "/${domainObjectName}/{id}", method = RequestMethod.GET)
    @Log(actionName = "查询用户")
    public ${javaBeanClassName} get${javaBeanClassName}ById(@PathVariable(value = "id") Serializable id){
        return ${javaBeanName}Service.getOne${javaBeanClassName}(id);
    }

    /**
     * 新增用户
     * @param   create${javaBeanClassName}          新增对象参数
     * @param   bindingResult       参数校验结果
     * @return  ${javaBeanClassName}                用户领域对象
     */
    @RequestMapping(value = "/${domainObjectName}", method = RequestMethod.POST)
    @Log(actionName = "新增用户")
    public ${javaBeanClassName} create${javaBeanClassName}(@RequestBody @Valid Create${javaBeanClassName} create${javaBeanClassName}, BindingResult bindingResult) throws ArgumentValidException {
        if(bindingResult != null && bindingResult.hasErrors()){
            throw new ArgumentValidException(bindingResult);
        }
        return ${javaBeanName}Service.create${javaBeanClassName}(create${javaBeanClassName});
    }

    /**
     * 更新用户
     * @param id                            主键
     * @param update${javaBeanClassName}                    更新对象参数
     * @param bindingResult                 参数校验结果
     * @throws ArgumentValidException       参数校验异常类
     */
    @RequestMapping(value = "/${domainObjectName}/{id}", method = RequestMethod.PUT)
    @Log(actionName = "更新用户")
    public void update${javaBeanClassName}(@PathVariable(value = "id") Serializable id,
                           @RequestBody @Valid Update${javaBeanClassName} update${javaBeanClassName}, BindingResult bindingResult) throws ArgumentValidException {
        if(bindingResult != null && bindingResult.hasErrors()){
            throw new ArgumentValidException(bindingResult);
        }
        ${javaBeanName}Service.update${javaBeanClassName}(update${javaBeanClassName});
    }

    /**
     *  删除用户
     * @param id    主键
     */
    @RequestMapping(value = "/${domainObjectName}/{id}", method = RequestMethod.DELETE)
    @Log(actionName = "删除单个用户")
    public void delete${javaBeanClassName}(@PathVariable(value = "id") Serializable id){
        Serializable[] ids = {id};
        ${javaBeanName}Service.delete${javaBeanClassName}(ids);
    }

    /**
     *  删除用户
     * @param ids    主键
     */
    @RequestMapping(value = "/${domainObjectName}", method = RequestMethod.DELETE)
    @Log(actionName = "批量删除用户")
    public void delete${javaBeanClassName}s(@RequestParam(value = "ids") Serializable[] ids){
        ${javaBeanName}Service.delete${javaBeanClassName}(ids);
    }

}
