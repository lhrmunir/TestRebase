package com.interfaces.generic;

public class GenericInterfaceImpl<T> implements MyGenericInterface<T>{

    @Override
    public T produce() {
        return (T) new Car();
    }
}
