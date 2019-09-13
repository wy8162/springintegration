package com.wy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Csv2TransactionUtil {
    public final static DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    public static PaymentTransaction createtrans(String line) {
        String[] fields = line.split(",");
        PaymentTransaction trans = new PaymentTransaction();
        trans.setTransNumber(fields[0]);
        try {
            trans.setTimestamp(df.parse(fields[1]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        trans.setSrcAccount(fields[2]);
        trans.setSrcRouting(fields[3]);
        trans.setDstAccount(fields[4]);
        trans.setDstRouting(fields[5]);
        trans.setAmount(Float.parseFloat(fields[6]));
        return trans;
    }
}
