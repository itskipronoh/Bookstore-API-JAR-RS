package resource;

import com.bookstore.application.bookstore_api.model.Author;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.*;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorResource {

    private static final Map<String, Author> AUTHORS = new HashMap<>();

    static {
        AUTHORS.put("1", new Author(
                "1",
                "Chinua Achebe",
                "Nigerian novelist, poet, and critic.",
                List.of("1")
        ));
        AUTHORS.put("2", new Author(
                "2",
                "Ngũgĩ wa Thiong’o",
                "Kenyan writer and academic known for his work in African literature.",
                List.of("2")
        ));
    }

    @GET
    public Response getAllAuthors() {
        return Response.ok(new ArrayList<>(AUTHORS.values())).build();
    }

    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") String id) {
        Author author = AUTHORS.get(id);
        if (author != null) {
            return Response.ok(author).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Author not found with ID: " + id)
                    .build();
        }
    }
}
