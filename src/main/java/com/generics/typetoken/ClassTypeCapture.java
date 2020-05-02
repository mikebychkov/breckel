package com.generics.typetoken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClassTypeCapture<T> {
    private Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return this.kind.isInstance(arg);
    }

    public static class Constr<E> {
        Class<E> cc;
        public Constr(Class<E> cc) {
            this.cc = cc;
        }
        public E getVal() {
            try {
                return cc.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class Doer {
        String name;

        public Doer() {
            this.name = "unnamed Doer";
        }

        public Doer(String name) {
            this.name = name;
        }

        public void doSmth() {
            System.out.println("dododo");
        }

        public String saySmth() {
            return "hohoho";
        }
    }

    public static class TypeHolder {
        Map<String, Class<?>> data = new HashMap<>();

        public void add(String name, Class<?> kind) {
            data.put(name, kind);
        }

        public Class<?> get(String name) {
            return data.get(name);
        }

        public Object createNew(Class<?> cl) {
            try {
                return cl.getDeclaredConstructor(String.class).newInstance("soso");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
        //
        Constr<String> cc = new Constr<>(String.class);
        String str = cc.getVal();
        //
        TypeHolder the = new TypeHolder();
        the.add("Doer", Doer.class);
        Class<?> cl = the.get("Doer");
        System.out.println(
                ((Doer) the.createNew(cl)).saySmth()
        );
        Doer newDo = (Doer) cl.cast(the.createNew(cl));
        newDo.doSmth();
    }
}
