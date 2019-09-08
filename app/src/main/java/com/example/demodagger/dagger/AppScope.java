package com.example.demodagger.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Lifetime is for the full application.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface AppScope {}