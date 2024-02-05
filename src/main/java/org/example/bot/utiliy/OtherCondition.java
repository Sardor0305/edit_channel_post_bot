package org.example.bot.utiliy;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class OtherCondition {
    public static void process(Update update, TelegramLongPollingBot bot){
        try {
            bot.execute(SendMessage.builder()
                            .text("please send video or photo")
                            .chatId(UpdateIdProcess.chatId(update))
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
