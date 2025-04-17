package com.bookstore.application.bookstore_api.controller;
import com.bookstore.application.bookstore_api.model.Author;
import com.bookstore.application.bookstore_api.model.Book;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorController {

    private static final List<Author> authors = new ArrayList<>();
    private static final List<Book> books = new ArrayList<>();

    @POST
    public Response createAuthor(Author author) {
        if (author.getName() == null || author.getName().isEmpty()) {
            throw new BadRequestException("Author name is required.");
        }
        authors.add(author);
        return Response.status(Response.Status.CREATED)
                .entity("Author created successfully with ID: " + author.getId())
                .build();
    }

    @GET
    public Response getAllAuthors() {
        return Response.ok(authors).build();
    }

    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") String id) {
        for (Author author : authors) {
            if (author.getId().equals(id)) {
                return Response.ok(author).build();
            }
        }
        throw new NotFoundException("Author with ID " + id + " not found.");
    }

    @PUT
    @Path("/{id}")
    public Response updateAuthor(@PathParam("id") String id, Author updatedAuthor) {
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).getId().equals(id)) {
                authors.set(i, updatedAuthor);
                return Response.ok("Author updated successfully with ID: " + id).build();
            }
        }
        throw new NotFoundException("Author with ID " + id + " not found.");
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAuthor(@PathParam("id") String id) {
        boolean removed = authors.removeIf(author -> author.getId().equals(id));
        if (!removed) {
            throw new NotFoundException("Author with ID " + id + " not found.");
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}/books")
    public Response getBooksByAuthor(@PathParam("id") String id) {
        boolean exists = authors.stream().anyMatch(author -> author.getId().equals(id));
        if (!exists) {
            throw new NotFoundException("Author with ID " + id + " not found.");
        }

        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthorId().equals(id)) {
                authorBooks.add(book);
            }
        }

        return Response.ok(authorBooks).build();
    }
}
