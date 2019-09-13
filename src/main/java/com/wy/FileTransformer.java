package com.wy;

import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileTransformer {
    @Transformer
    public Message<List<String>> splitToLines(Message<File> message) {
        List<String> list = new ArrayList<String>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader((message.getPayload())));
            String line = bufferedReader.readLine();
            for (int i=0; i < 900 && line != null; i++) {
                list.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MessageBuilder.withPayload(list).build();
    }

    @Transformer
    public Message<?> translateToTransaction(Message<String> message) {
        return MessageBuilder.withPayload(Csv2TransactionUtil.createtrans(message.getPayload())).build();
    }
}
