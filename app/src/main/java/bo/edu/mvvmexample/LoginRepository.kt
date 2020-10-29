package bo.edu.mvvmexample

class LoginRepository {
    fun login(userName: String) = userName == "secret"
}