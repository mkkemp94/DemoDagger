package com.example.demodagger.dagger;

import dagger.Component;

/**
 * This will inject the driver.
 * <p>
 * Define what we want to expose to the outside -- like Driver.
 * <p>
 * If ActivityComponent is a subcomponent I don't need to expose Driver though.
 * It is available by default.
 */

@AppScope
@Component(modules = DriverModule.class)
public interface AppComponent {
    
    //// For Diesel
    //    ActivityComponent getActivityComponent();
    
    /**
     * For Petrol
     * <p>
     * Pass modules that are not abstract and don't have a default constructor.
     * <p>
     * Prevents having to expose the Driver to our AppComponent.
     * ActivityComponent is automatically able to access it.
     * <p>
     * This is called a factory method.
     */
    ActivityComponent.Builder getActivityComponentBuilder();
}
