package berlin.code.smartme.smartme

import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View

class HabitChoosingViewModel : ViewModel() {
    // TODO: Give it more functionality
    val text = "HELLO"
    var count = 0
    fun onAccept(view: View, fragment:Fragment){
        count++
        if (count == 3) {
            fragment.fragmentManager?.beginTransaction()?.remove(fragment)?.commit()
            Log.d("HabitChoosing","Fragment killed")
        }
    }

}
