package com.example.demodagger;

import dagger.Component;

/**
 * The component is the most important piece of Dagger.
 *
 * Creates and stores objects ... and then provides them to us.
 * Can also be called injector.
 *
 * Dependency Graph: ... Directed Acyclic Graph ... DAG
 *
 * Block Cylinder Spark Plugs    Tires   Rims
 *   ^      Engine     ^           Wheels  ^
 *             ^         Car          ^
 *
 * At compile time Dagger will implement this interface
 * and create all the necessary code.
 *
 * We also need to tell the component to use our custom modules.
 * Dagger will put this module into our component
 * so that it knows where to get objects it needs from.
 */

@Component (modules = WheelsModule.class)
public interface CarComponent {

    // Create a car object
    Car createCar();
    TestCarObject createTestCarObject();

    // Here's my object, please fill out its fields
    void inject(MainActivity mainActivity);

    void inject(TestCarObject testCarObjectObjectFieldInjection);
}
