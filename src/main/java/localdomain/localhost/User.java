package localdomain.localhost;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 
	 @NotNull
	 private String email;
	 
	 @NotNull 
	 private String password;
	 
	 
	 public Long getId(){
		return id;
	 }
	 
	 public void setId(long id){
		 this.id=id;
	 }
	 
	 public String getEmail(){
		 return email;
		 }
		 
     public void setEmail(String email){
		 this.email=email;
	 }
     
     public String getPassword(){
 		return password;
 	 }
 	 
 	 public void setPassword(String password){
 		 this.password=password;
 	 }
	 
	 
	 
	 
	 
}
