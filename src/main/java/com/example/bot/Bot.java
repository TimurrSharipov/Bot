package com.example.bot;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public final class Bot extends TelegramLongPollingBot {
    private String BOT_NAME = "Timb_bABot";
    private String BOT_TOKEN = "5776805897:AAHWV430Igas-pMB5x19JwjSz0BQci4gGHk";


    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }


    @Override
    public void onUpdateReceived(Update update) {
        try {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId());
            message.setText("Собрание через 15 минут");

        execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
    @Scheduled(cron = "0 * * * * MON-FRI")
    public SendMessage getMessage(){
        return new SendMessage();
    }




}
