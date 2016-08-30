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
 * Controller para expor serviços REST de Product
 * 
 * @author Usu�rio de Teste
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/cronoscommerce/Product")
public class ProductREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
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
    public Product post(@Validated @RequestBody final Product entity) throws Exception {
        return productBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Product put(@Validated @RequestBody final Product entity) throws Exception {
        return productBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Product put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final Product entity) throws Exception {
        return productBusiness.put(entity);
    }


    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        productBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<Product>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(productBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery listByName
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/listByName/{name}")    
  public  HttpEntity<PagedResources<Product>> listByNameParams (@PathVariable("name") java.lang.String name, Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(productBusiness.listByName(name, pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery listBySub_category
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/listBySub_category/{sub_category}")    
  public  HttpEntity<PagedResources<Product>> listBySub_categoryParams (@PathVariable("sub_category") SubCategory sub_category, Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(productBusiness.listBySub_category(sub_category, pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery listById
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/listById/{id}")    
  public  HttpEntity<PagedResources<Product>> listByIdParams (@PathVariable("id") java.lang.String id, Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(productBusiness.listById(id, pageable   )), HttpStatus.OK);    
  }



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Product get(@PathVariable("id") java.lang.String id) throws Exception {
        return productBusiness.get(id);
    }
}
