package com.example.demodagger.dagger;

import dagger.Component;

/**
 * This will inject the driver.
 * <p>
 * Define what we want to expose to the outside -- like Driver
 */

@AppScope
@Component(modules = DriverModule.class)
public interface AppComponent {
    
    // App is responsible for creating and holding onto driver.
    // Don't need this if ActivityComponent is a subcomponent
    //    Driver createDriver();
    
    /**
     * Pass modules that are not abstract and don't have a default constructor.
     *
     * Prevents having to expose the Driver to our AppComponent.
     * ActivityComponent is automatically able to access it.
     *
     * This is called a factory method.
     */
    ActivityComponent.Builder getActivityComponentBuilder();
}
