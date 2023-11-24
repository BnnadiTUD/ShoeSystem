
/**
 *
 * Bryan Nnadi
 * C22469126
 */
public class Boots extends Footwear
{
    public String sport;
    public String studs;
    
    public Boots()
    {
        super();
        this.sport = " ";
        this.studs = " ";
    }
    
    public Boots(double size, String brand, double price, String color, int stockAvailable, String sport, String studs)
    {
        super(size, brand, price, color, stockAvailable);
        this.sport = sport;
        this.studs = studs;
    }
    
    public String getSport()
    {
        return this.sport;
    }
    
    public String getStuds()
    {
        return this.studs;
    }
    
    public void setSport(String sport)
    {
        this.sport = sport;
    }
    
    public void setStuds(String sport)
    {
        this.studs = studs;
    }
    
    public String toString()
    {
        String result = " ";
        
        result = super.toString() + " " +
                 "\nSport: " + this.sport + " " +
                 "\nStuds: " + this.studs;
        
        return result;
    }
}