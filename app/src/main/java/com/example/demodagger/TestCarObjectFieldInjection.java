package com.example.demodagger;

import android.util.Log;

import javax.inject.Inject;

class TestCarObjectFieldInjection {

    private static final String TAG = "TestCarObjectFieldInjection";

    // Field injection is meant for framework classes where we don't have access to the constructor.
    // Using it in classes like these is discouraged.
    // Use constructor injection where possible.
    @Inject
    Car car3;

    private CarComponent mComponent;

    public TestCarObjectFieldInjection(CarComponent component) {
        mComponent = component;
        component.inject(this);
    }

    public void driveFieldCar() {
        Log.d(TAG, "CarFieldInjection: driveFieldCar");
        car3.drive();
    }

    public void createCarAndDrive() {
        Log.d(TAG, "CarFieldInjection: createCarAndDrive");
        Car car = mComponent.createCar();
        car.drive();
    }
}
