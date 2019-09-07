package com.example.demodagger;

import android.util.Log;

import javax.inject.Inject;

public class Car {

    private static final String TAG = "Car";

    Engine mEngine;
    Wheels mWheels;

    @Inject
    public Car(Engine engine, Wheels wheels) {
        mEngine = engine;
        mWheels = wheels;
    }

    public void drive() {
        Log.d(TAG, "Driving...");
    }
}
