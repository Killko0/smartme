package berlin.code.smartme.smartme

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import android.util.Log
import androidx.work.WorkManager
import berlin.code.smartme.smartme.data.HabitsData
import berlin.code.smartme.smartme.data.User
import berlin.code.smartme.smartme.data.UserDatabase
import berlin.code.smartme.smartme.data.UserRepository
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext


class MainViewModel(application: Application) : AndroidViewModel(application){

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)






     init {

         Log.d("NOTIFICATION","Enqueued!")

     }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

}