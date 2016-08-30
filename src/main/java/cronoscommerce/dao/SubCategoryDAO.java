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
@Repository("SubCategoryDAO")
@Transactional(transactionManager="cronoscommerce-TransactionManager")
public interface SubCategoryDAO extends JpaRepository<SubCategory, java.lang.String> {

  /**
   * Obtém a instância de SubCategory utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM SubCategory entity WHERE entity.id = :id")
  public SubCategory findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de SubCategory utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM SubCategory entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select s from SubCategory s")
  public Page<SubCategory> list ( Pageable pageable );
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select s from SubCategory s where s.name LIKE CONCAT('%', COALESCE(:name, s.name),'%')")
  public Page<SubCategory> listByName (@Param(value="name") java.lang.String name , Pageable pageable );
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select s from SubCategory s where s.category = :category")
  public Page<SubCategory> listByCategory (@Param(value="category") Category category , Pageable pageable );
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select s from SubCategory s where s.id LIKE CONCAT('%', COALESCE(:id, s.id),'%')")
  public Page<SubCategory> listById (@Param(value="id") java.lang.String id , Pageable pageable );
  

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Product entity WHERE entity.sub_category.id = :id")
  public Page<Product> findProduct(@Param(value="id") java.lang.String id,  Pageable pageable );






}