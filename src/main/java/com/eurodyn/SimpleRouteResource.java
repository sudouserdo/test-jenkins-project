package com.eurodyn;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

@Path("/sample")
public class SimpleRouteResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getParam(@QueryParam("param") String param) {
        Map<String, String> response = new HashMap<>();
        response.put("parameter", param != null ? param : "null");
        return response;
    }
}

