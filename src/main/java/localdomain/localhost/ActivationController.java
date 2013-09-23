package localdomain.localhost;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Model
public class ActivationController {

	@Inject
	ActivationService as;
	
    @ManagedProperty(value="#{param.key}")
    private String key;

    private boolean valid;

    @PostConstruct
    public void init() {
    	valid=as.isValid(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("key"));
    }

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
    
    // ...
}

