package bo.edu.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val repository = LoginRepository()
        loginViewModel = LoginViewModel(repository)

        loginViewModel.model.observe(this, Observer(::updateUi))

        buttonLogin.setOnClickListener {
            loginViewModel.doLogin(editTextUser.text.toString())
        }
    }

    fun updateUi(model: LoginViewModel.UiModel) {
        when(model) {
            is LoginViewModel.UiModel.Login -> showMessage(model.success)
        }
    }

    fun showMessage(resp: Boolean) {
        if(resp) {
            Toast.makeText(this, R.string.login_success, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, R.string.login_error, Toast.LENGTH_LONG).show()
        }
    }
}