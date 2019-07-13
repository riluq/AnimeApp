package com.riluq.animeapp

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.riluq.animeapp.network.TopAiring
import com.riluq.animeapp.network.TopUpcoming
import com.riluq.animeapp.topairing.TopAiringAdapter
import com.riluq.animeapp.topupcoming.TopUpcomingAdapter

@BindingAdapter("listDataTopAiring")
fun RecyclerView.bindRecyclerViewTopAiring(data: List<TopAiring>?) {
    val adapter = adapter as TopAiringAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataTopUpcoming")
fun RecyclerView.bindRecyclerViewTopUpcoming(data: List<TopUpcoming>?) {
    val adapter = adapter as TopUpcomingAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun ImageView.bindImage(imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(this)

    }
}

@BindingAdapter("textTitle")
fun TextView.bindTextTitle(text: String?) {
    text.let {
        this.text = it
    }
}
@BindingAdapter("textRank")
fun TextView.bindTextAiringRank(number: Int?) {
    number.let {
        this.text = "#$it"
    }
}
@BindingAdapter("textScore")
fun TextView.bindTextAiringScore(score: Double?) {
    score.let {
        if (it != 0.0) {
            this.text = "Score $it"
        }
    }
}

@BindingAdapter("apiStatusImage")
fun ImageView.bindStatusImage(status: JikanMoeApiStatus?) {
    when(status) {
        JikanMoeApiStatus.Loading -> {
            visible()
            setImageResource(R.drawable.loading_animation)
        }
        JikanMoeApiStatus.Error -> {
            visible()
            setImageResource(R.drawable.ic_connection_error)
        }
        JikanMoeApiStatus.Done -> {
            gone()
        }
    }
}

@BindingAdapter("apiStatusSwipe")
fun SwipeRefreshLayout.bindStatusSwipe(status: JikanMoeApiStatus?) {
    when(status) {
        JikanMoeApiStatus.Loading -> {
            this.isRefreshing = true
        }
        JikanMoeApiStatus.Error -> {
            this.isRefreshing = false
        }
        JikanMoeApiStatus.Done -> {
            this.isRefreshing = false
        }
    }
}
