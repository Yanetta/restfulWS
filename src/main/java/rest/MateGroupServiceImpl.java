package rest;

import rest.myResource.Book;
import rest.myResource.MateGroup;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rs/mate")
public class MateGroupServiceImpl implements MateGroupService {
    private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

    @Override
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response getMateGroup() {
        return Response.status(Response.Status.OK).entity(mateGroup).type(MediaType.APPLICATION_XML).build();
    }

    @Override
    @GET
    @Path("/teacher")
    @Produces(MediaType.APPLICATION_XML)
    public Response getTeacher() {
        return Response.status(Response.Status.ACCEPTED).entity(mateGroup.getTeacher()).type(MediaType.APPLICATION_XML).build();

    }
}
