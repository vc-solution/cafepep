package login;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LoginService {

	
	@PersistenceContext()
	EntityManager em;
	
	public boolean checkActivation(String username){
		
		try{
		Query q = em.createQuery("SELECT u FROM User u WHERE u.email = "+ "'"+username+"'");
		
		
		
		
		List results = q.getResultList();
		
		User user = null;
		
		if(!results.isEmpty()){
		    // ihgnores multiple results
			
		    user = (User) results.get(0);
		}
		
		if(user!=null){
			
			return (user.getVerification_key()==null);
		}
		
		else{
			return false;
		}
		}
		catch(Exception e){
			
		}
		
		finally{
			em.close();
		}
		
		return true;
	
	}
}
