package org.example.bot.photo;

import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class SendEditPhoto {
    public static void processForPhoto(Update update, TelegramLongPollingBot bot){
        try {
            bot.execute(SendMessage.builder()
                            .text("please waiting...")
                            .chatId(UpdateIdProcess.chatId(update))
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        SavePhoto.saveProcess(update, bot);
        try {
            bot.execute(SendPhoto.builder()

                    .chatId(UpdateIdProcess.chatId(update))
                    .photo(new InputFile(new File("/home/sharipov/IdeaProjects/joinlinkbot/src/main/resources/"+
                            update.getChannelPost().getPhoto().get(2).getFileId()+".png")))

                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        File file =new File("/home/sharipov/IdeaProjects/joinlinkbot/src/main/resources/"+
                update.getChannelPost().getPhoto().get(2).getFileId()+".png");
        file.delete();


    }
}
