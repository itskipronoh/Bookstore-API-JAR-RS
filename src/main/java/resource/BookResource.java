package resource;

import com.bookstore.application.bookstore_api.model.Book;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    // Simulated database
    private static final Map<String, Book> BOOKS = new HashMap<>();

    static {
        BOOKS.put("1", new Book("1", "Things Fall Apart", "101", "978-0435905255", 1958, 9.99, 20));
        BOOKS.put("2", new Book("2", "The River Between", "102", "978-0435905484", 1965, 12.99, 15));
    }

    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") String id) {
        Book book = BOOKS.get(id);
        if (book != null) {
            return Response.ok(book).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Book not found with ID: " + id)
                    .build();
        }
    }
}
