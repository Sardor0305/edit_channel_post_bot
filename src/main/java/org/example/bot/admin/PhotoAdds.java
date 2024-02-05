package org.example.bot.admin;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class PhotoAdds {
    public static void addsProcess(Update update, TelegramLongPollingBot bot, Long chatId) {
        String fileId = update.getMessage().getPhoto().get(2).getFileId();
        String caption = update.getMessage().getCaption();

        if (update.getMessage().hasPhoto()) {
            try {
                bot.execute(SendPhoto.builder()
                        .chatId(chatId)
                        .photo(new InputFile(fileId))
                        .caption(caption)
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }
    }
}