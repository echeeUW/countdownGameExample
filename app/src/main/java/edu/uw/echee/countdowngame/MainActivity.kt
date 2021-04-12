package edu.uw.echee.countdowngame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val gameViewModel: CountdownViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameViewModel.progress.observe(this, Observer { progress ->
            findViewById<TextView>(R.id.tvProgress).text = progress.toString()
        })

        findViewById<Button>(R.id.btnP1).setOnClickListener {
            gameViewModel.onLossProgress()
        }

        findViewById<Button>(R.id.btnP2).setOnClickListener {
            gameViewModel.onAddProgress()
        }



    }
}
