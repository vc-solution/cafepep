package login;



import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ActivationService {

	@PersistenceContext()
	EntityManager em;
	
	public Boolean isValid(String key)
	{
		Boolean valid=false;
		Query q = em.createQuery("SELECT u FROM User u WHERE u.verification_key = "+ "'"+key+"'");
		
	     
    	try{ 
//            User user = (User) q.getSingleResult();
    		List results = q.getResultList();
    		User user = null;
    		if(!results.isEmpty()){
    		    // ignores multiple results
    		    user = (User) results.get(0);
    		}
            if(user!=null)
            {
            	valid=true;
            	user.setVerification_key(null);
            	em.flush();
            }
            else
            {
            	valid=false;
            }
            }  
    		catch(Exception e){ 	          
               System.out.println(e.getMessage());
            } 
    	return valid;
	}
	
}
