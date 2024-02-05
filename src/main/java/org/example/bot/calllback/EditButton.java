package org.example.bot.calllback;

import org.example.bot.enam.CallDate;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class EditButton {
    public static InlineKeyboardButton BTN_WHITE = InlineKeyboardButton.builder()
            .text("WHITE")
            .callbackData(CallDate.CALLBACK_WHITE.getValue())
            .build();
    public static InlineKeyboardButton BTN_BLACK = InlineKeyboardButton.builder()
            .text("BLACK")
            .callbackData(CallDate.CALLBACK_BACK.getValue())
            .build();
    public static InlineKeyboardButton BTN_BLUE = InlineKeyboardButton.builder()
            .text("BLUE")
            .callbackData(CallDate.CALLBACK_BLUE.getValue())
            .build();



    public static InlineKeyboardButton BTN_SMALL = InlineKeyboardButton.builder()
            .text("small")
            .callbackData(CallDate.CALLBACK_SMALL.getValue())
            .build();
    public static InlineKeyboardButton BTN_MEDIUM = InlineKeyboardButton.builder()
            .text("medium")
            .callbackData(CallDate.CALLBACK_MEDIUM.getValue())
            .build();
    public static InlineKeyboardButton BTN_BIG = InlineKeyboardButton.builder()
            .text("big")
            .callbackData(CallDate.CALLBACK_BIG.getValue())
            .build();





    public static InlineKeyboardButton BTN_SLOW = InlineKeyboardButton.builder()
            .text("SLOW")
            .callbackData(CallDate.SPEED_SLOW.getValue())
            .build();
    public static InlineKeyboardButton BTN_MIDDLE = InlineKeyboardButton.builder()
            .text("MIDDLE")
            .callbackData(CallDate.SPEED_MIDDLE.getValue())
            .build();
    public static InlineKeyboardButton BTN_FAST = InlineKeyboardButton.builder()
            .text("FAST")
            .callbackData(CallDate.SPEED_FAST.getValue())
            .build();
}
