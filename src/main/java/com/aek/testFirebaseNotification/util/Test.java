package com.aek.testFirebaseNotification.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Date date = test.parseDateStrToDate("20230212");
        test.testCreateNotiMessage(date);
    }

    private void testCreateNotiMessage(Date debtDate){
        System.out.println(debtDate);
        LocalDate localDate = Instant.ofEpochMilli(debtDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        Date expireDebtDate = Date.from(localDate.plusDays(30).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date currentDate = new Date();

        long diff = expireDebtDate.getTime() - currentDate.getTime();

        System.out.println("debtDate : " + debtDate);
        System.out.println("expireDebtDate : " + expireDebtDate);
        System.out.println("currentDate : " + currentDate);
        System.out.println("day diff : " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

    }

    private Date parseDateStrToDate(String dateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
}
