package com.internshala.showapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieAdapter(val movieList:ArrayList<Movie>,val context: Context):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {



    inner class MovieViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val movieName=itemView.findViewById<TextView>(R.id.movieName)
        val movieIcon=itemView.findViewById<ImageView>(R.id.movieIcon)
        val language=itemView.findViewById<TextView>(R.id.movieLanguage)
        val rating=itemView.findViewById<TextView>(R.id.movieRating)
        val status=itemView.findViewById<TextView>(R.id.movieStatus)
        val genere=itemView.findViewById<TextView>(R.id.movieGenere)
        val cardContent=itemView.findViewById<CardView>(R.id.cardContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie=movieList[position]

        holder.movieName.text=currentMovie.name
        holder.language.text="Language : "+currentMovie.launguage

            holder.rating.text="Rating : "+currentMovie.rating

        holder.status.text="Status : "+currentMovie.status
        holder.genere.text="Genere : "+currentMovie.genere
        Picasso.get().load(currentMovie.url).into(holder.movieIcon)
        holder.cardContent.setOnClickListener {
            val moviename=currentMovie.name
            val language=currentMovie.launguage
            val rating=currentMovie.rating
            val status=currentMovie.status
            val type=currentMovie.type
            val genere=currentMovie.genere

            val summary=currentMovie.summary
            val premiere=currentMovie.premiere
            val url=currentMovie.url
            val runtime=currentMovie.runtime
            val intent=Intent(context,DetailScreen::class.java)

            intent.putExtra("movieName",moviename)
            intent.putExtra("movieLanguage",language)
            intent.putExtra("movieRating",rating)
            intent.putExtra("movieStatus",status)
            intent.putExtra("movieType",type)
            intent.putExtra("movieGenere",genere)
            intent.putExtra("movieSummary",summary)
            intent.putExtra("moviePremiere",premiere)
            intent.putExtra("url",url)
            intent.putExtra("runtime",runtime)

            startActivity(context,intent,null)


        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}