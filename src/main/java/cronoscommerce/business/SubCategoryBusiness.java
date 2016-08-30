package cronoscommerce.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import cronoscommerce.dao.*;
import cronoscommerce.entity.*;


/**
 * Classe que representa a camada de negócios de SubCategoryBusiness
 * 
 * @generated
 **/
@Service("SubCategoryBusiness")
public class SubCategoryBusiness {

    /**
     * Instância da classe SubCategoryDAO que faz o acesso ao banco de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("SubCategoryDAO")
    protected SubCategoryDAO repository;

    // CRUD

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    public SubCategory post(final SubCategory entity) throws Exception {
      // begin-user-code  
      // end-user-code  
      repository.save(entity);
      // begin-user-code  
      // end-user-code  
      return entity;
    }

    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    public SubCategory get(java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
       SubCategory result = repository.findOne(id);
      // begin-user-code  
      // end-user-code        
      return result;
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    public SubCategory put(final SubCategory entity) throws Exception {
      // begin-user-code  
      // end-user-code        
      repository.saveAndFlush(entity);
      // begin-user-code  
      // end-user-code        
      return entity;
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    public void delete( java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
      repository.delete(id);
      // begin-user-code  
      // end-user-code        
    }

    // CRUD
    
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<SubCategory> list ( Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<SubCategory> result = repository.list (  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<SubCategory> listByName ( java.lang.String name , Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<SubCategory> result = repository.listByName ( name ,  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<SubCategory> listByCategory ( Category category , Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<SubCategory> result = repository.listByCategory ( category ,  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<SubCategory> listById ( java.lang.String id , Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<SubCategory> result = repository.listById ( id ,  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
    
    

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<Product> findProduct(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<Product> result = repository.findProduct(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;	  
  }



}

