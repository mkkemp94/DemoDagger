package com.example.demodagger.car;

import android.util.Log;

import com.example.demodagger.dagger.QualifierEngineCapacity;
import com.example.demodagger.dagger.QualifierHorsepower;

import javax.inject.Inject;

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
    public PetrolEngine(@QualifierHorsepower int horsePower,
                        @QualifierEngineCapacity int engineCapacity) {
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
