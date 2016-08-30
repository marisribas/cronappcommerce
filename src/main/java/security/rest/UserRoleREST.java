package security.rest;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

import security.entity.*;
import security.business.*;


/**
 * Controller para expor serviços REST de UserRole
 * 
 * @author Usu�rio de Teste
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/security/UserRole")
public class UserRoleREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("UserRoleBusiness")
    private UserRoleBusiness userRoleBusiness;


    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public UserRole post(@Validated @RequestBody final UserRole entity) throws Exception {
        return userRoleBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public UserRole put(@Validated @RequestBody final UserRole entity) throws Exception {
        return userRoleBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public UserRole put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final UserRole entity) throws Exception {
        return userRoleBusiness.put(entity);
    }


    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        userRoleBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<UserRole>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(userRoleBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery findByUser
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/findByUser/{user}")    
  public  HttpEntity<PagedResources<UserRole>> findByUserParams (@PathVariable("user") User user, Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(userRoleBusiness.findByUser(user, pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery findByEmail
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/findByEmail/{email}")    
  public  HttpEntity<PagedResources<UserRole>> findByEmailParams (@PathVariable("email") java.lang.String email, Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(userRoleBusiness.findByEmail(email, pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery findByLogin
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/findByLogin/{login}")    
  public  HttpEntity<PagedResources<UserRole>> findByLoginParams (@PathVariable("login") java.lang.String login, Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(userRoleBusiness.findByLogin(login, pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery findByRole
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/findByRole/{roleid}")    
  public  HttpEntity<PagedResources<UserRole>> findByRoleParams (@PathVariable("roleid") java.lang.String roleid, Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(userRoleBusiness.findByRole(roleid, pageable   )), HttpStatus.OK);    
  }



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public UserRole get(@PathVariable("id") java.lang.String id) throws Exception {
        return userRoleBusiness.get(id);
    }
}
