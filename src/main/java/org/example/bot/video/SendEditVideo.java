package org.example.bot.video;

import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class SendEditVideo {

    public static void processForVideo(Update update, TelegramLongPollingBot bot){
        try {
            bot.execute(SendMessage.builder()
                            .text("please waiting...")
                            .chatId(UpdateIdProcess.chatId(update))
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SaveVideo.saveProcess(update,bot);
        try {
            bot.execute(SendVideo.builder()
                    .chatId(UpdateIdProcess.chatId(update))
                    .video(new InputFile(new File("/home/sharipov/IdeaProjects/joinlinkbot/src/main/resources/"+
                            update.getChannelPost().getVideo().getFileId()+".mp4")))

                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        File file =new File("/home/sharipov/IdeaProjects/joinlinkbot/src/main/resources/"+
                update.getChannelPost().getVideo().getFileId()+".mp4");
        file.delete();

    }
}
