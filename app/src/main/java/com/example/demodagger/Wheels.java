package com.example.demodagger;

public class Wheels {

    private final Rims mRims;
    private final Tires mTires;

    // We don't own this class, so we can't annotate it with @Inject.
    public Wheels(Rims rims, Tires tires) {
        mRims = rims;
        mTires = tires;
    }
}
