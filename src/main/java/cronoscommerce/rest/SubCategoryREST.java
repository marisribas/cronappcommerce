package cronoscommerce.rest;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

import cronoscommerce.entity.*;
import cronoscommerce.business.*;


/**
 * Controller para expor serviços REST de SubCategory
 * 
 * @author Usu�rio de Teste
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/cronoscommerce/SubCategory")
public class SubCategoryREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("SubCategoryBusiness")
    private SubCategoryBusiness subCategoryBusiness;

    /**
     * @generated
     */
      @Autowired
      @Qualifier("ProductBusiness")
      private ProductBusiness productBusiness;

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public SubCategory post(@Validated @RequestBody final SubCategory entity) throws Exception {
        return subCategoryBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public SubCategory put(@Validated @RequestBody final SubCategory entity) throws Exception {
        return subCategoryBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public SubCategory put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final SubCategory entity) throws Exception {
        return subCategoryBusiness.put(entity);
    }


    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        subCategoryBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<SubCategory>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(subCategoryBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery listByName
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/listByName/{name}")    
  public  HttpEntity<PagedResources<SubCategory>> listByNameParams (@PathVariable("name") java.lang.String name, Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(subCategoryBusiness.listByName(name, pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery listByCategory
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/listByCategory/{category}")    
  public  HttpEntity<PagedResources<SubCategory>> listByCategoryParams (@PathVariable("category") Category category, Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(subCategoryBusiness.listByCategory(category, pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery listById
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/listById/{id}")    
  public  HttpEntity<PagedResources<SubCategory>> listByIdParams (@PathVariable("id") java.lang.String id, Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(subCategoryBusiness.listById(id, pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Product")    
  public HttpEntity<PagedResources<Product>> findProduct(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(subCategoryBusiness.findProduct(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/Product/{relationId}")    
  public void deleteProduct(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.productBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/Product/{relationId}")
  public Product putProduct(@Validated @RequestBody final Product entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.productBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/Product")
  public Product postProduct(@Validated @RequestBody final Product entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	SubCategory sub_category = this.subCategoryBusiness.get(instanceId);
	entity.setSub_category(sub_category);
	return this.productBusiness.post(entity);
  }   



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public SubCategory get(@PathVariable("id") java.lang.String id) throws Exception {
        return subCategoryBusiness.get(id);
    }
}
