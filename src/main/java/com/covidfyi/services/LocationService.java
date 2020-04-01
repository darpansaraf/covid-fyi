package com.covidfyi.services;

import com.covidfyi.dao.LocationRepository;
import com.covidfyi.entities.LocationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public LocationEntity save(LocationEntity locationEntity){

        return locationRepository.save(locationEntity);

    }

    public LocationEntity getLocationByStateNameDistrictName(String state, String district){
        LocationEntity location = locationRepository.getLocationByStateNameDistrictName(state,district);
        return location;
    }

}
