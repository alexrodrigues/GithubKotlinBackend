package org.example.DTO

import kotlinx.serialization.Serializable

@Serializable
data class GithubRepoDTO(
    val name: String,
    val repositoryUrl: String,
    val starCount: Int
)