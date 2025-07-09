package com.app.myfirebaseauthapp.usecases

import com.app.myfirebaseauthapp.remote.FirebaseAuthService
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(private val authService: FirebaseAuthService) {

    operator fun invoke(): FirebaseUser? {
        return authService.getCurrentUser()
    }
}