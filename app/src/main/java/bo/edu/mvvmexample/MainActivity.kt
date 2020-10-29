package bo.edu.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var counter: Int = 0
    lateinit var liveDataString: LiveDataString
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        liveDataString = LiveDataString()
        liveDataString.cadena.observe(this, Observer(::updateUi))

        button.setOnClickListener {
            counter++
            //textView.text = counter.toString()
            liveDataString.cambiarValor(counter.toString())
        }
    }
    fun updateUi(s: String) {
        textView.text = s
    }
}

class LiveDataString: ViewModel() {
    val cadena: LiveData<String>
        get() = _cadena

    private val _cadena = MutableLiveData<String>()

    fun cambiarValor(string: String) {
        _cadena.value = string
    }
}