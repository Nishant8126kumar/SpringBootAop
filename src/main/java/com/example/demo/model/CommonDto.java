package com.example.demo.model;

public class CommonDto<T> {

    private T t1, t2, t3, t4;

    public CommonDto() {
    }

    public CommonDto(T t1, T t2, T t3, T t4) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
    }
    public  CommonDto(T t1,T t2)
    {
        this.t1=t1;
        this.t2=t2;
    }

    public T getT1() {
        return t1;
    }

    public void setT1(T t1) {
        this.t1 = t1;
    }

    public T getT2() {
        return t2;
    }

    public void setT2(T t2) {
        this.t2 = t2;
    }

    public T getT3() {
        return t3;
    }

    public void setT3(T t3) {
        this.t3 = t3;
    }

    public T getT4() {
        return t4;
    }

    public void setT4(T t4) {
        this.t4 = t4;
    }

    @Override
    public String toString() {
        return "commonDto{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                ", t3=" + t3 +
                ", t4=" + t4 +
                '}';
    }
}
