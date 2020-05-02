package com.generics.comparable;

public class Crocodile extends Animal
//        implements Comparable<Crocodile>
{

    private int length;

    public Crocodile(String name, int len) {
        super(name);
        this.length = len;
    }

    public static void main(String[] args) {
        Crocodile croc1 = new Crocodile("Alabama", 10);
        Crocodile croc2 = new Crocodile("Misisipy", 12);
        System.out.println(croc1.compareTo(croc2));
    }

/*
    @Override
    public int compareTo(Crocodile o) {
        return 0;
    }
*/
}
