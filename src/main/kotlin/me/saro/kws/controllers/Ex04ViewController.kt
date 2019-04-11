package me.saro.kws.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller()
@RequestMapping("/ex04")
class Ex04ViewController {

    enum class Domain {
        SARO, GS, LOCAL, DEF, NONE
    }

    @GetMapping("/1")
    fun no1() = "ex04/1";

    @GetMapping("/2")
    fun no2(model: Module) = "ex04/2";
}