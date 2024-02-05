package org.example.bot.photo;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class SavePhoto {
    public static void saveProcess(Update update , TelegramLongPollingBot bot) {
        PhotoSize photo = update.getChannelPost().getPhoto().get(2);
        String fileId = photo.getFileId();
        String urlPhoto = "/home/sharipov/IdeaProjects/unitybot/src/main/resources/"
                + fileId + ".png";
        try {

            GetFile getFileRequest = new GetFile();
            getFileRequest.setFileId(fileId);
            File file = bot.execute(getFileRequest);
            String filePath = file.getFileUrl(bot.getBotToken());
            System.out.println(filePath);

            try (InputStream inputStream = new URL(filePath).openStream();
                 FileOutputStream outputStream = new FileOutputStream("/home/sharipov/IdeaProjects/joinlinkbot/src/main/resources/photo/" +
                         fileId + ".png")) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        } catch (TelegramApiException | IOException e) {
            e.printStackTrace();
        }


            ChangePhoto.changePhotoProcess(update, bot);

            java.io.File file = new java.io.File("/home/sharipov/IdeaProjects/joinlinkbot/src/main/resources/photo/"+fileId + ".png");
            file.delete();




    }
}
