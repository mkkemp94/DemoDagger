package com.example.demodagger.dagger;

import com.example.demodagger.car.Rims;
import com.example.demodagger.car.Tires;
import com.example.demodagger.car.Wheels;

import dagger.Module;
import dagger.Provides;

/**
 * If we own the classes, we can annotate them with @Inject to use them with Dagger.
 *
 * If not, we have to use modules to create them.
 *
 * Modules are classes that contribute to the object graph.
 */

@Module
public abstract class WheelsModule {

    // If all provides methods are static, this class can be abstract.
    // That way we don't create an instance of it in Dagger
    
    /**
     * If the provider methods don't depend on an instance state of the module,
     * they can be marked as static.
     * @return new Rims object
     */
    @Provides
    static Rims provideRims() {
        // We can't annotate the constructor of rims but we can call it ourselves.
        return new Rims();
    }

    /**
     * Whenever Dagger needs tires it calls this method, creates a Tires object,
     * calls inflate on it, and returns it.
     * @return new Tires object
     */
    @Provides
    static Tires provideTires() {
        Tires tires = new Tires();
        // Can do any configuration necessary on objects before returning them.
        tires.inflate();
        return tires;
    }

    /**
     * Wheels need rims and tires. Now Dagger knows how to create rims and tires!
     * Pass them as arguments, just like in an injected constructor.
     * @return Wheels made from Rims and Tires
     */
    @Provides
    static Wheels provideWheels(Rims rims, Tires tires) {
        return new Wheels(rims, tires);
    }
}
