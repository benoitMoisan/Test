
package tprest;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	private String name;
	private String emailAdress;
	
	public User() {}
	
	public User(String name, String emailAdress) {
		this.name = name;
		this.emailAdress =emailAdress;
	}
        
        public String getName() {
            return this.name;
        }
	
	public String getEmail() {
            return this.emailAdress;
        }
}
