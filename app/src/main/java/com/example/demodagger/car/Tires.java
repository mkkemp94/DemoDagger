package com.example.demodagger.car;

import android.util.Log;

public class Tires {
    // We don't own this class, so we can't annotate it with @Inject.
    private static final String TAG = "Tires";

    public void inflate() {
        Log.d(TAG, "Tires inflated...");
    }
}
