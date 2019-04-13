package me.saro.kws.controllers

import me.saro.commons.Converter
import me.saro.commons.Utils
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest


@Controller
@RequestMapping("/ex05")
class Ex05SmartCastController {

    // 인터페이스와 클래스
    interface Inter
    class Num(val value: Int) : Inter
    class Sum(val left: Inter, val right: Inter) : Inter

    fun eval(i: Inter): Int {
        if (i is Num) {
            return i.value
        }
        if (i is Sum) {
            return eval(i.left) + eval(i.right)
        }

        throw IllegalArgumentException("지원하지 않는 타입")
    }

    fun weval(i: Inter) : Int =
        when {
            i is Num ->
                i.value
            i is Sum ->
                weval(i.left) + weval(i.right)
            else ->
                throw IllegalArgumentException("지원하지 않는 타입")
        }


    @GetMapping("/1")
    @ResponseBody // 결과는 40 이어야함.
    fun no1(req: HttpServletRequest) = eval(Sum(Sum(Num(3), Num(7)), Num(30)))

    @GetMapping("/2")
    @ResponseBody // 결과는 40 이어야함.
    fun no2(req: HttpServletRequest) = weval(Sum(Sum(Num(3), Num(7)), Num(30)))

}