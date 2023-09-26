package org.example.channel_post;

import org.example.enam.UserState;
import org.example.state.UserButtonState;
import org.example.utility.LinkSave;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetJoinLink {
    public static void process(Update update, TelegramLongPollingBot bot){
      if(UserButtonState.USER_BUTTON_STATE_MAP.containsKey(update.getChannelPost().getChatId())){

            if (UserButtonState.USER_BUTTON_STATE_MAP.get(update.getChannelPost().getChatId()).equals(UserState.DEFAULT)) {
                LinkSave.add(update,update.getChannelPost().getText());

                UserButtonState.USER_BUTTON_STATE_MAP.put(update.getChannelPost().getChatId(),UserState.CREATElINK);
          ///      LinkSave.SAVE_LINK.put(update.getChannelPost().getChatId(), update.getChannelPost().getText());
                String str=  update.getChannelPost().getText();
                try {
                    bot.execute(SendMessage.builder()
                                    .chatId(update.getChannelPost().getChatId())
//                                    .messageId(update.getChannelPost().getMessageId())
                                    .text("✅ Link shu ko'rinishda bo'ladi\n\n" +
                                            "\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47 \n\n" +
                                            str+"\n\n" +
                                            "\uD83D\uDC46\uD83D\uDC46\uD83D\uDC46 \n")

                            .build());

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
