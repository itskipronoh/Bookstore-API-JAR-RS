package resource;

import com.bookstore.application.bookstore_api.model.Cart;
import com.bookstore.application.bookstore_api.model.CartItem;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

@Path("/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartResource {

    // Simulated in-memory storage (replace with DB/service in production)
    private static final Map<String, Cart> CARTS = new HashMap<>();

    // GET /cart/{customerId}
    @GET
    @Path("/{customerId}")
    public Response getCart(@PathParam("customerId") String customerId) {
        Cart cart = CARTS.get(customerId);
        if (cart == null) {
            cart = new Cart(customerId);
            CARTS.put(customerId, cart);
        }
        return Response.ok(cart).build();
    }

    // POST /cart/{customerId}/add
    @POST
    @Path("/{customerId}/add")
    public Response addItem(@PathParam("customerId") String customerId, CartItem item) {
        Cart cart = CARTS.computeIfAbsent(customerId, Cart::new);

        if (cart.hasItem(item.getBookId())) {
            cart.updateItem(item.getBookId(), item.getQuantity());
        } else {
            cart.addItem(item);
        }

        return Response.ok(cart).build();
    }

    // PUT /cart/{customerId}/update
    @PUT
    @Path("/{customerId}/update")
    public Response updateItem(@PathParam("customerId") String customerId, CartItem item) {
        Cart cart = CARTS.get(customerId);
        if (cart == null || !cart.hasItem(item.getBookId())) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Item not found in cart.").build();
        }

        cart.updateItem(item.getBookId(), item.getQuantity());
        return Response.ok(cart).build();
    }

    // DELETE /cart/{customerId}/remove/{bookId}
    @DELETE
    @Path("/{customerId}/remove/{bookId}")
    public Response removeItem(@PathParam("customerId") String customerId,
                               @PathParam("bookId") String bookId) {
        Cart cart = CARTS.get(customerId);
        if (cart == null || !cart.hasItem(bookId)) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Item not found in cart.").build();
        }

        cart.removeItem(bookId);
        return Response.ok(cart).build();
    }
}
