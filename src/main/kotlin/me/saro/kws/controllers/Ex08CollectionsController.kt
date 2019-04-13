package me.saro.kws.controllers

import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.io.ByteArrayOutputStream
import java.lang.Exception
import java.util.stream.Collectors
import java.util.stream.Stream
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Controller
@RequestMapping("/ex08")
class Ex08CollectionsController {

    @GetMapping("/1")
    @ResponseBody // 1~100 까지의 합 : 5050 이 나와야함.
    fun no1(req: HttpServletRequest): String {

        var set = hashSetOf(1, 7, 53)

        var list = arrayListOf(3, 27, 3)

        var map = hashMapOf(11 to "abc", 2 to "hi")

        var list2 = listOf(33, 22, 11)

        return "stop"

    }


}