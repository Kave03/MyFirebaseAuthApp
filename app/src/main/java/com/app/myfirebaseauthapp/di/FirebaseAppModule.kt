package com.app.myfirebaseauthapp.di

import com.app.myfirebaseauthapp.remote.FirebaseAuthService
import com.app.myfirebaseauthapp.remote.FirebaseAuthServiceImpl
import com.app.myfirebaseauthapp.usecases.FirebaseLoginUseCase
import com.app.myfirebaseauthapp.usecases.FirebaseSignUpUseCase
import com.app.myfirebaseauthapp.usecases.GetCurrentUserUseCase
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseAppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseAuthService(auth: FirebaseAuth): FirebaseAuthService {
        return FirebaseAuthServiceImpl(auth)
    }

    @Provides
    @Singleton
    fun provideLoginUseCase(authService: FirebaseAuthService): FirebaseLoginUseCase {
        return FirebaseLoginUseCase(authService)
    }

    @Provides
    @Singleton
    fun provideSignUpUseCase(authService: FirebaseAuthService): FirebaseSignUpUseCase {
        return FirebaseSignUpUseCase(authService)
    }

    @Provides
    @Singleton
    fun provideGetCurrentUserUseCase(authService: FirebaseAuthService): GetCurrentUserUseCase {
        return GetCurrentUserUseCase(authService)
    }
}