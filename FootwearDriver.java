import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class FootwearDriver here.
 *
 * Bryan Nnadi
 * C22469126
 */
public class FootwearDriver
{
    ArrayList<Footwear> catalogue;

    public FootwearDriver()
    {
        catalogue = new ArrayList<Footwear>();

        System.out.println("\nWelcome to the menu of Fantastic Footwear");
        System.out.println("We are a footwear company based in Dublin who specialise in selling boots and trainers for men");
        System.out.println("We were founded in 2003 by Student/Designer Bryan Nnadi");
        System.out.println("Here at Fantastic Footwear Trainers we employ over 2000 staff and have 3 offices nationwide");
        System.out.println("We sell all your favorite brands such Nike, Balenciaga, Jordan, Dior and our very own exclusive brand");
        System.out.println("Here on our website we hope to offer a luxorious shopping experience, enjoy");

        mainMenu();
    }

    public static void main (String[] args )
    {
        new FootwearDriver();
    }

    public void exitMenu()
    {
        // empty method as it indicates the end to the program
    }

    /**  Create main menu option */
    public int getMainMenuOption()
    {// This lets a user select a number between 1 and 3 on the main menu
        Scanner scan = new Scanner(System.in);
        int choice;
        do
        {
            choice = scan.nextInt();
        }while(choice < 1 || choice > 3);
        return choice;
    }

    /** Create main menu */
    public void mainMenu()
    {
        
        int menuOption = 0;
        do
        {
            System.out.println("\nFantistic Footwear - Stock Control System.");
            System.out.println("==========================================");
            System.out.println("1. Customer Menu.");
            System.out.println("2. Staff Menu");
            System.out.println("3. Exit Menu.");

            System.out.println("\nPlease choose either 1, 2, or 3");

            menuOption = getMainMenuOption();
            if(menuOption == 1)//when a user selects one they are directed to the customer menu
            {
                customerMenu();
            }
            else if (menuOption == 2)//when a user selects 2 they are directed to the staff menu
            {
                staffMenu();
            }
            else if (menuOption == 3)//when a user selects 3 they are directed to exit 
            {
                System.out.print("\f");
            }
        }while(menuOption != 3);
    }

    /**  Create customer menu option */
    public int getCustomerMenuOption()
    {// This lets a user select a number between 1 and 5 on the customer menu
        Scanner scan = new Scanner(System.in);
        int choice;
        do
        {
            choice = scan.nextInt();
        }while(choice < 1 || choice > 6);
        return choice;
    }

    /**  Create customer menu */
    public void customerMenu()
    {
        System.out.print("\f");
        int menuOption = 0;
        do
        {//after each method is ran the user is brought back to menu until they choose option 5
            System.out.println("\nCustomer Menu.");
            System.out.println("=================");
            System.out.println("\n1. Trainers Catalouge");
            System.out.println("2. Boots Catalogue");
            System.out.println("3. Buy a pair of trainers");
            System.out.println("4. Buy a pair of boots");
            System.out.println("5. Search for footwear by size/price");            
            System.out.println("6. Exit to Main Menu");

            System.out.println("\nPlease choose either 1, 2, 3, 4, 5 or 6");

            menuOption = getCustomerMenuOption();

            if (menuOption == 1)
            {// if a user selects option 1 they get to see the trainers catalogue
                displayTrainers();
            }
            else if (menuOption == 2)
            {// if a user selects option 2 they get to see the boots catalogue
                displayBoots();
            }
            else if (menuOption == 3)
            {// if a user selects option 3 they can buy trainers
                buyTrainers();
            }
            else if (menuOption == 4)
            {// if a user selects option 4 they can buy boots
                buyBoots();
            }
            else if (menuOption == 5)
            {
                searchBySizeAndPrice();
            }
            else if (menuOption == 6)
            {// if a user selects option 6 they go back to main menu
                System.out.print("\f");
            }
        }while (menuOption != 6);
    }

    /**  Display trainers */
    public void displayTrainers()
    {// this method didplays the trainers catalogue
        System.out.print("\f");
        Trainers t;
        int number = 1;
        boolean trainersFound = false;
        System.out.println("\nDisplaying trainers catalogue...");
        for (Footwear f : catalogue)
        {
            if (f instanceof Trainers)
            {
                t = (Trainers) f;
                System.out.println("\nTrainers: " + number);
                System.out.print(f.toString());
                number ++;
                trainersFound = true;
            }
        }
        if (!trainersFound) 
        {// if there are none instock an error message is printed out
            System.out.println("\nThere are no trainers in stock.");
        }
    }

    /**  Display boots */
    public void displayBoots() 
    {// this method didplays the boots catalogue
        System.out.print("\f");
        Boots b;
        int number = 1;
        boolean bootsFound = false;
        System.out.println("\nDisplaying boots catalogue...");
        for (Footwear f : catalogue) 
        {
            if (f instanceof Boots) 
            {
                b = (Boots) f;
                System.out.println("\nBoots: " + number);
                System.out.print(f.toString());
                number++;
                bootsFound = true;
            }
        }
        if (!bootsFound) 
        {// if there are none instock an error message is printed out
            System.out.println("\nThere are no boots in stock.");
        }
    }

    /**  Buy trainers */
    public void buyTrainers()
    {// this methods lets a user buy trainers
        System.out.print("\f");
        boolean trainersInStock = false;
        for (Footwear f : catalogue) 
        {// first it searches to see if there are trainers in stock and if there you can proceed
            if (f instanceof Trainers && f.getStockAvailable() > 0) {
                trainersInStock = true;
                break;
            }
        }
        Trainers trainers;
        int number = 1;
        System.out.println("\nDisplaying trainers catalogue...");
        for (Footwear f : catalogue)
        {
            if (f instanceof Trainers)
            {
                trainers = (Trainers) f;
                System.out.println("\nTrainers: " + number);
                System.out.print(f.toString());
                number ++;
            }
        }
        if (!trainersInStock) 
        {// if there are none instock they are returned to main menu
            System.out.println("\nThere are no trainers in stock.");
            return;
        }

        int amount = 0;
        String trainer;
        double size, price;
        String color, description, brand; 
        boolean laces;
        boolean found = false;
        Scanner scan = new Scanner(System.in);
        int newStock;
        // the user new inputs the details of the trainer they want to buy
        System.out.println("\nPick a trainer from the catalogue above that you want to buy, make sure to include all relevant data\n");
        System.out.print("\nSize: UK");
        size = scan.nextDouble();
        scan.nextLine(); 
        while (!(size >= 5.5 && size <= 12 && size % 0.5 == 0)) 
        {// this while loop makes sure that the staff member only inputs mens shoe size and also verifies that are whole or
            //half numbers
            if (size > 12) 
            {
                System.out.println("\nWe don't sell sizes bigger than UK12, please try adding a smaller size");
            } else if (size < 5.5) 
            {
                System.out.println("\nWe only sell men's boots starting from size UK5.5, please try adding a bigger size");
            } else 
            {
                System.out.println("\nPlease enter a valid size - a whole number or half number between 5.5 and 12");
            }
            System.out.print("\nSize: UK");
            size = scan.nextDouble();
        }
        System.out.print("Brand: ");
        brand = scan.nextLine();
        System.out.print("Price: €");
        price = scan.nextDouble();
        scan.nextLine();
        System.out.print("Color: ");        
        color = scan.nextLine();
        System.out.print("Description: ");        
        description = scan.nextLine();
        while (true)
        { //this while loop makes sure that this detail is either true or false
            System.out.print("Add lace type (true/false): ");
            String laceType = scan.nextLine();
            if (laceType.equalsIgnoreCase("true")) 
            {
                laces = true;
                break;
            } else if (laceType.equalsIgnoreCase("false")) {
                laces = false;
                break;
            } 
            else 
            {
                System.out.println("Invalid input! Please enter either 'true' or 'false'");
            }
        }

        Trainers t;
        for (Footwear buy : catalogue)
        {
            if (buy instanceof Trainers)
            {
                t = (Trainers) buy;
                if (size == (buy.getSize()) && brand.equalsIgnoreCase(buy.getBrand()) && price == (buy.getPrice())
                && color.equalsIgnoreCase(buy.getColor()) && description.equalsIgnoreCase(t.getDescription())
                && laces == (t.getLaces()))
                {// if the trainer is found they can proceed to buy
                    found = true;
                    System.out.println("\nHow many pairs would you like to buy?");
                    amount = scan.nextInt();
                    if (buy.getStockAvailable() == 0)
                    {//if there are none instock anymore an error message is displayed
                        System.out.println("\nThis trainer is out of stock");
                        System.out.println("Transaction unsuccessful!");
                        System.out.println("Returning to customer menu...");
                    }
                    else if (amount <= buy.getStockAvailable() && buy.getStockAvailable() > 0)
                    {//if the amount they want to buy is lesser or equal to the amount instock they can buy them 
                        newStock = buy.getStockAvailable() - amount;
                        buy.setStockAvailable(newStock);
                        System.out.println("\nYou have just bought " + amount + " of this trainer");
                        System.out.println("Thank you for purchase");
                        System.out.println("Transaction successful!");
                        System.out.println("Returning to customer menu...");
                    }
                    else if (amount > buy.getStockAvailable())
                    {// if the user inputs an amount greater than the amount instock this error message gets displayed
                        System.out.print("\nPlease lower the amount and try again, not enough in stock!");
                    }
                }
            }
        }
        if (found==false)
        { // if the trainer doesnt exist this error is shown
            System.out.println("\nThe trainer does not exist");
        }
    }

    /**  Buy Boots */
    public void buyBoots()
    {// this methods lets a user buy boots
        System.out.print("\f");
        boolean bootsInStock = false;
        for (Footwear b : catalogue)
        {// first it searches to see if there are boots in stock and if there you can proceed
            if (b instanceof Boots && b.getStockAvailable() > 0) {
                bootsInStock = true;
                break;
            }
        }
        Boots boot;
        int number = 1;
        System.out.println("\nDisplaying boots catalogue...");
        for (Footwear f : catalogue) 
        {
            if (f instanceof Boots) 
            {
                boot = (Boots) f;
                System.out.println("\nBoots: " + number);
                System.out.print(f.toString());
                number++;
            }
        }
        if (!bootsInStock) 
        {// if there are none instock they are returned to main menu
            System.out.println("\nThere are no boots in stock.");
            return;
        }

        int amount = 0;
        String boots;
        double size, price;
        String color, brand, sport, studs; 
        boolean found = false;
        boolean bootsFound = false;
        Scanner scan = new Scanner(System.in);
        int newStock;

        System.out.println("\nPick a boot from the catalogue above that you want to buy, make sure to include all relevant data\n");
        System.out.print("\nSize: UK");
        size = scan.nextDouble();
        scan.nextLine(); 
        while (!(size >= 5.5 && size <= 12 && size % 0.5 == 0)) 
        {// this while loop makes sure that the staff member only inputs mens shoe size and also verifies that are whole or
            //half numbers
            if (size > 12) 
            {
                System.out.println("\nWe don't sell sizes bigger than UK12, please try adding a smaller size");
            } else if (size < 5.5) 
            {
                System.out.println("\nWe only sell men's boots starting from size UK5.5, please try adding a bigger size");
            } else 
            {
                System.out.println("\nPlease enter a valid size - a whole number or half number between 5.5 and 12");
            }
            System.out.print("\nSize: UK");
            size = scan.nextDouble();
        }
        System.out.print("Brand: ");
        brand = scan.nextLine();
        System.out.print("Price: €");
        price = scan.nextDouble();
        scan.nextLine(); 
        System.out.print("Color: ");        
        color = scan.nextLine();
        System.out.print("Sport (Football. Gaelic or Rugby): ");
        sport = scan.nextLine();
        do
        { //this do while states if the user doesnt choose either Football, Gaelic or Rugby they wont be able to move on 
            if(sport.equalsIgnoreCase("Football"))
            {
            }
            else if(sport.equalsIgnoreCase("Gaelic"))
            {
            }
            else if(sport.equalsIgnoreCase("Rugby"))
            {
            }
            else 
            {
                System.out.print("Sport (Football. Gaelic or Rugby): ");
                sport = scan.nextLine();
            }
        }while(!sport.equalsIgnoreCase("Football") && !sport.equalsIgnoreCase("Gaelic") && 
        !sport.equalsIgnoreCase("Rugby"));
        System.out.print("Stud type (FG = Firm ground, SG = Soft ground, AG = Artificial ground): ");
        studs = scan.nextLine();
        do
        { //this do while states if the user doesnt choose either fg, ag or sg they wont be able to move on 
            if(studs.equalsIgnoreCase("fg"))
            {
            }
            else if(studs.equalsIgnoreCase("sg"))
            {
            }
            else if(studs.equalsIgnoreCase("ag"))
            {
            }
            else 
            {
                System.out.print("Stud type (FG = Firm ground, SG = Soft ground, AG = Artificial ground): ");
                studs = scan.nextLine();
            }
        }while(!studs.equalsIgnoreCase("fg") && !studs.equalsIgnoreCase("sg") && 
        !studs.equalsIgnoreCase("ag"));

        Boots b;
        for (Footwear buy : catalogue)
        {
            if (buy instanceof Boots)
            {
                b = (Boots) buy;
                if (size == (buy.getSize()) && brand.equalsIgnoreCase(buy.getBrand()) && price == (buy.getPrice())
                && color.equalsIgnoreCase(buy.getColor()) && sport.equalsIgnoreCase(b.getSport())
                && studs.equalsIgnoreCase(b.getStuds()))
                {// if the boot is found they can proceed to buy
                    found = true;
                    System.out.println("\nHow many pairs would you like to buy?");
                    amount = scan.nextInt();
                    if (buy.getStockAvailable() == 0)
                    {//if there are none instock anymore an error message is displayed
                        System.out.println("\nThis boot is out of stock");
                        System.out.println("Transaction unsuccessful!");
                        System.out.println("Returning to customer menu...");
                    }
                    else if (amount <= buy.getStockAvailable() && buy.getStockAvailable() > 0)
                    {//if the amount they want to buy is lesser or equal to the amount instock they can buy them 
                        newStock = buy.getStockAvailable() - amount;
                        buy.setStockAvailable(newStock);
                        System.out.println("\nYou have just bought " + amount + " of this boot");
                        System.out.println("Thank you for purchase");
                        System.out.println("Transaction successful!");
                        System.out.println("Returning to customer menu...");
                    }
                    else if (amount > buy.getStockAvailable())
                    {// if the user inputs an amount greater than the amount instock this error message gets displayed
                        System.out.print("\nPlease lower the amount and try again, not enough in stock!");
                    }

                    if (found==false)
                    { // if the trainer doesnt exist this error is shown
                        System.out.println("\nThe boot does not exist");
                    }
                }
            }
        }
        if (!bootsFound) 
        {// if there are no boots instock this error is shown
            System.out.println("\nThis boot does not exist.");
        }
    }

    public void searchBySizeAndPrice() {
        System.out.print("\f");
        double minSize, maxSize, minPrice, maxPrice;

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSearch by size and/or price range");

        // Prompt the user to enter the size range
        System.out.print("\nEnter minimum size (UK): ");
        minSize = scanner.nextDouble();
        while (!(minSize >= 5.5 && minSize <= 12 && minSize % 0.5 == 0)) 
        {// this while loop makes sure that the staff member only inputs mens shoe size and also verifies that are whole or
            //half numbers
            if (minSize > 12) 
            {
                System.out.println("\nWe don't sell sizes bigger than UK12, please try adding a smaller size");
            } else if (minSize < 5.5) 
            {
                System.out.println("\nWe only sell men's trainers starting from size UK5.5, please try adding a bigger size");
            } else 
            {
                System.out.println("\nPlease enter a valid size - a whole number or half number between 5.5 and 12");
            }
            System.out.print("\nSize: UK");
            minSize = scanner.nextDouble();
        }
        System.out.print("Enter maximum size (UK): ");
        maxSize = scanner.nextDouble();
        while (!(maxSize >= 5.5 && maxSize <= 12 && maxSize % 0.5 == 0)) 
        {// this while loop makes sure that the staff member only inputs mens shoe size and also verifies that are whole or
            //half numbers
            if (maxSize > 12) 
            {
                System.out.println("\nWe don't sell sizes bigger than UK12, please try adding a smaller size");
            } else if (maxSize < 5.5) 
            {
                System.out.println("\nWe only sell men's trainers starting from size UK5.5, please try adding a bigger size");
            } else 
            {
                System.out.println("\nPlease enter a valid size - a whole number or half number between 5.5 and 12");
            }
            System.out.print("\nSize: UK");
            maxSize = scanner.nextDouble();
        }

        // Prompt the user to enter the price range
        System.out.print("\nEnter minimum price (€): ");
        minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price (€): ");
        maxPrice = scanner.nextDouble();

        // Search for footwear matching the size and price range
        boolean found = false;
        System.out.println("\nResults:");
        for (Footwear f : catalogue) {
            if ((f instanceof Trainers || f instanceof Boots)
            && f.getSize() >= minSize && f.getSize() <= maxSize
            && f.getPrice() >= minPrice && f.getPrice() <= maxPrice) {
                System.out.println(f.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo results found.");
        }
    }

    /**  Create staff menu option */
    public int getStaffMenuOption()
    { // This lets a user select a number between 1 and 4 on the staff menu
        Scanner scan = new Scanner(System.in);
        int choice;
        do
        {
            choice = scan.nextInt();
        }while(choice < 1 || choice > 4);
        return choice;
    }

    /**  Create staff menu */
    public void staffMenu()
    {
        System.out.print("\f");
        // Prompt user for password
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter password to access Staff Menu:");
        String password;

        System.out.print("Password:");
        password = scanner.nextLine();

        // Check if password is correct
        if (!password.equals("mypassword")) {
            System.out.println("\nIncorrect password. Access denied.");

        }
        else
        {

            int menuOption = 0;
            do
            {
                System.out.println("\nStaff Menu.");
                System.out.println("=================");
                System.out.println("1. Add a pair of trainers to the catalogue");
                System.out.println("2. Add a  pair of boots to the catalogue");
                System.out.println("3. Update the stock level for an existing table or chair with a new delivery");
                System.out.println("4. Exit Staff menu");

                System.out.println("\nPlease choose either 1, 2, 3 or 4");

                menuOption = getStaffMenuOption();

                if (menuOption == 1)
                {// if a staff memeber selects option 1 they can add a trainer to the list
                    addTrainer();
                }
                else if (menuOption == 2)
                {// if a staff memeber selects option 2 they can add a boot to the list
                    addBoots();
                }
                else if (menuOption == 3)
                {// if a staff memeber selects option 3 they can update stock
                    updateStock();
                }
                else if (menuOption == 4)
                {// if a staff memeber selects option 4 they go back to the main menu
                    System.out.print("\f");
                    System.out.print("Thank you to all staff and customers for using our new system, come back soon!");
                }
            }while (menuOption != 4);
        }
    }

    /**  Add trainers */
    public void addTrainer()
    {
        System.out.print("\f");
        double price, size;
        String brand, color, description;
        int stockAvailable = 0;
        boolean laces = true;

        Footwear trainer1;

        Scanner scan = new Scanner(System.in);

        System.out.print("\nCreating trainers for the catalogue...");
        //input the details of the trainer
        System.out.println("\nChoose a size, brand, price, color, amount, description, lace type: ");
        System.out.print("\nAdd size: UK");
        size = scan.nextDouble();
        scan.nextLine();
        while (!(size >= 5.5 && size <= 12 && size % 0.5 == 0)) 
        {// this while loop makes sure that the staff member only inputs mens shoe size and also verifies that are whole or
            //half numbers
            if (size > 12) 
            {
                System.out.println("\nWe don't sell sizes bigger than UK12, please try adding a smaller size");
            } else if (size < 5.5) 
            {
                System.out.println("\nWe only sell men's trainers starting from size UK5.5, please try adding a bigger size");
            } else 
            {
                System.out.println("\nPlease enter a valid size - a whole number or half number between 5.5 and 12");
            }
            System.out.print("\nSize: UK");
            size = scan.nextDouble();
            scan.nextLine();
        }
        System.out.print("Add brand (Real brand or make up your own): ");
        brand = scan.nextLine();
        System.out.print("Add price: €");
        price = scan.nextDouble();
        scan.nextLine();
        System.out.print("Add color: ");
        color = scan.nextLine();
        System.out.print("Add stock: ");
        stockAvailable = scan.nextInt();
        scan.nextLine();
        System.out.print("Add description e.g casual, skating, luxury...: ");
        description = scan.nextLine();
        while (true)
        { //this while loop makes sure that this detail is either true or false
            System.out.print("Add lace type (true/false): ");
            String laceType = scan.nextLine();
            if (laceType.equalsIgnoreCase("true")) 
            {
                laces = true;
                break;
            } else if (laceType.equalsIgnoreCase("false")) {
                laces = false;
                break;
            } 
            else 
            {
                System.out.println("Invalid input! Please enter either 'true' or 'false'");
            }
        }
        
        System.out.println("\nThe trainer has been successfully added");
        //this adds the trainer to the arraylist (catalogue)
        trainer1 = new Trainers (size, brand, price, color, stockAvailable, description, laces);
        catalogue.add(trainer1);
    }

    /**  Add Boots */
    public void addBoots()
    {
        System.out.print("\f");
        double size, price;
        String brand, color, sport, studs;
        int stockAvailable = 0; 

        Footwear boot1;

        Scanner scan = new Scanner(System.in);

        System.out.print("\nCreating boots for the catalogue...\n");
        //input the details of the trainer
        System.out.println("\nChoose a size, brand, price, color, stockAvailable, sport, studs: ");
        System.out.print("Add size: UK");
        size = scan.nextDouble();
        scan.nextLine();
        while (!(size >= 5.5 && size <= 12 && size % 0.5 == 0)) 
        {// this while loop makes sure that the staff member only inputs mens shoe size and also verifies that are whole or
            //half numbers
            if (size > 12) 
            {
                System.out.println("\nWe don't sell sizes bigger than UK12, please try adding a smaller size");
            } else if (size < 5.5) 
            {
                System.out.println("\nWe only sell men's boots starting from size UK5.5, please try adding a bigger size");
            } else 
            {
                System.out.println("\nPlease enter a valid size - a whole number or half number between 5.5 and 12");
            }
            System.out.print("\nSize: UK");
            size = scan.nextDouble();
            scan.nextLine();
        }
        System.out.print("Add brand (Real brand or make up your own): ");
        brand = scan.nextLine();
        System.out.print("Add price: €");
        price = scan.nextDouble();
        scan.nextLine();
        System.out.print("Add color: ");
        color = scan.nextLine();
        System.out.print("Add stock: ");
        stockAvailable = scan.nextInt();
        scan.nextLine();
        System.out.print("Add sport (Football, Gaelic or Rugby): ");
        sport = scan.nextLine();
        do
        { //this do while states if the user doesnt choose either Football, Gaelic or Rugby they wont be able to move on 
            if(sport.equalsIgnoreCase("Football"))
            {
            }
            else if(sport.equalsIgnoreCase("Gaelic"))
            {
            }
            else if(sport.equalsIgnoreCase("Rugby"))
            {
            }
            else 
            {
                System.out.print("Sport (Football. Gaelic or Rugby): ");
                sport = scan.nextLine();
            }
        }while(!sport.equalsIgnoreCase("Football") && !sport.equalsIgnoreCase("Gaelic") && 
        !sport.equalsIgnoreCase("Rugby"));
        System.out.print("Stud type (FG = Firm ground, SG = Soft ground, AG = Artificial ground): ");
        studs = scan.nextLine();
        do
        { //this do while states if the user doesnt choose either fg, ag or sg they wont be able to move on 
            if(studs.equalsIgnoreCase("fg"))
            {
            }
            else if(studs.equalsIgnoreCase("sg"))
            {
            }
            else if(studs.equalsIgnoreCase("ag"))
            {
            }
            else 
            {
                System.out.print("Stud type (FG = Firm ground, SG = Soft ground, AG = Artificial ground): ");
                studs = scan.nextLine();
            }
        }while(!studs.equalsIgnoreCase("fg") && !studs.equalsIgnoreCase("sg") && 
        !studs.equalsIgnoreCase("ag"));
        
        System.out.println("\nThe boot has been successfully added");
        //this adds the boot to the arraylist (catalogue)
        boot1 = new Boots (size, brand, price, color, stockAvailable, sport, studs);
        catalogue.add(boot1);
    }

    /**  Update stock */
    public void updateStock()
    {
        System.out.print("\f");
        Scanner scan = new Scanner(System.in);
        String footwear;
        double size, price;
        String color, description, brand, sport, studs; 
        int stockAvailable;
        boolean laces;
        boolean found = false;
        int newStockAvailable;
        int additionalStock;
        int updatedStock;
        //user is asked to choose if they want to update the stock of a boot or trainer
        System.out.println("\nPlease choose which item you would like to update Trainers or Boots ");
        footwear = scan.nextLine();
        //if you type trainers then...
        if(footwear.equalsIgnoreCase("Trainers"))
        {// display trainers
            Trainers t;
            int number = 1;
            System.out.println("\nDisplaying trainers catalogue...");
            for (Footwear f : catalogue)
            {
                if (f instanceof Trainers)
                {
                    t = (Trainers) f;
                    System.out.println("\nTrainer" + number);
                    System.out.print(f.toString());
                    number ++;
                }
            }
            System.out.println
            ("\nChoose the trainer you would like to update(include the size, brand, price, color, desciprion, laces)");
            System.out.print("\nSize: UK");
            size = scan.nextDouble();
            scan.nextLine();
            while (!(size >= 5.5 && size <= 12 && size % 0.5 == 0)) 
            {// this while loop makes sure that the staff member only inputs mens shoe size and also verifies that are whole or
                //half numbers
                if (size > 12) 
                {
                    System.out.println("\nWe don't sell sizes bigger than UK12, please try adding a smaller size");
                } else if (size < 5.5) 
                {
                    System.out.println("\nWe only sell men's trainers starting from size UK5.5, please try adding a bigger size");
                } else 
                {
                    System.out.println("\nPlease enter a valid size - a whole number or half number between 5.5 and 12");
                }
                System.out.print("\nSize: UK");
                size = scan.nextDouble();
                scan.nextLine();
            }
            System.out.print("Brand: ");
            brand = scan.nextLine();
            System.out.print("Price: €");
            price = scan.nextDouble();
            scan.nextLine();
            System.out.print("Color: ");
            color = scan.nextLine();
            System.out.print("Description: ");
            description = scan.nextLine();
            while (true)
            { //this while loop makes sure that this detail is either true or false
                System.out.print("Lace type (true/false): ");
                String laceType = scan.nextLine();
                if (laceType.equalsIgnoreCase("true")) 
                {
                    laces = true;
                    break;
                } else if (laceType.equalsIgnoreCase("false")) {
                    laces = false;
                    break;
                } 
                else 
                {
                    System.out.println("Invalid input! Please enter either 'true' or 'false'");
                }
            }

            for (Footwear f : catalogue) 
            {//search for the trainer you want to update and if it exists then...
                if (f instanceof Trainers) 
                {
                    t = (Trainers) f;
                    if (size == (f.getSize()) && brand.equalsIgnoreCase(f.getBrand()) && price == (f.getPrice())
                    && color.equalsIgnoreCase(f.getColor()) && description.equalsIgnoreCase(t.getDescription())
                    && laces == (t.getLaces())) 
                    { // input amount that you want to update 
                        found = true;
                        System.out.println("\nHow much new stock has been delivered: ");
                        additionalStock = scan.nextInt();
                        updatedStock = additionalStock + f.getStockAvailable();
                        f.setStockAvailable(updatedStock);
                        System.out.println("\nStock has been updated successfully!");
                    }
                }
            }
            if(!found)
            {
                System.out.println("\nTrainer not found!");
                System.out.println("\nReturning to staff menu...");
            }
        }
        else if(footwear.equalsIgnoreCase("Boots"))
        {
            Boots b;
            int number = 1;
            System.out.println("\nDisplaying boots catalogue...");
            for (Footwear f : catalogue)
            {
                if (f instanceof Trainers)
                {
                    b = (Boots) f;
                    System.out.println("\nBoots: " + number);
                    System.out.print(f.toString());
                    number ++;
                }
            }
            System.out.println
            ("\nChoose the boot you would like to update(include the size, brand, price, color, sport, studs)");
            System.out.print("\nSize: UK");
            size = scan.nextDouble();
            scan.nextLine();
            while (!(size >= 5.5 && size <= 12 && size % 0.5 == 0)) 
            {// this while loop makes sure that the staff member only inputs mens shoe size and also verifies that are whole or
                //half numbers
                if (size > 12) 
                {
                    System.out.println("\nWe don't sell sizes bigger than UK12, please try adding a smaller size");
                } else if (size < 5.5) 
                {
                    System.out.println("\nWe only sell men's boots starting from size UK5.5, please try adding a bigger size");
                } else 
                {
                    System.out.println("\nPlease enter a valid size - a whole number or half number between 5.5 and 12");
                }
                System.out.print("\nSize: UK");
                size = scan.nextDouble();
                scan.nextLine();
            }
            System.out.print("Brand: ");
            brand = scan.nextLine();
            System.out.print("Price: €");
            price = scan.nextDouble();
            scan.nextLine();
            System.out.print("Color: ");
            color = scan.nextLine();
            System.out.print("Sport: ");
            sport = scan.nextLine();
            do
            { //this do while states if the user doesnt choose either Football, Gaelic or Rugby they wont be able to move on 
                if(sport.equalsIgnoreCase("Football"))
                {
                }
                else if(sport.equalsIgnoreCase("Gaelic"))
                {
                }
                else if(sport.equalsIgnoreCase("Rugby"))
                {
                }
                else 
                {
                    System.out.print("Sport: ");
                    sport = scan.nextLine();
                }
            }while(!sport.equalsIgnoreCase("Football") && !sport.equalsIgnoreCase("Gaelic") && 
            !sport.equalsIgnoreCase("Rugby"));
            System.out.print("Stud type: ");
            studs = scan.nextLine();
            do
            { //this do while states if the user doesnt choose either fg, ag or sg they wont be able to move on 
                if(studs.equalsIgnoreCase("fg"))
                {
                }
                else if(studs.equalsIgnoreCase("sg"))
                {
                }
                else if(studs.equalsIgnoreCase("ag"))
                {
                }
                else 
                {
                    System.out.print("Stud type (FG = Firm ground, SG = Soft ground, AG = Artificial ground): ");
                    studs = scan.nextLine();
                }
            }while(!studs.equalsIgnoreCase("fg") && !studs.equalsIgnoreCase("sg") && 
            !studs.equalsIgnoreCase("ag"));
            for (Footwear f : catalogue) 
            {
                if (f instanceof Boots) 
                {
                    b = (Boots) f;
                    if (size == (f.getSize()) && brand.equalsIgnoreCase(f.getBrand()) && price == (f.getPrice())
                    && color.equalsIgnoreCase(f.getColor()) && sport.equalsIgnoreCase(b.getSport())
                    && studs.equalsIgnoreCase(b.getStuds())) 
                    {
                        found = true;
                        System.out.println("\nHow much new stock has been delivered: ");
                        additionalStock = scan.nextInt();
                        updatedStock = additionalStock + f.getStockAvailable();
                        f.setStockAvailable(updatedStock);
                        System.out.println("\nThere are now " + f.getStockAvailable() + " in stock");
                        System.out.println("\nStock has been updated successfully!");
                        System.out.println("\nReturning to staff menu...");
                    }
                }
            }
            if(!found)
            {
                System.out.println("\nBoots not found!");
                System.out.println("\nReturning to staff menu...");
            }
        }
        else if (!footwear.equalsIgnoreCase("Boots") && !footwear.equalsIgnoreCase("Trainers"))
        {
            System.out.println("\nPlease choose a valid product");
            System.out.println("\nReturning to staff menu...");
        }
    }
}

