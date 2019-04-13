package berlin.code.smartme.smartme

import android.content.Context
import android.support.annotation.NonNull
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotifyWorker(@NonNull context: Context, @NonNull params: WorkerParameters): Worker(context, params) {
    @NonNull
    override fun doWork():Result{
        // Method to trigger an instant notification
        val notificationOneTime = false
        Log.d("Worker","NOTIFICATION FIRED")
        return Result.success()
        // (Returning RETRY tells WorkManager to try this task again
        // later; FAILURE says not to try again.)
    }
}