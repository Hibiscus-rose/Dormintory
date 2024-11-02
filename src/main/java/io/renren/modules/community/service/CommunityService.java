package io.renren.modules.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.community.entity.CommunityEntity;
import java.util.List;


import java.util.Map;

/**
 * 组团管理
 *
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:26:45
 */
public interface CommunityService extends IService<CommunityEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<CommunityEntity> findAll();
}

