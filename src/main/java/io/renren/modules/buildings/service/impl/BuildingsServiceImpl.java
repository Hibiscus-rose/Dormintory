package io.renren.modules.buildings.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.buildings.dao.BuildingsDao;
import io.renren.modules.buildings.entity.BuildingsEntity;
import io.renren.modules.buildings.service.BuildingsService;

import javax.xml.crypto.dsig.keyinfo.KeyValue;


@Service("buildingsService")
public class BuildingsServiceImpl extends ServiceImpl<BuildingsDao, BuildingsEntity> implements BuildingsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key= (String) params.get("key");
        System.out.println(key);

        Integer num;
        try {
            num = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            num = null;
        }
        System.out.println("查询条件：buildingId = " + num);
        IPage<BuildingsEntity> page = this.page(
                new Query<BuildingsEntity>().getPage(params),
                new QueryWrapper<BuildingsEntity>().eq(num != null,"building_id",num)
        );
        System.out.println("查询结果数量：" + page.getRecords().size());
        return new PageUtils(page);
    }

}