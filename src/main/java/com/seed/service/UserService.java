package com.seed.service;

import com.seed.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("user")
@Service("userService")
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    @POST
    @Path("create")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User create(User user) {
        final long id = 123;
        user.setId(id);
        LOGGER.info(String.format("Creating User: %s", user.toString()));
        return user;
    }

    @GET
    @Path("get/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User read(@PathParam("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setEmail("jdoe@whatever.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        LOGGER.info(String.format("Reading User: %s", user));
        return user;
    }

    @PUT
    @Path("update")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void update(User user) {
        final String firstName = "Bob";
        user.setFirstName(firstName);
        LOGGER.info(String.format("Updating User: %s", user));
    }

    @DELETE
    @Path("delete/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") Long id) {
        LOGGER.info(String.format("Deleting User ID: %s", id));
    }
}
