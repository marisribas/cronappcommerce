package cronoscommerce.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;


/**
 * Classe que representa a tabela PRODUCT
 * @generated
 */
@Entity
@Table(name = "\"PRODUCT\""


)
@XmlRootElement
public class Product implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 1355181247l;
	
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
	@Column(name = "value", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String value;
	
	/**
	 * @generated
	 */
	@Column(name = "amount", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String amount;
	
	/**
	 * @generated
	 */
	@ManyToOne
	@JoinColumn(name="fk_sub_category", referencedColumnName = "id", insertable=true, updatable=true)
	private SubCategory sub_category;
	
	/**
	 * @generated
	 */
	@Column(name = "image", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String image;
	
	/**
	 * @generated
	 */
	@Column(name = "deliveryFee", nullable = true, unique = false, insertable=true, updatable=true)
	private java.lang.String deliveryfee;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public Product(){
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
	public Product setId(java.lang.String id){
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
	public Product setName(java.lang.String name){
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
	public Product setDescription(java.lang.String description){
		this.description = description;
		return this;
	}
	
	/**
	 * Obtém value
	 * @param value value
	 * return value
	 * @generated
	 */
	public java.lang.String getValue(){
		return this.value;
	}
	
	/**
	 * Define value
	 * @param value value
	 * @generated
	 */
	public Product setValue(java.lang.String value){
		this.value = value;
		return this;
	}
	
	/**
	 * Obtém amount
	 * @param amount amount
	 * return amount
	 * @generated
	 */
	public java.lang.String getAmount(){
		return this.amount;
	}
	
	/**
	 * Define amount
	 * @param amount amount
	 * @generated
	 */
	public Product setAmount(java.lang.String amount){
		this.amount = amount;
		return this;
	}
	
	/**
	 * Obtém sub_category
	 * @param sub_category sub_category
	 * return sub_category
	 * @generated
	 */
	public SubCategory getSub_category(){
		return this.sub_category;
	}
	
	/**
	 * Define sub_category
	 * @param sub_category sub_category
	 * @generated
	 */
	public Product setSub_category(SubCategory sub_category){
		this.sub_category = sub_category;
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
	public Product setImage(java.lang.String image){
		this.image = image;
		return this;
	}
	
	/**
	 * Obtém deliveryfee
	 * @param deliveryfee deliveryfee
	 * return deliveryfee
	 * @generated
	 */
	public java.lang.String getDeliveryfee(){
		return this.deliveryfee;
	}
	
	/**
	 * Define deliveryfee
	 * @param deliveryfee deliveryfee
	 * @generated
	 */
	public Product setDeliveryfee(java.lang.String deliveryfee){
		this.deliveryfee = deliveryfee;
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
	    
	    if(!(obj instanceof Product))
	      return false;
	    
	    Product other = (Product)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}
