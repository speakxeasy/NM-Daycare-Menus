import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Day Object holds 3 meals. Meals are strings derived from the various food
 *  reading files. Lunch and Supper grains are different from the rest of the
 *  grains (breakfast, snackAM, snackPM, snackLate). The lunch and supper
 *  grains are "bulkier" than the rest. For example
 */
public class Day {
    private List<String> FRUITS;
    private List<String> PROTEINS;
    private List<String> VEGETABLES;
    private List<String> GRAINS;
    private String[] BREAKFAST_MENU;
    private String[] SNACK_AM_MENU;
    private String[] LUNCH_MENU;
    private String[] SNACK_PM_MENU;
    private String[] SUPPER_MENU;
    private String[] SNACK_LATE_MENU;

    /**
     * Day Object. 5 Days per week. Each Day holds 3 meals (may change based on user.)
     */
    public Day(List<String> fruits, List<String> vegetables, List<String> proteins, List<String> grains){
        this.FRUITS = fruits;
        this.VEGETABLES = vegetables;
        this.PROTEINS = proteins;
        this.GRAINS = grains;
    }

    //SETTERS
    /**
     * Makes a new breakfast meal. Breakfast consists of:
     *   1. Fruits
     *   2. Grains
     */
    public void makeBreakfastMenu(String[] excludeFoods){
        //Breakfast Menu
        String[] breakfast = new String[2];

        //NEW IDEA
        boolean needsRepeat = true;
        while(needsRepeat){
            needsRepeat = false;

            //Random Fruits Index + Item
            int randIndex = (int) (Math.random() * FRUITS.size());
            breakfast[0] = FRUITS.get(randIndex);

            //Random Grains Index + Item
            randIndex = (int) (Math.random() * GRAINS.size());
            breakfast[1] = GRAINS.get(randIndex);

            //Checks if breakfast menu does NOT include excluded foods. If it
            // does, then it re-creates a new breakfast menu.
            if(excludeFoods != null){
                for(String bannedFoodItem : excludeFoods){
                    if(bannedFoodItem.equals(breakfast[0]) ||
                            bannedFoodItem.equals(breakfast[1])){
                        needsRepeat = true;
                        break;
                    }
                }
            }
        }

        //Return Random Food Items
        BREAKFAST_MENU = breakfast;
    }

    /**
     * Makes a new snackAM meal. SnackAM consists of:
     *   1. Vegetables
     *   2. Grains
     *   3. Proteins
     */
    public void makeSnackAMMenu(String[] excludeFoods){
        //SnackAM Menu
        String[] snackAM = new String[3];

        //NEW IDEA
        boolean needsRepeat = true;
        while(needsRepeat){
            needsRepeat = false;

            //Random Vegetables Index + Item
            //int randIndex = (int) (Math.random() * VEGETABLES.size());
            snackAM[0] = VEGETABLES.get((int) (Math.random() * VEGETABLES.size()));

            //Random Grains Index + Item
            //randIndex = (int) (Math.random() * GRAINS.size());
            snackAM[1] = GRAINS.get((int) (Math.random() * GRAINS.size()));

            //Random Proteins Index + Item
            //randIndex = (int) (Math.random() * PROTEINS.size());
            snackAM[2] = PROTEINS.get((int) (Math.random() * PROTEINS.size()));

            //NEW IDEA
            if(excludeFoods != null){
                for(String bannedFoodItem : excludeFoods){
                    if(bannedFoodItem.equals(snackAM[0]) ||
                            bannedFoodItem.equals(snackAM[1]) ||
                            bannedFoodItem.equals(snackAM[2])){
                        needsRepeat = true;
                        break;
                    }
                }
            }
        }

        //Return Random Food Items
        SNACK_AM_MENU = snackAM;
    }

    /**
     * Makes a new lunch meal. Lunch consists of:
     *   1. Fruits
     *   2. Vegetables
     *   3. Grains
     *   4. Proteins
     */
    public void makeLunchMenu(String[] excludeFoods){
        //Lunch Menu
        String[] lunch = new String[4];

        //NEW IDEA
        boolean needsUpdate = true;
        while(needsUpdate){
            needsUpdate = false;

            //Random Fruits Index + Items
            int randIndex = (int) (Math.random() * FRUITS.size());
            lunch[0] = FRUITS.get(randIndex);

            //Random Vegetables Index + Items
            randIndex = (int) (Math.random() * VEGETABLES.size());
            lunch[1] = VEGETABLES.get(randIndex);

            //Random Grains Index + Items
            randIndex = (int) (Math.random() * GRAINS.size());
            lunch[2] = GRAINS.get(randIndex);

            //Random Proteins Index + Items
            randIndex = (int) (Math.random() * PROTEINS.size());
            lunch[3] = PROTEINS.get(randIndex);

            //NEW IDEA
            if(excludeFoods != null){
                for(String bannedFoodItem : excludeFoods){
                    if(bannedFoodItem.equals(lunch[0]) ||
                            bannedFoodItem.equals(lunch[1]) ||
                            bannedFoodItem.equals(lunch[2]) ||
                            bannedFoodItem.equals(lunch[3])){
                        needsUpdate = true;
                        break;
                    }
                }
            }
        }

        //Return Random Food Items
        LUNCH_MENU = lunch;
    }

    /**
     * Makes a new snack AM meal. Snack PM consists of:
     *   1. Fruits
     *   2. Grains
     *   3. Proteins
     */
    public void makeSnackPMMenu(String[] excludeFoods){
        //SnackPM Menu
        String[] snackPM = new String[3];

        //NEW IDEA
        boolean needsUpdate = true;
        while(needsUpdate){
            needsUpdate = false;

            //Random Fruits Index + Item
            int randIndex = (int) (Math.random() * FRUITS.size());
            snackPM[0] = FRUITS.get(randIndex);

            //Random Grains Index + Item
            randIndex = (int) (Math.random() * GRAINS.size());
            snackPM[1] = GRAINS.get(randIndex);

            //Random Proteins Index + Item
            randIndex = (int) (Math.random() * PROTEINS.size());
            snackPM[2] = PROTEINS.get(randIndex);

            //NEW IDEA
            if(excludeFoods != null){
                for(String bannedFoodItem : excludeFoods){
                    if(bannedFoodItem.equals(snackPM[0]) ||
                            bannedFoodItem.equals(snackPM[1]) ||
                            bannedFoodItem.equals(snackPM[2])){
                        needsUpdate = true;
                        break;
                    }
                }
            }
        }

        //Return Random Food Items
        SNACK_PM_MENU = snackPM;
    }

    /**
     * Makes a new supper meal. Supper consists of:
     *   1. Fruits
     *   2. Vegetables
     *   3. Grains
     *   4. Proteins
     */
    public void makeSupperMenu(String[] excludeFoods){
        //Supper Menu
        String[] supper = new String[4];

        //NEW IDEA
        boolean needsUpdate = true;
        while(needsUpdate){
            needsUpdate = false;

            //Random Fruits Index + Item
            int randIndex = (int) (Math.random() * FRUITS.size());
            supper[0] = FRUITS.get(randIndex);

            //Random Vegetables Index + Item
            randIndex = (int) (Math.random() * VEGETABLES.size());
            supper[1] = VEGETABLES.get(randIndex);

            //Random Grains Index + Item
            randIndex = (int) (Math.random() * GRAINS.size());
            supper[2] = GRAINS.get(randIndex);

            //Random Proteins Index + Item
            randIndex = (int) (Math.random() * PROTEINS.size());
            supper[3] = PROTEINS.get(randIndex);

            //NEW IDEA
            if(excludeFoods != null){
                for(String bannedFoodItem : excludeFoods){
                    if(bannedFoodItem.equals(supper[0]) ||
                            bannedFoodItem.equals(supper[1]) ||
                            bannedFoodItem.equals(supper[2]) ||
                            bannedFoodItem.equals(supper[3])){
                        needsUpdate = true;
                        break;
                    }
                }
            }
        }

        //Return Random Food Items
        SUPPER_MENU = supper;
    }

    /**
     * Makes a new snack late meal. Snack Late consists of:
     *   1. Vegetables
     *   2. Grains
     *   3. Proteins
     */
    public void makeSnackLateMenu(String[] excludeFoods){
        //SnackLate Menu
        String[] snackLate = new String[3];

        //NEW IDEA
        boolean needsUpdate = true;
        while(needsUpdate){
            needsUpdate = false;

            //Random Vegetables Index + Item
            int randIndex = (int) (Math.random() * VEGETABLES.size());
            snackLate[0] = VEGETABLES.get(randIndex);

            //Random Grains Index + Item
            randIndex = (int) (Math.random() * GRAINS.size());
            snackLate[1] = GRAINS.get(randIndex);

            //Random Proteins Index + Item
            randIndex = (int) (Math.random() * PROTEINS.size());
            snackLate[2] = PROTEINS.get(randIndex);

            //NEW IDEA
            if(excludeFoods != null){
                for(String bannedFoodItem : excludeFoods){
                    if(bannedFoodItem.equals(snackLate[0]) ||
                            bannedFoodItem.equals(snackLate[1]) ||
                            bannedFoodItem.equals(snackLate[2])){
                        needsUpdate = true;
                        break;
                    }
                }
            }
        }

        //Return Random Food Items
        SNACK_LATE_MENU = snackLate;
    }

    /**
     * Makes or updates an array of banned foods. Temporary items are food
     *  items from the previous day. Permanent items are allergic food. It
     *  clears out the previous day's menu and updates it with today's menu,
     *  but keeps the allergic food items.
     */
    //TODO: Add Allergies File (List, top) & Here.
    public void updateExcludedFoods(){
        //Empty's out yesterday's entire menu (Fresh start)
        Menus.EXCLUDED_FOODS = null;

        //List of excluded foods bc idk how long it will be.
        List<String> excludeFoods = new ArrayList<>();

        //Gathers today's food items to be excluded for tomorrow's menu.
        for(String requests : Menus.MEAL_REQUESTS){
            switch (requests){
                case Menus.BREAKFAST:
                    String[] breakfast = getBreakfast();
                    if(breakfast != null){
                        for(String foodItem : breakfast){
                            excludeFoods.add(foodItem);
                        }
                    }
                    break;

                case Menus.SNACK_AM:
                    String[] snackAM = getSnackAM();
                    if(snackAM != null){
                        for(String foodItem : snackAM){
                            excludeFoods.add(foodItem);
                        }
                    }
                    break;

                case Menus.LUNCH:
                    String[] lunch = getLunch();
                    if(lunch != null){
                        for(String foodItem : lunch){
                            excludeFoods.add(foodItem);
                        }
                    }
                    break;

                case Menus.SNACK_PM:
                    String[] snackPM = getSnackPM();
                    if(snackPM != null){
                        for(String foodItem : snackPM){
                            excludeFoods.add(foodItem);
                        }
                    }
                    break;

                case Menus.SUPPER:
                    String[] supper = getSupper();
                    if(supper != null){
                        for(String foodItem : supper){
                            excludeFoods.add(foodItem);
                        }
                    }
                    break;

                case Menus.SNACK_LATE:
                    String[] snackLate = getSnackLate();
                    if(snackLate != null){
                        for(String foodItem : snackLate){
                            excludeFoods.add(foodItem);
                        }
                    }
                    break;

                default:
                    System.out.println("Could Not Find Excluded Food Item.");
            }
        }

        //Transfer our List onto an Array & Updates EXCLUDED_FOODS.
        String[] bannedFoods = new String[excludeFoods.size()];
        for(int i = 0; i < excludeFoods.size(); i++){
            bannedFoods[i] = excludeFoods.get(i);
        }
        Menus.EXCLUDED_FOODS = bannedFoods;
    }


    //GETTERS
    /**
     * Grabs Breakfast Menu
     * @return return breakfast menu.
     */
    public String[] getBreakfast(){
        return BREAKFAST_MENU;
    }

    /**
     * Grabs Snack AM Menu
     * @return return snack AM menu.
     */
    public String[] getSnackAM(){
        return SNACK_AM_MENU;
    }

    /**
     * Grabs Lunch Menu
     * @return return lunch menu.
     */
    public String[] getLunch(){
        return LUNCH_MENU;
    }

    /**
     * Grabs Snack PM Menu
     * @return return Snack PM menu.
     */
    public String[] getSnackPM(){
        return SNACK_PM_MENU;
    }

    /**
     * Grabs Supper Menu
     * @return return Supper menu.
     */
    public String[] getSupper(){
        return SUPPER_MENU;
    }

    /**
     * Grabs SnackLate Menu
     * @return return Snack Late menu.
     */
    public String[] getSnackLate(){
        return SNACK_LATE_MENU;
    }


    /**
     * Checks to see if today's food items are unique and do not repeat. It does
     *  this by looping over each of today's menu items and matching it to the
     *  same menu, but on a different loop. It will count itself. As long as
     *  there are exactly 1 match, there will be no repeats. If more than 1
     *  match occurs, then the same food item was found elsewhere and the menu
     *  is not unique.
     * @return returns true if there is exactly 1 match.
     */
    public boolean isUnique(){
        String[][] Menu = {getBreakfast(), getSnackAM(),
                getLunch(), getSnackPM(), getSupper(), getSnackLate()};
        int matches = 0;
        //Loops over Original Menu.
        for(String[] serving : Menu){
            if(serving != null){
                for(String foodItem : serving){
                    matches = 0;

                    //Creates & Loops over a COPY of the Menu above.
                    for(String[] servingCopy : Menu){
                        if(servingCopy != null){
                            //Checks if foodItem was found in the Menu (copy)
                            for(String foodItemCopy : servingCopy){
                                if(foodItem.equals(foodItemCopy)){
                                    matches++;
                                }
                            }
                            //Checks if matches != more than 1 match
                            if(matches > 1){
                                return false;
                            }
                        }
                    }

                }
            }
        }
        return true;
    }



















//    //MAIN PROGRAM.
//    /**
//     * Main Program.
//     * @param args arguments.
//     * @throws FileNotFoundException fileNoteFound.
//     */
//    //TODO'S
//    //TODO: Add Allergies File (& add list of Allergies to Private List on top // Exclude Foods)
//    //TODO: Done.
//    //TODO: Done.
//    //TODO: Clean Code. (New Page?)
//    //TODO: Work on Excel aspect...
//
//    public static void main(String[] args) throws FileNotFoundException {
//        //Read from a file
//        //Fruits
//        File FruitsFile = new File("/Users/speak_easy/CS251/Menus" +
//                "/src/Food Items/Fruits.txt");
//        Scanner read = new Scanner(FruitsFile);
//        List<String> Fruits = new ArrayList<>();
//        while(read.hasNextLine()){
//            String item = read.nextLine();
//            Fruits.add(item);
//        }
//        read.close();
//
//        //Proteins
//        File ProteinsFile = new File("/Users/speak_easy/CS251/" +
//                "Menus/src/Food Items/Proteins.txt");
//        read = new Scanner(ProteinsFile);
//        List<String> Proteins = new ArrayList<>();
//        while(read.hasNextLine()){
//            String item = read.nextLine();
//            Proteins.add(item);
//        }
//        read.close();
//
//        //Vegetables
//        File VegetablesFile = new File("/Users/speak_easy/CS251/" +
//                "Menus/src/Food Items/Vegetables.txt");
//        read = new Scanner(VegetablesFile);
//        List<String> Vegetables = new ArrayList<>();
//        while(read.hasNextLine()){
//            String item = read.nextLine();
//            Vegetables.add(item);
//        }
//        read.close();
//
//        //Grains
//        File GrainsFile = new File("/Users/speak_easy/CS251/" +
//                "Menus/src/Food Items/Grains.txt");
//        read = new Scanner(GrainsFile);
//        List<String> Grains = new ArrayList<>();
//        while(read.hasNextLine()){
//            String item = read.nextLine();
//            Grains.add(item);
//        }
//        read.close();
//
//        //User Input
//        //Choose Numbers of Weeks needed
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("~ Welcome, let's make a new menu. ~");
//        //Choose Meals (up to 6)
//        boolean hideBreakfast = false;
//        boolean hideSnackAM = false;
//        boolean hideLunch = false;
//        boolean hideSnackPM = false;
//        boolean hideSupper = false;
//        boolean hideSnackLate = false;
//
//        System.out.println("2. Choose your meals (3x)");
//        int optionsLeft = 3;
//        MEAL_REQUESTS = new String[3];
//        while(optionsLeft > 0){
//            System.out.println("     ~ Options ~");
//            if(!hideBreakfast){
//                System.out.println("   [br] Breakfast");
//            }
//            if(!hideSnackAM){
//                System.out.println("   [sa] Snack A.M.");
//            }
//            if(!hideLunch){
//                System.out.println("   [lu] Lunch");
//            }
//            if(!hideSnackPM){
//                System.out.println("   [sp] Snack P.M.");
//            }
//            if(!hideSupper){
//                System.out.println("   [su] Supper");
//            }
//            if(!hideSnackLate){
//                System.out.println("   [sl] Snack Late");
//            }
//
//            //Checks to see if user input is valid.
//            String mealOption = scanner.nextLine().toLowerCase();
//            if( (mealOption.equals(BREAKFAST) && !hideBreakfast) ||
//                    (mealOption.equals(SNACK_AM) && !hideSnackAM) ||
//                    (mealOption.equals(LUNCH) && !hideLunch) ||
//                    (mealOption.equals(SNACK_PM) && !hideSnackPM) ||
//                    (mealOption.equals(SUPPER) && !hideSupper) ||
//                    (mealOption.equals(SNACK_LATE) && !hideSnackLate)){
//
//                optionsLeft--;
//                //Adds user input to mealRequests Array
//                for(int i = 0; i < MEAL_REQUESTS.length; i++){
//                    if(MEAL_REQUESTS[i] == null){
//                        MEAL_REQUESTS[i] = mealOption;
//                        break;
//                    }
//                }
//                //Checks to see which option to get rid of in the menu.
//                switch (mealOption) {
//                    case BREAKFAST:
//                        hideBreakfast = true;
//                        break;
//                    case SNACK_AM:
//                        hideSnackAM = true;
//                        break;
//                    case LUNCH:
//                        hideLunch = true;
//                        break;
//                    case SNACK_PM:
//                        hideSnackPM = true;
//                        break;
//                    case SUPPER:
//                        hideSupper = true;
//                        break;
//                    case SNACK_LATE:
//                        hideSnackLate = true;
//                        break;
//                }
//
//            }else{
//                System.out.println("Invalid Choice");
//            }
//            System.out.println();
//        }
//
//        //Suspense
//        try{
//            System.out.print("Making new menus");
//            TimeUnit.SECONDS.sleep(1);
//            System.out.print(".");
//            TimeUnit.SECONDS.sleep(1);
//            System.out.print(".");
//            TimeUnit.SECONDS.sleep(1);
//            System.out.println(".");
//        }catch (Exception e){
//            System.out.println("Couldn't make new Menus. System Timeout.");
//        }
//
//        //Makes a new week w/ 7 days.
//        Day[] Week = new Day[7];
//        Day Monday = new Day(Fruits, Vegetables, Proteins, Grains);
//        Day Tuesday = new Day(Fruits, Vegetables, Proteins, Grains);
//        Day Wednesday = new Day(Fruits, Vegetables, Proteins, Grains);
//        Day Thursday = new Day(Fruits, Vegetables, Proteins, Grains);
//        Day Friday = new Day(Fruits, Vegetables, Proteins, Grains);
//        Day Saturday = new Day(Fruits, Vegetables, Proteins, Grains);
//        Day Sunday = new Day(Fruits, Vegetables, Proteins, Grains);
//        Week[0] = Monday;
//        Week[1] = Tuesday;
//        Week[2] = Wednesday;
//        Week[3] = Thursday;
//        Week[4] = Friday;
//        Week[5] = Saturday;
//        Week[6] = Sunday;
//
//
//        //Make meal requests for each day. Sorts through all the days of the week.
//        for(Day day: Week) {
//            System.out.println("//New Day, New Menus//");
//
//            //Responsible for checking if TODAY's menu does NOT have
//            // repeating food items before continuing on to next day.
//            boolean isUnique = false;
//            while (!isUnique) {
//                //isUnique = true;
//                //Creates all the Meal Requests for a day.
//                for (String mealRequest : MEAL_REQUESTS) {
//                    System.out.println("*Creating new food request*");
//                    switch (mealRequest) {
//                        case BREAKFAST:
//                            day.makeBreakfastMenu(EXCLUDED_FOODS);
//                            break;
//                        case SNACK_AM:
//                            day.makeSnackAMMenu(EXCLUDED_FOODS);
//                            break;
//                        case LUNCH:
//                            day.makeLunchMenu(EXCLUDED_FOODS);
//                            break;
//                        case SNACK_PM:
//                            day.makeSnackPMMenu(EXCLUDED_FOODS);
//                            break;
//                        case SUPPER:
//                            day.makeSupperMenu(EXCLUDED_FOODS);
//                            break;
//                        case SNACK_LATE:
//                            day.makeSnackLateMenu(EXCLUDED_FOODS);
//                            break;
//                        default:
//                            System.out.println("Meal Request Does Not Exist.");
//                            break;
//                    }
//                }
//                //Checks if newly created menu's are unique, else, the program
//                // needs to create new ones.
//                isUnique = day.isUnique();
//
//                //if day's menu's ARE unique, then add those items to exclude
//                // foods.
//                if(isUnique){
//                    day.updateExcludedFoods();
//                }
//            }
//        }
//
//
//        //Print out week's menus (user may change weeks amount)
//        for(int i = 0; i < 7; i++){
//            //Grab Meal & Date
//            Day day = Week[i];
//            String dayOfWeek = DAYS_OF_WEEK[i];
//            //Print System (Temp.)
//            System.out.println("~ " + dayOfWeek + " ~");
//            for(String request: MEAL_REQUESTS){
//                switch (request){
//                    case BREAKFAST:
//                        //Grabs New Meal & Prints
//                        System.out.print("Breakfast: ");
//                        String[] Menu = day.getBreakfast();
//                        for(String foodItem: Menu){
//                            System.out.print(" |" + foodItem + "|");
//                        }
//                        System.out.println();
//                        break;
//
//                    case SNACK_AM:
//                        //Grabs New Meal & Prints
//                        System.out.print("SnackAM: ");
//                        Menu = day.getSnackAM();
//                        for(String foodItem: Menu){
//                            System.out.print(" |" + foodItem + "|");
//                        }
//                        System.out.println();
//                        break;
//
//                    case LUNCH:
//                        //Grabs New Meal & Prints
//                        System.out.print("Lunch: ");
//                        Menu = day.getLunch();
//                        for(String foodItem: Menu){
//                            System.out.print(" |" + foodItem + "|");
//                        }
//                        System.out.println();
//                        break;
//
//                    case SNACK_PM:
//                        //Grabs New Meal & Prints
//                        System.out.print("SnackPM: ");
//                        Menu = day.getSnackPM();
//                        for(String foodItem: Menu){
//                            System.out.print(" |" + foodItem + "|");
//                        }
//                        System.out.println();
//                        break;
//
//                    case SUPPER:
//                        //Grabs New meal & Prints
//                        System.out.print("Supper: ");
//                        Menu = day.getSupper();
//                        for(String foodItem: Menu){
//                            System.out.print(" |" + foodItem + "|");
//                        }
//                        System.out.println();
//                        break;
//
//                    case SNACK_LATE:
//                        //Grabs New meal & Prints
//                        System.out.print("SnackLate: ");
//                        Menu = day.getSnackLate();
//                        for(String foodItem: Menu){
//                            System.out.print(" |" + foodItem + "|");
//                        }
//                        System.out.println();
//                        break;
//
//                    default:
//                        System.out.println("Request Not Found.");
//                }
//            }
//            System.out.println();
//        }
//    }
}
