package me.saro.kws.controllers

import me.saro.commons.Converter
import me.saro.commons.Utils
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest


@Controller()
@RequestMapping("/ex03")
class Ex03EnumWhenController {

    enum class Domain {
        SARO, GS, LOCAL, DEF, NONE
    }

    @GetMapping("/1")
    @ResponseBody
    fun no1(req: HttpServletRequest) = when(Domain.valueOf(req.getParameter("d") ?: "NONE")) {
        Domain.SARO, Domain.GS -> "사로 서비스"
        Domain.LOCAL -> "로컬"
        Domain.DEF -> "기본값"
        else -> "기타"
    }

    @GetMapping("/2")
    @ResponseBody
    fun no2(req: HttpServletRequest, @RequestParam("v", required = false) v: String?) = when {
        v == null -> "v의 값이 없음"
        v == "A" || v == "B" || v == "C" -> "v는 A,B,C 중 하나임"
        else -> "기타"
    }

    /**
     * 준비
     */
    @GetMapping("/3")
    @ResponseBody
    fun no3(req: HttpServletRequest): String {

        println("일반적이 함수형태")

        //var map = Converter
        for ((k, v) in Converter.toMap<String, String>("key", "val", "이름", "홍길동")) {
            println("$k : $v")
        }

        var list = arrayListOf("가", "나", "다", "A", "B")
    //		// 안됨.
    //		for ((i, v) in list) {
    //			println("[$i] : $v")
    //		}
        println(list)

        var a = "asdf"
        var b = if (a.isNotEmpty())  1 else 2
        // var c = a.length > 0  ? 1 : 2 // 3항식은 안됨...;
        println("b의 값음 $b")

        return "111";
    }

}