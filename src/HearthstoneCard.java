
public class HearthstoneCard 
{
	private Object name;
	private Object cost;
	private Object attack;
	private Object defense;
	
	
	public HearthstoneCard(Object name, Object cost, Object attack, Object defense)
	{
		this.cost = cost;
		this.attack = attack;
		this.defense = defense;
		this.name = name;
	}
	
	
	public void setName(String name)
	{
		if(name.length() >= 5)
		{
			this.name = name;
		}
	}
	
	
	void display()
	{
		System.out.format("Name: %s \nCost: %d \nAttack: %d \nDefense: %d \n", this.name, this.cost, this.attack, this.defense);
	}
}
