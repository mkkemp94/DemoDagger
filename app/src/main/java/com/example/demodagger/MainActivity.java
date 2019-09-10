package com.example.demodagger;

import android.os.Bundle;
import android.util.Log;

import com.example.demodagger.car.Car;
import com.example.demodagger.dagger.ActivityComponent;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = "MainActivity";
    
    @Inject public Car mCar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Diesel
        //        ActivityComponent component = ((ExampleApp) getApplication())
        //                .getAppComponent()
        //                .getActivityComponentBuilder(new DieselEngineModule(
        //                        100,
        //                        1200));
        
        // Petrol
        ActivityComponent component = ((ExampleApp) getApplication())
                .getAppComponent()
                .getActivityComponentBuilder()
                .horsePower(150)
                .engineCapacity(1300)
                .build();
        
        
        component.inject(this);
        
        Log.d(TAG, "onCreate: First car already injected.");
        mCar.drive();
        
        // Constructor injection
        Log.d(TAG, "onCreate: Creating car by asking component to create it.");
        Car createdCar = component.createCar();
        createdCar.drive();
        
        //        // Custom
        //        Log.d(TAG, "onCreate: Creating car by asking component to create custom object.");
        //        TestCarObject testCarObject = component.createTestCarObject();
        //        testCarObject.driveFieldCar();
    }
}
