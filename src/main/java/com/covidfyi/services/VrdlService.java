package com.covidfyi.services;

import com.covidfyi.dao.VrdlRepository;
import com.covidfyi.entities.GetVrdlRQ;
import com.covidfyi.entities.LocationEntity;
import com.covidfyi.entities.SortingInfo;
import com.covidfyi.entities.VrdlEntity;
import com.covidfyi.utils.FilterConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class VrdlService {

    @Autowired
    private VrdlRepository vrdlRepository;

    @Autowired
    private LocationService locationService;

    public VrdlEntity saveVrdl(VrdlEntity vrdl) {
        vrdl.setCreatedOn(new Date());

        LocationEntity savedLocationEntity = locationService.getLocationByStateNameDistrictName(vrdl.getLocation().getState(), vrdl.getLocation().getDistrict());
        if (savedLocationEntity == null) {
            LocationEntity locationEntity = new LocationEntity();
            locationEntity.setState(vrdl.getLocation().getState());
            locationEntity.setDistrict(vrdl.getLocation().getDistrict());
            savedLocationEntity = locationService.save(locationEntity);
        }
        vrdl.setLocation(savedLocationEntity);
        VrdlEntity savedVrdl = vrdlRepository.save(vrdl);
        return savedVrdl;
    }

    public List<VrdlEntity> getVrdls(GetVrdlRQ getVrdlRQ) {

        List<VrdlEntity> vrdls = new ArrayList<VrdlEntity>();
        Pageable page = PageRequest.of(0, 20);
        HashMap<String, Object> conditions = new HashMap<String, Object>();
        if (getVrdlRQ != null && getVrdlRQ.getFilterText() != null)
            conditions.put(FilterConstants.FILTER_TEXT, getVrdlRQ.getFilterText());
        conditions.put(FilterConstants.SORTING_INFO, new SortingInfo("createdOn", true));
        Page<VrdlEntity> pagedVrdls = vrdlRepository.searchVrdlEntity(conditions, page);

        return pagedVrdls.getContent();
    }
}
