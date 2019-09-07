package com.example.demodagger;

import android.util.Log;

import javax.inject.Inject;

class TestCarObjectFieldInjection {

    private static final String TAG = "TestCarObjectFieldInjection";

    // Field injection is meant for framework classes where we don't have access to the constructor.
    // Using it in classes like these is discouraged.
    // Use constructor injection where possible.

    // I can also make the constructor injectable and then  inject fields...
    // But this seems like bad practice too because I'm creating a new car out of thin air
    @Inject
    Car car3;

    @Inject
    public TestCarObjectFieldInjection() {
        // This is having this constructor annotated with @Inject
        // And also having the CarComponent create this object instead of MainActivity
        // Is the same as before
        // Where I created a new one of this object and passed it a component
    }

    public void driveFieldCar() {
        Log.d(TAG, "CarFieldInjection: driveFieldCar");
        car3.drive();
    }
}
