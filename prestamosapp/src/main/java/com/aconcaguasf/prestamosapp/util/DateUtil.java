package com.aconcaguasf.prestamosapp.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    private static final Logger logger = LogManager.getLogger(DateUtil.class);

    public static LocalDate getFechaLocalDate(String localDateString, String formato) {
        LocalDate localDate = null;
        try {
            if (localDateString != null && !localDateString.trim().isEmpty()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
                localDate = LocalDate.parse(localDateString, formatter);
            }
        } catch (Exception e) {
            logger.error("Error: " + localDateString + " " + formato + ", "+ e.getMessage());
        }
        return localDate;
    }

    public static String getFechaLocalDateTexto(LocalDate localDate, String formato) {
        String localDateString = "";
        try {
            if (localDate != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
                localDateString = localDate.format(formatter);
            }
        } catch (Exception e) {
            logger.error("Error: "+ localDate + " "+ formato+", " + e.getMessage());
        }
        return localDateString;
    }
}
