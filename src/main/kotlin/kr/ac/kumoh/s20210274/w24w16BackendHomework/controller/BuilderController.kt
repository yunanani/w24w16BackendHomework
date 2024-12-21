package kr.ac.kumoh.s20210274.w24w16BackendHomework.controller
import kr.ac.kumoh.s20210274.w24w16BackendHomework.model.BuilderModel
import kr.ac.kumoh.s20210274.w24w16BackendHomework.service.BuilderService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/builder")
@CrossOrigin(origins=["https://wsp2024builderfrontend.netlify.app"]) // 프론트엔드 주소 설정
class BuilderController(private val service: BuilderService) {

    @PostMapping
    fun addBuilder(@RequestBody builder: BuilderModel): BuilderModel = service.addBuilder(builder)

    @GetMapping
    fun getAllBuilder(): List<BuilderModel> = service.getAllBuilder()

    @GetMapping("/{id}")
    fun getBuilderById(@PathVariable id: String): BuilderModel? = service.getBuilderById(id)


    @PutMapping("/{id}")
    fun updateBuilder(@PathVariable id: String, @RequestBody BuilderDetails: BuilderModel): BuilderModel? = service.updateBuilder(id, BuilderDetails)


    @DeleteMapping("/{id}")
    fun deleteBuilder(@PathVariable id: String): Map<String, String> {
        return if (service.deleteBuilder(id))
            mapOf("status" to "deleted")
        else
            mapOf("status" to "not found")
    }
}
