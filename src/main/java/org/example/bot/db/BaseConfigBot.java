package org.example.bot.db;


import org.example.bot.admin.PhotoAdds;
import org.example.bot.admin.VideoAdds;
import org.example.bot.enam.State;
import org.example.bot.utiliy.UpdateIdProcess;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.*;

public class BaseConfigBot {

    private static Connection connection;


    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/join_link";
    private static final String username = "sharipov";
    private static final String password = "123";


    // Perform database operations here


    public static void insertUser(Update update, TelegramLongPollingBot bot) {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the PostgreSQL database!");

            String sql = "INSERT INTO users_chat (chat_id, user_id) VALUES (?, ?)";
            String selectSql = "SELECT chat_id FROM users_chat WHERE chat_id = ?";

            try (PreparedStatement selectStatement = connection.prepareStatement(selectSql);
                    PreparedStatement statement = connection.prepareStatement(sql)) {


                selectStatement.setLong(1, UpdateIdProcess.userId(update));
                ResultSet resultSet = selectStatement.executeQuery();
                Long chatId = null;

                while (resultSet.next()) {
                    // Retrieve data from the result set
                    chatId = resultSet.getLong("chat_id");
                    System.out.println("--------"+chatId);
                }
                if(chatId == null) {
                    statement.setLong(1, UpdateIdProcess.chatId(update));
                    statement.setLong(2, UpdateIdProcess.userId(update));
                }
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Data insertion failed!");
                }
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
        }
    }







    public static void UpdateLink(Update update, TelegramLongPollingBot bot) {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the PostgreSQL database!");



            String updateSql = "UPDATE users_chat SET text = ? WHERE chat_id = ?";

            try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {

                updateStatement.setString(1, update.getMessage().getText());
                updateStatement.setLong(2, UpdateIdProcess.chatId(update));
                updateStatement.executeUpdate();
                int rowsInserted =updateStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully! for link ");
                } else {
                    System.out.println("Data insertion failed!----");
                }

            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
        }
    }

    public static void updateState(Update update,String st) {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the PostgreSQL database!");

            String updateSqlStr = "UPDATE users_chat SET state = ? WHERE chat_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(updateSqlStr)) {
                statement.setString(1, st);
                statement.setLong(2, UpdateIdProcess.chatId(update));

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Data insertion failed!");
                }
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
        }
    }
    public static String selectState(Update update) {
        String st ;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the PostgreSQL database!");

            String selectSqlStr = "select state from users_chat where chat_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(selectSqlStr)) {
                statement.setLong(1,UpdateIdProcess.chatId(update));


                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    // Retrieve data from the result set
                    st = resultSet.getString("state");
                    return st;

                }
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully!------------");
                } else {
                    System.out.println("Data insertion failed!---------------");
                }

            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error:---------- " + e.getMessage());
        }
        return null;
    }


    public static void updateSize(Update update, Integer size) {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the PostgreSQL database!");

            String updateSqlStr = "UPDATE users_chat SET size = ? WHERE chat_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(updateSqlStr)) {
                statement.setInt(1, size);
                statement.setLong(2, UpdateIdProcess.chatId(update));

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Data insertion failed!");
                }
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
        }
    }

    public static void updateSpeed(Update update, Integer speed) {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the PostgreSQL database!");

            String updateSqlStr = "UPDATE users_chat SET speed = ? WHERE chat_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(updateSqlStr)) {
                statement.setInt(1, speed);
                statement.setLong(2, UpdateIdProcess.chatId(update));

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Data insertion failed!");
                }
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
        }
    }

    public static void updateColor(Update update,String color) {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the PostgreSQL database!");

            String updateSqlStr = "UPDATE users_chat SET color = ? WHERE chat_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(updateSqlStr)) {
                statement.setString(1, color);
                statement.setLong(2, UpdateIdProcess.chatId(update));

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Data insertion failed!");
                }
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
        }
    }

    public static String selectColor(Update update) {
        String color1 = "white";
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the PostgreSQL database!");

            String selectSqlStr = "select color from users_chat where chat_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(selectSqlStr)) {
                statement.setLong(1,UpdateIdProcess.chatId(update));


                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    // Retrieve data from the result set
                    color1 = resultSet.getString("color");

                }
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Data insertion failed!");
                }

            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
        }
        return color1;
    }

    public static int selectSpeed(Update update) {
        int speed1 =7 ;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the PostgreSQL database!");
            String selectSqlStr = "select speed from users_chat where chat_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(selectSqlStr)) {
                statement.setLong(1,UpdateIdProcess.chatId(update));
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    // Retrieve data from the result set
                    speed1 = resultSet.getInt("speed");
                    return speed1;

                }
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Data insertion failed!");
                }

            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
        }
        return speed1;
    }
    public static int selectSize(Update update) {
        int size1 = 16;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the PostgreSQL database!");
            String selectSqlStr = "select size from users_chat where chat_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(selectSqlStr)) {
                statement.setLong(1,UpdateIdProcess.chatId(update));
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    // Retrieve data from the result set
                    size1 = resultSet.getInt("size");

                }
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Data insertion failed!");
                }

            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
        }
       return size1;
    }

    public static String selectText(Update update) {
        String text = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the PostgreSQL database!");

            String selectSqlStr = "select text from users_chat where chat_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(selectSqlStr)) {
                statement.setLong(1,UpdateIdProcess.chatId(update));


                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    // Retrieve data from the result set
                    text = resultSet.getString("text");

                }
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Data insertion failed!");
                }

            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
        }
        return text;
    }

    public static void selectChatIdPhoto(Update update,TelegramLongPollingBot bot) {

        if(BaseConfigBot.selectState(update).equals(State.ADMIN.toString())){
BaseConfigBot.updateState(update,State.START.toString());

        int i = 1;

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the PostgreSQL database!");

            String selectSqlStr = "select chat_id from users_chat ";

            try (PreparedStatement statement = connection.prepareStatement(selectSqlStr)) {
//                statement.setLong(1,UpdateIdProcess.chatId(update));


                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    // Retrieve data from the result set
                    Long chatId = resultSet.getLong("chat_id");
                    PhotoAdds.addsProcess(update,bot,chatId);
                }
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully!");
                } else {
                    System.out.println("Data insertion failed!");
                }

            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed! Error: " + e.getMessage());
        }

    }
    }

    public static void selectChatIdVideo(Update update,TelegramLongPollingBot bot) {
        if( BaseConfigBot.selectState(update).equals(State.ADMIN.toString())){
            BaseConfigBot.updateState(update,State.START.toString());

            int i = 1;

            try {
                connection = DriverManager.getConnection(jdbcUrl, username, password);
                System.out.println("Connected to the PostgreSQL database!");

                String selectSqlStr = "select chat_id from users_chat ";

                try (PreparedStatement statement = connection.prepareStatement(selectSqlStr)) {
//                statement.setLong(1,UpdateIdProcess.chatId(update));


                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        // Retrieve data from the result set
                        Long chatId = resultSet.getLong("chat_id");
                        VideoAdds.addsProcess(update,bot,chatId);
                    }
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Data inserted successfully!");
                    } else {
                        System.out.println("Data insertion failed!");
                    }

                }
                connection.close();
            } catch (SQLException e) {
                System.out.println("Connection failed! Error: " + e.getMessage());
            }

        }
    }
    public static void showStatistic(Update update,TelegramLongPollingBot bot) {
        if(BaseConfigBot.selectState(update).equals(State.STATISTIC.toString())){
            BaseConfigBot.updateState(update,State.START.toString());



            try {
                connection = DriverManager.getConnection(jdbcUrl, username, password);
                System.out.println("Connected to the PostgreSQL database!");

                String selectSqlStr = "select id from users_chat order by id desc limit 1";

                try (PreparedStatement statement = connection.prepareStatement(selectSqlStr)) {
//                statement.setLong(1,UpdateIdProcess.chatId(update));


                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        // Retrieve data from the result set
                        int chatId = resultSet.getInt("id");
                        bot.execute(SendMessage.builder()

                                        .chatId(UpdateIdProcess.chatId(update))
                                        .text("users number "+chatId)
                                .build());

                    }
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Data inserted successfully!");
                    } else {
                        System.out.println("Data insertion failed!");
                    }

                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                connection.close();
            } catch (SQLException e) {
                System.out.println("Connection failed! Error: " + e.getMessage());
            }

        }
    }


}