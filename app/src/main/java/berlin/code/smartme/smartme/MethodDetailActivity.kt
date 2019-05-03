package berlin.code.smartme.smartme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MethodDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        setContentView(R.layout.activity_method_detail)

    }
}
