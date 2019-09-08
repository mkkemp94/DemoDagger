package com.example.demodagger.car;

import android.util.Log;

import com.example.demodagger.dagger.ActivityScope;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Lives as long as the activity is alive.
 *
 * Constructor is injected with @Inject to put this scope at the top.
 */
@ActivityScope
public class Car {

    private static final String TAG = "Car";

    private Driver mDriver;
    private Engine mEngine;
    private Wheels mWheels;
    private int mCarCost;

    /**
     * Dagger first calls constructor,
     * then injects the fields,
     * then calls the injected method
     *
     * Probably don't combine all three in a real app.
     */
    @Inject
    public Car(Driver driver, Engine engine, Wheels wheels, @Named("car cost") int carCost) {
        mDriver = driver;
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
        Log.d(TAG, mDriver + " drives " + this);
    }
}
