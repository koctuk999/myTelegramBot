package ksolow.mytelegrambot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyTelegramBotApplication

fun main(args: Array<String>) {
    runApplication<MyTelegramBotApplication>(*args)
}
