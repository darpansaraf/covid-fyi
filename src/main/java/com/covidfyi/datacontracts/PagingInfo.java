package com.covidfyi.datacontracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagingInfo {

    private int pageNumber;
    private int pageSize;
    private long totalResults;

    public PagingInfo()
    {

    }

    public  PagingInfo( int pageNumber, int pageSize)
    {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}