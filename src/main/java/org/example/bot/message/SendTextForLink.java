package org.example.bot.message;

import org.example.bot.db.BaseConfigBot;
import org.example.bot.enam.State;
import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Objects;

public class SendTextForLink {
    public static void process(Update update, TelegramLongPollingBot bot) {
        BaseConfigBot.updateState(update, State.PROCESS.toString());

        if (Objects.equals(BaseConfigBot.selectState(update), State.PROCESS.toString())) {
//            BaseConfigBot.updateState(update,State.NEXT_JOIN.toString());
            try {
                bot.execute(SendMessage.builder()
                        .text("send link text")
                        .chatId(UpdateIdProcess.chatId(update))
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

            SaveLink.process(update, bot);

        }
    }
}
