package com.experiment.factory;

import com.experiment.imp.Flyable;

public class FlyableFactory implements Flyable {
    @Override
    public void fly() {
        System.out.println("I can fly!");
    }
}
