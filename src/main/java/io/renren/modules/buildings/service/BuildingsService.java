package io.renren.modules.buildings.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.buildings.entity.BuildingsEntity;

import java.util.Map;

/**
 * 楼栋管理
 *
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:25:15
 */
public interface BuildingsService extends IService<BuildingsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

