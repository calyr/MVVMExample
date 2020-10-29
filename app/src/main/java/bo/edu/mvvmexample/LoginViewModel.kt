package bo.edu.mvvmexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(val loginRepository: LoginRepository): ViewModel() {
    val model: LiveData<UiModel>
        get() = _model

    private val _model = MutableLiveData<UiModel>()

    sealed class UiModel {
        class Login(val success: Boolean): UiModel()
    }

    fun doLogin(userName: String) {
        _model.value = UiModel.Login( loginRepository.login(userName))
    }



}