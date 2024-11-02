package io.renren.modules.dormsupervisor.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.DormSupervisor.dao.DormsupervisorDao;
import io.renren.modules.DormSupervisor.entity.DormsupervisorEntity;
import io.renren.modules.DormSupervisor.service.DormsupervisorService;


@Service("dormsupervisorService")
public class DormsupervisorServiceImpl extends ServiceImpl<DormsupervisorDao, DormsupervisorEntity> implements DormsupervisorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DormsupervisorEntity> page = this.page(
                new Query<DormsupervisorEntity>().getPage(params),
                new QueryWrapper<DormsupervisorEntity>()
        );

        return new PageUtils(page);
    }

}