package com.example.spacelearner;

import android.util.Log;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeLeftCalculator {
    public static String getTimeLeft(String date1, String date2) {
        String timeLeft = "Not defined";
        try {
            String format = "MM/dd/yyyy HH:mm";
            SimpleDateFormat sdf = new SimpleDateFormat(format);

            Date dateObj1 = sdf.parse(date1);
            Date dateObj2 = sdf.parse(date2);

            DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");
//            getTime() returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object
            long diff = dateObj2.getTime() - dateObj1.getTime();

//            int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
//            return "difference between days: " + diffDays;
//
            int diffhours = (int) (diff / (60 * 60 * 1000));
            int diffmin = (int) (diff / (60 * 1000));

            if (diffhours > 0) {
                String hoursLeft = crunchifyFormatter.format(diffhours);
                if (diffhours == 1) {
                    timeLeft = "Next Revision in " + hoursLeft + " hour";
                } else {
                    timeLeft = "Next Revision in " + hoursLeft + " hours";
                }

            } else if (diffmin > 0) {
                String minutesLeft = crunchifyFormatter.format(diffmin);
                if (diffmin == 1) {
                    timeLeft = "Next Revision in " + minutesLeft + " minute";
                } else {
                    timeLeft = "Next Revision in " + minutesLeft + " minutes";
                }
            } else {
                timeLeft = "Next Revision in 1 minute";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return timeLeft;
    }
}
