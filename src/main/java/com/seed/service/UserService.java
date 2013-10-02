package com.seed.service;

import com.seed.model.User;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("user")
@Api(value = "/user", description = "Operations about Users")
@Service("userService")
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    @POST
    @Path("/create")
    @ApiOperation(value = "Creates a user", notes = "Please feel free to write something useful to the API users", response = User.class)
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User create(@ApiParam(value = "Request with the info of the new user", required = true) User user) {
        final long id = 123;
        user.setId(id);
        LOGGER.info(String.format("Creating User: %s", user.toString()));
        return user;
    }

    @GET
    @Path("/get/{id}")
    @ApiOperation(value = "Gets a user by its ID", notes = "Please feel free to write something useful to the API users", response = User.class)
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User read(@ApiParam(value = "The ID of the user to get", required = true) @PathParam("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setEmail("jdoe@whatever.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        LOGGER.info(String.format("Reading User: %s", user));
        return user;
    }

    @PUT
    @Path("/update")
    @ApiOperation(value = "Updates a user", notes = "Please feel free to write something useful to the API users")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void update(@ApiParam(value = "Request with the info of the user to update", required = true) User user) {
        final String firstName = "Bob";
        user.setFirstName(firstName);
        LOGGER.info(String.format("Updating User: %s", user));
    }

    @DELETE
    @Path("/delete/{id}")
    @ApiOperation(value = "Deletes a user by its ID", notes = "Please feel free to write something useful to the API users")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void delete(@ApiParam(value = "The ID of the user to delete", required = true) @PathParam("id") Long id) {
        LOGGER.info(String.format("Deleting User ID: %s", id));
    }
}
