package org.example;

import org.w3c.dom.ls.LSOutput;

public class App {
    class X {
        int n = 1;
    }
    class Y extends X {
        int n = 2;
    }

    public static void main(String[] args) {
        App app = new App();
        app.test();
    }

    public void test() {
        X obj = new Y();
        System.out.println(obj.n);
    }
}
