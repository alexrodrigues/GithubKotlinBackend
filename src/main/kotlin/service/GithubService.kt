package org.example.service

import org.example.repository.GithubRepository
import org.example.mapper.GithubRepoMapper
import org.example.DTO.GithubRepoDTO

class GithubService(private val repository: GithubRepository = GithubRepository()) {
    suspend fun getTopSwiftRepositories(): List<GithubRepoDTO> {
        val repos = repository.fetchTopSwiftRepositories()
        return GithubRepoMapper.toDtoList(repos)
    }
}