package org.example.bot.message;

import org.example.bot.db.BaseConfigBot;
import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EditSpeedSave {
        public static void slowSave(Update update,TelegramLongPollingBot bot){
            BaseConfigBot.updateSpeed(update,10);
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
    public static void middleSave(Update update,TelegramLongPollingBot bot){
        BaseConfigBot.updateSpeed(update,5);
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

    public static void fastSave(Update update,TelegramLongPollingBot bot){
        BaseConfigBot.updateSpeed(update,3);
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

