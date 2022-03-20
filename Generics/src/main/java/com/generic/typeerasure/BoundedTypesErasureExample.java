package com.generic.typeerasure;

public class BoundedTypesErasureExample {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<Double> doubleBox = new Box<Double>();
        Box<Number> dNumberBox = new Box<Number>();
        Box<Number> lNumberBox = new Box<Number>();

        integerBox.add(new Integer(10));
        doubleBox.add(new Double(10.0));
        dNumberBox.add(new Double(98.0092));
        lNumberBox.add(new Double(50L));

        System.out.format("Integer Value: %d\n", integerBox.get());
        System.out.format("Double Value: %s\n", doubleBox.get());

        System.out.format("dNumberBox Value: %s\n", dNumberBox.get());
        System.out.format("lNumberBox Value: %s\n", lNumberBox.get());
    }

    static class Box<T extends Number> {
        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }
}


