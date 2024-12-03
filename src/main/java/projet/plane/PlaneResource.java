package projet.plane;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("planes")
public class PlaneResource {

    @Context
    private UriInfo context;

    public PlaneResource() {
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Plane> getPlanes() {
        return BookPlaneBD.getPlanes();
    }

    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Plane getPlane(@PathParam("id") String numPlane) {
        return BookPlaneBD.getPlanes().stream().filter(p -> p.getNumPlane().equals(numPlane)).findFirst().orElse(null);
    }

    
    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Plane> searchPlanesByCriteria(@QueryParam("dep") String departure, @QueryParam("arr") String arrival) {
        List<Plane> result = new ArrayList<>();
        for (Plane plane : BookPlaneBD.getPlanes()) {
            if (departure.equals(plane.getVilleDepart()) && arrival.equals(plane.getVilleArrivee())) {
                result.add(plane);
            }
        }
        return result;
    }

    
    @POST
    @Path("create")
    public void createPlane(@QueryParam("num") String num, @QueryParam("departure") String departure,
                            @QueryParam("arrival") String arrival, @QueryParam("heure") int heure) {
        Plane newPlane = new Plane(num, departure, arrival, heure);
        BookPlaneBD.getPlanes().add(newPlane);
    }

    
    @DELETE
    @Path("remove/{id}")
    public void removePlane(@PathParam("id") String numPlane) {
        BookPlaneBD.getPlanes().removeIf(p -> p.getNumPlane().equals(numPlane));
    }
}