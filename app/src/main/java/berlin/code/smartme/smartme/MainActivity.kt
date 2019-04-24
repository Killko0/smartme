package berlin.code.smartme.smartme

import android.Manifest
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.R
import android.graphics.Color
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ImageView.ScaleType
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat.startActivity
import android.widget.ImageView
import berlin.code.smartme.smartme.data.HabitsData
import kotlinx.android.synthetic.main.fragment_bottom_navigation.*

class MainActivity : AppCompatActivity(){
    private lateinit var habitsData : HabitsData

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {

        // Make sure this is before calling super.onCreate
        //setTheme(R.style.Theme_MyApp);
        super.onCreate(savedInstanceState)
        habitsData= HabitsData()
        habitsData.readJson(assets.open("habits.json"))

        val initIntent = Intent(this, Roadmap::class.java)
        startActivity(initIntent)
        val serviceIntent= Intent(this, LocationService::class.java)
        startService(serviceIntent)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 2)

            setContentView(berlin.code.smartme.smartme.R.layout.activity_main)
            if (supportActionBar != null) {
                supportActionBar!!.hide()
            }
            //Setting up the bottom navbar
            //bottom_navigation.titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW
            //bottom_navigation.accentColor = Color.parseColor("#2D9187");

            val homeItem = AHBottomNavigationItem(
                "",
                berlin.code.smartme.smartme.R.drawable.home2
            )
            val dataItem = AHBottomNavigationItem(
                "",
                berlin.code.smartme.smartme.R.drawable.data2
            )
            val historyItem = AHBottomNavigationItem(
                "Home",
                berlin.code.smartme.smartme.R.drawable.history
            )
            val settingsItem = AHBottomNavigationItem(
                "Home",
                berlin.code.smartme.smartme.R.drawable.settings
            )
            val lightbulbItem = AHBottomNavigationItem(
                "Home",
                berlin.code.smartme.smartme.R.drawable.lightbulb
            )
            //bottom_navigation.setOnTabSelectedListener(AHBottomNavigation.OnTabSelectedListener { position, wasSelected ->
                // Do something cool here...
                //Log.d("MainActivity1", position?.toString())
                true
//            })
//            bottom_navigation.setOnNavigationPositionListener(AHBottomNavigation.OnNavigationPositionListener {
//                // Manage the new y position
//            })
//            bottom_navigation.addItem(homeItem)
//            bottom_navigation.addItem(lightbulbItem)
//            bottom_navigation.addItem(historyItem)
//            bottom_navigation.addItem(dataItem)
//            bottom_navigation.addItem(settingsItem)


            //Populating the horizontal list
            for (i in 0..19) {
                val imageView = ImageView(this)
                imageView.id = i

                var ic = when (i) {
                    0 -> berlin.code.smartme.smartme.R.drawable.square
                    1 -> R.drawable.ic_dialog_email
                    else -> berlin.code.smartme.smartme.R.drawable.square
                }
                imageView.isClickable = true
                imageView.bringToFront()
                imageView.setPadding(2, 2, 2, 2)

                imageView.setOnClickListener {
                    //Log.d("MainActivity", imageView.id.toString())
                }
                imageView.setImageResource(
                    ic
                )

                imageView.scaleType = ScaleType.FIT_CENTER
                linear.addView(imageView)
            }

    }
    fun goMethodsOverview(view: View){
        val methodsIntent = Intent(this,MethodsOverview::class.java)
        startActivity(methodsIntent)
    }
}

