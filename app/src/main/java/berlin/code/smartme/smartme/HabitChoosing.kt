package berlin.code.smartme.smartme

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import berlin.code.smartme.smartme.data.HabitsData
import kotlinx.android.synthetic.main.habit_choosing_fragment.*
import org.json.JSONArray


class HabitChoosing : Fragment() {
    var habits= JSONArray()
    companion object {
        fun newInstance() = HabitChoosing()
    }
    private val thisScope = this
    private lateinit var viewModel: HabitChoosingViewModel
    private lateinit var habitsData : HabitsData


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.habit_choosing_fragment, container, false)
        val btn:Button? = view?.findViewById(R.id.button7)
        btn?.setOnClickListener{v:View -> viewModel.onAccept(v,thisScope)}
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HabitChoosingViewModel::class.java)
        // TODO: Use the ViewModel
        val habit = habits.getJSONObject(viewModel.count)


        val title = habit["title"].toString()
        val description = habit["description"].toString()
        Log.d("habits",title)
        habit_title.text = title
        habit_description.text = description



    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        habitsData= HabitsData()

        if(context != null){
            habits = habitsData.readJson(context.assets.open("habits.json"))
        }

    }
     private fun onAccept(view:View?){

    }

}
