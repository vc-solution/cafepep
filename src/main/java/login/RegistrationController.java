package login;

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
		user.setVerification_key(Encoder.hashAndEncodePassword(user.getEmail()+user.getPassword()));
		
		registrationService.register(user);
		registrationService.sendRegistrationMail(user);
		return "newRegistration.xhtml";
		
	}

	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
}
