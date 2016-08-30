package cronoscommerce.dao;

import cronoscommerce.entity.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*;



/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("CategoryDAO")
@Transactional(transactionManager="cronoscommerce-TransactionManager")
public interface CategoryDAO extends JpaRepository<Category, java.lang.String> {

  /**
   * Obtém a instância de Category utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Category entity WHERE entity.id = :id")
  public Category findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Category utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Category entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select c from Category c")
  public Page<Category> list ( Pageable pageable );
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select c from Category c where c.name LIKE CONCAT('%', COALESCE(:name, c.name),'%')")
  public Page<Category> listByName (@Param(value="name") java.lang.String name , Pageable pageable );
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select c from Category c where c.id LIKE CONCAT('%', COALESCE(:id, c.id),'%')")
  public Page<Category> listById (@Param(value="id") java.lang.String id , Pageable pageable );
  

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM SubCategory entity WHERE entity.category.id = :id")
  public Page<SubCategory> findSubCategory(@Param(value="id") java.lang.String id,  Pageable pageable );






}