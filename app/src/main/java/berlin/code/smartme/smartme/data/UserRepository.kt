package berlin.code.smartme.smartme.data

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import kotlin.coroutines.CoroutineContext

//Repository that provides a clean API to the rest of the app, mainly for deciding whether to fetch locally or from network
class UserRepository(private val userDao: UserDao) {

    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    @WorkerThread
    suspend fun insert(user: User) {
        userDao.insert(user)
    }
}