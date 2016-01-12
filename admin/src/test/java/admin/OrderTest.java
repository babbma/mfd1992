package admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Employee;
import com.app.entity.easyui.DataGrid;
import com.app.entity.easyui.PageHelper;
import com.app.service.EmployeeService;
import com.app.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(value="transactionManager")
//@WebAppConfiguration
@ContextConfiguration(value={"classpath:spring/application-config.xml"})
public class OrderTest {
	@Resource
	private OrderService orderService;
	@Resource
	private EmployeeService employeeService;
	@Test
	public void test(){
		PageHelper helper =new PageHelper();
		helper.setPage(1);
		helper.setRows(10);
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		Employee emp = employeeService.findById(2);
		DataGrid dg = orderService.findPageList(helper, params, emp);
		System.out.println(dg.getTotal());
	}

}
