package io.renren;

import io.renren.common.utils.RedisUtils;
import io.renren.modules.account.controller.AccountController;
import io.renren.modules.account.entity.AccountEntity;
import io.renren.modules.account.service.AccountService;
import io.renren.modules.community.entity.CommunityEntity;
import io.renren.modules.community.service.CommunityService;
import io.renren.modules.community.service.impl.CommunityServiceImpl;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private CommunityService communityService;
	@Test
	public void contextLoads() {

		communityService.findAll().forEach(System.out::println);


		System.out.println(ToStringBuilder.reflectionToString(redisUtils.get("user", SysUserEntity.class)));
	}

}
