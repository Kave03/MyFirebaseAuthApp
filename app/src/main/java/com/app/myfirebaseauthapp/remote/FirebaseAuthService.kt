package com.app.myfirebaseauthapp.remote

import com.google.firebase.auth.FirebaseUser

interface FirebaseAuthService {

    suspend fun register(email: String, password: String): FirebaseUser?

    suspend fun login(email: String, password: String): FirebaseUser?

    fun getCurrentUser(): FirebaseUser?
}