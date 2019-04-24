package berlin.code.smartme.smartme

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_bottom_navigation.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BottomNavigation.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BottomNavigation.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BottomNavigation : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    //private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
        //Setting up the bottom navbar
        //bottom_navigation.titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW
        //bottom_navigation.accentColor = Color.parseColor("#2D9187");

        val homeItem = AHBottomNavigationItem(
            "",
            R.drawable.home2
        )
        val dataItem = AHBottomNavigationItem(
            "",
            R.drawable.data2
        )
        val historyItem = AHBottomNavigationItem(
            "Home",
            R.drawable.history
        )
        val settingsItem = AHBottomNavigationItem(
            "Home",
            R.drawable.settings
        )
        val lightbulbItem = AHBottomNavigationItem(
            "Home",
            R.drawable.lightbulb
        )
//        bottom_navigation.setOnTabSelectedListener(AHBottomNavigation.OnTabSelectedListener { position, wasSelected ->
//            // Do something cool here...
//            //Log.d("MainActivity1", position?.toString())
//            true
//        })
//        bottom_navigation.setOnNavigationPositionListener(AHBottomNavigation.OnNavigationPositionListener {
//            // Manage the new y position
//        })
//        bottom_navigation.addItem(homeItem)
//        bottom_navigation.addItem(lightbulbItem)
//        bottom_navigation.addItem(historyItem)
//        bottom_navigation.addItem(dataItem)
//        bottom_navigation.addItem(settingsItem)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_navigation, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
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
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BottomNavigation.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BottomNavigation().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
