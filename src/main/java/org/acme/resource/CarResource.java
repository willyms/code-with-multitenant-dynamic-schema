package org.acme.resource;


import io.quarkus.panache.common.Parameters;
import org.acme.entites.Car;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {

    @GET
    public List<Car> getAll() {
        return Car.listAll();
    }

    @GET
    @Path("/listCarsByYear")
    public List listCarsByYear(@QueryParam("year") int year) {
        return Car.find("year(modelYear) = :year", Parameters.with("year",year)).list();
    }

    @GET
    @Path("/listCarsToSale")
    public List listCarsToSale() {
        return Car.find("isAvailableSale", true).list();
    }

    @GET
    @Path("/countCarsAvaiableSale")
    public Long countCarsAvaiableSale() {
        return Car.count("isAvailableSale", true);
    }

    @POST
    @Transactional
    public Response create(Car car) {
        Car.persist(car);
       return Response.ok(car).status(Response.Status.CREATED).build();
    }
}