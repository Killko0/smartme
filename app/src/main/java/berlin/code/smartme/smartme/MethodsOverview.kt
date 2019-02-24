package berlin.code.smartme.smartme

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_methods_overview.*

class MethodsOverview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_methods_overview)
        setSupportActionBar(toolbar)
        val methods = arrayOf("Close the windows","Switch off the lights","Don't use electricity","Close the windows","Switch off the lights","Don't use electricity","Close the windows","Switch off the lights","Don't use electricity","Close the windows","Switch off the lights","Don't use electricity","Close the windows","Switch off the lights","Don't use electricity","Close the windows","Switch off the lights","Don't use electricity")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, methods)
        val listView: ListView = findViewById(R.id.listview)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.d("MethodsOverview", listView.getItemAtPosition(position).toString())
        }
        listView.setOnItemClickListener{
            parent, view, position, id -> val methodsIntent = Intent(this,MethodDetailActivity::class.java)
            startActivity(methodsIntent)
        }


    }

    fun displayMethodDetail(view:View){
        val methodsIntent = Intent(this,MethodDetailActivity::class.java)
        startActivity(methodsIntent)
    }

}

