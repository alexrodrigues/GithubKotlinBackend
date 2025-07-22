package org.example.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepo(
    val name: String,
    @SerialName("html_url") val repositoryUrl: String,
    @SerialName("stargazers_count") val starCount: Int
)