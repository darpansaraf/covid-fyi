package com.covidfyi.dao;

import com.covidfyi.entities.LocationEntity;
import com.covidfyi.entities.SortingInfo;
import com.covidfyi.entities.VrdlEntity;
import com.covidfyi.utils.FilterConstants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class VrdlRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public Page<VrdlEntity> searchVrdlEntity(Map<String, Object> conditions, Pageable page) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<VrdlEntity> query = cb.createQuery(VrdlEntity.class);
        Root<VrdlEntity> root = query.from(VrdlEntity.class);
        Join<VrdlEntity, LocationEntity> locationEntityJoin = root.join(FilterConstants.LOCATION, JoinType.LEFT);

        List<Predicate> predicates = getPredicatesCondition(conditions, cb, root,locationEntityJoin);

        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));

        SortingInfo sortingInfo = (SortingInfo) conditions.get(FilterConstants.SORTING_INFO);
        List<Order> orders = getOrdersByList(cb, root, sortingInfo);
        query.orderBy(orders).distinct(true);
        TypedQuery<VrdlEntity> typedQuery = entityManager.createQuery(query).setFirstResult(page.getPageNumber() * page.getPageSize()).setMaxResults(page.getPageSize());
        List<VrdlEntity> resultList = typedQuery.getResultList();

        long resultsCount = createCountQuery(cb, query, root);
        return new PageImpl<VrdlEntity>(resultList, page, resultsCount);
    }

    private List<Predicate> getPredicatesCondition(Map<String, Object> conditions, CriteriaBuilder cb, Root<VrdlEntity> root, Join<VrdlEntity, LocationEntity> locationEntityJoin) {
        List<Predicate> predicates = new ArrayList<>();
        if (conditions != null && conditions.size() > 0) {
            conditions.forEach((field, value) -> {
                switch (field) {
                    case FilterConstants.FILTER_TEXT:
                        predicates.add(cb.or(
                                cb.like(root.get(FilterConstants.ID).as(String.class), "%" + value.toString() + "%"),
                                cb.like(cb.lower(root.get(FilterConstants.NAME)), "%" + value.toString().toLowerCase() + "%"),
                                cb.like(cb.lower(locationEntityJoin.get(FilterConstants.DISTRICT)), "%" + value.toString().toLowerCase() + "%"),
                                cb.like(cb.lower(locationEntityJoin.get(FilterConstants.STATE)), "%" + value.toString().toLowerCase() + "%"),
                                cb.like(cb.lower(root.get(FilterConstants.INFORMATION_TYPE)), "%" + value.toString().toLowerCase() + "%")
                        ));
                        break;
                }
            });
        }
        return predicates;
    }

    private <T> long createCountQuery(final CriteriaBuilder cb,
                                      final CriteriaQuery<T> criteria, final Root<T> root) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);

        countCriteria.select(builder.count(root));

        for (Root<?> fromRoot : criteria.getRoots()) {
            countCriteria.getRoots().add(fromRoot);
        }

        final Predicate whereRestriction = criteria.getRestriction();
        if (whereRestriction != null) {
            countCriteria.where(whereRestriction);
        }

        final Predicate groupRestriction = criteria.getGroupRestriction();
        if (groupRestriction != null) {
            countCriteria.having(groupRestriction);
        }

        countCriteria.groupBy(criteria.getGroupList());
        countCriteria.distinct(criteria.isDistinct());
        return entityManager.createQuery(countCriteria).getSingleResult();
    }

    private List<Order> getOrdersByList(CriteriaBuilder cb, Root<VrdlEntity> root, SortingInfo sortingInfo) {
        List<Order> orders = new ArrayList<Order>(2);
        switch (sortingInfo.getOrderby()) {
//            case "added_on":
//                if (sortingInfo.getSortDescending())
//                    orders.add(cb.desc(root.get(sortingInfo.getOrderby())));
//                else
//                    orders.add(cb.asc(root.get(sortingInfo.getOrderby())));
//                break;
            default:
                if (sortingInfo.getSortDescending())
                    orders.add(cb.desc(root.get(sortingInfo.getOrderby())));
                else
                    orders.add(cb.asc(root.get(sortingInfo.getOrderby())));
                break;
        }
        return orders;
    }

}
