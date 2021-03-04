# Menus Guide
### Overview
* Day Object holds 3 meals. Meals are strings derived from the various 
food reading files. Lunch and Supper grains are different from the 
rest of the grains (breakfast, snackAM, snackPM, snackLate). The 
lunch and supper grains are "bulkier" than the rest. For example, 
it would be fine to see "spaghetti" as a grain in Lunch, but not as a
grain in snackAM. 

* The program reads your files (Proteins, Fruits, 
Vegetables, GrainsLight, GrainsHeavy) and pulls out all the meal 
contents. Then, it asks the user what it wants it to do with the food
items. The user will then select which days it needs meals for, as
well as for what meals. The program will then make the appropriate 
number of days and select the appropriate meals for those days. The 
user will NOT be able to changes which meals he or she wants for each
individual day. For instances, the user will start the program and 
be asked which days they need (mon-sun), then which meals they need, 
and that's it. 

### How to use
1. Make 5 files (.txt) and name them exactly as they appear below.
    1. "Proteins"
    2. "Fruits"
    3. "Vegetables"
    4. "GrainsLight"
    5. "GrainsHeavy"
    
2. Move the files in the "Food Items" folder next to the src

3. Add your food items to their respective category. All fruits 
(strawberries, blueberries, etc.) in the Fruits.txt file. There 
should only be 1 food item per line in the text file. 

4. Run Program
