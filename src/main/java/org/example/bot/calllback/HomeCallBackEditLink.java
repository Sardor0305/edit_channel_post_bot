package org.example.bot.calllback;

import org.example.bot.db.BaseConfigBot;
import org.example.bot.enam.State;
import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class HomeCallBackEditLink {
    private static final InlineKeyboardMarkup INLINE_EDIT_LINK =  InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(Buttons.BTN_COLOR))
            .keyboardRow(List.of(Buttons.BTN_SIZE))
            .keyboardRow(List.of(Buttons.BTN_SPEED))
            .build();


    public static void process(Update update, TelegramLongPollingBot bot) {

            try {
                bot.execute(SendMessage.builder()
                        .text("choice option")
                        .replyMarkup(INLINE_EDIT_LINK)
                        .chatId(UpdateIdProcess.chatId(update))
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }


    }
}
