package com.covidfyi.services;

import com.covidfyi.dao.VrdlRepository;
import com.covidfyi.entities.VrdlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VrdlService {

    @Autowired
    private VrdlRepository vrdlRepository;

    public VrdlEntity saveVrdl(VrdlEntity vrdl){
        vrdl.setCreatedOn(new Date());
        VrdlEntity savedVrdl = vrdlRepository.save(vrdl);
        return savedVrdl;
    }

    public List<VrdlEntity> getAllVrdls(){

        List<VrdlEntity> vrdls = new ArrayList<VrdlEntity>();
         vrdlRepository.findAll().forEach( vrdl -> vrdls.add(vrdl) );
        return vrdls;

    }
}
