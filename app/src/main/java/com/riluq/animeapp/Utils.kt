package com.riluq.animeapp

import android.view.View

fun View.visible() = run { this.visibility = View.VISIBLE }
fun View.invisible() = run { this.visibility = View.INVISIBLE }
fun View.gone() = run { this.visibility = View.GONE }
