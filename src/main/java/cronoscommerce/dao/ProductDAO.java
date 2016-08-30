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
@Repository("ProductDAO")
@Transactional(transactionManager="cronoscommerce-TransactionManager")
public interface ProductDAO extends JpaRepository<Product, java.lang.String> {

  /**
   * Obtém a instância de Product utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Product entity WHERE entity.id = :id")
  public Product findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Product utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Product entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select p from Product p")
  public Page<Product> list ( Pageable pageable );
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select p from Product p where p.name LIKE CONCAT('%', COALESCE(:name, p.name),'%')")
  public Page<Product> listByName (@Param(value="name") java.lang.String name , Pageable pageable );
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select p from Product p where p.sub_category = :sub_category")
  public Page<Product> listBySub_category (@Param(value="sub_category") SubCategory sub_category , Pageable pageable );
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select p from Product p where p.id LIKE CONCAT('%', COALESCE(:id, p.id),'%')")
  public Page<Product> listById (@Param(value="id") java.lang.String id , Pageable pageable );
  







}