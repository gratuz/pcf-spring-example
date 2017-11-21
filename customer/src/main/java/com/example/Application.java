package com.example;

import com.util.NotificationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        //try {
            //Listener listener = new Listener();
            //listener.start();
        //}catch(SQLException e){
            //we just won't listen then.
        //}


    }



}


/**
 * <p>Following the pattern explained in the postgres documentation here:
 * https://jdbc.postgresql.org/documentation/83/listennotify.html</p>
 */
class Listener extends Thread {

    private Connection conn;
    private org.postgresql.PGConnection pgconn;

    //@Value("${spring.datasource.url}")
    private String DbUrl = "jdbc:postgresql://localhost:5432/postgres";

    Listener() throws SQLException {

        this.conn = DriverManager.getConnection(DbUrl);
        this.pgconn = (org.postgresql.PGConnection)conn;
        Statement stmt = conn.createStatement();
        stmt.execute("LISTEN app_message");
        stmt.close();

    }

    public void run() {
        while (true) {
            try {
                // issue a dummy query to contact the backend
                // and receive any pending notifications.
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT 1");
                rs.close();
                stmt.close();

                org.postgresql.PGNotification notifications[] = pgconn.getNotifications();
                if (notifications != null) {
                    for (int i=0; i<notifications.length; i++) {
                        NotificationResolver.Resolve(notifications[i]);
                    }
                }

                // wait a while before checking again for new
                // notifications
                Thread.sleep(500);
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

}





