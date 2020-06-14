package com.person.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
@Lazy
public class Box<T> {

    private HashMap<String, T> box;

    public Box() {
        box = new HashMap<>();
    }

    public void put(String s, T t) {
        box.put(s, t);
    }

    public T get(String k) {
        Function<String, T> f = box::get;
        /* p->box.get(p)*/
        return f.apply(k);
    }

    public HashMap<String, T> get() {
        return box;
    }

    public int size() {
        Supplier<Integer> fa = box::size;
        return fa.get()
                ;
    }

    public void clear() {
        box.clear();
    }

    public void newBox() {
        box = new HashMap<String, T>();
    }

}
