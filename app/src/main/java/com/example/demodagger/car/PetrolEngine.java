package com.example.demodagger.car;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class PetrolEngine implements Engine {
    
    private static final String TAG = "Car";
    
    private int mHorsePower;
    private int mEngineCapacity;
    
    /**
     * The named annotation distinguishes between the two integers.
     * It is better to create a custom annotation, preventing typos,
     * but this is okay for now.
     */
    @Inject
    public PetrolEngine(@Named("horse power") int horsePower,
                        @Named("engine capacity") int engineCapacity) {
        mHorsePower = horsePower;
        mEngineCapacity = engineCapacity;
    }
    
    @Override
    public void start() {
        Log.d(TAG, "Petrol engine started. " +
                "\nHorsepower: " + mHorsePower +
                "\nEngine Capacity: " + mEngineCapacity);
    }
}
