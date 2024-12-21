package kr.ac.kumoh.s20210274.w24w16BackendHomework.service
import kr.ac.kumoh.s20210274.w24w16BackendHomework.model.BuilderModel
import kr.ac.kumoh.s20210274.w24w16BackendHomework.repository.BuilderRepository
import org.springframework.stereotype.Service

@Service
class BuilderService(private val repository: BuilderRepository) {

    fun addBuilder(builder:BuilderModel ): BuilderModel = repository.save(builder)


    fun getAllBuilder(): List<BuilderModel> = repository.findAll()


    fun getBuilderById(id: String): BuilderModel? = repository.findById(id).orElse(null)



    fun updateBuilder(id: String, builder: BuilderModel): BuilderModel? {
        val BuilderTarget = repository.findById(id)

        return if (BuilderTarget.isPresent) {
            val oldBuilder = BuilderTarget.get()
            val updatedBuilder = oldBuilder.copy(
                youtubeName = builder.youtubeName,
                realName = builder.realName,
                height = builder.height,
                rating = builder.rating,
                numberOfSubscribers =builder.numberOfSubscribers,
                career = builder.career
            )
            repository.save(updatedBuilder)
        } else {
            null
        }
    }

    fun deleteBuilder(id: String): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else {
            false
        }
    }
}
