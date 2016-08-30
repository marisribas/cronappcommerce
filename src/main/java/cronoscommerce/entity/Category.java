package cronoscommerce.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;


/**
 * Classe que representa a tabela CATEGORY
 * @generated
 */
@Entity
@Table(name = "\"CATEGORY\""


)
@XmlRootElement
public class Category implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 115157234l;
	
	/**
	 * @generated
	 */
	@Id
    
	@Column(name = "id", insertable=true, updatable=true)
	private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
	
	/**
	 * @generated
	 */
	@Column(name = "name", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String name;
	
	/**
	 * @generated
	 */
	@Column(name = "description", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String description;
	
	/**
	 * @generated
	 */
	@Column(name = "image", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String image;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public Category(){
	}

	
	/**
	 * Obtém id
	 * @param id id
	 * return id
	 * @generated
	 */
	public java.lang.String getId(){
		return this.id;
	}
	
	/**
	 * Define id
	 * @param id id
	 * @generated
	 */
	public Category setId(java.lang.String id){
		this.id = id;
		return this;
	}
	
	/**
	 * Obtém name
	 * @param name name
	 * return name
	 * @generated
	 */
	public java.lang.String getName(){
		return this.name;
	}
	
	/**
	 * Define name
	 * @param name name
	 * @generated
	 */
	public Category setName(java.lang.String name){
		this.name = name;
		return this;
	}
	
	/**
	 * Obtém description
	 * @param description description
	 * return description
	 * @generated
	 */
	public java.lang.String getDescription(){
		return this.description;
	}
	
	/**
	 * Define description
	 * @param description description
	 * @generated
	 */
	public Category setDescription(java.lang.String description){
		this.description = description;
		return this;
	}
	
	/**
	 * Obtém image
	 * @param image image
	 * return image
	 * @generated
	 */
	public java.lang.String getImage(){
		return this.image;
	}
	
	/**
	 * Define image
	 * @param image image
	 * @generated
	 */
	public Category setImage(java.lang.String image){
		this.image = image;
		return this;
	}
	
	/**
	 * @generated
	 */
	@Override
	public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((id == null) ? 0 : id.hashCode());

        return result;
    }
	
	/**
	 * @generated
	 */	
	@Override
  	public boolean equals(Object obj) {
    
	    if(this == obj)
	      return true;
	    
	    if(obj == null)
	      return false;
	    
	    if(!(obj instanceof Category))
	      return false;
	    
	    Category other = (Category)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}
