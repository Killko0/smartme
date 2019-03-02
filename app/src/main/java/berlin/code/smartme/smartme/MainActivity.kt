package berlin.code.smartme.smartme

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.graphics.Color.parseColor
import android.R
import android.app.Notification.EXTRA_NOTIFICATION_ID
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
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
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.widget.ImageView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    //private lateinit var viewAdapter: RecyclerView.Adapter<*>
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        // Make sure this is before calling super.onCreate
        //setTheme(R.style.Theme_MyApp);

        super.onCreate(savedInstanceState)
        setContentView(berlin.code.smartme.smartme.R.layout.activity_main)
        if (supportActionBar != null) {
            supportActionBar!!.hide();
        }
        //Setting up the bottom navbar
        bottom_navigation.titleState = AHBottomNavigation.TitleState.ALWAYS_HIDE
        bottom_navigation.accentColor = Color.parseColor("#2D9187");

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
        bottom_navigation.setOnTabSelectedListener(AHBottomNavigation.OnTabSelectedListener { position, wasSelected ->
            // Do something cool here...
            Log.d("MainActivity",position.toString())
            true
        })
        bottom_navigation.setOnNavigationPositionListener(AHBottomNavigation.OnNavigationPositionListener {
            // Manage the new y position
        })
        bottom_navigation.addItem(homeItem)
        bottom_navigation.addItem(lightbulbItem)
        bottom_navigation.addItem(historyItem)
        bottom_navigation.addItem(dataItem)
        bottom_navigation.addItem(settingsItem)


        //Populating the horizontal list
        for (i in 0..19) {
            val imageView = ImageView(this)
            imageView.id = i

            var ic = when (i){
                0-> berlin.code.smartme.smartme.R.drawable.square
                1-> R.drawable.ic_dialog_email
                else-> berlin.code.smartme.smartme.R.drawable.square
            }
            imageView.isClickable = true
            imageView.bringToFront()
            imageView.setPadding(2, 2, 2, 2)

            imageView.setOnClickListener{
                    Log.d("MainActivity",imageView.id.toString())
            }
            imageView.setImageResource(
                ic
                )

            imageView.scaleType = ScaleType.FIT_CENTER
            linear.addView(imageView)
        }

        val TAG = "MyBroadcastReceiver"

        class MyBroadcastReceiver : BroadcastReceiver() {

            override fun onReceive(context: Context, intent: Intent) {
                StringBuilder().apply {
                    append("Action: ${intent.action}\n")
                    append("URI: ${intent.toUri(Intent.URI_INTENT_SCHEME)}\n")
                    toString().also { log ->
                        Log.d(TAG, log)
                        Toast.makeText(context, log, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        //Settings up notifications
        val snoozeIntent = Intent(this, MyBroadcastReceiver::class.java).apply {
            //action = ACTION_SNOOZE
            putExtra(EXTRA_NOTIFICATION_ID, 0)
        }
        val snoozePendingIntent: PendingIntent =
            PendingIntent.getBroadcast(this, 0, snoozeIntent, 0)

        val CHANNEL_ID = "ID01"
        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_delete)
            .setContentTitle("SMARTME")
            .setContentText("You just clicked on an element!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(R.drawable.ic_input_add, "DONE",
              snoozePendingIntent)


        fun createNotificationChannel() {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name ="Hello hellooooooooo"
                val descriptionText ="Hello helloooooooo"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                    description = descriptionText
                }
                // Register the channel with the system
                val notificationManager: NotificationManager =
                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }
        }


        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(12, builder.build())
        }





    }
    fun goMethodsOverview(view: View){
        val methodsIntent = Intent(this,MethodsOverview::class.java)
        startActivity(methodsIntent)
    }
}

