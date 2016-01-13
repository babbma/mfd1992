package admin;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.entity.Dealer;
import com.app.entity.Order;
import com.app.entity.OrderList;
import com.app.entity.Product;
import com.app.entity.Store;
import com.app.exception.CustomException;
import com.app.service.DealerService;
import com.app.service.OrderListService;
import com.app.service.OrderService;
import com.app.service.ProductService;
import com.app.service.StoreService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/application-config.xml"})
public class InitDataTest {

	@Resource
	private OrderService orderService;
	@Resource
	private OrderListService orderListService;
	@Resource
	private StoreService storeService;
	@Resource
	private DealerService dealerService;
	@Resource
	private ProductService productService;
	
	@Test
	public void addOrder() throws CustomException{
		Store store = new Store();
		store.setAreaId(2);
		storeService.save(store);
		
		Dealer dealer = new Dealer();
		dealerService.save(dealer);
		
		Product product = new Product();
		product.setName("demo");
		product.setDealerId(dealer.getId());
		productService.save(product);
		
		Order order = new Order();
		order.setStoreId(store.getId());
		
		orderService.save(order);
		
		OrderList orderList = new OrderList();
		orderList.setOrderId(order.getId());
		orderList.setProductId(product.getId());
		orderList.setProductNumber(3);
		orderListService.save(orderList);
	}
}
