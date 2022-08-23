package com.example.courtcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(),View.OnClickListener {
    var result1: Int = 0
    var result2: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val button1: Button = findViewById<Button>(R.id.button1)
        val button2: Button = findViewById<Button>(R.id.button2)
        val button3: Button = findViewById<Button>(R.id.button3)
        val button4: Button = findViewById<Button>(R.id.button4)
        val button5: Button = findViewById<Button>(R.id.button5)
        val button6: Button = findViewById<Button>(R.id.button6)
        val button7: Button = findViewById<Button>(R.id.button7)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        var totalPointsTeamA: TextView = findViewById<TextView>(R.id.text3)
        var totalPointsTeamB: TextView = findViewById<TextView>(R.id.text4)

        if(view?.id == R.id.button1)
        {
            Toast.makeText(this, "3 points added to Team A", Toast.LENGTH_SHORT).show()
            result1+=3
            totalPointsTeamA.setText(result1.toString())
        }
       else if(view?.id == R.id.button2)
        {
            Toast.makeText(this, "3 points added to Team B", Toast.LENGTH_SHORT).show()
            result2+=3
            totalPointsTeamB.setText(result2.toString())

        }
        else if(view?.id == R.id.button3)
        {
            Toast.makeText(this, "2 points added to Team A", Toast.LENGTH_SHORT).show()
            result1+=2
            totalPointsTeamA.setText(result1.toString())

        }
        else if(view?.id == R.id.button4)
        {
            Toast.makeText(this, "2 points added to Team B", Toast.LENGTH_SHORT).show()
            result2+=2
            totalPointsTeamB.setText(result2.toString())

        }
        else if(view?.id == R.id.button5)
        {
            Toast.makeText(this, "Free throw to Team A, 1 point added", Toast.LENGTH_SHORT).show()
            result1+=1
            totalPointsTeamA.setText(result1.toString())

        }
        else if(view?.id == R.id.button6)
        {
            Toast.makeText(this, "Free throw to Team B, 1 point added", Toast.LENGTH_SHORT).show()
            result2+=1
            totalPointsTeamB.setText(result2.toString())

        }
        else if(view?.id == R.id.button7)
        {
            Toast.makeText(this, "All points are reset to 0", Toast.LENGTH_SHORT).show()
            result1 = 0
            result2 = 0
            totalPointsTeamA.setText(result1.toString())
            totalPointsTeamB.setText(result2.toString())

        }

    }

}