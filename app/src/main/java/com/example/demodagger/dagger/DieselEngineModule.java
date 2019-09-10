package com.example.demodagger.dagger;

import com.example.demodagger.car.DieselEngine;
import com.example.demodagger.car.Engine;

import dagger.Module;
import dagger.Provides;

@Module
public class DieselEngineModule {
    
    /**
     * This passes the value at runtime to a module.
     * which puts the value into the dependency graph.
     * You later need to provide it using a provide method.
     * <p>
     * Consider the following instead:
     * <p>
     * It is more efficient to use a custom builder.
     * That way you can use BindsInstance to get variables into the graph at runtime.
     * Dagger doesn't need to create an instance of the module if BindsInstance is used.
     * <p>
     * See PetrolEngineModule.java later
     */
    private int mHorsepower;
    private int mEngineCapacity;
    
    public DieselEngineModule(int horsePower, int engineCapacity) {
        mHorsepower = horsePower;
        mEngineCapacity = engineCapacity;
    }
    
    /**
     * Whenever an INTEGER is needed it can get it from this method.
     * <p>
     * Makes sense now to put horsepower part and engine into separate modules
     * so we can use them independently of each other...
     */
    @Provides
    @QualifierHorsepower
    int provideHorsePower() {
        return mHorsepower;
    }
    
    @Provides
    @QualifierEngineCapacity
    int provideEngineCapacity() {
        return mEngineCapacity;
    }
    
    @Provides
    Engine provideEngine(DieselEngine dieselEngine) {
        return dieselEngine;
    }
    
}
