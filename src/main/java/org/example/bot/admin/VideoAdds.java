package org.example.bot.admin;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class VideoAdds {
    public static void addsProcess(Update update, TelegramLongPollingBot bot, Long chatId) {
        String fileId = update.getMessage().getVideo().getFileId();
        String caption = update.getMessage().getCaption();
        try {
            bot.execute(SendVideo.builder()
                    .chatId(chatId)
                    .video(new InputFile(fileId))
                    .caption(caption)
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }


}
