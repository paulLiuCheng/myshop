package com.jacklin.myshop.entity;

import lombok.Data;

@Data
public class OrderDetail {
    private Integer id;

    private Order order_id;

    private Goods goods_id;
    private Integer shoppingnum;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Order getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Order order_id) {
		this.order_id = order_id;
	}
	public Goods getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Goods goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getShoppingnum() {
		return shoppingnum;
	}
	public void setShoppingnum(Integer shoppingnum) {
		this.shoppingnum = shoppingnum;
	}
    
    

}