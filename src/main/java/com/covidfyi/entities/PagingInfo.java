package com.covidfyi.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingInfo {

    private int pageNumber;
    private int pageSize;
    private long totalResults;

    public PagingInfo()
    {

    }

    public PagingInfo(int pageNumber, int pageSize)
    {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}