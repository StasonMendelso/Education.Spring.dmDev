package org.stanislav.spring.database.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.stanislav.spring.database.entity.Role;
import org.stanislav.spring.database.entity.User;
import org.stanislav.spring.dto.PersonalInfo;
import org.stanislav.spring.dto.UserFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislav Hlova
 */
@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository {

    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    private static final String FIND_BY_COMPANY_AND_ROLE = """
            SELECT 
                firstname,
                lastname,
                birth_date
            FROM users
            WHERE company_id = ?
                AND role = ?
            """;

    @Override
    public List<User> findAllByFilter(UserFilter userFilter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();
        if (userFilter.getFirstName() != null) {
            predicates.add(criteriaBuilder.like(root.get("firstname"), userFilter.getFirstName()));
        }
        if (userFilter.getLastName() != null) {
            predicates.add(criteriaBuilder.like(root.get("lastname"), userFilter.getLastName()));
        }
        if (userFilter.getBirthDate() != null) {
            predicates.add(criteriaBuilder.lessThan(root.get("birthDate"), userFilter.getBirthDate()));
        }
        criteriaQuery.where(predicates.toArray(Predicate[]::new));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role) {
        return jdbcTemplate.query(FIND_BY_COMPANY_AND_ROLE, (rs, rowNum) -> new PersonalInfo(
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getDate("birth_date").toLocalDate()), companyId, role.name());
    }
}
