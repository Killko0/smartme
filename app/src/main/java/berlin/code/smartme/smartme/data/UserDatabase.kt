package berlin.code.smartme.smartme.data

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.*
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Declaring the DB TODO Change name to app database
@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase : RoomDatabase()  {
    abstract fun userDao(): UserDao

    //Making sure its singleton, meaning there only can be one instance of the DB at a time
    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): UserDatabase {
            val tempInstance = INSTANCE
            //Checking whether instance of DB already exists or not
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "User_database"
                ).addCallback(Companion.UserDatabaseCallback(scope)).build() //.allowMainThreadQueries()
                INSTANCE = instance
                return instance
            }
        }

        //Pre-populating the DB on a co-routine
        private class UserDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.userDao())
                    }
                }
            }
        }

        fun populateDatabase(userDao: UserDao) {
            userDao.deleteAll()

            var user = User(5,"Mohsen")
            userDao.insert(user)


        }
    }
}