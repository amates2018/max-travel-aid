package io.travelaid.util

import android.support.annotation.DrawableRes
import android.support.annotation.NonNull
import android.support.annotation.StringRes

/**
 * Project : max-travel-aid
 * Created by Dennis Bilson on Wed at 7:54 PM.
 * Package name : io.travelaid.util
 *
 * Data model for viewpager items
 * Contains drawable image, title and a short description
 */
data class ViewPagerData(@NonNull @DrawableRes val image: Int,
                         @NonNull @StringRes val title: Int,
                         @NonNull @StringRes val description: Int)