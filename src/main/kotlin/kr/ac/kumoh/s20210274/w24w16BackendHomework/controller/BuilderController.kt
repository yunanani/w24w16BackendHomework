package kr.ac.kumoh.s20210274.w24w16BackendHomework.controller
import kr.ac.kumoh.s20210274.w24w16BackendHomework.model.BuilderModel
import kr.ac.kumoh.s20210274.w24w16BackendHomework.service.BuilderService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins=["https://wsp2024builderfrontend.netlify.app"])  // 프론트엔드 주소 설정
class BuilderController(private val service: BuilderService) {

    @GetMapping
    fun getRoot() = mapOf("status" to "success")

    @GetMapping("/api/message")
    fun getMessage() = mapOf("status" to "success")
}