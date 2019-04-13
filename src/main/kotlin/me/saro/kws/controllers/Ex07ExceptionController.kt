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
@RequestMapping("/ex07")
class Ex07ExceptionController {

    @GetMapping("/1")
    @ResponseBody // 1~100 까지의 합 : 5050 이 나와야함.
    fun no1(req: HttpServletRequest): String {

        try {

        } catch (e: Exception) {

        }  finally {

        }

        return "pass"
    }

    @GetMapping("/2")
    @ResponseBody // 1~100 까지의 합 : 5050 이 나와야함.
    fun no2(req: HttpServletRequest) {

        var result = try {
            throw Exception("exceptions");
        } catch (e: Exception) {

        }  finally {

        }

        println(result)
    }
}