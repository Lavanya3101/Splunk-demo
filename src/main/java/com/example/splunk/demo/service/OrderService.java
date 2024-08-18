package com.example.splunk.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
//import java.util.logging.LogManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.splunk.demo.dto.Order;
import com.example.splunk.demo.util.Mapper;
@Service
public class OrderService {
Logger logger=LogManager.getLogger(OrderService.class);
	
	private List<Order> orderList=new ArrayList<>();
	public Order addOrder(Order order) {
		logger.info("OrderService:addOrder execution started...");
		logger.info("OrderService:addOrder request payload{}",Mapper.mapToJsonString(order));
		order.setOrderPlacedDate(new Date());
		order.setTransactionId(UUID.randomUUID().toString());
		orderList.add(order);
		logger.info("OrderService:addOrder response{}",Mapper.mapToJsonString(order));
		logger.info("OrderService:addOrder execution ended...");
		return order;
	}

	public List<Order> getOrders() {
		logger.info("OrderService:getOrders execution started...");
		List<Order> list=null;
		list=orderList;
		logger.info("OrderService:getOrders response{}",Mapper.mapToJsonString(orderList));
		logger.info("OrderService:getOrders execution ended...");
		return list;
	}

	public Order getOrderById(int id) {
		logger.info("OrderService:getOrderById execution started...");
		Order order=orderList.stream().filter(ord->ord.getId()==id).findAny().orElseThrow(()->new RuntimeException("Ordernot found with id:"+id));
		logger.info("OrderService:getOrderById execution ended...");
		return order;
	}

}
