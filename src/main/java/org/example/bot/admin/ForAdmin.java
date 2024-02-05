package org.example.bot.admin;

import org.example.bot.db.BaseConfigBot;
import org.example.bot.enam.State;
import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ForAdmin {
    public static void adminProcess(Update update, TelegramLongPollingBot bot) {
        if (update.getMessage().getText().equals("/join_adds")) {
            BaseConfigBot.updateState(update, State.ADMIN.toString());

            try {
                bot.execute(SendMessage.builder()
                        .chatId(UpdateIdProcess.chatId(update))
                        .text("reklamani yuboring")
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
        else if(update.getMessage().getText().equals("/show_statistic")){
            BaseConfigBot.updateState(update,State.STATISTIC.toString());
            BaseConfigBot.showStatistic(update,bot);
        }
    }
}
