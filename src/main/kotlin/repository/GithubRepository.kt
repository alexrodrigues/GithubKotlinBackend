package org.example.repository

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.example.model.GithubRepo


@Serializable
data class GithubSearchResponse(
    val items: List<GithubRepo>
)

class GithubRepository {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun fetchTopSwiftRepositories(): List<GithubRepo> {
        val response: GithubSearchResponse = client.get("https://api.github.com/search/repositories?q=language:swift&sort=stars").body()
        return response.items
    }
} 