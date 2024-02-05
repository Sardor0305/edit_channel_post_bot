package org.example.bot;

import org.example.bot.admin.ForAdmin;
import org.example.bot.calllback.CallBackProcess;
import org.example.bot.db.BaseConfigBot;

import org.example.bot.message.Start;
import org.example.bot.message.StartProcess;
import org.example.bot.photo.SendEditPhoto;

import org.example.bot.utiliy.OtherCondition;
import org.example.bot.video.SendEditVideo;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class JoinLinkBot extends TelegramLongPollingBot {
    public JoinLinkBot(){
        super("5699895765:AAEK8z5kTgQSr-N6Epx75gjR76VtDwdaYgQ");
    }
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasChannelPost()) {

            if (update.getChannelPost().hasText()) {

                StartProcess.process(update,this);



            } else if (update.getChannelPost().hasVideo()) {
                if(update.getChannelPost().getCaption()!=null){

                }
                SendEditVideo.processForVideo(update, this);
            } else if (update.getChannelPost().hasPhoto()) {
                if(update.getChannelPost().getCaption()!=null){

                }
                SendEditPhoto.processForPhoto(update, this);

            } else {
                OtherCondition.process(update,this);
            }


        } else if (update.hasCallbackQuery()) {

            CallBackProcess.process(update, this);


        }
        else if(update.hasMessage()){
            if(update.getMessage().hasText()){
                Start.startProcess(update,this);
                ForAdmin.adminProcess(update,this);
                BaseConfigBot.selectChatIdPhoto(update,this);
                BaseConfigBot.selectChatIdVideo(update,this);
            }
        }
    }
    @Override
    public String getBotUsername() {
        return "@Allunitybot";
    }
}
