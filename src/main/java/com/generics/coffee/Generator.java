package com.generics.coffee;

public interface Generator<T> {

    public T next() throws NoSuchMethodException;
}
