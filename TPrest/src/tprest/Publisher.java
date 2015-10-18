/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprest;


import java.io.IOException;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
 
public class Publisher {
 
    static final String BASE_URI = "http://localhost:9999/MyServer/";
 
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServerFactory.create(BASE_URI);
            // The root resources in the java path will be automatically detected
            server.start();
            System.out.println("Browse the available operations with this URL : "+BASE_URI+"application.wadl");
            System.out.println("Press Enter to stop the server. ");
            System.in.read();
            System.out.println("Server stopped.");
            server.stop(0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}