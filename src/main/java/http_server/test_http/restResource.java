/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http_server.test_http;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import sso_b2b.util_b2b.tokenUtil;

/**
 *
 * @author vasil
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class restResource {

    @Context
    private HttpHeaders requestHeaders;
    @Context
    private Response response;
    @Context
    private Request request;

    @Path("/test")
    @GET
    public Response test() {
        try {
            tokenUtil utl = new tokenUtil("");
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
