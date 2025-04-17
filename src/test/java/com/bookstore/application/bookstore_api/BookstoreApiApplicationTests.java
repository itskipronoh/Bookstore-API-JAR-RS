package com.bookstore.application.bookstore_api;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookstoreApiApplicationTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new BookstoreApiApplication(); // your JAX-RS app config
	}

	@Test
	void testApplicationStartup() {
		// Ping an endpoint to verify the app loads (adjust as needed)
		Response response = target("/api/books").request().get();
		assertNotNull(response);
		assertTrue(response.getStatus() == 200 || response.getStatus() == 204 || response.getStatus() == 404);
	}
}
