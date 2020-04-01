package com.covidfyi.datacontracts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetVrdlRQ {

    private String filterText;
    private PagingInfo pagingInfo;
    private SortingInfo sortingInfo;

}
