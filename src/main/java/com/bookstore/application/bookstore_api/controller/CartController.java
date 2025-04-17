package com.bookstore.application.bookstore_api.controller;

import com.bookstore.application.bookstore_api.exception.CartItemNotFoundException;
import com.bookstore.application.bookstore_api.exception.CustomerNotFoundException;
import com.bookstore.application.bookstore_api.model.Cart;
import com.bookstore.application.bookstore_api.model.CartItem;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.HashMap;
import java.util.Map;

@Path("/customers/{customerId}/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartController {

    private static final Map<String, Cart> customerCarts = new HashMap<>();

    // POST: Add a book to the customer's cart
    @POST
    @Path("/items")
    public Response addToCart(@PathParam("customerId") String customerId, CartItem item) {
        customerCarts.putIfAbsent(customerId, new Cart(customerId));
        customerCarts.get(customerId).addItem(item);
        return Response.ok("Book added to cart successfully!").build();
    }

    // GET: Retrieve a customer's cart
    @GET
    public Response getCart(@PathParam("customerId") String customerId) {
        Cart cart = customerCarts.get(customerId);
        if (cart == null) {
            throw new CustomerNotFoundException("Cart for customer ID: " + customerId + " not found.");
        }
        return Response.ok(cart).build();
    }

    // PUT: Update quantity of a book in the cart
    @PUT
    @Path("/items/{bookId}")
    public Response updateCartItem(@PathParam("customerId") String customerId,
                                   @PathParam("bookId") String bookId,
                                   @QueryParam("quantity") int quantity) {

        Cart cart = customerCarts.get(customerId);
        if (cart == null) {
            throw new CustomerNotFoundException("Cart for customer ID: " + customerId + " not found.");
        }
        if (!cart.hasItem(bookId)) {
            throw new CartItemNotFoundException("Book with ID: " + bookId + " not found in cart.");
        }
        cart.updateItem(bookId, quantity);
        return Response.ok("Book quantity updated successfully!").build();
    }

    // DELETE: Remove a book from the cart
    @DELETE
    @Path("/items/{bookId}")
    public Response removeFromCart(@PathParam("customerId") String customerId,
                                   @PathParam("bookId") String bookId) {

        Cart cart = customerCarts.get(customerId);
        if (cart == null) {
            throw new CustomerNotFoundException("Cart for customer ID: " + customerId + " not found.");
        }
        if (!cart.hasItem(bookId)) {
            throw new CartItemNotFoundException("Book with ID: " + bookId + " not found in cart.");
        }
        cart.removeItem(bookId);
        return Response.ok("Book removed from cart!").build();
    }
}
