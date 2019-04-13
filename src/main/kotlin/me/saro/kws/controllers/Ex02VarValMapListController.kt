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

}