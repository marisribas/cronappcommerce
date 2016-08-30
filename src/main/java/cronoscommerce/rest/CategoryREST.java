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
 * Controller para expor serviços REST de Category
 * 
 * @author Usu�rio de Teste
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/cronoscommerce/Category")
public class CategoryREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("CategoryBusiness")
    private CategoryBusiness categoryBusiness;

    /**
     * @generated
     */
      @Autowired
      @Qualifier("SubCategoryBusiness")
      private SubCategoryBusiness subCategoryBusiness;

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public Category post(@Validated @RequestBody final Category entity) throws Exception {
        return categoryBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Category put(@Validated @RequestBody final Category entity) throws Exception {
        return categoryBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Category put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final Category entity) throws Exception {
        return categoryBusiness.put(entity);
    }


    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        categoryBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<Category>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(categoryBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery listByName
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/listByName/{name}")    
  public  HttpEntity<PagedResources<Category>> listByNameParams (@PathVariable("name") java.lang.String name, Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(categoryBusiness.listByName(name, pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery listById
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/listById/{id}")    
  public  HttpEntity<PagedResources<Category>> listByIdParams (@PathVariable("id") java.lang.String id, Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(categoryBusiness.listById(id, pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/SubCategory")    
  public HttpEntity<PagedResources<SubCategory>> findSubCategory(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(categoryBusiness.findSubCategory(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/SubCategory/{relationId}")    
  public void deleteSubCategory(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.subCategoryBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/SubCategory/{relationId}")
  public SubCategory putSubCategory(@Validated @RequestBody final SubCategory entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.subCategoryBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/SubCategory")
  public SubCategory postSubCategory(@Validated @RequestBody final SubCategory entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Category category = this.categoryBusiness.get(instanceId);
	entity.setCategory(category);
	return this.subCategoryBusiness.post(entity);
  }   



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Category get(@PathVariable("id") java.lang.String id) throws Exception {
        return categoryBusiness.get(id);
    }
}
