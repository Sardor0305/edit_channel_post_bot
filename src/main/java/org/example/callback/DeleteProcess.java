package org.example.callback;

import org.example.state.UserButtonState;
import org.example.utility.CheckAdmin;
import org.example.utility.LinkSave;
import org.example.utility.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.swing.text.Utilities;

public class DeleteProcess {
    public static void process(Update update, TelegramLongPollingBot bot) {
        if (CheckAdmin.isChannelAdmin(update,bot)) {
            LinkSave.delete(update.getCallbackQuery().getMessage().getChatId());
            try {
                bot.execute(SendMessage.builder()
                        .chatId(update.getCallbackQuery().getMessage().getChatId())
                        .text("✅ Joriy havola o’chirildi")

                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

            // LinkSave.SAVE_LINK.remove(UpdateIdProcess.chatId(update));
        }
    }
}