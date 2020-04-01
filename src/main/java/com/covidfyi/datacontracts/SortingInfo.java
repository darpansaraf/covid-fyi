package com.covidfyi.datacontracts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortingInfo {

    private Enums.OrderBy orderby;
    private Boolean sortDescending;
}
