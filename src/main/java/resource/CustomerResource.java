package resource;

import com.bookstore.application.bookstore_api.model.Customer;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.*;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    // In-memory storage (replace with database in future)
    private static final Map<String, Customer> CUSTOMERS = new HashMap<>();

    // Register a new customer
    @POST
    public Response registerCustomer(Customer customer) {
        if (CUSTOMERS.containsKey(customer.getId())) {
            return Response.status(Response.Status.CONFLICT)
                    .entity("Customer already exists with ID: " + customer.getId())
                    .build();
        }

        CUSTOMERS.put(customer.getId(), customer);
        return Response.status(Response.Status.CREATED).entity(customer).build();
    }

    // Get customer by ID
    @GET
    @Path("/{id}")
    public Response getCustomerById(@PathParam("id") String id) {
        Customer customer = CUSTOMERS.get(id);
        if (customer != null) {
            return Response.ok(customer).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Customer not found").build();
        }
    }

    // Simple login endpoint
    @POST
    @Path("/login")
    public Response login(Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<Customer> match = CUSTOMERS.values().stream()
                .filter(c -> c.getEmail().equals(email) && c.getPassword().equals(password))
                .findFirst();

        if (match.isPresent()) {
            return Response.ok(match.get()).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid credentials").build();
        }
    }
}
