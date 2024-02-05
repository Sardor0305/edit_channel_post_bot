package org.example.bot.calllback;

import org.example.bot.enam.CallDate;
import org.example.bot.message.EditColorSave;
import org.example.bot.message.EditSizeSave;
import org.example.bot.message.EditSpeedSave;
import org.example.bot.message.SendTextForLink;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CallBackProcess {


    public static void process(Update update, TelegramLongPollingBot bot){

        switch (CallDate.of(update.getCallbackQuery().getData())){
            case CALLBACK_TEXT ->  SendTextForLink.process(update, bot);
            case CALLBACK_EDIT -> HomeCallBackEditLink.process(update,bot);

            case CALLBACK_COLOR -> ColorCallBack.colorProcess(update,bot);
            case CALLBACK_WHITE -> EditColorSave.whiteSave(update,bot);
            case CALLBACK_BACK -> EditColorSave.blackSave(update,bot);
            case CALLBACK_BLUE -> EditColorSave.blueSave(update,bot);

            case CALLBACK_SIZE -> SizeCallBack.sizeProcess(update,bot);
            case CALLBACK_SMALL -> EditSizeSave.smallSave(update,bot);
            case CALLBACK_MEDIUM -> EditSizeSave.mediumSave(update,bot);
            case CALLBACK_BIG -> EditSizeSave.largeSave(update,bot);


            case CALLBACK_SPEED ->SpeedCallBack.speedProcess(update,bot);
            case SPEED_SLOW -> EditSpeedSave.slowSave(update,bot);
            case SPEED_MIDDLE -> EditSpeedSave.middleSave(update, bot);
            case SPEED_FAST -> EditSpeedSave.fastSave(update,bot);
        }
    }
}
