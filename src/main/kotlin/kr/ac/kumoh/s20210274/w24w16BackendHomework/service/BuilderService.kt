package kr.ac.kumoh.s20210274.w24w16BackendHomework.service
import kr.ac.kumoh.s20210274.w24w16BackendHomework.model.BuilderModel
import kr.ac.kumoh.s20210274.w24w16BackendHomework.repository.BuilderRepository
import org.springframework.stereotype.Service

@Service
class BuilderService(private val repository: BuilderRepository) {

    // 새로운 곡 추가
    fun addBuilder(builder:BuilderModel ): BuilderModel = repository.save(builder)

    // 모든 곡 조회
    fun getAllBuilder(): List<BuilderModel> = repository.findAll()

    // id로 곡 조회
    fun getBuilderById(id: String): BuilderModel? = repository.findById(id).orElse(null)


    // 곡 정보 수정
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

    // 곡 삭제
    fun deleteBuilder(id: String): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else {
            false
        }
    }
}
