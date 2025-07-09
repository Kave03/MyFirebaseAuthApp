package com.app.myfirebaseauthapp.remote

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthServiceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : FirebaseAuthService {
    override suspend fun register(email: String, password: String): FirebaseUser? {
        return try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await().user
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun login(email: String, password: String): FirebaseUser? {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await().user
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun getCurrentUser(): FirebaseUser? = firebaseAuth.currentUser

}