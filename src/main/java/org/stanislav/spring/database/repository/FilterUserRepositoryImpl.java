package org.stanislav.spring.database.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.stanislav.spring.database.entity.User;
import org.stanislav.spring.dto.UserFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislav Hlova
 */
@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository {

    private final EntityManager entityManager;

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
}
