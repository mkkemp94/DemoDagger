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
 */

@Component
public interface CarComponent {

    // Create a car object
    Car createCar();

    // Here's my object, please fill out its fields
    void inject(MainActivity mainActivity);
    void inject(TestCarObjectFieldInjection testCarObjectObjectFieldInjection);
}
