package com.pankaj6apr.newsdaily.common.util

import com.google.gson.annotations.SerializedName

enum class Category(val category: String) {
    @SerializedName("general")
    GENERAL("General"),
    @SerializedName("business")
    BUSINESS("Business"),
    @SerializedName("entertainment")
    ENTERTAINMENT("Entertainment"),
    @SerializedName("health")
    HEALTH("Health"),
    @SerializedName("science")
    SCIENCE("Science"),
    @SerializedName("sports")
    SPORTS("Sports"),
    @SerializedName("technology")
    TECHNOLOGY("Technology")
}