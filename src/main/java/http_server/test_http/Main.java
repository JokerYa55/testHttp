/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http_server.test_http;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author vasil
 */
public class Main {

    public static String base_url = "http://127.0.0.1:8080/http_test/";
    public static final String appPath = System.getProperty("user.dir");
    private static final String APP_NAME = "admin_rest_b2b";
    private static final Logger log = Logger.getLogger(String.format("%s.log", APP_NAME));
    public static String sso_url;

    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.dekses.jersey.docker.demo package
        final ResourceConfig rc = new ResourceConfig().packages("sso_b2b.adminrest_b2b_micro");
        
            // create and start a new instance of grizzly http server
            // exposing the Jersey application at BASE_URI
            return GrizzlyHttpServerFactory.createHttpServer(URI.create(base_url), rc);
        
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        log.info(String.format("\n******************************** \nApp started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", base_url));
        System.in.read();
        server.stop();
    }

    
}
