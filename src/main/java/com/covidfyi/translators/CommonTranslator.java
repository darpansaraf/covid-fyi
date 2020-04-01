package com.covidfyi.translators;

import com.covidfyi.entities.PagingInfo;
import com.covidfyi.entities.SortingInfo;

public class CommonTranslator {

    public static PagingInfo toDomainObject(com.covidfyi.datacontracts.PagingInfo dtoPagingInfo) {
        if (dtoPagingInfo != null) {
            PagingInfo doPagingInfo = new PagingInfo();
            doPagingInfo.setPageNumber(dtoPagingInfo.getPageNumber());
            doPagingInfo.setPageSize(dtoPagingInfo.getPageSize());
            return doPagingInfo;
        }
        return new PagingInfo(0, 10);
    }

    public static com.covidfyi.datacontracts.PagingInfo toDataContractObject(PagingInfo doPagingInfo) {
        if (doPagingInfo != null) {
            com.covidfyi.datacontracts.PagingInfo dtoPagingInfo = new com.covidfyi.datacontracts.PagingInfo();
            dtoPagingInfo.setPageNumber(doPagingInfo.getPageNumber());
            dtoPagingInfo.setPageSize(doPagingInfo.getPageSize());
            dtoPagingInfo.setTotalResults(doPagingInfo.getTotalResults());
            return dtoPagingInfo;
        }
        return new com.covidfyi.datacontracts.PagingInfo();
    }

    public static SortingInfo toDomainObject(com.covidfyi.datacontracts.SortingInfo dtoSortingInfo) {
        if (dtoSortingInfo != null) {
            String orderby = "created_on";
            switch (dtoSortingInfo.getOrderby()) {
                default:
                    orderby = "createdOn";
            }
            return new SortingInfo(orderby, dtoSortingInfo.getSortDescending());
        }
        return new SortingInfo("createdOn", true);
    }

}
