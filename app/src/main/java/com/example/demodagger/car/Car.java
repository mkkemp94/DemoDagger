package com.example.demodagger.car;

import android.util.Log;

import javax.inject.Inject;

public class Car {

    private static final String TAG = "Car";

    Engine mEngine;
    Wheels mWheels;

    /**
     * Dagger first calls constructor,
     * then injects the fields,
     * then calls the injected method
     *
     * Probably don't combine all three in a real app.
     */
    @Inject
    public Car(Engine engine, Wheels wheels) {
        mEngine = engine;
        mWheels = wheels;
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
        Log.d(TAG, "Driving...");
    }
}
