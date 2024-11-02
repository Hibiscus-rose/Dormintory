package io.renren.modules.community.controller;

import java.util.Arrays;
import java.util.Map;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.community.entity.CommunityEntity;
import io.renren.modules.community.service.CommunityService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 组团管理
 *
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:26:45
 */
@RestController
@RequestMapping("community/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("community:community:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = communityService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("/findAll")
    public R findAll(){
        List<CommunityEntity> list = communityService.findAll();
        return R.ok().put("list", list);
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{communityName}")
    @RequiresPermissions("community:community:info")
    public R info(@PathVariable("communityName") String communityName){
		CommunityEntity community = communityService.getById(communityName);

        return R.ok().put("community", community);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("community:community:save")
    public R save(@RequestBody CommunityEntity community){
		communityService.save(community);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("community:community:update")
    public R update(@RequestBody CommunityEntity community){
		communityService.updateById(community);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("community:community:delete")
    public R delete(@RequestBody String[] communityNames){
		communityService.removeByIds(Arrays.asList(communityNames));

        return R.ok();
    }

}
