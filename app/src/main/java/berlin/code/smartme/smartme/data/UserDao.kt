package berlin.code.smartme.smartme.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface UserDao {
        @Query("SELECT * from user_table ORDER BY first_name ASC")
        fun getAllUsers(): List<User>

        @Insert
        fun insert(user: User)

        @Query("DELETE FROM user_table")
        fun deleteAll()
}