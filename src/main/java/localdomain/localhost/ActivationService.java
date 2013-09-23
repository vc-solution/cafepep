package localdomain.localhost;

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
            User user = (User) q.getSingleResult();
            if(user!=null)
            {
            	valid=true;
            }
            else
            {
            	valid=false;
            }
            }  
    		catch(Exception e){ 	          
               
            } 
    	return valid;
	}
	
}
