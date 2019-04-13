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
@RequestMapping("/ex09")
class Ex09DefaultParamController {

    @GetMapping("/1")
    @ResponseBody // 1~100 까지의 합 : 5050 이 나와야함.
    fun no1(req: HttpServletRequest): List<String> {

        var list = arrayListOf<String>()

        list.add(abc("a"))
        list.add(abc("a", 1))
        list.add(abc(b = 1, a = "ccc"))

        return list
    }

    fun abc(a: String, b: Int = 33): String {
        return a + b;
    }


}