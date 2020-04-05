package com.rmn.moviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val tvTitle: TextView = findViewById(R.id.txt_title)
        val tvDesc: TextView = findViewById(R.id.txt_description)
        val ivPoster: ImageView = findViewById(R.id.img_poster)
        val tvGenre: TextView = findViewById(R.id.genre)
        val tvDuration: TextView = findViewById(R.id.duration)
        val tvDirector: TextView = findViewById(R.id.director)
        val tvRating: TextView = findViewById(R.id.rating)

        val movie = intent.getParcelableExtra(EXTRA_MOVIE) as Movie
        val mTitle = movie.movieTitle
        val mDesc = movie.moviedescription
        val mPhoto: Int = movie.moviePoster
        val mGenre = movie.movieGenre
        val mDuration = movie.movieDuration
        val mDirector = movie.movieDirector
        val mRating = movie.movieRating

        tvTitle.text = mTitle
        tvDesc.text = mDesc
        ivPoster.setImageResource(mPhoto)
        tvGenre.text = mGenre
        tvDuration.text = mDuration
        tvDirector.text = mDirector
        tvRating.text = mRating
    }
}
