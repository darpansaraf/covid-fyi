package com.covidfyi.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortingInfo {

    public SortingInfo() {
    }

    public SortingInfo(String orderby, Boolean sortDescending) {
        this.orderby = orderby;
        this.sortDescending = sortDescending;
    }

    private String orderby;
    private Boolean sortDescending;


    public Boolean getSortDescending() {
        if(sortDescending !=null)
            return sortDescending;
        return false;
    }
}
