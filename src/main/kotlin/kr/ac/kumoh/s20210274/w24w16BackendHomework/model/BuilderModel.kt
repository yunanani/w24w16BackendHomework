package kr.ac.kumoh.s20210274.w24w16BackendHomework.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "builders")
data class BuilderModel(
    @Id val id: String? = null,
    val youtubeName: String,
    val realName: String,
    val height: Double,
    val rating: Int,
    val numberOfSubscribers: String,
    val career: String,
    val imageUrl: String?
)
