package com.twgroup.kotlinblog.test

import org.springframework.web.bind.annotation.*

@RestController
class HttpControllerTest {
    @GetMapping("/http/get")
    fun getTest(@RequestParam id: Int): String? {
        println(id)
        return "get 요청"
    }

    @PostMapping("/http/post")
    fun postTest(): String? {
        return "post 요청"
    }

    @PutMapping("/http/put")
    fun putTest(): String? {
        return "put 요청"
    }

    @DeleteMapping("/http/delete")
    fun deleteTest(): String? {
        return "delete 요청"
    }
}