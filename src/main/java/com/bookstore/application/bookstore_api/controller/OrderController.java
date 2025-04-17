package com.bookstore.application.bookstore_api.controller;

import com.bookstore.application.bookstore_api.exception.CustomerNotFoundException;
import com.bookstore.application.bookstore_api.exception.OrderNotFoundException;
import com.bookstore.application.bookstore_api.model.Order;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("/customers/{customerId}/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderController {

    private static final List<Order> orders = new ArrayList<>();

    @POST
    public Response createOrder(@PathParam("customerId") String customerId, Order order) {
        order.setCustomerId(customerId);
        orders.add(order);
        return Response.ok("Order placed successfully with ID: " + order.getOrderId()).build();
    }

    @GET
    public Response getAllOrders(@PathParam("customerId") String customerId) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerId().equals(customerId)) {
                customerOrders.add(order);
            }
        }
        if (customerOrders.isEmpty()) {
            throw new CustomerNotFoundException("No orders found for customer ID: " + customerId);
        }
        return Response.ok(customerOrders).build();
    }

    @GET
    @Path("/{orderId}")
    public Response getOrderById(@PathParam("customerId") String customerId,
                                 @PathParam("orderId") String orderId) {
        for (Order order : orders) {
            if (order.getCustomerId().equals(customerId) &&
                    order.getOrderId().equals(orderId)) {
                return Response.ok(order).build();
            }
        }
        throw new OrderNotFoundException("Order with ID: " + orderId + " not found for customer ID: " + customerId);
    }
}
