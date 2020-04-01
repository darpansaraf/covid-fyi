package com.covidfyi.dao;

import com.covidfyi.entities.LocationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends PagingAndSortingRepository<LocationEntity, Long> {

    @Query(value = "select * from location where name = :statename",nativeQuery = true)
    LocationEntity getLocationByStateName(@Param(value = "statename") String statename);

    @Query(value = "select * from location where state = :state and district  = :district",nativeQuery = true)
    LocationEntity getLocationByStateNameDistrictName(@Param(value = "state") String state,@Param(value = "district") String district);
}
