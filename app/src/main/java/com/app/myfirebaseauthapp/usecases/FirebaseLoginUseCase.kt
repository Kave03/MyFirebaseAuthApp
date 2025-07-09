package com.app.myfirebaseauthapp.usecases

import com.app.myfirebaseauthapp.remote.FirebaseAuthService
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class FirebaseLoginUseCase @Inject constructor(private val authService: FirebaseAuthService) {

    suspend operator fun invoke(email: String, password: String): FirebaseUser? {
        return authService.login(email, password)
    }
}