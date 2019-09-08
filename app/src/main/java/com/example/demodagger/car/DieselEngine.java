package com.example.demodagger.car;

import android.util.Log;

public class DieselEngine implements Engine {

    private static final String TAG = "Car";

    private int mHorsePower;

    public DieselEngine(int horsePower) {
        mHorsePower = horsePower;
    }

    @Override
    public void start() {
        Log.d(TAG, "Diesel engine started. Horsepower: " + mHorsePower);
    }
}
