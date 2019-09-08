package com.example.demodagger;

import android.app.Application;

import com.example.demodagger.dagger.CarComponent;
import com.example.demodagger.dagger.DaggerCarComponent;

public class ExampleApp extends Application {
    
    private CarComponent mComponent;
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        mComponent = DaggerCarComponent
                .builder()
                .horsePower(150)
                .engineCapacity(1300)
                .cost(17000)
                .carCost(18350)
                .build();
    }
    
    public CarComponent getAppComponent() {
        return mComponent;
    }
}
