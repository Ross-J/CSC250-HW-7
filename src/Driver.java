import java.net.URL;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Scanner;

public class Driver
{
	public static void main(String[] args)
	{
		URLReader hearthstoneURLReader = new URLReader("https://api.hearthstonejson.com/v1/25770/enUS/cards.json");
		
		Object obj = JSONValue.parse(hearthstoneURLReader.gettheURLContents());
		
		HearthstoneCard[] theMinions = new HearthstoneCard[5217];
		
		if(obj instanceof JSONArray)
		{
			JSONArray array = (JSONArray)obj;

			int count = 0;
			
			for(int i = 0; i < array.size(); i++)
			{
				JSONObject cardData = (JSONObject)array.get(i);
				
		    	if(cardData.containsKey("cost") && cardData.containsKey("name"))
		    	{
		    		if(cardData.containsKey("type") && cardData.get("type").equals("MINION"))
		    		{
			    		count++;
			    		Object name = cardData.get("name");
			    		Object cost = cardData.get("cost");
			    		Object attack = cardData.get("attack");
			    		Object health = cardData.get("health");
			    		HearthstoneCard card = new HearthstoneCard(name, cost, attack, health);
			    		theMinions[i] = card;
			    		theMinions[i].display();
		    		}
		    	}
			}
			System.out.println(count);
		}
	}
}
