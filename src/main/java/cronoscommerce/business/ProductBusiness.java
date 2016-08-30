package cronoscommerce.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import cronoscommerce.dao.*;
import cronoscommerce.entity.*;


/**
 * Classe que representa a camada de negócios de ProductBusiness
 * 
 * @generated
 **/
@Service("ProductBusiness")
public class ProductBusiness {

    /**
     * Instância da classe ProductDAO que faz o acesso ao banco de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("ProductDAO")
    protected ProductDAO repository;

    // CRUD

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Product post(final Product entity) throws Exception {
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
    public Product get(java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
       Product result = repository.findOne(id);
      // begin-user-code  
      // end-user-code        
      return result;
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Product put(final Product entity) throws Exception {
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
  public Page<Product> list ( Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Product> result = repository.list (  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<Product> listByName ( java.lang.String name , Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Product> result = repository.listByName ( name ,  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<Product> listBySub_category ( SubCategory sub_category , Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Product> result = repository.listBySub_category ( sub_category ,  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<Product> listById ( java.lang.String id , Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Product> result = repository.listById ( id ,  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
    
    



}

