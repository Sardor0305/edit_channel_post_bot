package org.example.bot.calllback;

import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class CallBackHome {
    private static final InlineKeyboardMarkup INLINE_HOME = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(Buttons.BTN_TEXT,Buttons.BTN_EDIT))
            .build();



    public static void homeProcess(Update update, TelegramLongPollingBot bot){
        try {
            bot.execute(SendMessage.builder()
                    .text("please choice text color")
                    .chatId(UpdateIdProcess.chatId(update))
                    .replyMarkup(INLINE_HOME)
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }
}
