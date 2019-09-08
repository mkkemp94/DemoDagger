package com.example.demodagger.dagger;

import com.example.demodagger.car.DieselEngine;
import com.example.demodagger.car.Engine;

import javax.inject.Named;

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
    private int mCost;
    
    public DieselEngineModule(int horsePower, int engineCapacity, int cost) {
        mHorsepower = horsePower;
        mEngineCapacity = engineCapacity;
        mCost = cost;
    }
    
    /**
     * Whenever an INTEGER is needed it can get it from this method.
     * <p>
     * Makes sense now to put horsepower part and engine into separate modules
     * so we can use them independently of each other...
     */
    @Provides
    @Named("horse power")
    int provideHorsePower() {
        return mHorsepower;
    }
    
    @Provides
    @Named("engine capacity")
    int provideEngineCapacity() {
        return mEngineCapacity;
    }
    
    @Provides
    @Named("cost")
    int provideCost() {
        return mCost;
    }
    
    @Provides
    Engine provideEngine(DieselEngine dieselEngine) {
        return dieselEngine;
    }
    
    /**
     * Better performance and more concise.
     * Dagger never creates an instance of this class,
     * so we can't use normal provides methods in this module.
     *
     * @return a new DieselEngine
     */
    
    //    @Binds // doesn't support configuration
    //    abstract Engine bindEngine(DieselEngine engine);
}
