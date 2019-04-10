package me.saro.kws.controllers

import me.saro.commons.Converter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest
import javax.websocket.server.PathParam

@Controller()
@RequestMapping("/ex02")
class Ex02VarValMapListController {

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