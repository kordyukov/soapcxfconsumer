package com.cfxconsume;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest
public class AbstractServiceTest {
    static int TEST_PORT = 5432;

    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:14.5")
            .withReuse(true)
            .withExposedPorts(TEST_PORT);

    @DynamicPropertySource
    static void setUpDatasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.jdbc-url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        registry.add("camunda.datasource.jdbc-url", () -> postgreSQLContainer.getJdbcUrl().concat("&currentSchema=camunda"));
    }

    @BeforeAll
    static void startPostgresSql() {
        postgreSQLContainer.start();
    }
}
