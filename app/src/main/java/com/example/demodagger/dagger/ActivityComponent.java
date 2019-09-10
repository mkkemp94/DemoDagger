package com.example.demodagger.dagger;

import com.example.demodagger.MainActivity;
import com.example.demodagger.car.Car;

import dagger.BindsInstance;
import dagger.Subcomponent;

/**
 * The component is the most important piece of Dagger.
 * <p>
 * Creates and stores objects ... and then provides them to us.
 * Can also be called injector.
 * <p>
 * Dependency Graph: ... Directed Acyclic Graph ... DAG
 * <p>
 * Block Cylinder Spark Plugs    Tires         Rims
 * ^      Engine     ^          ^   Wheels  ^
 * ^         Car          ^
 * <p>
 * At compile time Dagger will implement this interface
 * and create all the necessary code.
 * <p>
 * We also need to tell the component to use our custom modules.
 * Dagger will put these modules into our component
 * so that it knows where to get objects it needs from.
 */

@ActivityScope
@Subcomponent(modules = {
        WheelsModule.class,
        
        // Can't use both or Dagger won't know which engine to use
        // Swap modules to easily test app
        PetrolEngineModule.class,
        //        DieselEngineModule.class
    
})
public interface ActivityComponent {
    
    // Create a car object
    Car createCar();
    
    // Here's my class, please fill out its fields
    void inject(MainActivity mainActivity);
    
    // TestCarObject createTestCarObject();
    // void inject(TestCarObject testCarObjectObjectFieldInjection);
    
    /**
     * Define the API for our car component builder ourselves.
     * Must define all methods that would be generated on their own.
     */
    @Subcomponent.Builder
    interface Builder {
        
        /**
         * Allows method chain call for horsepower on the builder.
         * <p>
         * This allows PetrolModule to be abstract and we don't have to pass anything to it.
         * Dagger doesn't have to instantiate anything which makes the code more efficient.
         * <p>
         * Should prefer BindsInstance over module constructor arguments wherever possible.
         * <p>
         * By naming these parameters we can use multiple of the same type.
         * Hard coding the strings is prone to typos, but we can make custom annotations instead.
         * Won't do here but I know how to do it!!
         * <p>
         * This gets variables into dependency graph at runtime
         *
         * @param horsePower the horsepower we need
         * @return the builder itself
         */
        @BindsInstance
        Builder horsePower(@QualifierHorsepower int horsePower);
        
        @BindsInstance
        Builder engineCapacity(@QualifierEngineCapacity int engineCapacity);
        
        // Dagger will implement this method.
        ActivityComponent build();
    }
}
