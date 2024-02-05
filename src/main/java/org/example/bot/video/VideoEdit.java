package org.example.bot.video;

import org.example.bot.db.BaseConfigBot;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class VideoEdit {
    public static void processVideo(Update update , TelegramLongPollingBot bot){
///home/sharipov/IdeaProjects/joinlinkbot/src/main/java/org/example/bot/video
        String fileId = update.getChannelPost().getVideo().getFileId();
        String inputVideoPath = "/home/sharipov/IdeaProjects/joinlinkbot/src/main/resources/video/"
                + fileId+".mp4";

        String outputVideoPath = "/home/sharipov/IdeaProjects/joinlinkbot/src/main/resources/"
                +fileId+".mp4" ;
        String watermarkText = BaseConfigBot.selectText(update);
        String fontPath = "/home/sharipov/IdeaProjects/joinlinkbot/src/main/resources/java.ttf";
        int fontSize = BaseConfigBot.selectSize(update);
        String fontColor = BaseConfigBot.selectColor(update);
        int speed = BaseConfigBot.selectSpeed(update);
        System.out.println(fontColor+fontSize+speed);
        // or specify other colors using hexadecimal or RGB values
        String style = "Semibold";

        addRandomTextWatermark(inputVideoPath, outputVideoPath, watermarkText, fontPath, fontSize, fontColor,speed);

    }
    private static void addRandomTextWatermark(String inputVideoPath, String outputVideoPath, String watermarkText, String fontPath, int fontSize, String fontColor,int speed) {
//        try {
                    String filter = "drawtext=text='" + watermarkText + "':fontfile=" + fontPath + ":fontsize=" + fontSize +
                    ":x=if(eq(mod(t\\,"+ speed + ")\\,2)\\,rand(0\\,(w-text_w))\\,x)" +
                    ":y=if(eq(mod(t\\,"+ speed + ")\\,2)\\,rand(0\\,(h-text_h))\\,y)" +
                    ":alpha=if(lt(t\\, "+ speed + ")\\,2\\,if(lt(t\\,10)\\,1-(t-5)/1\\,if(lt(t\\,10)\\,(t-5)/1\\,2)))"+
                 ":fontcolor=" + fontColor;
//        String filter = "drawtext=text='" + watermarkText + "':fontfile=" + fontPath + ":fontsize=" + fontSize +
//                    ":x=if(eq(mod(t\\,5)\\,2)\\,rand(0\\,(w-text_w))\\,x)" +
//                    ":y=if(eq(mod(t\\,5)\\,2)\\,rand(0\\,(h-text_h))\\,y)" +
//                ":alpha=if(lt(t\\,10)\\,1-(t-5)/1\\,2)" +
//                ":fontcolor=" + fontColor;

//                            ":fontstyle="+style;

                ProcessBuilder processBuilder = new ProcessBuilder("ffmpeg",
                        "-i", inputVideoPath,
                        "-vf", filter,
                        "-c:a", "copy",
                        outputVideoPath);
        try {
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }

//            System.out.println("Text watermark added to the video.");

//
//    } catch (IOException e) {
//            throw new RuntimeException(e);
//        }




    }

}

