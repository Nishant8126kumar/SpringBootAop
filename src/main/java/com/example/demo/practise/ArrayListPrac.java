package com.example.demo.practise;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

class Data<T, I extends Number> {
    private T key;
    private T value;

    public Data(T key, T value) {
        this.key = key;
        this.value = value;
    }

    public void set(T key, T value) {
        this.value = value;
    }

    public T get(T key) throws Exception {
        if (this.key == key) {
            return value;
        } else {
            throw new Exception("no value present");
        }
    }
}

public class ArrayListPrac {
    public static void main(String[] args) {
//        Period diff = Period.between(LocalDate.parse("2016-08-31"),
//                LocalDate.parse("2016-11-30"));
        Period diff = Period.between(LocalDate.parse("2020-08-30"), LocalDate.now());
        Period period = Period.between(LocalDate.parse("2020-05-08"), LocalDate.now());
        System.out.println(LocalDate.now());
        Integer monthDiff = period.getMonths();
        System.out.println(monthDiff);
    }
}
