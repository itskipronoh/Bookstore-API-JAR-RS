package com.bookstore.application.bookstore_api;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/") //
public class BookstoreApiApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(com.bookstore.application.bookstore_api.controller.BookController.class);
        resources.add(com.bookstore.application.bookstore_api.controller.AuthorController.class);
        resources.add(com.bookstore.application.bookstore_api.controller.CustomerController.class);
        resources.add(com.bookstore.application.bookstore_api.controller.CartController.class);
        resources.add(com.bookstore.application.bookstore_api.controller.OrderController.class);
        return resources;
    }
}
