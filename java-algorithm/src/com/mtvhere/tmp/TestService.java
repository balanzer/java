package com.mtvhere.tmp;

public class TestService {
    public static void main(final String[] stgp) {
        System.out.println("TestService");

        final Service2 serv2 = new ServiceImpl();
        final Service1 serv1 = new ServiceImpl();
        serv1.method1a();
        serv2.method2a();

        serv1.common();
        serv2.common();
    }
}
