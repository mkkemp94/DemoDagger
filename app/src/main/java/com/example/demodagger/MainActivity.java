package com.example.demodagger;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // Field injection
    @Inject public Car mCar;
    @Inject public Car mCar2;
    @Inject public Car mCar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent component = DaggerCarComponent.create();

        // Populate my fields for me
        component.inject(this);

        Log.d(TAG, "onCreate: first car field");
        mCar.drive();

        Log.d(TAG, "onCreate: second car field");
        mCar2.drive();

        Log.d(TAG, "onCreate: third car field");
        mCar3.drive();

        TestCarObjectFieldInjection testCarObjectFieldInjection = new TestCarObjectFieldInjection(component);
        testCarObjectFieldInjection.driveFieldCar();
        testCarObjectFieldInjection.createCarAndDrive();

        // Constructor injection
        Log.d(TAG, "onCreate: Car created by component directly");
        Car createdCar = component.createCar();
        createdCar.drive();
    }
}
