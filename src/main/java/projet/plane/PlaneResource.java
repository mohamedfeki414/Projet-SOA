package projet.plane;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("planes")
public class PlaneResource {

    @Context
    private UriInfo context;

    public PlaneResource() {
    }

    // a)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Plane> getPlanes() {
        return PlaneBD.getPlanes();
    }

    // b)
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Plane getPlane(@PathParam("id") String numPlane) {
        return PlaneBD.getPlanes().stream().filter(p -> p.getNumPlane().equals(numPlane)).findFirst().orElse(null);
    }

    // c)
    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Plane> searchPlanesByCriteria(@QueryParam("dep") String departure, @QueryParam("arr") String arrival) {
        List<Plane> result = new ArrayList<>();
        for (Plane plane : PlaneBD.getPlanes()) {
            if (departure.equals(plane.getDepartureCity()) && arrival.equals(plane.getArrivalCity())) {
                result.add(plane);
            }
        }
        return result;
    }

    // d)
    @POST
    @Path("create")
    public void createPlane(@QueryParam("num") String num, @QueryParam("departure") String departure,
                            @QueryParam("arrival") String arrival, @QueryParam("heure") int heure) {
        Plane newPlane = new Plane(num, departure, arrival, heure);
        PlaneBD.getPlanes().add(newPlane);
    }

    // f)
    @DELETE
    @Path("remove/{id}")
    public void removePlane(@PathParam("id") String numPlane) {
        PlaneBD.getPlanes().removeIf(p -> p.getNumPlane().equals(numPlane));
    }