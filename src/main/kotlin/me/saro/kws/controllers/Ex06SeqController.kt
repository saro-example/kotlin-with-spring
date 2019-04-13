package me.saro.kws.controllers

import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.util.stream.Collectors
import java.util.stream.Stream
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Controller
@RequestMapping("/ex06")
class Ex06SeqController {

    @GetMapping("/1")
    @ResponseBody // 1~100 까지의 합 : 5050 이 나와야함.
    fun no1(req: HttpServletRequest) = (1..100).sum();

    @GetMapping("/2", produces = arrayOf(MediaType.TEXT_PLAIN_VALUE))
    @ResponseBody
    fun no2(res: HttpServletResponse): String {
        var ints = ArrayList<Int>()
        // i 에 숫자대입
        // 시작 100
        // downTo 1 -> 역방향
        // step 3 -> 3씩 떨어짐
        // 결과 100, 97....
        for (i in 100 downTo 1 step 3) {
            ints.add(i)
        }
        return ints.stream().map(Int::toString).collect(Collectors.joining("\n"))
    }
}