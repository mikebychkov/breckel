package com.collections.hash;

import java.util.Arrays;
import java.util.List;

public class HashBaby {

    public static void stringArrayHashCode() {
        String[] ar = {"1234", "capibara", "Nixon"};
        System.out.println("=============");
        System.out.println(Arrays.toString(ar));
        System.out.println("=============");
        System.out.println(Arrays.hashCode(ar));
        System.out.println("=============");
        System.out.println("1234:" + "1234".hashCode());
        System.out.println("capibara:" + "capibara".hashCode());
        System.out.println("Nixon:" + "Nixon".hashCode());
        System.out.println("=============");
        int result = "1234".hashCode();
        result = result * 31 + "capibara".hashCode();
        result = result * 31 + "Nixon".hashCode();
        System.out.println(result);
        System.out.println("=============");
        result = "1234".hashCode();
        result = (result << 5) - 1 + "capibara".hashCode();
        result = (result << 5) - 1 + "Nixon".hashCode();
        System.out.println(result);
        System.out.println("=============");
    }

    public static void intValues() {
        System.out.println("=============");
        System.out.println("0:" + Integer.hashCode(0));
        System.out.println("1:" + Integer.hashCode(1));
        System.out.println("2:" + Integer.hashCode(2));
        System.out.println("=============");
        int result = Integer.hashCode(0);
        result = result * 31 + Integer.hashCode(1);
        result = result * 31 + Integer.hashCode(2);
        System.out.println(result);
        System.out.println("=============");
    }

    public static void intArrayHashCode() {
        int[] ar = {0, 1, 2};
        System.out.println("=============");
        System.out.println(Arrays.toString(ar));
        System.out.println("=============");
        System.out.println(ar.hashCode());
        System.out.println(Arrays.hashCode(ar));
        System.out.println("=============");
    }

    public static void integerArrayListHashCode() {
        List<Integer> ar = Arrays.asList(0, 1, 2);
        System.out.println("=============");
        System.out.println(ar);
        System.out.println("=============");
        System.out.println(ar.hashCode());
        System.out.println("=============");
    }

    public static void main(String[] args) {
        intValues();
        intArrayHashCode();
        integerArrayListHashCode();
        stringArrayHashCode();
    }
}
