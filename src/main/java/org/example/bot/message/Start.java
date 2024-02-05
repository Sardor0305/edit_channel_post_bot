package org.example.bot.message;


import org.example.bot.db.BaseConfigBot;
import org.example.bot.enam.State;
import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Start {
    public static void startProcess(Update update, TelegramLongPollingBot bot){
        if(update.getMessage().getText().equals("/start")){
            BaseConfigBot.insertUser(update,bot);

            try {
                bot.execute(SendMessage.builder()
                                .chatId(UpdateIdProcess.chatId(update))
                                .text("hi ")
                        .build());

            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }


        }


    }

}
