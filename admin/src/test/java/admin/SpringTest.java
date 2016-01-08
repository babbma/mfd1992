package admin;

import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(value="transactionManager")
//@WebAppConfiguration
@ContextConfiguration(value={"classpath:spring/application-config.xml"})
public class SpringTest {
	@Resource
	private UserDao userDao;

	@Test
	public void test() {
		userDao.findByList(new HashMap<String, Object>());
	}

}
