package login;

import java.security.MessageDigest;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sun.misc.BASE64Encoder;

@ManagedBean
@Model
public class RegistrationController {

	@EJB
	RegistrationService registrationService;
	User user=new User();
	boolean entityNotExists;
	
	
	public String register(){
		user.setVerification_key(Encoder.hashAndEncodePassword(user.getEmail()+user.getPassword()));
		
		try{
			registrationService.register(user);
			entityNotExists=true;
			registrationService.sendRegistrationMail(user);
			return "newRegistration.xhtml?faces-redirect=true";
		}
		
		catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"LOGIN ERROR",user.getEmail()+" already exists"));
			entityNotExists=false;
			return "";
		}
		
		
		
	}

	

	public boolean isEntityNotExists() {
		return entityNotExists;
	}



	public void setEntityNotExists(boolean entityNotExists) {
		this.entityNotExists = entityNotExists;
	}



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
}
