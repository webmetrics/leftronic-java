package biz.neustar.leftronic;

import java.io.IOException;

import org.junit.Test;

public class LeftronicIT {
	
	@Test
	public void testImageUrl() throws LeftronicException, IOException{
		LeftronicClient client = new LeftronicClient("Your API key", 5);
		client.sendText("Favicon_Position0", "title", "message", "http://www.reddit.com/favicon.ico");
		
	}

}
