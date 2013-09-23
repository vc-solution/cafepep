package localdomain.localhost;

import java.security.MessageDigest;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sun.misc.BASE64Encoder;

@ManagedBean
@Model
public class RegistrationController {

	@EJB
	RegistrationService registrationService;
	User user=new User();
	
	
	public String register(){
		user.setVerification_key(hashAndEncodePassword(user.getEmail()+user.getPassword()));
		
		registrationService.register(user);
		registrationService.sendRegistrationMail(user);
		return "newRegistration.xhtml";
		
	}

	private String hashAndEncodePassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] passwordDigest = md.digest();
            return new BASE64Encoder().encode(passwordDigest);
        } catch (Exception e) {
            throw new RuntimeException("Exception encoding password", e);
        }
    }

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
}
