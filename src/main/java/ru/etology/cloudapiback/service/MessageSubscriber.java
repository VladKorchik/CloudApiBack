package ru.etology.cloudapiback.service;

import antlr.debug.MessageEvent;
import antlr.debug.MessageListener;
import antlr.debug.TraceEvent;
import org.springframework.data.redis.connection.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageSubscriber implements MessageListener {
    public static List<String> messageList = new ArrayList<String>();
    public void onMessage(final Message message, final byte[] pattern) {
        messageList.add(message.toString());
        System.out.println("Message received: " + new String(message.getBody()));
    }

    @Override
    public void reportError(MessageEvent messageEvent) {

    }

    @Override
    public void reportWarning(MessageEvent messageEvent) {

    }

    @Override
    public void doneParsing(TraceEvent traceEvent) {

    }

    @Override
    public void refresh() {

    }
}