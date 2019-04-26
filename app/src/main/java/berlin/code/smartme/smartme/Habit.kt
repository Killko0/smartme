package berlin.code.smartme.smartme

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import org.json.JSONArray

class Habit(private val context: Context, private val dataSource: JSONArray): BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return dataSource.length()
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.layout_habit, parent, false)
        val titleTextView = rowView.findViewById(R.id.habit_title) as TextView
        val descriptionTextView = rowView.findViewById(R.id.habit_description) as TextView
        var habit = dataSource.getJSONObject(position)
        titleTextView.text = habit["title"].toString()
        descriptionTextView.text = habit["description"].toString()

        return rowView
    }

}