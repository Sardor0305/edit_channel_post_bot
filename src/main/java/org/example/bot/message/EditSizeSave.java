package org.example.bot.message;

import org.example.bot.db.BaseConfigBot;
import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EditSizeSave {
        public static void smallSave(Update update,TelegramLongPollingBot bot){
            BaseConfigBot.updateSize(update,32);
            //here save db
            try {
                bot.execute(SendMessage.builder()
                                .text("successful")
                                .chatId(UpdateIdProcess.chatId(update))
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    public static void mediumSave(Update update,TelegramLongPollingBot bot){
        BaseConfigBot.updateSize(update,64);
        //here save db
        try {
            bot.execute(SendMessage.builder()
                    .text("successful")
                    .chatId(UpdateIdProcess.chatId(update))
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static void largeSave(Update update,TelegramLongPollingBot bot){
        BaseConfigBot.updateSize(update,128);
        //here save db
        try {
            bot.execute(SendMessage.builder()
                    .text("successful")
                    .chatId(UpdateIdProcess.chatId(update))
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    }

