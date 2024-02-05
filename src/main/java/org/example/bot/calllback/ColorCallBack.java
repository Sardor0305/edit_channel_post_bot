package org.example.bot.calllback;

import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class ColorCallBack {
    private static final InlineKeyboardMarkup INLINE_LINK_COLOR = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(EditButton.BTN_WHITE,EditButton.BTN_BLACK,EditButton.BTN_BLUE))
            .build();

    public static void
    colorProcess(Update update, TelegramLongPollingBot bot){
        try {
            bot.execute(SendMessage.builder()
                            .text("please choice text color")
                            .chatId(UpdateIdProcess.chatId(update))
                            .replyMarkup(INLINE_LINK_COLOR)

                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }
}
