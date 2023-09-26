package org.example.utility;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatAdministrators;

import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMemberMember;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.awt.*;
import java.util.List;

public class CheckAdmin {
    public static boolean isChannelAdmin(Update update, TelegramLongPollingBot bot) {
;
        GetChatMember member = new GetChatMember();
        member.setChatId(update.getCallbackQuery().getMessage().getChatId());
        member.setUserId(update.getCallbackQuery().getFrom().getId());///userId

        try {
            ChatMember member1 = bot.execute(member);
            if (member1.getStatus().equals("administrator") ||
                    member1.getStatus().equals("creator")) {
                return true;
            }
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        return false;
    }




    }


