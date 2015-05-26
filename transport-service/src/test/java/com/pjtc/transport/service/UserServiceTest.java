package com.pjtc.transport.service;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.pjtc.transport.ExceptionBase;
import com.pjtc.transport.ValidationException;
import com.pjtc.transport.domain.Account;
import com.pjtc.transport.domain.TransportOrder;
import com.pjtc.transport.domain.TransportOrderItem;
import com.pjtc.transport.domain.User;
import com.pjtc.transport.service.TransportOrderService;
import com.pjtc.transport.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/config/applicationContext-service.xml", 		
	"/config/applicationContext-persistence.xml"})
@TransactionConfiguration(transactionManager="txManager", defaultRollback = false)
@Transactional
public class UserServiceTest  {
	
	@Autowired
	private TransportOrderService transportOrderService;
	@Autowired
	private UserService userService;
	//private IUserService userService;
	
	@Before
	public void setup(){
		System.out.println("Set up");
	}
	
	@After
	public void tearDown(){
		System.out.println("Tear down");	
	}
	
	@Test
	@Rollback(false)
	public void testCreateOrder(){
		
		Account account = new Account();
		account.setName("Test account");
		
		User user = new User();
		user.setFirstName("Tom");
		user.setLastName("L");
		user.setUserName("tom@yahoo.com");
		user.setPassword("111111");
		
		TransportOrder order = new TransportOrder();
		order.setCreatedBy(user);
		order.setLastChangedBy(user);
		order.setShipper(account);
		
		TransportOrderItem item1 = new TransportOrderItem();
		item1.setProduct("Product1");
		item1.setProductType("Normal");
		item1.setQuantity(2);
		item1.setQuantityUoM("PC");
		
		order.addItem(item1);
		
		try {
			account.setId(userService.createAccount(account));	
			user.setId(userService.createUser(user));
			transportOrderService.createOrder(order);
		
			List<TransportOrder> transportOrders = transportOrderService
					.queryOrder(null, null);
			
			for (TransportOrder transportOrder: transportOrders){
				System.out.println(transportOrder.getId());
				System.out.println(transportOrder.getCreatedAt());
			}
			
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionBase e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}