import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            String filepath = "./so70824574/input.txt";

            //Generate data
            String[] data = {"2021-12-12/08-22-12", "Cert1"};
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            for(String j: data) {
                dataOutputStream.writeUTF(j);
            }
            dataOutputStream.flush();

            //Import data
            DataInputStream read = new DataInputStream(new FileInputStream(filepath));
            DateTimeFormatter format_day = DateTimeFormatter.ofPattern("uuuu/MM/dd");
            DateTimeFormatter format_hour = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalDate now_day = LocalDate.now();
            LocalDateTime now_hour = LocalDateTime.now();
            ArrayList<String> dates = new ArrayList<>();
            ArrayList<String> expire_in_week = new ArrayList<>();
            ArrayList<String> expire_tomorrow = new ArrayList<>();
            ArrayList<String> expire_today = new ArrayList<>();
            ArrayList<String> expired = new ArrayList<>();
            while (read.available() > 0) {
                String date = read.readUTF();
                String cert_num = read.readUTF();
                dates.add(date);
                for (String s : dates) {
                    String[] inputData = s.split("/");

                    String days = inputData[0];
                    LocalDate date_days = LocalDate.parse(days.replace("-", "/"), format_day);

                    String hours = inputData[1];
                    LocalTime date_hours = LocalTime.parse(hours.replace("-", ":"), format_hour);
                    LocalDateTime offsetTime = LocalDateTime.of(date_days, date_hours);

                    long daysbetween = ChronoUnit.DAYS.between(now_day, date_days);
                    long hoursbetween = ChronoUnit.HOURS.between(now_hour, offsetTime);
                    if (daysbetween == 7) {
                        expire_in_week.add(cert_num);
                    } else if (daysbetween == 1) {
                        expire_tomorrow.add(cert_num);
                    } else if (daysbetween == 0 && hoursbetween > 0) {
                        expire_today.add(cert_num);
                    } else if (daysbetween < 0 || (daysbetween == 0 && hoursbetween < 0)) {
                        expired.add(cert_num);
                    } else {
                    }


                }
            }

            System.out.println("Certificates that expires:");
            System.out.println("Next week");
            for (String w : expire_in_week) {
                System.out.print(w + "|");
            }
            System.out.println("Tomorrow");
            for (String tm : expire_tomorrow) {
                System.out.print(tm + "|");
            }
            System.out.println("Today");
            for (String td : expire_today) {
                System.out.print(td + "|");
            }
            System.out.println("Today");
            for (String ex : expired) {
                System.out.print(ex + "|");
            }


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}