package ru.netology.nmedia

fun main() {
    val postsWithAuthors = getAllPostsWithAuthors()
    postsWithAuthors.forEach { postWithAuthor ->
        println("ID: ${postWithAuthor.post.id}")
        println("Author: ${postWithAuthor.author?.name ?: "Unknown"}")
        println("Content: ${postWithAuthor.post.content}")
        println("Published: ${postWithAuthor.post.published}")
        println("Likes: ${postWithAuthor.post.likes}")
    }
}