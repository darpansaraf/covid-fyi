package com.covidfyi.translators;

import com.covidfyi.datacontracts.Vrdl;
import com.covidfyi.entities.VrdlEntity;

import java.util.ArrayList;
import java.util.List;

public class VrdlTranslator {

    public static Vrdl toDataContractObject(VrdlEntity vrdlEntity) {
        if (vrdlEntity != null) {
            Vrdl dtoVrdl = new Vrdl();

            dtoVrdl.setDetails(vrdlEntity.getDetails());
            dtoVrdl.setDistrict(vrdlEntity.getDistrict());
            dtoVrdl.setDrName(vrdlEntity.getDrName());
            dtoVrdl.setExtension(vrdlEntity.getExtension());
            dtoVrdl.setId(vrdlEntity.getId());
            dtoVrdl.setPrimaryEmail(vrdlEntity.getPrimaryEmail());
            dtoVrdl.setSecondaryEmail(vrdlEntity.getSecondaryEmail());
            dtoVrdl.setName(vrdlEntity.getName());
            dtoVrdl.setPrimaryPhone(vrdlEntity.getPrimaryPhone());
            dtoVrdl.setSecondaryPhone(vrdlEntity.getSecondaryPhone());
            dtoVrdl.setSource(vrdlEntity.getSource());
            dtoVrdl.setSourceLink(vrdlEntity.getSourceLink());
            dtoVrdl.setState(vrdlEntity.getState());

            return dtoVrdl;
        }
        return null;
    }

    public static VrdlEntity toDomainObject(Vrdl vrdl) {
        if (vrdl != null) {

            VrdlEntity vrdlEntiry = new VrdlEntity();

            vrdlEntiry.setDetails(vrdl.getDetails());
            vrdlEntiry.setDistrict(vrdl.getDistrict());
            vrdlEntiry.setDrName(vrdl.getDrName());
            vrdlEntiry.setExtension(vrdl.getExtension());
            vrdlEntiry.setPrimaryEmail(vrdl.getPrimaryEmail());
            vrdlEntiry.setSecondaryEmail(vrdl.getSecondaryEmail());
            vrdlEntiry.setName(vrdl.getName());
            vrdlEntiry.setPrimaryPhone(vrdl.getPrimaryPhone());
            vrdlEntiry.setSecondaryPhone(vrdl.getSecondaryPhone());
            vrdlEntiry.setSource(vrdl.getSource());
            vrdlEntiry.setSourceLink(vrdl.getSourceLink());
            vrdlEntiry.setState(vrdl.getState());

            return vrdlEntiry;
        }
        return null;
    }

    public static List<Vrdl> toDataContractObject(List<VrdlEntity> vrdlEntityList) {

        if (vrdlEntityList != null && vrdlEntityList.size() > 0) {
            List<Vrdl> dtoVrdlds = new ArrayList<Vrdl>();
            for (VrdlEntity doVrdl :
                    vrdlEntityList) {
                Vrdl dtoVrdl = toDataContractObject(doVrdl);
                if (dtoVrdl != null)
                    dtoVrdlds.add(dtoVrdl);
            }
            return dtoVrdlds;
        }
        return null;

    }
}
