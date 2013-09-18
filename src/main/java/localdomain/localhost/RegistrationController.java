package localdomain.localhost;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean
@Model
public class RegistrationController {

	@EJB
	RegistrationService registrationService;
	
	
	public String register(String name){
		
	
		registrationService.register(name);
		
		return "registration.xhtml";
		
		
	}
	
	
}
