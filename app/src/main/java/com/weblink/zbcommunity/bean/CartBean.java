package com.weblink.zbcommunity.bean;

public class CartBean
{

	public int id;

	public  String img_shop;

	public  String img_thing;

	public String getImg_shop() {
		return img_shop;
	}

	public void setImg_shop(String img_shop) {
		this.img_shop = img_shop;
	}

	public String getImg_thing() {
		return img_thing;
	}

	public void setImg_thing(String img_thing) {
		this.img_thing = img_thing;
	}

	public  int carNum;

	public  String shopName;

	public  String content;

	public  float price;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getCarNum()
	{
		return carNum;
	}

	public void setCarNum(int carNum)
	{
		this.carNum = carNum;
	}

	public String getShopName()
	{
		return shopName;
	}

	public void setShopName(String shopName)
	{
		this.shopName = shopName;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

}
