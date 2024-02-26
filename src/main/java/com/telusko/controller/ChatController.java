package com.telusko.controller;

import com.telusko.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {


    //creating a method that receives the data for chatroom and
    // then it sends the message to the chatroom topic

    //whenever user sends  the message to /message , then we will get message to this particular method
    //whenever th is method receives the message, then it sends the message to a particular topic

    @MessageMapping("/message")  //app/message(as /app is the ApplicationDestinationPrefix)
    @SendTo("/chatroom/public")   //(a user needs to listen to this topic , to receive messages)
    public Message recievePublicMessage(@Payload Message message) {
        return message;
    }




}
