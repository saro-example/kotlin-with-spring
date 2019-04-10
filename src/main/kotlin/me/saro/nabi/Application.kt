package me.saro.nabi

import me.saro.commons.Converter
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class Application : CommandLineRunner {
	override fun run(vararg args: String?) {
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
	}

}

fun main(args: Array<String>) {
	print("hi111")
	runApplication<Application>(*args)
}

