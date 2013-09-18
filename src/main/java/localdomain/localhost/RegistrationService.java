package localdomain.localhost;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class RegistrationService {

	@PersistenceContext()
	EntityManager em;
	
	public void register(String name){
		
		User user= new User();
		user.setEmail(name);
		user.setPassword("peter");
		
		em.persist(user);
		em.flush();
	}
}

