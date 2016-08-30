package cronoscommerce.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;


/**
 * Classe que representa a tabela SUBCATEGORY
 * @generated
 */
@Entity
@Table(name = "\"SUBCATEGORY\""


)
@XmlRootElement
public class SubCategory implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -1262071999l;
	
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
	@ManyToOne
	@JoinColumn(name="fk_category", referencedColumnName = "id", insertable=true, updatable=true)
	private Category category;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public SubCategory(){
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
	public SubCategory setId(java.lang.String id){
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
	public SubCategory setName(java.lang.String name){
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
	public SubCategory setDescription(java.lang.String description){
		this.description = description;
		return this;
	}
	
	/**
	 * Obtém category
	 * @param category category
	 * return category
	 * @generated
	 */
	public Category getCategory(){
		return this.category;
	}
	
	/**
	 * Define category
	 * @param category category
	 * @generated
	 */
	public SubCategory setCategory(Category category){
		this.category = category;
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
	    
	    if(!(obj instanceof SubCategory))
	      return false;
	    
	    SubCategory other = (SubCategory)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}
