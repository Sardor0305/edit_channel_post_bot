package org.example;


import org.example.callback.CallbackProcess;
import org.example.channel_post.ChannelPostProcess;
import org.example.channel_post.GetJoinLink;
import org.example.channel_post.ShowCallBack;
import org.example.state.UserButtonState;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class JoinlinkBot extends TelegramLongPollingBot {
    public JoinlinkBot() {
        super("6303622533:AAHsVQPyvhaxWJzaCVNcmOl0Z-moPp14wnA");
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                if (update.getMessage().getText().equals("/start")) {
                    try {
                        execute(SendMessage.builder()
                                .chatId(update.getMessage().getChatId())
                                .text("Botimizga xush kelibsiz\uD83D\uDE0A\n" +
                                        "BU bot nima qila oladi?\n" +
                                        "Bot sizga kanal link qo'sha oladi \n" +
                                        "Buning uchun botni kanalga admin qilishingiz uzi kifoya\uD83D\uDC6E\n" +
                                        "@Raximov14_bot kalit suzni yozing va havola kiriting\n" +
                                        "CHEKLOVLAR\n" +
                                        "❌ Tepasida 'forward' qilingan xabarlarga post qo'ymaydi\n" +
                                        "❌ Captionsiz xabarlarga post qo'ymaydi")

                                .build());
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    {

                    }

                }
            }

        } else if (update.hasCallbackQuery()) {

            CallbackProcess.process(update, this);
        }


        if (update.hasChannelPost() &&
                update.getChannelPost().getCaption() != null
                && update.getChannelPost().getForwardFromChat() == null
                && update.getChannelPost().getForwardFrom() == null) {
            ChannelPostProcess.process(update, this);


        } else if (update.hasChannelPost() && update.getChannelPost().hasText()) {
            ShowCallBack.showBtnProcess(update,this);
            GetJoinLink.process(update, this);
        }


    }


    @Override
    public String getBotUsername() {
        return "@pulkursibot";
    }
}
