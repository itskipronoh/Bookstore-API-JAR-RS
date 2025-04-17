package com.bookstore.application.bookstore_api.controller;

import com.bookstore.application.bookstore_api.exception.BookNotFoundException;
import com.bookstore.application.bookstore_api.exception.InvalidInputException;
import com.bookstore.application.bookstore_api.model.Book;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {

    private static final List<Book> books = new ArrayList<>();

    @POST
    public Response createBook(Book book) {
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new InvalidInputException("Book title is required.");
        }
        books.add(book);
        return Response.status(Response.Status.CREATED)
                .entity("Book created successfully with ID: " + book.getId())
                .build();
    }

    @GET
    public Response getAllBooks() {
        return Response.ok(books).build();
    }

    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return Response.ok(book).build();
            }
        }
        throw new BookNotFoundException("Book with ID " + id + " not found.");
    }

    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") String id, Book updatedBook) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthorId(updatedBook.getAuthorId());
                book.setIsbn(updatedBook.getIsbn());
                book.setPublicationYear(updatedBook.getPublicationYear());
                book.setPrice(updatedBook.getPrice());
                book.setStockQuantity(updatedBook.getStockQuantity());
                return Response.ok("Book updated successfully.").build();
            }
        }
        throw new BookNotFoundException("Book with ID " + id + " not found.");
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") String id) {
        boolean removed = books.removeIf(book -> book.getId().equals(id));
        if (!removed) {
            throw new BookNotFoundException("Book with ID " + id + " not found.");
        }
        return Response.noContent().build();
    }
}
