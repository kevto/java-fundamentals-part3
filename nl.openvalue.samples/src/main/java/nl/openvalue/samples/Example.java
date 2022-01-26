package nl.openvalue.samples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example {
    public static class Queue {

        private List<Message> messages = new ArrayList<>();

        public Message newMessage(String content) {
            Message m = new Message(content);
            messages.add(m);
            return m;
        }

        public List<Message> getMessages() {
            List<Message> cloned = new ArrayList<>();
            cloned.addAll(messages);
            return cloned;
        }

        public int size() {
            return messages.size();
        }

        public static class Message {
            private String content;
            public Message(String content) {
                this.content = content;
            }
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        Queue.Message m1 = q.newMessage("m1");
        System.out.println("Size:" + q.size());

        List<Queue.Message> cloned = q.getMessages();
        cloned.add(new Queue.Message("m2"));
        System.out.println("Size:" + q.size());
        System.out.println("Cloned size:" + cloned.size());
    }
}
