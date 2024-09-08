package ru.netology.nmedia

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking

data class PostWithAuthor(
    val post: Post,
    val author: Author?
)

fun getAllPostsWithAuthors(): List<PostWithAuthor> = runBlocking {
    val posts = RetrofitInstance.postApi.getAllPosts()
    val authors = posts.map { post -> async(Dispatchers.IO) { RetrofitInstance.postApi.getAuthorById(post.authorId) } }
    val authorsList = authors.awaitAll()
    posts.map { post ->
        PostWithAuthor(post, authorsList.find { it.id == post.authorId })
    }
}