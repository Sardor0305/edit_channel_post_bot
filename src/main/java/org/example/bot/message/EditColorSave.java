package org.example.bot.message;

import org.example.bot.db.BaseConfigBot;
import org.example.bot.utiliy.UpdateIdProcess;
import org.glassfish.grizzly.compression.lzma.impl.Base;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EditColorSave {
        public static void whiteSave(Update update,TelegramLongPollingBot bot){

            BaseConfigBot.updateColor(update,"white");
            try {
                bot.execute(SendMessage.builder()
                                .text("successful")
                                .chatId(UpdateIdProcess.chatId(update))
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    public static void blackSave(Update update,TelegramLongPollingBot bot){
        BaseConfigBot.updateColor(update,"black");
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

    public static void blueSave(Update update,TelegramLongPollingBot bot){
        BaseConfigBot.updateColor(update,"blue");
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

