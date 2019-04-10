package me.saro.kws.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/ex01")
class Ex01FunController {

    /**
     * http://localhost:8080/ex01/1
     */
    @GetMapping("/1")
    @ResponseBody
    fun no1() = "first-example"

    /**
     * 어노테이션에 2개이상의 값을 넣을대도 기본값 value 선언 생략 가능
     * http://localhost:8080/ex01/2/abc
     */
    @GetMapping("/2/{name}", produces = arrayOf("text/html"))
    @ResponseBody
    fun no2(req: HttpServletRequest, @PathVariable("name") name: String) =
    """멀티라인 예제
       입력한 변수는 ${name}입니다.
       앞뒤로 글자가 붙어있지 않은경우
       아래와 같이 $name 으로 쓸 수 있습니다.
       접속 ip 주소는 ${req.remoteAddr} 입니다.""".replace("\n", "<br/>")

    /**
     * 드디어 처음으로 등장하는 일반적인 함수
     * http://localhost:8080/ex01/3
     */
    @GetMapping("/3")
    @ResponseBody
    fun no3(req: HttpServletRequest): String {
        return "축약이 없는 일반적인 형태의 함수"
    }

}