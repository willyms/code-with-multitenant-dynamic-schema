package org.acme.resource;

import org.flywaydb.core.Flyway;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/migrantions")
@Produces(MediaType.APPLICATION_JSON)
public class MigrantionResource {

    @Inject
    Flyway flyway;

    @GET
    public Response info() {
        return Response.ok(flyway.info()).status(Response.Status.OK).build();
    }

    @GET
    @Path("/start")
    public Response start() {
        flyway.clean();
        flyway.migrate();
        return Response.noContent().status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/schema/new")
    public Response schemaNew(@QueryParam("schema") String schema) {
        Flyway.configure()
                // apply/use the default (Spring) flyway configiration
                .configuration(flyway.getConfiguration())
                // use the passed schema
                .schemas(schema)
                .defaultSchema(schema)
                // get a Flyway instance
                .load()
                // run the migration
                .migrate();
        return Response.noContent().status(Response.Status.CREATED).build();
    }
}
