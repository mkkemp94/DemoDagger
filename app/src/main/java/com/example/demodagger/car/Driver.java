package com.example.demodagger.car;

import com.example.demodagger.dagger.AppScope;

/**
 * Lives as long as the application is alive.
 */
@AppScope
public class Driver {
    // We don't own this class, so we can't annotate it with @Inject.
}
