package org.example.bot.message;

import org.example.bot.calllback.CallBackHome;
import org.example.bot.db.BaseConfigBot;
import org.example.bot.enam.State;
import org.glassfish.grizzly.compression.lzma.impl.Base;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartProcess {
    public static void process(Update update, TelegramLongPollingBot bot){
        if(update.getChannelPost().getText().equals("/startbot")){
//            BaseConfigBot.updateState(update, State.PROCESS.toString());
            CallBackHome.homeProcess(update,bot);

        }


    }

}
