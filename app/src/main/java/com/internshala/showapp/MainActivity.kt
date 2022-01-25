package com.internshala.showapp

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.json.JSONException
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var recycler:RecyclerView
    lateinit var bottomNavigation:BottomNavigationView
    lateinit var adapter:MovieAdapter
    var previousMenuItem:MenuItem?=null
    private lateinit var movieList:ArrayList<Movie>
    private lateinit var temporaryList:ArrayList<Movie>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler=findViewById(R.id.recycler)




         movieList= arrayListOf<Movie>()
        temporaryList= arrayListOf<Movie>()
        val url="https://api.tvmaze.com/search/shows?q=all"
        val queue= Volley.newRequestQueue(this)
        val request=JsonArrayRequest(Request.Method.GET,url,null, {
           val l=it.length()
           for (i in 0 until l){

               val r=it.getJSONObject(i)
               val show=r.getJSONObject("show")
               val name=show.getString("name")


               val movieLang=show.getString("language")
               val status=show.getString("status")

               val rating=show.getJSONObject("rating").getString("average")
               val imageUrl=show.getJSONObject("image").getString("medium")
               val type=show.getString("type")
               val genere:String=show.getJSONArray("genres")[0].toString()
//               val generee=show.getJSONArray("genres")[1].toString()
               val runtime=show.getString("runtime")
               val premiere=show.getString("premiered")
               val s=show.getString("summary")
               val summary=Html.fromHtml(s).toString()




              val movie=Movie(name,movieLang,status,rating,imageUrl,type,genere,runtime, premiere, summary)
              movieList.add(movie)





           }

            temporaryList.addAll(movieList)
            adapter= MovieAdapter(temporaryList,this)
            recycler.adapter=adapter
            recycler.layoutManager=LinearLayoutManager(this)

        }, {
        Toast.makeText(this,"Some Error Occured",Toast.LENGTH_SHORT).show()
        }
        )

        queue.add(request)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation_menu,menu)
        val item=menu?.findItem(R.id.searchIcon)
        val searchView=item?.actionView as? SearchView
        searchView?.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                temporaryList.clear()
                val searchtext=newText!!.toLowerCase(Locale.getDefault())

                if(searchtext.isNotEmpty()){
                  movieList.forEach{

                      if (it.name.toLowerCase(Locale.getDefault()).contains(searchtext)){
                          temporaryList.add(it)
                      }
                  }

                    recycler.adapter!!.notifyDataSetChanged()


                }

                else{
                    temporaryList.clear()
                    temporaryList.addAll(movieList)
                    recycler.adapter!!.notifyDataSetChanged()
                }



                return false
            }

        })

        return super.onCreateOptionsMenu(menu)

    }
}




