package com.app.open.ai.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.app.open.ai.R

enum class NavigationItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String,
) {
    CHAT(
        title = R.string.tab_chat,
        icon = R.drawable.ic_forum,
        route = "route_match",
    ),
    Image(
        title = R.string.tab_image,
        icon = R.drawable.ic_image_search,
        route = "route_news_feed",
    ),
}