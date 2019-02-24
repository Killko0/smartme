package berlin.code.smartme.smartme

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.graphics.Color.parseColor
import android.R
import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ImageView.ScaleType
import android.graphics.BitmapFactory
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    //private lateinit var viewAdapter: RecyclerView.Adapter<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(berlin.code.smartme.smartme.R.layout.activity_main)
        //Setting up the bottom navbar
        bottom_navigation.setBehaviorTranslationEnabled (false)
        val item1 = AHBottomNavigationItem(
           "Home",
            R.drawable.ic_delete
        )
        bottom_navigation.addItem(item1)
        bottom_navigation.addItem(item1)
        bottom_navigation.addItem(item1)
        bottom_navigation.addItem(item1)

        for (i in 0..19) {
            val imageView = ImageView(this)
            imageView.setId(i)
            imageView.setPadding(2, 2, 2, 2)
            imageView.setImageBitmap(
                BitmapFactory.decodeResource(
                    resources, R.drawable.ic_delete
                )
            )
            imageView.setScaleType(ScaleType.FIT_XY)
            linear.addView(imageView)
        }





    }
    fun goMethodsOverview(view: View){
        val methodsIntent = Intent(this,MethodsOverview::class.java)
        startActivity(methodsIntent)
    }
}

