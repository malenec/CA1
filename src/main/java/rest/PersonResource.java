package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonDTO;
import dtos.RenameMeDTO;
import facades.FacadeExample;
import facades.PersonFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("person")
public class PersonResource{

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final PersonFacade FACADE =  PersonFacade.getPersonFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response postPerson(String input){
        PersonDTO personDTO = GSON.fromJson(input, PersonDTO.class);
        System.out.println(personDTO);
        return Response.ok().entity(personDTO).build();
    }
}
