package com.mtvhere.tmp;

public class ServiceImpl implements Service1, Service2 {
    @Override
    public void method1a() {
        System.out.println("method1a");
    }

    @Override
    public void common() {

        System.out.println("common");

    }

    @Override
    public int common1(final int a) {
        return 0;
    }

    @Override
    public int common2(final int a) {
        return 0;
    }

    @Override
    public String common1(final String name) {
        return "test";
    }

    @Override
    public int common2(final String a) {
        return 0;
    }

    @Override
    public void method2a() {
        System.out.println("method2a");
    }
}
