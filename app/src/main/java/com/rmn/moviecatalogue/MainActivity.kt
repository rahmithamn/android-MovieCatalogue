package com.rmn.moviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MovieAdapter
    private lateinit var movieTitle: Array<String>
    private lateinit var movieDescription: Array<String>
    private lateinit var moviePhoto: TypedArray
    private lateinit var movieGenre: Array<String>
    private lateinit var movieDuration: Array<String>
    private lateinit var movieDirector: Array<String>
    private lateinit var movieRating: Array<String>

    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = MovieAdapter(this)
        listView.adapter = adapter


        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, movies[position].movieTitle, Toast.LENGTH_SHORT).show()
            val detailMovieIntent = Intent(this@MainActivity, DetailMovieActivity::class.java)
            detailMovieIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies[position])
            startActivity(detailMovieIntent)
        }

    }
    private fun prepare() {
        movieTitle = resources.getStringArray(R.array.movie_title)
        movieDescription = resources.getStringArray(R.array.movie_description)
        moviePhoto = resources.obtainTypedArray(R.array.movie_photo)
        movieGenre = resources.getStringArray(R.array.movie_genre)
        movieDuration = resources.getStringArray(R.array.movie_duration)
        movieDirector = resources.getStringArray(R.array.movie_director)
        movieRating = resources.getStringArray(R.array.movie_rating)

    }
    private fun addItem() {
        for (position in movieTitle.indices) {
            val movie = Movie(
                moviePhoto.getResourceId(position, -1),
                movieTitle[position],
                movieDescription[position],
                movieGenre[position],
                movieDuration[position],
                movieDirector[position],
                movieRating[position]
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }


}
