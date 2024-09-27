package ksolow.mytelegrambot.config

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.text
import ksolow.mytelegrambot.config.BotCommands.TEST
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BotConfig(
    @Value("\${bot.token}")
    val botToken: String
) {
    @Bean
    fun telegramBot() = bot {
        token = botToken
        dispatch {
            command(TEST.command) {
                bot.sendMessage(
                    chatId = message.chat.id,
                    text = "Hello world"
                )
            }

            text {
                val answer = when {
                    text == "42" -> "Don't panic!"
                    else -> null
                }

                answer?.let {
                    bot.sendMessage(chatId = message.chat.id, text = it)
                }
            }
        }
    }
}

enum class BotCommands(val command: String) {
    TEST("test")
}