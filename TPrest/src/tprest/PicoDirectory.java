/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author benoit
 */
@Path("/PicoDirectory")
public class PicoDirectory {
    Users users;
    String fileName="users.bd";
    
    private void saveUsersFile(String fileName) throws JAXBException, IOException {

		JAXBContext ctx = JAXBContext.newInstance(Users.class);
		Marshaller m = ctx.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);	    
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            m.marshal(users, out);
        }
	}
    
    private void getUsersFromFile(String fileName) throws JAXBException, IOException {
		JAXBContext ctx = JAXBContext.newInstance(Users.class);
		Unmarshaller u = ctx.createUnmarshaller();
		users = (Users) u.unmarshal(new File(fileName));
	}
    
    
    private void createUsers() {
        Map<String, User> createdUsers = new HashMap<>();
        
        User user1 = new User("Yang", "yang@gmail.com");
        createdUsers.put("yang@gmail.com", user1);
        
        User user2 = new User("Erwan", "erwan@gmail.com");
        createdUsers.put("erwan@gmail.com", user2);
        
        User user3 = new User("Victor", "victor@gmail.com");
        createdUsers.put("victor@gmail.com", user3); 
        
        users = new Users(createdUsers);
        
    } 
    
    
    @GET
	@Path("/all")
	@Produces(MediaType.TEXT_XML)
	public Users allUsers() throws JAXBException, IOException {
		getUsersFromFile(fileName);
		return users;
	}
    
    @GET
	@Path("/init")
	@Produces(MediaType.TEXT_XML)
	public Users initUsers() throws JAXBException, IOException {
                createUsers();
		saveUsersFile(fileName);
		return users;
	}
    
    
    @GET
    @Path("/{email}")
    @Produces(MediaType.TEXT_XML)
    public String getNameUser (@PathParam("email") String email) throws JAXBException, IOException {
        getUsersFromFile(fileName);
        return users.getNameUser(email);
    }
    
    @PUT
    @Path("/put")
    @Consumes({MediaType.APPLICATION_XML})
    public void putUser (User user) throws JAXBException, IOException {
        getUsersFromFile(fileName);
        users.putUser(user);
        saveUsersFile(fileName);
        
    }
    
    @DELETE
    @Path("/email/{email}")    
    public void deleteUser (@PathParam("email") String email) throws JAXBException, IOException {
        getUsersFromFile(fileName);
        users.deleteUser(email);
        saveUsersFile(fileName);
        
    }
    
}
