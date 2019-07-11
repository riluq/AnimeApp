package com.riluq.animeapp

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.riluq.animeapp.network.TopAiring
import com.riluq.animeapp.topairing.TopAiringAdapter

@BindingAdapter("listData")
fun RecyclerView.bindRecyclerView(data: List<TopAiring>?) {
    val adapter = adapter as TopAiringAdapter
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

@BindingAdapter("textTopAiringTitle")
fun TextView.bindTextAiringTitle(text: String?) {
    text.let {
        this.text = it
    }
}
@BindingAdapter("textTopAiringRank")
fun TextView.bindTextAiringRank(number: Int?) {
    number.let {
        this.text = "#$it"
    }
}