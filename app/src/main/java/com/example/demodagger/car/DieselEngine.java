package com.example.demodagger.car;

import android.util.Log;

import javax.inject.Inject;

public class DieselEngine implements Engine {
    
    private static final String TAG = "Car";
    
    private int mHorsePower;
    
    @Inject
    public DieselEngine(int horsePower) {
        mHorsePower = horsePower;
    }
    
    @Override
    public void start() {
        Log.d(TAG, "Diesel engine started. Horsepower: " + mHorsePower);
    }
}
