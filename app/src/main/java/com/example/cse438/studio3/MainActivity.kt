package com.example.cse438.studio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438.studio3.Adapter.BreweryListAdapter
import com.example.cse438.studio3.data.Brewery
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var breweryList: ArrayList<Brewery> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = BreweryListAdapter(breweryList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //get the ViewModel
        val viewModel = ViewModelProviders.of(this).get(BreweryViewModel::class.java)


        viewModel.breweryList.observe(this, Observer {
            breweryList.clear()
            breweryList.addAll(it)

            adapter.notifyDataSetChanged()
        })


        search_button.setOnClickListener {
            val input = search_box.text.toString()
            viewModel.searchBreweries(input)
        }
    }
}
