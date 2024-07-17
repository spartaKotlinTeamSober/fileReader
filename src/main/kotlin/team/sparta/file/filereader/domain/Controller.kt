package team.sparta.file.filereader.domain

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/file/filereader")
class Controller(private val service:Service) {
    @GetMapping
    fun startFileReader():ResponseEntity<Boolean>{
        return ResponseEntity.ok().body(service.startFileReader())
    }
}