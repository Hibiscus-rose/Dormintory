package io.renren.modules.account.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.account.entity.AccountEntity;
import io.renren.modules.account.service.AccountService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 账户管理
 *
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:05:31
 */
@RestController
@RequestMapping("account/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("account:account:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accountService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("account:account:info")
    public R info(@PathVariable("id") String id){
		AccountEntity account = accountService.getById(id);

        return R.ok().put("account", account);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("account:account:save")
    public R save(@RequestBody AccountEntity account){
		accountService.insertAccount(account);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("account:account:update")
    public R update(@RequestBody AccountEntity account){
		accountService.updateById(account);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("account:account:delete")
    public R delete(@RequestBody String[] ids){
		accountService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
