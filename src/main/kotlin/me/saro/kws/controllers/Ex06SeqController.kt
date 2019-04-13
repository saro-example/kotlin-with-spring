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

    @GetMapping("/5")
    @ResponseBody
    // ('가' <= '망' && '망' <= '힣') 과 동일
    fun no5(req: HttpServletRequest) = ('망' in '가'..'힣')

    @GetMapping("/7")
    @ResponseBody
    // "예제단어"는 사전 순서로 "부트"와 "코틀린" 사이에 있다.
    fun no7(req: HttpServletRequest) = ("예제단어" in "부트".."코틀린")

    @GetMapping("/8")
    @ResponseBody // 37은 20과 100사이 존재하지 않는다 = 거짓
    fun no8(req: HttpServletRequest) = (37 !in 20..100)
}