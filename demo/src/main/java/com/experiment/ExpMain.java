package com.experiment;

import com.experiment.factory.FlyableFactory;

public class ExpMain {
    public static void main(String[] args) {
        callMethod();
    }
    public static void callMethod() {
        FlyableFactory flyableFactory = new FlyableFactory();
        flyableFactory.fly();
    }
}