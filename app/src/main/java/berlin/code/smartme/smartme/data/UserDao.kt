package berlin.code.smartme.smartme.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
//Document access object, contains all queries
@Dao
interface UserDao {
        @Query("SELECT * from user_table ORDER BY first_name ASC")
         fun getAllUsers(): LiveData<List<User>>

        @Insert
        fun insert(user: User)

        @Query("DELETE FROM user_table")
        fun deleteAll()
}