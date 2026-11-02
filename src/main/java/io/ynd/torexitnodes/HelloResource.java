package io.ynd.torexitnodes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting greet() {
        return new Greeting("world");
       }

    public record Greeting(String message) {
    }
}
