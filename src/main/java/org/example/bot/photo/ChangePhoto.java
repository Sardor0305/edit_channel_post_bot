package org.example.bot.photo;

import org.example.bot.db.BaseConfigBot;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChangePhoto {
    public static void changePhotoProcess(Update update , TelegramLongPollingBot bot){

String fileId =update.getChannelPost().getPhoto().get(2).getFileId();
        File sourceImageFile = new File("/home/sharipov/IdeaProjects/joinlinkbot/src/main/resources/photo/"
                + fileId+".png");
        File destImageFile = new File("/home/sharipov/IdeaProjects/joinlinkbot/src/main/resources/"
                +fileId+".png");
String link = BaseConfigBot.selectText(update);
int size = BaseConfigBot.selectSize(update);
String color = BaseConfigBot.selectColor(update);
if(link!=null){

        addWatermarkOnImage(link,size,color,sourceImageFile, destImageFile);
    }
    }
    private  static void addWatermarkOnImage(String text,int size,String color, File sourceImageFile, File destImageFile) {

        try {

            BufferedImage sourceImage = ImageIO.read(sourceImageFile);
            Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();

            AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
            g2d.setComposite(alphaChannel);
            if(color.equals("blue")){
                g2d.setColor(Color.blue);
            }
            else if(color.equals("black")){
                g2d.setColor(Color.black);
            }
            else{
                g2d.setColor(Color.white);
            }

            g2d.setFont(new Font("Arial", Font.BOLD, size));
            FontMetrics fontMetrics = g2d.getFontMetrics();
            Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);
            // calculates the coordinate where the String is painted
            int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
            int centerY = sourceImage.getHeight() / 2 + sourceImage.getHeight() / 4;

            // paints the textual watermark
            g2d.drawString(text, centerX, centerY);

            ImageIO.write(sourceImage, "png", destImageFile);
            g2d.dispose();

            //System.out.println("The text watermark is added to the image.");

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
