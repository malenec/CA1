package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.PersonFacade;
import facades.ZipCodeFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("zipcode")
public class ZipCodeResource {


    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final ZipCodeFacade FACADE = ZipCodeFacade.getZipCodeFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    public Response getAll() {
        return Response.ok().entity(GSON.toJson(FACADE.getAllZipCodes())).build();
    }


}
