package com.example.searchgoogle

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.searchgoogle.adapter.MovieAdapter
import com.example.searchgoogle.data.api.ApiService
import com.example.searchgoogle.data.api.MovieService
import com.example.searchgoogle.data.model.MovieResponse
import com.example.searchgoogle.data.model.Result
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var  layoutManager: LinearLayoutManager
    private lateinit var  adapter: ArrayAdapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager= GridLayoutManager(this,2)
        recycler.layoutManager = layoutManager
        getMovieData {
            movies:List<Result> ->
         recycler.adapter = MovieAdapter(movies)
            Log.i("filmes", "onCreate: "+ movies)
        }

    }

    private fun getMovieData(callback: (List<Result>) -> Unit) {
        val apiService = ApiService.getInstance().create(MovieService::class.java)
        apiService.getMoviePopulares().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

        })
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.serach_nav,menu)
//
//        val search = menu?.findItem(R.id.action_search)
//        val searchView = search?.actionView as SearchView
//        searchView.queryHint="Digite o filme"
//        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return  false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                Log.d("onQueryTextChange",newText.toString())
//                adapter.filter.filter(newText)
//                return true
//            }
//        })
//        return super.onCreateOptionsMenu(menu)
//    }

}