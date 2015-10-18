/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprest;

import com.sun.jersey.api.client.Client;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author benoit
 */
public class JavaClient {
    static final String REST_URI = "http://localhost:9999/MyServer/";

	public static void main(String[] args) {
		Client client = Client.create(new DefaultClientConfig());
		URI uri=UriBuilder.fromUri(REST_URI).build();
		WebResource service = client.resource(uri);
                
                System.out.println();
                System.out.println("init users in XML : \n"+
		service.path("PicoDirectory/init").type(MediaType.APPLICATION_XML).get(String.class));
		System.out.println("---------------------------------------------------");
                
                System.out.println();
                System.out.println("obtenir le nom de l'utilisateur dont l'adresse mail est : yang@gmail.com");
                System.out.println(service.path("PicoDirectory/yang@gmail.com").type(MediaType.APPLICATION_XML).get(String.class));
                System.out.println("---------------------------------------------------");
                
                System.out.println();
                System.out.println("Rajouter user (benoit, benoit@gmail.com) : ");
                service.path("PicoDirectory/put").type(MediaType.APPLICATION_XML).put("<user>"
                                                                    +        "<name>benoit</name>"
                                                                    +        "<emailAdress>benoit@gmail.com</emailAdress>"
                                                                    +"</user>");
                
                System.out.println();
                System.out.println("---------------------------------------------------");
                System.out.println("all users in XML : \n"+
		service.path("PicoDirectory/all").type(MediaType.APPLICATION_XML).get(String.class));
		System.out.println("---------------------------------------------------");
                
                System.out.println("delete user with email benoit@gmail.com       : \n");
		service.path("PicoDirectory/email/benoit@gmail.com").delete();
                System.out.println("---------------------------------------------------");
                
                System.out.println("all users in XML : \n"+
		service.path("PicoDirectory/all").type(MediaType.APPLICATION_XML).get(String.class));
		System.out.println("---------------------------------------------------");
                
        }
}
