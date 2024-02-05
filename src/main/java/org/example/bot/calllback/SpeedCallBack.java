package org.example.bot.calllback;

import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class SpeedCallBack {
    private static final InlineKeyboardMarkup INLINE_LINK_SPEED = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(EditButton.BTN_SLOW,EditButton.BTN_MIDDLE,EditButton.BTN_FAST))
            .build();

    public static void speedProcess(Update update, TelegramLongPollingBot bot){
        try {
            bot.execute(SendMessage.builder()
                            .text("please choice speed")
                            .chatId(UpdateIdProcess.chatId(update))
                            .replyMarkup(INLINE_LINK_SPEED)

                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }
}
