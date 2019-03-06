package berlin.code.smartme.smartme.survey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import berlin.code.smartme.smartme.MainActivity
import berlin.code.smartme.smartme.R

class Survey_6 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide();
        }
        setContentView(R.layout.activity_survey_6)
    }
    fun nextStep(view: View){
        val surveyIntent = Intent(this, MainActivity::class.java)
        startActivity(surveyIntent)
    }
}
