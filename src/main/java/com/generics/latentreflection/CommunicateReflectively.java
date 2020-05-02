package com.generics.latentreflection;

import java.lang.reflect.Method;

public class CommunicateReflectively {

    public static void perform(Object speaker) {
        Class<?> cl = speaker.getClass();
        System.out.println(cl);
        try {
            Method speak = cl.getMethod("speak");
            speak.invoke(speaker);
        } catch (Exception e) {
            System.out.println("Speaker cant speak");
        }
        try {
            Method sit = cl.getMethod("sit");
            sit.invoke(speaker);
        } catch (Exception e) {
            System.out.println("Speaker cant sit");
        }
    }

    public static void main(String[] args) {
        CommunicateReflectively.perform(new Dog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
    }
}
