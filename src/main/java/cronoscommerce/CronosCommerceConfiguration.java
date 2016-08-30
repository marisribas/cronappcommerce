package cronoscommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Classe que configura os beans para persistencia
 * 
 * @author Usuário de Teste
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "cronoscommerce-EntityManagerFactory",
        transactionManagerRef = "cronoscommerce-TransactionManager"
)
class CronosCommerceConfiguration {
  

    @Bean(name="cronoscommerce-EntityManagerFactory")
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("cronoscommerce");
        return factoryBean;
    }

    @Bean(name = "cronoscommerce-TransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
	  public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {

      Resource sourceData = new ClassPathResource("CronosCommerceData.json");
  		Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
  		factory.setResources(new Resource[] { sourceData });

		  return factory;
	  }
}


