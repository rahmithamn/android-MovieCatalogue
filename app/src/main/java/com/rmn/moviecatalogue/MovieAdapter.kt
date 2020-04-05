package com.rmn.moviecatalogue

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class MovieAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var movies = arrayListOf<Movie>()
    companion object {
        const val EXTRA_MOVIE= "extra_movie"
    }
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val movie = getItem(position) as Movie
        viewHolder.bind(movie)
        return itemView
    }
    private inner class ViewHolder internal constructor(view: View) {
        private val txtTitle: TextView = view.findViewById(R.id.txt_title)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPoster: ImageView = view.findViewById(R.id.img_poster)
        internal fun bind(movie: Movie) {
            txtTitle.text = movie.movieTitle
            txtDescription.text = movie.moviedescription
            imgPoster.setImageResource(movie.moviePoster)

        }
    }

    override fun getItem(i: Int): Any {
        return movies[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return movies.size
    }
}