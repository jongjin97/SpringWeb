package shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;

//    public void setType(MessageType type) {
//        this.type = type;
//    }
}
