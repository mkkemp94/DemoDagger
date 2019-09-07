package com.example.demodagger;

import android.os.Bundle;
import android.util.Log;

import com.example.demodagger.car.Car;
import com.example.demodagger.car.TestCarObject;
import com.example.demodagger.dagger.CarComponent;
import com.example.demodagger.dagger.DaggerCarComponent;

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

        // Field injection
        component.inject(this);

        Log.d(TAG, "onCreate: First car already created using field injection.");
        mCar.drive();

        Log.d(TAG, "onCreate: Second car already created using field injection.");
        mCar2.drive();

        Log.d(TAG, "onCreate: Third car already created using field injection.");
        mCar3.drive();

        // Constructor injection
        Log.d(TAG, "onCreate: Creating car by asking component to create it.");
        Car createdCar = component.createCar();
        createdCar.drive();

        // Custom
        Log.d(TAG, "onCreate: Creating car by asking component to create custom object.");
        TestCarObject testCarObject = component.createTestCarObject();
        testCarObject.driveFieldCar();
    }
}
