package berlin.code.smartme.smartme

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.habit_choosing_fragment.*


class HabitChoosing : Fragment() {

    companion object {
        fun newInstance() = HabitChoosing()
    }
    private val thisScope = this
    private lateinit var viewModel: HabitChoosingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.habit_choosing_fragment, container, false)
        val btn:Button? = view?.findViewById(R.id.button7)
        btn?.setOnClickListener{v:View -> onAccept(v)}
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HabitChoosingViewModel::class.java)
        // TODO: Use the ViewModel
        text_fragment.text = viewModel.text


    }
     private fun onAccept(view:View?){
        viewModel.count++
        if (viewModel.count == 3) {
            fragmentManager?.beginTransaction()?.remove(thisScope)?.commit()
            Log.d("HabitChoosing","Fragment killed")
        }
    }

}
