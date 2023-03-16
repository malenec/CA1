package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HobbyDTO;
import dtos.PersonDTO;
import dtos.RenameMeDTO;
import facades.FacadeExample;
import facades.HobbyFacade;
import facades.PersonFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final PersonFacade FACADE = PersonFacade.getPersonFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    public Response getAll() {
        return Response.ok().entity(GSON.toJson(FACADE.getAllPersons())).build();
    }

    @GET
    @Path("{id}")
    public Response getPerson(@PathParam("id") Long id) {
        PersonDTO personDTO = FACADE.getPersonById(id);
        return Response.ok().entity(GSON.toJson(personDTO)).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response postPerson(String input) {
        PersonDTO personDTO = GSON.fromJson(input, PersonDTO.class);
        FACADE.addPerson(personDTO);
        return Response.ok().entity(personDTO).build();
    }

    @PUT
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response putPerson(@PathParam("id") Long id, String input) {
        PersonDTO personDTO = GSON.fromJson(input, PersonDTO.class);
        personDTO.setId(id);
        personDTO = FACADE.updatePerson(personDTO);
        return Response.ok().entity(personDTO).build();
    }

    @PUT
    @Path("/hobby/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addHobbyToPerson(@PathParam("id") Long id, String input) {
        HobbyDTO hobbyDTO = GSON.fromJson(input, HobbyDTO.class);
        PersonDTO personDTO = FACADE.addHobbyToPerson(hobbyDTO.getHobbyId(), id);
        return Response.ok().entity(personDTO).build();
    }

    @DELETE     //deletes the WHOLE person
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deletePerson(@PathParam("id") Long id) {
        PersonDTO personDTO = FACADE.deletePerson(id);
        return Response.ok().entity(personDTO).build();
    }

    @DELETE     //deletes ONLY ONE hobby from the person
    @Path("/hobby/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response deleteHobbyFromPerson(@PathParam("id") Long id, String input) {
        HobbyDTO hobbyDTO = GSON.fromJson(input, HobbyDTO.class);
        PersonDTO personDTO = FACADE.deleteHobbyFromPerson(hobbyDTO.getHobbyId(), id);
        return Response.ok().entity(personDTO).build();
    }

}
