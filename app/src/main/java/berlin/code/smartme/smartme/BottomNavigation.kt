package berlin.code.smartme.smartme

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import kotlinx.android.synthetic.main.fragment_bottom_navigation.*

class BottomNavigation : Fragment() {
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_navigation, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Bottom",activity?.localClassName.toString())

        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Setting up the bottom navbar
        bottom_navigation?.titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW
        bottom_navigation?.accentColor = Color.parseColor("#0D65C1")
        val roadmapItem = AHBottomNavigationItem(
            "Roadmap",
            R.drawable.ic_roadmap
        )
        val tasksItem = AHBottomNavigationItem(
            "Tasks",
            R.drawable.ic_tasks
        )
        val billItem = AHBottomNavigationItem(
            "Bill Overview",
            R.drawable.ic_billing
        )
        val settingsItem = AHBottomNavigationItem(
            "Settings",
            R.drawable.ic_settings
        )

        bottom_navigation.setOnTabSelectedListener { position, wasSelected ->
            Log.d("Bottombar", position.toString())
            var initIntent=Intent(context, Roadmap::class.java)
            when(position){
                1-> initIntent= Intent(context, MethodsOverview::class.java)
            }
            startActivity(initIntent)
            true
        }
        bottom_navigation.setOnNavigationPositionListener {
            // Manage the new y position
        }
        bottom_navigation.addItem(roadmapItem)
        bottom_navigation.addItem(tasksItem)
        bottom_navigation.addItem(billItem)
        bottom_navigation.addItem(settingsItem)
//        when(activity?.localClassName){
//            "MethodsOverview"-> bottom_navigation.currentItem = 1
//            "Roadmap"-> bottom_navigation.currentItem = 0
//        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }
}
