package com.example.demodagger;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    /**
     * Better performance and more concise.
     * Dagger never creates an instance of this class,
     * so we can't use normal provides methods in this module.
     *
     * @return a new PetrolEngine
     */

    @Binds
    abstract Engine bindEngine(PetrolEngine engine);

    // or

    //    @Provides
    //    static Engine provideEngine() {
    //        return new PetrolEngine();
    //    }
}
