package com.telusko.controller;

import com.telusko.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    //creating dynamic topics with SimpMessagingTemplates
    private final SimpMessagingTemplate simpMessagingTemplate;

    public ChatController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }


    //creating a method that receives the data for chatroom and
    // then it sends the message to the chatroom topic

    //whenever user sends  the message to /message , then we will get message to this particular method
    //whenever this method receives the message, then it sends the message to a particular topic

    @MessageMapping("/message")  //app/message(as /app is the ApplicationDestinationPrefix)
    @SendTo("/chatroom/public")   //(a user needs to listen to this topic , to receive messages)
    public Message recievePublicMessage(@Payload Message message)
    {
        return message;
    }


    //creating a private message method
    @MessageMapping("/private-message")
    @SendTo()
    public Message receivePrivateMessage(@Payload Message message){

        //this method will automatically read out user destination prefix which is /user in our project.
        // and the topic will be /user/ReceiverName/private
        //the receiver name is dynamic here.
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);

        return message;


    }






}
