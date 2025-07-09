package com.app.myfirebaseauthapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.myfirebaseauthapp.usecases.FirebaseLoginUseCase
import com.app.myfirebaseauthapp.usecases.FirebaseSignUpUseCase
import com.app.myfirebaseauthapp.usecases.GetCurrentUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: FirebaseLoginUseCase,
    private val signUseCase: FirebaseSignUpUseCase,
    private val getCurrentUseUseCase: GetCurrentUserUseCase
) : ViewModel() {

    private val _authUiState = MutableStateFlow(AuthUiState())
    var authUiState = _authUiState.asStateFlow()

    init {
        getCurrentUser()
    }

    fun login(email: String, password: String) {
        _authUiState.value = _authUiState.value.copy(isLoading = true, error = null)

        viewModelScope.launch {
            try {
                val user = loginUseCase(email, password)
                if (user != null) {
                    _authUiState.value = AuthUiState(user = user)
                } else {
                    _authUiState.value = AuthUiState(error = "Login failed")
                }
            } catch (e: Exception) {
                _authUiState.value = AuthUiState(error = e.message ?: "Unknown error")
            }
        }
    }

    fun signUp(email: String, password: String) {
        _authUiState.value = _authUiState.value.copy(isLoading = true, error = null)

        viewModelScope.launch {
            try {
                val user = signUseCase(email, password)
                if (user != null) {
                    _authUiState.value = AuthUiState(user = user)
                } else {
                    _authUiState.value = AuthUiState(error = "Sign-up failed")
                }
            } catch (e: Exception) {
                _authUiState.value = AuthUiState(error = e.message ?: "Unknown error")
            }
        }
    }

    fun getCurrentUser() {
        val currentUser = getCurrentUseUseCase()
        _authUiState.value = AuthUiState(user = currentUser)
    }
}
