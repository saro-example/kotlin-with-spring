package me.saro.kws.controllers

import me.saro.commons.Converter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/ex02")
class Ex02VarValMapListController {

    @GetMapping("/1")
    @ResponseBody
    fun no1(): String {
        var a = "변수 입니다."
        a += "추가 대입"
        val b = "변경금지 상수입니다."
        // b += "추가대입" 오류
        return "$a / $b"
    }

    @GetMapping("/2")
    @ResponseBody
    fun no2(): String {
        var sb = StringBuilder();

        for ((k, v) in Converter.toMap<String, String>("key", "val", "이름", "홍길동")) {
            sb.append("$k : $v")
        }

        return sb.toString();
    }

    @GetMapping("/3")
    @ResponseBody
    fun no3(req: HttpServletRequest): String {

        val sb = StringBuilder();
        var list = arrayListOf("가", "나", "다", "A", "B")

        for (s in list) {
            sb.append("$s, ")
        }

        return sb.toString();
    }

    @GetMapping("/4")
    @ResponseBody
    fun no4(req: HttpServletRequest): String {

        val sb = StringBuilder();
        var list = arrayListOf("가", "나", "다", "A", "B")

        for ((i, s) in list.withIndex()) {
            sb.append("[$i] $s<br/>")
        }

        return sb.toString();
    }

    @GetMapping("/5")
    @ResponseBody
    // ('가' <= '망' && '망' <= '힣') 과 동일
    fun no5(req: HttpServletRequest) = ('망' in '가'..'힣')

    @GetMapping("/6")
    @ResponseBody
    fun no6(req: HttpServletRequest) = ("jpg" in setOf("jpg", "png", "gif"))

    @GetMapping("/7")
    @ResponseBody
    // "예제단어"는 사전 순서로 "부트"와 "코틀린" 사이에 있다.
    fun no7(req: HttpServletRequest) = ("예제단어" in "부트".."코틀린")

    @GetMapping("/8")
    @ResponseBody // 37은 20과 100사이 존재하지 않는다 = 거짓
    fun no8(req: HttpServletRequest) = (37 !in 20..100)
}