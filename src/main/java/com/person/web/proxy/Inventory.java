package com.person.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
@Lazy
public class Inventory<T> {

    private ArrayList<T> inventory;
    //add, clear, get(i), get(List), newInventory(어레이리스트에 타입을 주는거야)

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public void add(T t) {
        inventory.add(t);
    }

    public T get(int i) {
        Function<Integer, T> f = inventory::get;
        return f.apply(i);
    }

    public ArrayList<T> get() {
        return inventory;
    }

    public int size() {
        Supplier<Integer> f = inventory::size;
        return f.get();
    }

    public void clear() {
        inventory.clear();
    }

    public void newBox() {
        inventory = new ArrayList<T>();
    }
}