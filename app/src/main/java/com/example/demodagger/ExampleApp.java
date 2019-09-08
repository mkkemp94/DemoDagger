package com.example.demodagger;

import android.app.Application;

import com.example.demodagger.dagger.AppComponent;
import com.example.demodagger.dagger.DaggerAppComponent;

public class ExampleApp extends Application {
    
    private AppComponent mComponent;
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        mComponent = DaggerAppComponent.create();
    }
    
    public AppComponent getAppComponent() {
        return mComponent;
    }
}
