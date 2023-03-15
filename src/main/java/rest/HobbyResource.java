package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HobbyDTO;
import dtos.PersonDTO;
import facades.HobbyFacade;
import facades.PersonFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hobby")
public class HobbyResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final HobbyFacade FACADE = HobbyFacade.getHobbyFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    public Response getAllHobbies() {
        return Response.ok().entity(GSON.toJson(FACADE.getAllHobbies())).build();
    }
//
//    @GET
//    @Path("{id}")
//    public Response getPerson(@PathParam("id") Long id) {
//        PersonDTO personDTO = FACADE.getPersonById(id);
//        return Response.ok().entity(GSON.toJson(personDTO)).build();
//    }

//    @POST
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response postPerson(String input) {
//        PersonDTO personDTO = GSON.fromJson(input, PersonDTO.class);
//        FACADE.addPerson(personDTO);
//        return Response.ok().entity(personDTO).build();
//    }


}
