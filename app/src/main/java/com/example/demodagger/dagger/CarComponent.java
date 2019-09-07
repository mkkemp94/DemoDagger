package com.example.demodagger.dagger;

import com.example.demodagger.MainActivity;
import com.example.demodagger.car.Car;
import com.example.demodagger.car.TestCarObject;

import dagger.Component;

/**
 * The component is the most important piece of Dagger.
 * <p>
 * Creates and stores objects ... and then provides them to us.
 * Can also be called injector.
 * <p>
 * Dependency Graph: ... Directed Acyclic Graph ... DAG
 * <p>
 * Block Cylinder Spark Plugs    Tires         Rims
 *     ^      Engine     ^          ^   Wheels  ^
 *                ^         Car          ^
 * <p>
 * At compile time Dagger will implement this interface
 * and create all the necessary code.
 * <p>
 * We also need to tell the component to use our custom modules.
 * Dagger will put this module into our component
 * so that it knows where to get objects it needs from.
 */

@Component(modules = {
        WheelsModule.class,

        // Can't use both or Dagger won't know which engine to use
        PetrolEngineModule.class,
//        DieselEngineModule.class // Swap modules to easily test app

})
public interface CarComponent {

    // Create a car object
    Car createCar();

    TestCarObject createTestCarObject();

    // Here's my object, please fill out its fields
    void inject(MainActivity mainActivity);

    void inject(TestCarObject testCarObjectObjectFieldInjection);
}
