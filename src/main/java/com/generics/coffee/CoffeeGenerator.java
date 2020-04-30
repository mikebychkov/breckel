package com.generics.coffee;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] coffeeTypes = {Americano.class,
                                    Breve.class, Cappuccino.class,
                                    Latte.class, Mocha.class};
    private Random rand = new Random();
    private int size = 0;

    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    public Coffee next() {
        try {
            return (Coffee) this.coffeeTypes[
                    this.rand.nextInt(this.coffeeTypes.length)
                    ].getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private class CoffeeIterator implements Iterator<Coffee> {
        private CoffeeGenerator cgen;
        private int count = 0;

        public CoffeeIterator(CoffeeGenerator cgen) {
            this.cgen = cgen;
            this.count = cgen.size;
        }

        public boolean hasNext() {
            return this.count > 0;
        }

        public Coffee next() {
            this.count--;
            return cgen.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Coffee> iterator() {
        return new CoffeeIterator(this);
    }
}
