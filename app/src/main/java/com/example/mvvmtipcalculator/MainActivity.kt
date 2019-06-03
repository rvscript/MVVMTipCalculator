package com.example.mvvmtipcalculator

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.example.mvvmtipcalculator.databinding.ActivityMainBinding
import com.example.mvvmtipcalculator.viewmodel.CalculatorViewModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

/*
This is where we wire up our data binding from the xml
ActivityTipCalculatorBinding was created the moment we wrapped the layout in a layout tag in the xml
- the naming comes from the name of our layout file and it contains some useful properties
- properties:
    - a reference to every view that we 've given an id to in our layout.
    - this gives us a much more efficient way to access the views then using findViewById()
    -
 */
    lateinit var binding: com.example.mvvmtipcalculator.databinding.ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//      create a databinding version of setContentView which binds and inflates the layout and returns it all in one shot
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//        now the view model is wired up to the view
        binding.vm = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)

        setSupportActionBar(binding.toolbar)

        calculate_fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
