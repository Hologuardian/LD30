package holo.src.item;


public class Inventory
{
	public Item[] itemList;
	public int maxItems;
	public int selectedItem = 0;
	
	public Inventory(int max)
	{
		maxItems = max;
		itemList = new Item[maxItems];
	}
	
	public void selectItem(int slot)
	{
		if(slot >= 0 && slot < itemList.length)
			selectedItem = slot;
	}
	
	public Item getSelectedItem()
	{
		return itemList[selectedItem];
	}
	
	public void addItem(Item item)
	{
		if(this.getFreeSlot() != -1)
			itemList[this.getFreeSlot()] = item;
	}
	
	public Item removeItem(Item item)
	{
		for(int i = 0; i < itemList.length; ++i)
		{
			if(itemList[i] == item)
			{
				itemList[i] = null;
				return item;
			}
		}
		
		return null;
	}
	
	public int getFreeSlot()
	{
		for(int i = 0; i < itemList.length; ++i)
		{
			if(itemList[i] == null)
				return i;
		}
		
		return -1;
	}
}
