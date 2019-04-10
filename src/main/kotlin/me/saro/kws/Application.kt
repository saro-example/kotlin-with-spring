package me.saro.kws

import me.saro.commons.Converter
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application : CommandLineRunner {
	override fun run(vararg args: String) {
        println("기존 어플리케이션 러너가 실행되는 모습을 볼 수 있습니다.")
        println("요즘 언어답게 세미콜론이 필요하지 않습니다.")
	}
}

fun main(args: Array<String>) {
	println("프로젝트 실행준비")
	runApplication<Application>(*args)
}

