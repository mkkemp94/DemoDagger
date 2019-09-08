package com.example.demodagger.dagger;

import com.example.demodagger.car.DieselEngine;
import com.example.demodagger.car.Engine;

import dagger.Module;
import dagger.Provides;

@Module
public class DieselEngineModule {

    // Can also create a provides method for horsepower,
    // but this is only necessary if we want to use this in other places as well
    private int mHorsepower;

    public DieselEngineModule(int horsepower) {
        mHorsepower = horsepower;
    }

    @Provides
    Engine provideEngine() {
        return new DieselEngine(mHorsepower);
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
