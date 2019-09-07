package com.example.demodagger.dagger;

import com.example.demodagger.car.DieselEngine;
import com.example.demodagger.car.Engine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DieselEngineModule {

    /**
     * Better performance and more concise.
     * Dagger never creates an instance of this class,
     * so we can't use normal provides methods in this module.
     *
     * @return a new DieselEngine
     */

    @Binds
    abstract Engine bindEngine(DieselEngine engine);

    // or

    //    @Provides
    //    static Engine provideEngine() {
    //        return new DieselEngine();
    //    }
}
