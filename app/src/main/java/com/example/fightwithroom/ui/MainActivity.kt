import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fightwithroom.MyApp
import com.example.fightwithroom.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun setupViews() {
        val result = MyApp.app?.getDb()?.getAutDao()?.getAllUsers()?.first()

        tvLogin.text = result?.login
        tvPassword.text = result?.password
    }
}