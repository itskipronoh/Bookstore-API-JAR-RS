package resource;
import com.bookstore.application.bookstore_api.model.CartItem;
import com.bookstore.application.bookstore_api.model.Order;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    private static final Map<String, Order> ORDERS = new HashMap<>();

    // In-memory store: customerId -> List<Order>
    private static final Map<String, List<Order>> CUSTOMER_ORDERS = new HashMap<>();

    // POST /orders/place
    @POST
    @Path("/place")
    public Response placeOrder(Order order) {
        // Generate order ID and timestamp
        String orderId = UUID.randomUUID().toString();
        String orderDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Order newOrder = new Order(
                orderId,
                order.getCustomerId(),
                order.getItems(),
                order.getTotalPrice(),
                orderDate,
                "PLACED"
        );

        ORDERS.put(orderId, newOrder);

        // Add to customer's order history
        CUSTOMER_ORDERS.computeIfAbsent(order.getCustomerId(), k -> new ArrayList<>()).add(newOrder);

        return Response.status(Response.Status.CREATED).entity(newOrder).build();
    }

    // GET /orders/customer/{customerId}
    @GET
    @Path("/customer/{customerId}")
    public Response getOrdersByCustomer(@PathParam("customerId") String customerId) {
        List<Order> orders = CUSTOMER_ORDERS.get(customerId);
        if (orders == null || orders.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No orders found for customer.").build();
        }
        return Response.ok(orders).build();
    }

    // GET /orders/{orderId}
    @GET
    @Path("/{orderId}")
    public Response getOrderById(@PathParam("orderId") String orderId) {
        Order order = ORDERS.get(orderId);
        if (order == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Order not found.").build();
        }
        return Response.ok(order).build();
    }
}
