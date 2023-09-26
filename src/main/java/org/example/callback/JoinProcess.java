package org.example.callback;

import org.example.enam.UserState;
import org.example.state.UserButtonState;
import org.example.utility.CheckAdmin;
import org.example.utility.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class JoinProcess {

        public static void process(Update update, TelegramLongPollingBot bot) {
            if (CheckAdmin.isChannelAdmin(update,bot)) {
                UserButtonState.USER_BUTTON_STATE_MAP.put(UpdateIdProcess.chatId(update), UserState.DEFAULT);
                try {
                    bot.execute(SendMessage.builder()
                            .text("\uD83D\uDCCC Linkni kiriting: ")
                            .chatId(UpdateIdProcess.chatId(update))

                            .build());
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
