package org.example.bot.video;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class SaveVideo {
    public static void saveProcess(Update update , TelegramLongPollingBot bot) {
      String fileId =  update.getChannelPost().getVideo().getFileId();
        String urlVideo = "/home/sharipov/IdeaProjects/joinlinkbot/src/main/resources/video/" + fileId + ".mp4";
        try {

            GetFile getFileRequest = new GetFile();
            getFileRequest.setFileId(fileId);
            File file = bot.execute(getFileRequest);
            String filePath = file.getFileUrl(bot.getBotToken());
            System.out.println(filePath);

                try (InputStream inputStream = new URL(filePath).openStream();
                     FileOutputStream outputStream = new FileOutputStream("/home/sharipov/IdeaProjects/joinlinkbot/src/main/resources/video/" + fileId + ".mp4")) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            } catch (TelegramApiException | IOException e) {
                e.printStackTrace();
            }

        VideoEdit.processVideo(update, bot);


        java.io.File file = new java.io.File(urlVideo);
        file.delete();


    }









}
