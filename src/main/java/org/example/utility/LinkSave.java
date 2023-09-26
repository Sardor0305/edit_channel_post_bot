package org.example.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.ConnectDb;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class LinkSave {
    public static void add(Update update,String link){
        String query;
        if (get(String.valueOf(update.getChannelPost().getChatId())) != null){
            query = "UPDATE links SET link = '" + update.getChannelPost().getText() +"' WHERE channelId = '" + update.getChannelPost().getChatId() + "'";
        }else {
            query = "INSERT INTO links (channelId,link)  values ('" + update.getChannelPost().getChatId() + "','" + link+ "')";
        }
        try {
            Statement connect = ConnectDb.connect();
            connect.execute(query);
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void delete(Long channelId){
        String query = "DELETE FROM links WHERE channelId = '" + channelId + "'";
        try {
            Statement connect = ConnectDb.connect();
            connect.execute(query);
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static String get(String channel) {

        String query = "select link from links where channelId = '" + channel + "'";
        ResultSet resultSet;
        try {
            Statement statement = ConnectDb.connect();
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                return resultSet.getString("link");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static final Map<Long, String> SAVE_LINK = new HashMap<>();

}
