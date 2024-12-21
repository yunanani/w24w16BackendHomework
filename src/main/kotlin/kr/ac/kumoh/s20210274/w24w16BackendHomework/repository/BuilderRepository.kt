package kr.ac.kumoh.s20210274.w24w16BackendHomework.repository
import kr.ac.kumoh.s20210274.w24w16BackendHomework.model.BuilderModel
import org.springframework.data.mongodb.repository.MongoRepository

interface BuilderRepository : MongoRepository<BuilderModel, String> {
    // Custom query methods can be added here if needed
}
