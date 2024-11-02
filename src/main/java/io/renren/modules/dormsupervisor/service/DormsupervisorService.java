package io.renren.modules.DormSupervisor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.DormSupervisor.entity.DormsupervisorEntity;

import java.util.Map;

/**
 * 宿管人员管理
 *
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:27:46
 */
public interface DormsupervisorService extends IService<DormsupervisorEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

