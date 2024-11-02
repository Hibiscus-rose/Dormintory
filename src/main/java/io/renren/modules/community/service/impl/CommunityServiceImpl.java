package io.renren.modules.community.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.community.dao.CommunityDao;
import io.renren.modules.community.entity.CommunityEntity;
import io.renren.modules.community.service.CommunityService;


@Service("communityService")
public class CommunityServiceImpl extends ServiceImpl<CommunityDao, CommunityEntity> implements CommunityService {
    @Autowired
    private CommunityDao communityDao;

    @Override
    public List<CommunityEntity> findAll()
    {
       return communityDao.findAll();
    }
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key=(String)params.get("key");
        IPage<CommunityEntity> page = this.page(
                new Query<CommunityEntity>().getPage(params),
                new QueryWrapper<CommunityEntity>().like(StringUtils.isNotBlank(key),"Community_name", key)
        );

        return new PageUtils(page);
    }

}