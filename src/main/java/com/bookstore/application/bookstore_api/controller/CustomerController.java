package com.bookstore.application.bookstore_api.controller;

import com.bookstore.application.bookstore_api.exception.CustomerNotFoundException;
import com.bookstore.application.bookstore_api.model.Customer;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerController {

    private static final List<Customer> customers = new ArrayList<>();

    @POST
    public Response createCustomer(Customer customer) {
        if (customer.getName() == null || customer.getName().isEmpty()) {
            throw new BadRequestException("Customer name is required.");
        }
        if (customer.getEmail() == null || customer.getEmail().isEmpty()) {
            throw new BadRequestException("Customer email is required.");
        }
        customers.add(customer);
        return Response.status(Response.Status.CREATED)
                .entity("Customer created successfully with ID: " + customer.getId())
                .build();
    }

    @GET
    public Response getAllCustomers() {
        return Response.ok(customers).build();
    }

    @GET
    @Path("/{id}")
    public Response getCustomerById(@PathParam("id") String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return Response.ok(customer).build();
            }
        }
        throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
    }

    @PUT
    @Path("/{id}")
    public Response updateCustomer(@PathParam("id") String id, Customer updatedCustomer) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                customer.setName(updatedCustomer.getName());
                customer.setEmail(updatedCustomer.getEmail());
                customer.setPassword(updatedCustomer.getPassword());
                return Response.ok("Customer updated successfully with ID: " + id).build();
            }
        }
        throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") String id) {
        boolean removed = customers.removeIf(customer -> customer.getId().equals(id));
        if (!removed) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        return Response.noContent().build();
    }
}
