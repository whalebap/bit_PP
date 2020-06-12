package com.person.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component("pxy") @Lazy
public class Proxy {
    public void print(String t) {
        Consumer<String> c = System.out::println;
        c.accept(t);
    }
}
