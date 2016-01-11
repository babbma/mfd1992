package admin;

import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EmployeeDao;
import com.app.dao.UserDao;
import com.app.entity.Employee;
import com.app.entity.config.Constant;
import com.app.util.MD5Util;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(value="transactionManager")
//@WebAppConfiguration
@ContextConfiguration(value={"classpath:spring/application-config.xml"})
public class SpringTest {
	@Resource
	private UserDao userDao;

	@Resource
	private EmployeeDao employeeDao;
	@Test
	public void test() {
		userDao.findByList(new HashMap<String, Object>());
	}
	
	@Test
	public void insertAdmin(){
		Employee emp = new Employee();
		emp.setPhone("admin");
		emp.setName("admin");
		emp.setPwd(MD5Util.MD5("admin"));
		emp.setRole(Constant.ADMIN);
		employeeDao.save(emp);
	}

}
