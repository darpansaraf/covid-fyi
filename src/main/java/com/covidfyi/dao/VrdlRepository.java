package com.covidfyi.dao;

import com.covidfyi.entities.VrdlEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Map;

public interface VrdlRepository extends PagingAndSortingRepository<VrdlEntity, Long> {

    Page<VrdlEntity> searchVrdlEntity(Map<String, Object> conditions, Pageable pageable);

}
