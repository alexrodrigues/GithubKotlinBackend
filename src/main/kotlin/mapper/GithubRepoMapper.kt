package org.example.mapper

import org.example.model.GithubRepo
import org.example.DTO.GithubRepoDTO

object GithubRepoMapper {
    
    /**
     * Converts a GithubRepo model to GithubRepoDTO
     */
    fun toDto(model: GithubRepo): GithubRepoDTO {
        return GithubRepoDTO(
            name = model.name,
            repositoryUrl = model.repositoryUrl,
            starCount = model.starCount
        )
    }
    
    /**
     * Converts a list of GithubRepo models to a list of GithubRepoDTOs
     */
    fun toDtoList(models: List<GithubRepo>): List<GithubRepoDTO> {
        return models.map { toDto(it) }
    }
    
    /**
     * Converts a GithubRepoDTO to GithubRepo model
     * Note: This might not be needed for your current use case since you're only reading from GitHub API
     */
    fun toModel(dto: GithubRepoDTO): GithubRepo {
        return GithubRepo(
            name = dto.name,
            repositoryUrl = dto.repositoryUrl,
            starCount = dto.starCount
        )
    }
    
    /**
     * Converts a list of GithubRepoDTOs to a list of GithubRepo models
     */
    fun toModelList(dtos: List<GithubRepoDTO>): List<GithubRepo> {
        return dtos.map { toModel(it) }
    }
} 