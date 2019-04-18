package berlin.code.smartme.smartme

import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import java.util.concurrent.TimeUnit


val onetimeHabitNotificationRequest = OneTimeWorkRequestBuilder<NotifyWorker>()
    .setInitialDelay(1,TimeUnit.SECONDS)
    .build()

val repeatingHabitNotificationRequest =
    PeriodicWorkRequestBuilder<NotifyWorker>(1, TimeUnit.HOURS)
        .build()

