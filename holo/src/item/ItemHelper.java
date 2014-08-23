package holo.src.item;

import holo.src.entity.EntityBasicArrow;


public class ItemHelper
{
	public static ItemSword basicSword = new ItemSword(new String[]{"res/textures/item/BasicSword.png", "res/textures/item/BasicSwordBlur.png"}, 11, 90, 100, 2);
	public static ItemBow basicBow = new ItemBow(new String[]{"res/textures/item/BasicBow.png", "res/textures/item/BasicBowNoArrow.png"}, EntityBasicArrow.class, 550);
}
