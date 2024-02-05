package org.example.bot.calllback;

import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class SizeCallBack {
    private static final InlineKeyboardMarkup INLINE_LINK_SIZE = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(EditButton.BTN_SMALL,EditButton.BTN_MEDIUM,EditButton.BTN_BIG))
            .build();

    public static void sizeProcess(Update update, TelegramLongPollingBot bot){
        try {
            bot.execute(SendMessage.builder()
                            .text("please choice size")
                            .chatId(UpdateIdProcess.chatId(update))
                            .replyMarkup(INLINE_LINK_SIZE)

                    .build());


        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }



    }
}
