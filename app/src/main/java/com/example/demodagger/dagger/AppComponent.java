package com.example.demodagger.dagger;

import com.example.demodagger.car.Driver;

import dagger.Component;

/**
 * This will inject the driver.
 *
 * Define what we want to expose to the outside -- like Driver
 */

@AppScope
@Component(modules = DriverModule.class)
public interface AppComponent {
    
    // App is responsible for creating and holding onto driver.
    Driver createDriver();
}
