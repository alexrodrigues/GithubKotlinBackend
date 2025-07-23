package org.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.example.service.GithubService

fun main() {
    val port = System.getenv("PORT")?.toIntOrNull() ?: 8080
    embeddedServer(Netty, port = port, host = "0.0.0.0") {
        install(ContentNegotiation) {
            json(Json { prettyPrint = true })
        }
        routing {
            get("/") {
                call.respondText("Hello, Ktor!")
            }
            get("/swift-stars") {
                val service = GithubService()
                try {
                    val repos = service.getTopSwiftRepositories()
                    call.respond(repos)
                } catch (e: Exception) {
                    call.respondText("Failed to fetch repositories: ${e.localizedMessage}", status = io.ktor.http.HttpStatusCode.InternalServerError)
                }
            }
        }
    }.start(wait = true)
}