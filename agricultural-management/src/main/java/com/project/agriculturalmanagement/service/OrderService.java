package com.project.agriculturalmanagement.service;

import com.project.agriculturalmanagement.entity.Customer;
import com.project.agriculturalmanagement.entity.Order;
import com.project.agriculturalmanagement.entity.OrderDetail;

import java.util.List;

public interface OrderService {
    public List<Order> viewListOrders(Customer customer);
    public Order getOrder(long id);
    public List<OrderDetail> viewOrderDetail(long id);
    public int orderDetailItemTotal(List<OrderDetail>orderDetails);
    public void saveOrder(long addressId, Customer customer, String note);
}
