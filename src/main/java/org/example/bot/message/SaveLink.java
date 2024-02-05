package org.example.bot.message;

import org.example.bot.db.BaseConfigBot;
import org.example.bot.enam.State;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Objects;

public class SaveLink {

    public static void process(Update update, TelegramLongPollingBot bot){
        if(Objects.equals(BaseConfigBot.selectState(update), State.PROCESS.name())){
BaseConfigBot.updateState(update,State.NEXT_JOIN.toString());
            BaseConfigBot.UpdateLink(update,bot);
        }
    }
}
