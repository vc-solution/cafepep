package login;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


@Entity
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 
	 @NotNull
	 @Column(unique = true)
	 private String email;
	 
	 @NotNull
	 private String name;
	 
	 @NotNull 
	 private String password;
	 
	 
	 private String verification_key;
	 
	 
	 public Long getId(){
		return id;
	 }
	 
	 public String getVerification_key() {
		return verification_key;
	}

	public void setVerification_key(String verification_key) {
		this.verification_key = verification_key;
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
     
     public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword(){
 		return password;
 	 }
 	 
 	 public void setPassword(String password){
 		 this.password=Encoder.hashAndEncodePassword(password);
 	 }
	 
	 
	 
	 
	 
}
