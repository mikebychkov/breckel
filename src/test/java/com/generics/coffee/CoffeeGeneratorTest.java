package com.generics.coffee;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CoffeeGeneratorTest {

    @Test
    public void test() {
        assertThat(1, is(1));
    }

    @Test
    public void generatorUsing() {

        CoffeeGenerator cgen = new CoffeeGenerator(11);

        System.out.println(cgen.next());
        System.out.println(cgen.next());
        System.out.println(cgen.next());

        for (Coffee co : cgen) {
            System.out.println(co);
        }

        assertThat(1, is(1));
    }
}
