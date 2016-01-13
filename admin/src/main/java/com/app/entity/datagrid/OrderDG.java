package com.app.entity.datagrid;

import java.io.Serializable;

import com.app.entity.Dealer;
import com.app.entity.Order;
import com.app.entity.OrderList;
import com.app.entity.Product;
import com.app.entity.Store;

/**
 * 订单查询的列表数据
 * @author Administrator
 *
 */
public class OrderDG implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Order order;
	private OrderList orderList;
	private Product product;
	private Dealer dealer;
	private Store store;
	
	
	public OrderDG() {
		super();
	}
	public OrderDG(Integer id,Order order, OrderList orderList, Product product, Dealer dealer, Store store) {
		super();
		this.id = id;
		this.order = order;
		this.orderList = orderList;
		this.product = product;
		this.dealer = dealer;
		this.store = store;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderList getOrderList() {
		return orderList;
	}
	public void setOrderList(OrderList orderList) {
		this.orderList = orderList;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Dealer getDealer() {
		return dealer;
	}
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
