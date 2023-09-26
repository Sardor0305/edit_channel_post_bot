package org.example.callback;

import org.example.callback.button.Buttons;
import org.example.utility.CheckAdmin;
import org.example.utility.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class CallBackButtonProc {
    public static InlineKeyboardMarkup INLINE_JOIN_DELETE  = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(Buttons.BTN_JOIN,Buttons.BTN_DELETE))
            .build();

    public static void process(Update update , TelegramLongPollingBot bot) {

            try {
                bot.execute(SendMessage.builder()
                        .chatId(update.getChannelPost().getChatId())
                        .text("\uD83E\uDD13 Qaysi xizmatni tanlaysiz:")
                        .replyMarkup(INLINE_JOIN_DELETE)
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }




    }
}
