package admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.entity.Employee;
import com.app.entity.config.Constant;
import com.app.exception.CustomException;
import com.app.service.EmployeeService;
import com.app.util.MD5Util;

@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional(value="transactionManager")
//@WebAppConfiguration
@ContextConfiguration(value={"classpath:spring/application-config.xml"})
public class SpringTest {
	@Resource
	private EmployeeService employeeService;
	@Test
	public void test() {
//		userDao.findByList(new HashMap<String, Object>());
	}
	
	@Test
	public void insertAdmin() throws CustomException{
		Employee emp = new Employee();
		emp.setPhone("superadmin");
		emp.setName("superadmin");
		emp.setPwd(MD5Util.MD5("superadmin"));
		emp.setRole(Constant.ADMIN);
		employeeService.save(emp);
	}
	
}
