package com.internshala.showapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailScreen : AppCompatActivity() {
    lateinit var detailImage:ImageView
    lateinit var detailMovieName:TextView
    lateinit var detailMovieLanguage:TextView
    lateinit var detailMovieGenere:TextView
    lateinit var detailMovieStatus:TextView
    lateinit var detailMovieRating:TextView
    lateinit var detailMovieRuntime:TextView
    lateinit var detailMovieType:TextView
    lateinit var detailPremiere:TextView
    lateinit var detailSummary:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)

        detailImage=findViewById(R.id.detailMovieLogo)
        detailMovieName=findViewById(R.id.detailMovieName)
        detailMovieLanguage=findViewById(R.id.detailMovieLanguage)
        detailMovieGenere=findViewById(R.id.detailMovieGenere)
        detailMovieStatus=findViewById(R.id.detailMovieStatus)
        detailMovieRating=findViewById(R.id.detailMovieRating)
        detailMovieRuntime=findViewById(R.id.detailMovieRuntime)
        detailMovieType=findViewById(R.id.detailMovieType)
        detailPremiere=findViewById(R.id.detailPremiere)
        detailSummary=findViewById(R.id.detailSummary)

        val img=intent.getStringExtra("url")
        val name=intent.getStringExtra("movieName")
        val lang=intent.getStringExtra("movieLanguage")
        val genere=intent.getStringExtra("movieGenere")
        val status=intent.getStringExtra("movieStatus")
        val rating=intent.getStringExtra("movieRating")
        val runtime=intent.getStringExtra("runtime")
        val type=intent.getStringExtra("movieType")
        val premiere=intent.getStringExtra("moviePremiere")
        val summary=intent.getStringExtra("movieSummary")

        Picasso.get().load(img).into(detailImage)
        detailMovieName.text=name
        detailMovieLanguage.text="Language : " +lang
        detailMovieGenere.text="Genere : " +genere
        detailMovieStatus.text="Status : " +status
        detailMovieRating.text="Rating : " +rating
        detailMovieRuntime.text="Runtime : "+runtime
        detailMovieType.text="Type : "+type
        detailPremiere.text="Premiere : "+premiere
        detailSummary.text=summary



    }
}