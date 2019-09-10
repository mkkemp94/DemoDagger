package com.example.demodagger.dagger;

import com.example.demodagger.car.Driver;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class DriverModule {
    
    @Provides
    @AppScope
    static Driver provideDriver() {
        return new Driver();
    }
}
