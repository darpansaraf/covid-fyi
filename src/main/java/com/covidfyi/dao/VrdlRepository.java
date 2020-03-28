package com.covidfyi.dao;

import com.covidfyi.entities.VrdlEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VrdlRepository extends PagingAndSortingRepository<VrdlEntity, Long> {
}
