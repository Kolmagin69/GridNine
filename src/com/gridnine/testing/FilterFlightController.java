package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FilterFlightController {

    public List<List<Flight>> filterList(List<Flight> filterList, Filters... filters) {
        List<List<Flight>> filterList1 = new ArrayList<>();
        for (Filters filters1 : filters)
            filterList1.addAll(filters1.filterList(filterList));
        return filterList1;
    }

}
