package com.util;

import lombok.extern.slf4j.Slf4j;
import org.postgresql.PGNotification;


@Slf4j
public class NotificationResolver {

    public static boolean Resolve(PGNotification notification){


        log.info("RESOLVING: " + notification.getName() + ", " + notification.getParameter() + ", " + notification.getPID());

        return true;
    }

}
