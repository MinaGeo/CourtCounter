package com.example.courtcounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(),View.OnClickListener {
    var scoreTeamA: Int = 0
    var scoreTeamB: Int = 0
    private lateinit var  totalPointsTeamA: TextView
    private lateinit var  totalPointsTeamB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        totalPointsTeamA = findViewById<TextView>(R.id.teamA_Score)
        totalPointsTeamB = findViewById<TextView>(R.id.teamB_Score)

        val button1: Button = findViewById<Button>(R.id.pts3_A)
        val button2: Button = findViewById<Button>(R.id.pts3_B)
        val button3: Button = findViewById<Button>(R.id.pts2_A)
        val button4: Button = findViewById<Button>(R.id.pts2_B)
        val button5: Button = findViewById<Button>(R.id.FreeThrowA)
        val button6: Button = findViewById<Button>(R.id.FreeThrowB)
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


        if(view?.id == R.id.pts3_A)
        {
            Toast.makeText(this, "3 points added to Team A", Toast.LENGTH_SHORT).show()
            scoreTeamA+=3
            totalPointsTeamA.text = scoreTeamA.toString()
        }
       else if(view?.id == R.id.pts3_B)
        {
            Toast.makeText(this, "3 points added to Team B", Toast.LENGTH_SHORT).show()
            scoreTeamB+=3
            totalPointsTeamB.text = scoreTeamB.toString()

        }
        else if(view?.id == R.id.pts2_A)
        {
            Toast.makeText(this, "2 points added to Team A", Toast.LENGTH_SHORT).show()
            scoreTeamA+=2
            totalPointsTeamA.text = scoreTeamA.toString()

        }
        else if(view?.id == R.id.pts2_B)
        {
            Toast.makeText(this, "2 points added to Team B", Toast.LENGTH_SHORT).show()
            scoreTeamB+=2
            totalPointsTeamB.text = scoreTeamB.toString()

        }
        else if(view?.id == R.id.FreeThrowA)
        {
            Toast.makeText(this, "Free throw to Team A, 1 point added", Toast.LENGTH_SHORT).show()
            scoreTeamA+=1
            totalPointsTeamA.text = scoreTeamA.toString()

        }
        else if(view?.id == R.id.FreeThrowB)
        {
            Toast.makeText(this, "Free throw to Team B, 1 point added", Toast.LENGTH_SHORT).show()
            scoreTeamB+=1
            totalPointsTeamB.text = scoreTeamB.toString()

        }
        else if(view?.id == R.id.button7)
        {
            val intent = Intent()
            intent.action= Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"My text to share")
            intent.type = "text/plain"
            try {
                startActivity(intent)
            }
            catch(exception: Exception)
            {

            }

//            Toast.makeText(this, "All points are reset to 0", Toast.LENGTH_SHORT).show()
//            scoreTeamA = 0
//            scoreTeamB = 0
//            totalPointsTeamA.text = scoreTeamA.toString()
//            totalPointsTeamB.text = scoreTeamB.toString()

        }
        if (scoreTeamA >= 20) {
            openWinnerActivity("A")
        }
        else if (scoreTeamB>=20)
        {
            openWinnerActivity("B")
        }

    }
    private fun openWinnerActivity(winnerTeam: String)
    {
        val intent: Intent = Intent(this, winnerScreen::class.java)
        intent.putExtra("WINNER_TEAM", winnerTeam)

        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {

        super.onSaveInstanceState(outState)
        outState.putInt("TEAM_A_SCORE", scoreTeamA)
        outState.putInt("TEAM_B_SCORE", scoreTeamB)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        scoreTeamA = savedInstanceState.getInt("TEAM_A_SCORE")
        totalPointsTeamA.text = scoreTeamA.toString()
        scoreTeamB = savedInstanceState.getInt("TEAM_B_SCORE")
        totalPointsTeamB.text = scoreTeamB.toString()
    }
}