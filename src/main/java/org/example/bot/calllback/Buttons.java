package org.example.bot.calllback;



import org.example.bot.enam.CallDate;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class Buttons {
    /**
     * for size
     */
    public static InlineKeyboardButton BTN_SIZE = InlineKeyboardButton.builder()
            .text("SIZE")
            .callbackData(CallDate.CALLBACK_SIZE.getValue())
        .build();
    public static InlineKeyboardButton SIZE_SLOW = InlineKeyboardButton.builder()
            .text("SLOW")
            .callbackData(CallDate.CALLBACK_SIZE.getValue())
            .build();




    public static InlineKeyboardButton BTN_COLOR = InlineKeyboardButton.builder()
            .text("COLOR")
            .callbackData(CallDate.CALLBACK_COLOR.getValue())
            .build();

    public static InlineKeyboardButton BTN_SPEED = InlineKeyboardButton.builder()
            .text("SPEED")
            .callbackData(CallDate.CALLBACK_SPEED.getValue())
            .build();
    public static InlineKeyboardButton BTN_TEXT = InlineKeyboardButton.builder()
            .text("TEXT")
            .callbackData(CallDate.CALLBACK_TEXT.getValue())
            .build();
    public static InlineKeyboardButton BTN_EDIT = InlineKeyboardButton.builder()
            .text("EDIT")
            .callbackData(CallDate.CALLBACK_EDIT.getValue())
            .build();

}
