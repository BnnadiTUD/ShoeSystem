/**
 *
 * Bryan Nnadi
 * C22469126
 */
public class Trainers extends Footwear 
{
    public String description;
    public boolean laces;
    
    public Trainers()
    {
        super();
        this.description = " ";
        this.laces = true;
    }
    
    public Trainers(double size, String brand, double price, String color, int stockAvailable, String description, boolean laces)
    {
        super(size, brand, price, color, stockAvailable);
        this.description = description;
        this.laces = laces;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    
    public boolean getLaces()
    {
        return this.laces;   
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public void setLaces(boolean laces)
    {
        this.laces = laces;
    }
    
    public boolean hasLaces()
    {
        boolean laces;
        if (this.laces==true)
        {
            laces = true; 
        }
        else
        {
         laces = false;  
        }
        return laces;
    }
    
    public String toString()
    {
        String result = " ";
        
        result = super.toString() + " " +
        "\nDescription: " + this.description;
        if (this.laces==true)
        {
            result = result + "\nLaces\n";
        }
        else if (this.laces==false)
        {
            result = result + "\nLaceless\n";
        }
        return result;
    }
}
