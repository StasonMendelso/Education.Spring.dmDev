package org.stanislav.spring.integration.testService;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Stanislav Hlova
 */

@Service
@RequiredArgsConstructor
public class TestDatabaseService {
    private final EntityManager entityManager;

    public void resetDatabaseTables() {
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();

        for (String tableName : tableNames) {
            entityManager.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE " + tableName + " RESTART IDENTITY").executeUpdate();
            entityManager.createNativeQuery("ALTER SEQUENCE " + tableName +"_SEQ RESTART WITH 1").executeUpdate();
        }

        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();

    }

    private List<String> tableNames;

    @PostConstruct
    void afterPropertiesSet() {
        tableNames = entityManager.getMetamodel().getEntities().stream()
                .filter(entityType -> entityType.getJavaType().getAnnotation(Table.class) != null)
                .map(entityType -> entityType.getJavaType().getAnnotation(Table.class))
                .map(this::convertToTableName) // TODO
                .toList();
    }

    /**
     * Converts an (optional) schema and table on a {@link Table} annotation to something that h2
     * uses when it generates tables.
     */
    private String convertToTableName(Table table) {
        String schema = table.schema();
        String tableName = table.name();

        String convertedSchema = StringUtils.hasText(schema) ? schema.toLowerCase() + "." : "";
        String convertedTableName = tableName.replaceAll("([a-z])([A-Z])", "$1_$2");

        return convertedSchema + convertedTableName;
    }
}
