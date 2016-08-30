package cronoscommerce.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import cronoscommerce.dao.*;
import cronoscommerce.entity.*;


/**
 * Classe que representa a camada de negócios de CategoryBusiness
 * 
 * @generated
 **/
@Service("CategoryBusiness")
public class CategoryBusiness {

    /**
     * Instância da classe CategoryDAO que faz o acesso ao banco de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("CategoryDAO")
    protected CategoryDAO repository;

    // CRUD

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Category post(final Category entity) throws Exception {
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
    public Category get(java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
       Category result = repository.findOne(id);
      // begin-user-code  
      // end-user-code        
      return result;
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Category put(final Category entity) throws Exception {
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
  public Page<Category> list ( Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Category> result = repository.list (  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<Category> listByName ( java.lang.String name , Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Category> result = repository.listByName ( name ,  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<Category> listById ( java.lang.String id , Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Category> result = repository.listById ( id ,  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
    
    

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<SubCategory> findSubCategory(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<SubCategory> result = repository.findSubCategory(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;	  
  }



}

