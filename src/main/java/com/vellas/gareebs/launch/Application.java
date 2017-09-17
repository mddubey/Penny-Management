package com.vellas.gareebs.launch;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@SpringBootApplication(exclude={Neo4jDataAutoConfiguration.class})
//@ComponentScan({"com.vellas.gareebs"})
//@EntityScan({"com.vellas.gareebs"})
//@EnableNeo4jRepositories(basePackages = "com.vellas.gareebs.dao")
@EnableTransactionManagement
@EnableNeo4jRepositories
@SpringBootApplication(exclude={Neo4jDataAutoConfiguration.class})
public class Application {
//    private void createDbConnection(){
//        System.out.println("Creating neo4j db connection.");
//        try {
//            Driver driver = new org.neo4j.jdbc.Driver();
//            DriverManager.registerDriver(driver);
//            Connection con = DriverManager.getConnection("jdbc:neo4j:http://localhost:7474",
//                    "neo4j","password");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Bean
    public SessionFactory sessionFactory() {
//         with domain entity base package(s)
//        createDbConnection();
        return new SessionFactory("com.vellas.gareebs.model");
    }
//    @Bean
//    public Neo4jTransactionManager transactionManager() {
//        return new Neo4jTransactionManager(sessionFactory());
//    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
