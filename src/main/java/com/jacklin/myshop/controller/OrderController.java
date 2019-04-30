package com.jacklin.myshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacklin.myshop.common.ServerLayResult;
import com.jacklin.myshop.entity.Order;
import com.jacklin.myshop.service.OrderDetailService;
import com.jacklin.myshop.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 订单Controller
 */
@Api("后台订单接口")
@RestController
public class OrderController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// 注入Service
	@Autowired
	private OrderService orderService;

	// 注入订单详情Service
	@Autowired
	private OrderDetailService orderDetailService;

	/**
	 * 订单列表
	 *
	 * @param page
	 * @param limit
	 * @return
	 */
	@ApiOperation(value = "订单列表", notes = "查询结果集合数据")
	@GetMapping("/admin/order/list")
	public ServerLayResult<Order> OrderList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "limit", defaultValue = "10") Integer limit) {
		return new ServerLayResult(0, "", orderService.count(), orderService.selectAll(page, limit));
	}

	/**
	 * 根据id删除
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "订单删除", notes = "根据订单的id删除订单")
	@GetMapping("/admin/order/del")
	public String orderDel(@RequestParam(value = "id") Integer id) {
		logger.info("订单id----" + id);
		if (id != null && id > 0) {
			// 删除关联订单详情
			int index = orderDetailService.deleteByOrderId(id);
			if (index > 0) {
				int delete = orderService.deleteByPrimaryKey(id);
				if (delete > 0) {
					return "success";
				}
			}
		}
		return "error";
	}
}
