package nl.openvalue.samples.designpatterns;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public class DecoratorPattern {
	
	public static class Message {
		private String content;
		public Message(String content) {
			this.content = content;
		}
		
		public String getContent() { 
			return this.content; 
		}
		
		public void setContent(String content) { 
			this.content = content; 
		}
	}
	
	public static interface MessageDecorator {
		
		String decorate(String content);	
	}
	
	public static class LineNumberDecorator implements MessageDecorator {
		
		@Override
		public String decorate(String content) {
			String[] lines = content.split("\n");
			List<String> decoratedLines = new LinkedList<>();
			for (int i = 0; i < lines.length; i++) {
				// Voorbeeld: 
				//	1|Hallo
				//	2|Daar
				decoratedLines.add(String.format("%d|%s", i+1, lines[i]));
			}
			return String.join("\n", decoratedLines);
		}
		
	}
	
	public static class MessageWriter {
		
		private OutputStream outputStream;
		
		private MessageDecorator decorator;
		
		public MessageWriter(OutputStream outputStream) {
			this.outputStream = outputStream;
		}
		
		public void setDecorator(MessageDecorator decorator) {
			this.decorator = decorator;
		}
		
		public void write(Message message) throws IOException {
			byte[] content;
			if (decorator != null) {
				content = decorator.decorate(message.getContent()).getBytes();
			} else {
				content = message.getContent().getBytes();
			}
			outputStream.write(content);
		}
		
	}
	
	
	public static void main(String[] args) {
		MessageWriter writer = new MessageWriter(System.out);
//		writer.setDecorator(new LineNumberDecorator());
		try {
			writer.write(new Message("Hallo\nDaar!"));
		} catch (IOException e) { /* do nothing */ }
	}
	

}
