package com.gridnine.testing;

import java.util.List;
import java.util.function.Predicate;

public abstract class Filters<T, T1> {

    protected final Predicate<T1>[] filters;

    protected Filters(Predicate<T1>... filters) {
        this.filters = filters;
    }

    abstract List<List<T>> filterList(List<T> lists);

}
