package com.rmn.moviecatalogue

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MovieAdapter
    private lateinit var movieTitle: Array<String>
    private lateinit var movieDescription: Array<String>
    private lateinit var moviePhoto: TypedArray
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = MovieAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()
    }
    private fun prepare() {
        movieTitle = resources.getStringArray(R.array.movie_title)
        movieDescription = resources.getStringArray(R.array.movie_description)
        moviePhoto = resources.obtainTypedArray(R.array.movie_photo)
    }
    private fun addItem() {
        for (position in movieTitle.indices) {
            val movie = Movie(
                moviePhoto.getResourceId(position, -1),
                movieTitle[position],
                movieDescription[position]
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }
}
