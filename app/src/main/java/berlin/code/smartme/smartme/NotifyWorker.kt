package berlin.code.smartme.smartme

import android.R
import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.SystemClock
import android.support.annotation.NonNull
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.content.ContextCompat.getSystemService
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotifyWorker(@NonNull val context: Context, @NonNull params: WorkerParameters): Worker(context, params) {
    @NonNull
    override fun doWork():Result{
        // Method to trigger an instant notification
        val notificationOneTime = false
        Log.d("Worker","NOTIFICATION FIRED")
        //Settings up notifications
        val snoozeIntent = Intent(context, MyBroadcastReceiver::class.java).apply {
            //action = ACTION_SNOOZE
            Log.d("SnoozeIntent","Snooze intent fired!")
            putExtra(Notification.EXTRA_NOTIFICATION_ID, 0)
        }
        val notificationIntent = Intent(context, MyBroadcastReceiver::class.java).apply {
            Log.d("SnoozeIntent","Notification intent fired!")
        }

        val snoozePendingIntent: PendingIntent =
            PendingIntent.getBroadcast(context, 0, snoozeIntent, 0)

        val CHANNEL_ID = "ID01"
        var builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_delete)
            .setContentTitle("Marcou")
            .setContentText("You just clicked on an element!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(
                R.drawable.ic_input_add, "DONE",
                snoozePendingIntent
            )


        fun createNotificationChannel() {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Hello hellooooooooo"
                val descriptionText = "Hello helloooooooo"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                    description = descriptionText
                }
                // Register the channel with the system
                val notificationManager: NotificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }
        }
        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(12, builder.build())
        }

        return Result.success()
        // (Returning RETRY tells WorkManager to try this task again
        // later; FAILURE says not to try again.)
    }
}