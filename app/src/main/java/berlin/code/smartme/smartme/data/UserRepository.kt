package berlin.code.smartme.smartme.data

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

class UserRepository(private val userDao: UserDao) {

    val allUsers: List<User> = userDao.getAllUsers()

    @WorkerThread
    suspend fun insert(user: User) {
        userDao.insert(user)
    }
}