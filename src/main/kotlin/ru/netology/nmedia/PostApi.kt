package ru.netology.nmedia

import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {
    @GET("api/posts")
    suspend fun getAllPosts(): List<Post>

    @GET("api/authors/{id}")
    suspend fun getAuthorById(@Path("id") id: Long): Author
}
