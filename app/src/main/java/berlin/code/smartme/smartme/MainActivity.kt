package berlin.code.smartme.smartme

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.graphics.Color.parseColor
import android.R
import android.graphics.Color
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(berlin.code.smartme.smartme.R.layout.activity_main)
        //val bottomNavigation = bottom_navigation as AHBottomNavigation
        bottom_navigation.setBehaviorTranslationEnabled (false)
        val item1 = AHBottomNavigationItem(
           "Home",
            R.drawable.ic_delete
        )
        bottom_navigation.addItem(item1)
        bottom_navigation.addItem(item1)
        bottom_navigation.addItem(item1)
        bottom_navigation.addItem(item1)

    }
    fun goMethodsOverview(view: View){
        val methodsIntent = Intent(this,MethodsOverview::class.java)
        Log.d("MainActivity","Works!!!!!!")
        startActivity(methodsIntent)
    }
}
