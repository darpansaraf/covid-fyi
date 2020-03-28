package com.covidfyi.controllers;

import com.covidfyi.datacontracts.Vrdl;
import com.covidfyi.entities.VrdlEntity;
import com.covidfyi.services.VrdlService;
import com.covidfyi.translators.VrdlTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.OperationNotSupportedException;
import java.util.List;

@RestController
@RequestMapping("/api/covidfyi")
public class CovidFyiController {

    @Autowired
    private VrdlService vrdlService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vrdl> get() throws  Exception {
        List<VrdlEntity> vrdlEntityList = vrdlService.getAllVrdls();
        return VrdlTranslator.toDataContractObject(vrdlEntityList);

    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public Vrdl save(@RequestBody Vrdl vrdl) throws  Exception {
        VrdlEntity doVrdlEntity = VrdlTranslator.toDomainObject(vrdl);
        VrdlEntity savedVrdl = vrdlService.saveVrdl(doVrdlEntity);
        return VrdlTranslator.toDataContractObject(savedVrdl);
    }

}
