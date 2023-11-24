/**
 *
 * Bryan Nnadi
 * C22469126
 */
public class Footwear
{
    public double size;
    public String brand;
    public double price;
    public String color;
    public int stockAvailable;
    
    public Footwear()
    {
        this.size = 0;
        this.brand = " ";
        this.price = 0;
        this.color = " ";
        this.stockAvailable = 0;
    }
    
    public Footwear(double size, String brand, double price, String color, int stockAvailable)
    {
        this.size = size;
        this.brand = brand ;
        this.price = price;
        this.color = color;
        this.stockAvailable = stockAvailable;
    }
    
    public double getSize()
    {
        return this.size;
    }
    
    public String getBrand()
    {
        return this.brand;
    }
    
    public double getPrice()
    {
        return this.price;
    }
    
    public String getColor()
    {
        return this.color;
    }
    
    public int getStockAvailable()
    {
        return this.stockAvailable;
    }
    
    public void setSize(double size)
    {
        this.size = size;
    }
    
    public void setBrand(String brand)
    {
        this.brand = brand;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public void setColor(String color)
    {
        this.color = color;
    }
    
    public void setStockAvailable(int stock)
    {
        this.stockAvailable = stock;
    }

    
    public String toString()
    {
        return "\nSize: " + this.size + " " +
               "\nBrand: " + this.brand + " " +
               "\nPrice: " + this.price + " " +
               "\nColor: " + this.color + " " +
               "\nStock Available: " + ;this.stockAvailable
    }
}

package Week1;

public class Accont {

	public String name;
	public String address;
	public double balance;

	public Accont()
	{
		this.name = " ";
		this.address = " ";
		this.balance = 0;
	}
	
	public Accont(String name, String address, double balance)
	{
		this.name = name;
		this.address = address;
		this.balance = 0;		
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	public String toString()
    {
        return "\nName: " + this.name + " " +
               "\nAddress: " + this.address + " " +
               "\nBalance: €" + this.balance + " ";
    }
}
