package com.example.demodagger.car;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class Car {

    private static final String TAG = "Car";

    Engine mEngine;
    Wheels mWheels;
    private int mCarCost;

    /**
     * Dagger first calls constructor,
     * then injects the fields,
     * then calls the injected method
     *
     * Probably don't combine all three in a real app.
     */
    @Inject
    public Car(Engine engine, Wheels wheels, @Named("car cost") int carCost) {
        mEngine = engine;
        mWheels = wheels;
        mCarCost = carCost;
    }

    /**
     * Use method injection if you have to pass the injected object itself to the dependency.
     */
    @Inject // Dagger calls this method for us
    public void enableRemote(Remote remote) { // Dagger also provides the arguments
        remote.setListener(this); // pass this after the constructor finished
    }

    public void drive() {
        mEngine.start();
        Log.d(TAG, "Driving a car... Cost: " + mCarCost);
    }
}
