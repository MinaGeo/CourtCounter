package com.example.courtcounter

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class winnerScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner_screen)
val winnerTeam = intent.getStringExtra("WINNER_TEAM")
        val winnerLabel : TextView= findViewById(R.id.winnerText)
        val trophy : ImageView = findViewById<ImageView>(R.id.trophyImage)
winnerLabel.text ="Team $winnerTeam is the winner"
    }
}