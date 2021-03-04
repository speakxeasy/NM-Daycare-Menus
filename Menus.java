import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menus {
    public static final String[] DAYS_OF_WEEK = {"Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public static String[] MEAL_REQUESTS;
    public static String[] EXCLUDED_FOODS;
    public static final String BREAKFAST = "br";
    public static final String SNACK_AM = "sa";
    public static final String LUNCH = "lu";
    public static final String SNACK_PM = "sp";
    public static final String SUPPER = "su";
    public static final String SNACK_LATE = "sl";

    //MAIN PROGRAM.
    /**
     * Main Program.
     * @param args arguments.
     * @throws FileNotFoundException fileNoteFound.
     */
    //TODO'S
    //TODO: Add Allergies File (& add list of Allergies to Private List on top // Exclude Foods)
    //TODO: Done.
    //TODO: Done.
    //TODO: Clean Code. (New Page?)
    //TODO: Work on Excel aspect...

    public static void main(String[] args) throws IOException {
        //Read from a file
        //Fruits
        File FruitsFile = new File("/Users/speak_easy/CS251/Menus" +
                "/src/Food Items/Fruits.txt");
        Scanner read = new Scanner(FruitsFile);
        List<String> Fruits = new ArrayList<>();
        while(read.hasNextLine()){
            String item = read.nextLine();
            Fruits.add(item);
        }
        read.close();

        //Proteins
        File ProteinsFile = new File("/Users/speak_easy/CS251/" +
                "Menus/src/Food Items/Proteins.txt");
        read = new Scanner(ProteinsFile);
        List<String> Proteins = new ArrayList<>();
        while(read.hasNextLine()){
            String item = read.nextLine();
            Proteins.add(item);
        }
        read.close();

        //Vegetables
        File VegetablesFile = new File("/Users/speak_easy/CS251/" +
                "Menus/src/Food Items/Vegetables.txt");
        read = new Scanner(VegetablesFile);
        List<String> Vegetables = new ArrayList<>();
        while(read.hasNextLine()){
            String item = read.nextLine();
            Vegetables.add(item);
        }
        read.close();

        //Grains
        File GrainsFile = new File("/Users/speak_easy/CS251/" +
                "Menus/src/Food Items/Grains.txt");
        read = new Scanner(GrainsFile);
        List<String> Grains = new ArrayList<>();
        while(read.hasNextLine()){
            String item = read.nextLine();
            Grains.add(item);
        }
        read.close();

        //Allergies
        File AllergiesFile = new File("/Users/speak_easy/CS251/" +
                "Menus/src/Food Items/Allergies.txt");
        read = new Scanner(AllergiesFile);
        List<String> Allergies = new ArrayList<>();
        while(read.hasNextLine()){
            String item = read.nextLine();
            Allergies.add(item);
        }
        read.close();

        //User Input
        Scanner scanner = new Scanner(System.in);
        System.out.println("~ Welcome, let's make a new menu. ~");

        //User Enters File Name
        System.out.println("Enter Excel SpreadSheet Name (without .xlsx extension)");
        String fileName = scanner.nextLine();
        fileName = fileName + ".xlsx";

        //Picks Date
        System.out.println("2. Entering Start Date");
        System.out.println("  - Month (mm): ");
        int Month = scanner.nextInt();
        System.out.println("  - Day (dd):");
        int Day = scanner.nextInt();
        String resetScanIgnore = scanner.nextLine();

        //Choose Meals (up to 3)
        boolean hideBreakfast = false;
        boolean hideSnackAM = false;
        boolean hideLunch = false;
        boolean hideSnackPM = false;
        boolean hideSupper = false;
        boolean hideSnackLate = false;

        System.out.println("3. Choose your meals (3x)");
        int optionsLeft = 3;
        MEAL_REQUESTS = new String[3];
        while(optionsLeft > 0){
            System.out.println("     ~ Options ~");
            if(!hideBreakfast){
                System.out.println("   [br] Breakfast");
            }
            if(!hideSnackAM){
                System.out.println("   [sa] Snack A.M.");
            }
            if(!hideLunch){
                System.out.println("   [lu] Lunch");
            }
            if(!hideSnackPM){
                System.out.println("   [sp] Snack P.M.");
            }
            if(!hideSupper){
                System.out.println("   [su] Supper");
            }
            if(!hideSnackLate){
                System.out.println("   [sl] Snack Late");
            }

            //Checks to see if user input is valid.
            String mealOption = scanner.nextLine().toLowerCase();
            if( (mealOption.equals(BREAKFAST) && !hideBreakfast) ||
                    (mealOption.equals(SNACK_AM) && !hideSnackAM) ||
                    (mealOption.equals(LUNCH) && !hideLunch) ||
                    (mealOption.equals(SNACK_PM) && !hideSnackPM) ||
                    (mealOption.equals(SUPPER) && !hideSupper) ||
                    (mealOption.equals(SNACK_LATE) && !hideSnackLate)){

                optionsLeft--;
                //Adds user input to mealRequests Array
                for(int i = 0; i < MEAL_REQUESTS.length; i++){
                    if(MEAL_REQUESTS[i] == null){
                        MEAL_REQUESTS[i] = mealOption;
                        break;
                    }
                }
                //Checks to see which option to get rid of in the menu.
                switch (mealOption) {
                    case BREAKFAST:
                        hideBreakfast = true;
                        break;
                    case SNACK_AM:
                        hideSnackAM = true;
                        break;
                    case LUNCH:
                        hideLunch = true;
                        break;
                    case SNACK_PM:
                        hideSnackPM = true;
                        break;
                    case SUPPER:
                        hideSupper = true;
                        break;
                    case SNACK_LATE:
                        hideSnackLate = true;
                        break;
                }

            }else{
                System.out.println("Invalid Choice");
            }
            System.out.println();
        }

        //Suspense
        try{
            System.out.print("Making new menus");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(".");
        }catch (Exception e){
            System.out.println("Couldn't make new Menus. System Timeout.");
        }

        //Convert Allergies List into String Array
        for(int i = 0; i < Allergies.size(); i++){
            EXCLUDED_FOODS[i] = Allergies.get(i);
        }

        //Makes a new week w/ 7 days.
        Day[] Week = new Day[5];
        Day Monday = new Day(Fruits, Vegetables, Proteins, Grains);
        Day Tuesday = new Day(Fruits, Vegetables, Proteins, Grains);
        Day Wednesday = new Day(Fruits, Vegetables, Proteins, Grains);
        Day Thursday = new Day(Fruits, Vegetables, Proteins, Grains);
        Day Friday = new Day(Fruits, Vegetables, Proteins, Grains);
        Week[0] = Monday;
        Week[1] = Tuesday;
        Week[2] = Wednesday;
        Week[3] = Thursday;
        Week[4] = Friday;


        //Makes meal requests for each day. Sorts through all the days of the week.
        List<String> weeklyMenuList = new ArrayList<>();
        for(Day day: Week) {
            //Responsible for checking if TODAY's menu does NOT have
            // repeating food items before continuing on to next day.
            boolean isUnique = false;
            while (!isUnique) {
                boolean madeBreakfast = false;
                boolean madeSnackAM = false;
                boolean madeLunch = false;
                boolean madeSnackPM = false;
                boolean madeSupper = false;
                boolean madeSnackLate = false;
                //Creates all the Meal Requests for a day.
                for (String mealRequest : MEAL_REQUESTS) {
                    switch (mealRequest) {
                        case BREAKFAST:
                            day.makeBreakfastMenu(EXCLUDED_FOODS);
                            madeBreakfast = true;
                            break;
                        case SNACK_AM:
                            day.makeSnackAMMenu(EXCLUDED_FOODS);
                            madeSnackAM = true;
                            break;
                        case LUNCH:
                            day.makeLunchMenu(EXCLUDED_FOODS);
                            madeLunch = true;
                            break;
                        case SNACK_PM:
                            day.makeSnackPMMenu(EXCLUDED_FOODS);
                            madeSnackPM = true;
                            break;
                        case SUPPER:
                            day.makeSupperMenu(EXCLUDED_FOODS);
                            madeSupper = true;
                            break;
                        case SNACK_LATE:
                            day.makeSnackLateMenu(EXCLUDED_FOODS);
                            madeSnackLate = true;
                            break;
                        default:
                            System.out.println("Meal Request Does Not Exist.");
                            break;
                    }
                }
                //Checks if newly created menu's are unique, else, the program
                // needs to create new ones.
                isUnique = day.isUnique();

                //if day's menu's ARE unique, then add those items to exclude
                // foods for tomorrow's menu & Add today's menu to final
                // weekly menu.
                if(isUnique){
                    day.updateExcludedFoods();
                    if(madeBreakfast){
                        weeklyMenuList.addAll(Arrays.asList(day.getBreakfast()));
                    }
                    if(madeSnackAM){
                        weeklyMenuList.addAll(Arrays.asList(day.getSnackAM()));
                    }
                    if(madeLunch){
                        weeklyMenuList.addAll(Arrays.asList(day.getLunch()));
                    }
                    if(madeSnackPM){
                        weeklyMenuList.addAll(Arrays.asList(day.getSnackPM()));
                    }
                    if(madeSupper){
                        weeklyMenuList.addAll(Arrays.asList(day.getSupper()));
                    }
                    if(madeSnackLate){
                        weeklyMenuList.addAll(Arrays.asList(day.getSnackLate()));
                    }
                }
            }
        }

        //Converting Weekly Menu to String Array
        String[] weeklyMenu = new String[weeklyMenuList.size()];
        for(int i = 0; i < weeklyMenuList.size(); i++){
            weeklyMenu[i] = weeklyMenuList.get(i);
        }

        //Prints to Excel File
        System.out.println();
        System.out.println("[x]Printing to Excel Spreadsheet");
        PrintExcelFile print = new PrintExcelFile(weeklyMenu, fileName,
                Month, Day, MEAL_REQUESTS);
    }
}
