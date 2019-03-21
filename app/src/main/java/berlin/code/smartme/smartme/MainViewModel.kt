package berlin.code.smartme.smartme

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import android.util.Log
import berlin.code.smartme.smartme.data.User
import berlin.code.smartme.smartme.data.UserDatabase
import berlin.code.smartme.smartme.data.UserRepository
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext


class MainViewModel(application: Application) : AndroidViewModel(application){

    private val repository: UserRepository
    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)


    val allUsers: LiveData<List<User>>



     init {
                val wordsDao = UserDatabase.getDatabase(application, scope).userDao()
                repository = UserRepository(wordsDao)

                allUsers = repository.allUsers
                thread(start = true) {
                    Log.d("Thread", Thread.currentThread().toString())
                }
    }

    fun insert(user: User) = scope.launch(Dispatchers.IO) {
        repository.insert(user)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

}