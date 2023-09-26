package org.example.utility;

import org.telegram.telegrambots.meta.api.objects.Update;

public class UpdateIdProcess {
    public static Long chatId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getChatId();

        } else if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getMessage().getChatId();
        }
        else if(update.hasChannelPost()){
            return update.getChannelPost().getChatId();
        }

        return null;
    }





}
