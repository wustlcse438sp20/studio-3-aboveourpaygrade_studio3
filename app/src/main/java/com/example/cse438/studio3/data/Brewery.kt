package com.example.cse438.studio3.data


data class Brewery(
    val id: Int,
    val name: String,
    val brewery_type: String,
    val street: String,
    val state: String,
    val postal_code: String,
    val country: String,
    val longitude: String,
    val latitude: String,
    val phone: String,
    val website_url: String,
    val updated_at: String,
    val tags: List<String>
)