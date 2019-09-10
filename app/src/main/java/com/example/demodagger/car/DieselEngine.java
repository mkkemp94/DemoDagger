package com.example.demodagger.car;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class DieselEngine implements Engine {
    
    private static final String TAG = "Car";
    
    private int mHorsePower;
    private int mEngineCapacity;
    
    @Inject
    public DieselEngine(@Named("horse power") int horsePower,
                        @Named("engine capacity") int engineCapacity) {
        mHorsePower = horsePower;
        mEngineCapacity = engineCapacity;
    }
    
    @Override
    public void start() {
        Log.d(TAG, "Diesel engine started. " +
                "\nHorsepower: " + mHorsePower +
                "\nEngine capacity: " + mEngineCapacity);
    }
}
