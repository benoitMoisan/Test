/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprest;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benoit
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
    @XmlElementWrapper(name="users")@XmlElement(name="user")
    private Map<String, User> users = new HashMap<>();
    
    public Users () {
        User user1 = new User("Yang", "yang@gmail.com");
        this.users.put("yang@gmail.com", user1);
        
        User user2 = new User("Erwan", "erwan@gmail.com");
        this.users.put("erwan@gmail.com", user2);
        
        User user3 = new User("Victor", "victor@gmail.com");
        this.users.put("victor@gmail.com", user3); 
    }
    
    public Users (Map<String, User> users) {
        this.users = users;
    }
    
    public String getNameUser(String email) {
        User user = this.users.get(email);
        return user.getName();
    }
    
    public void putUser(User user) {       
        this.users.put(user.getEmail(), user);
    }
    
    public void deleteUser(String email) {
        this.users.remove(email);
    }
}
