package org.example.channel_post;

import org.example.enam.UserState;
import org.example.state.UserButtonState;
import org.example.utility.LinkSave;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChat;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.WriteAccessAllowed;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ChannelPostProcess {
    public static void process(Update update, TelegramLongPollingBot bot) {


//            Long chatId = ;
//            Integer messageId = ;
//            String text = ;
        System.out.println(update.getChannelPost().getChat());
        System.out.println();


        System.out.println("chatidaa---------" + update.getChannelPost().getChatId());
        if (LinkSave.get(String.valueOf(update.getChannelPost().getChatId())) != null
                && UserButtonState.USER_BUTTON_STATE_MAP.containsKey(update.getChannelPost().getChatId())
                && UserButtonState.USER_BUTTON_STATE_MAP.get(update.getChannelPost().getChatId()).equals(UserState.CREATElINK)
        ) {


            try {
                String username = LinkSave.get(String.valueOf(update.getChannelPost().getChatId()));
                System.out.println(LinkSave.SAVE_LINK);

                MessageEntity messageEntity = new MessageEntity();
                messageEntity.setType("bold");
                bot.execute(EditMessageCaption.builder()
                        .chatId(update.getChannelPost().getChatId())
                        .messageId(update.getChannelPost().getMessageId())
//                        .parseMode(ParseMode.HTML)
                        .caption(update.getChannelPost().getCaption() + "\n\n" + username)
                        .build());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }
    }

}

//                                    .messageId(update.getChannelPost().getMessageId())
////                                    .parseMode(ParseMode.HTML)
//                                    .caption(update.getChannelPost().getCaption() + "\n\n" + channel.getInviteLink())
//
//                                    .build());
//                }
//
//            } catch (TelegramApiException e) {
//                throw new RuntimeException(e);
//            }




//                System.out.println(link);


//    }



