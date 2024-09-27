package ksolow.mytelegrambot.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.github.kotlintelegrambot.Bot
import jakarta.annotation.PostConstruct

@Service
class BotService {

    @Autowired
    lateinit var bot: Bot

    @PostConstruct
    fun startBot() = bot.startPolling()
}