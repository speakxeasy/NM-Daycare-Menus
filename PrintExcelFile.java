import org.apache.poi.ss.usermodel.*;

import java.io.*;

public class PrintExcelFile {
    /**
     * Constructor that prints Menus to Excel File.
     */
    public PrintExcelFile(String[] menu, String fileName, int Month, int Day, String[] mealRequests) throws IOException {
        //Creates Basic Outline: File's Path (fileName), Workbook, Sheet.
        FileInputStream fileInput = new FileInputStream(new File(fileName));
        Workbook workbook = WorkbookFactory.create(fileInput);
        Sheet sheet = workbook.getSheetAt(0);

        //***Updates "Top-Row" Cells***//
        //Name
        Cell updatedCell = sheet.getRow(3).getCell(2);
        updatedCell.setCellValue("Name: Lidia Ramos");
        //Provider #
        //TODO: Find Provider #
        updatedCell = sheet.getRow(3).getCell(3);
        updatedCell.setCellValue("#######");
        //Phone #
        updatedCell = sheet.getRow(3).getCell(4);
        updatedCell.setCellValue("(505)515-8742");
        //Month (Finds Month)
        String monthWritten = "N/A";
        switch (Month) {
            case 1:
                monthWritten = "January";
                break;
            case 2:
                monthWritten = "February";
                break;
            case 3:
                monthWritten = "March";
                break;
            case 4:
                monthWritten = "April";
                break;
            case 5:
                monthWritten = "May";
                break;
            case 6:
                monthWritten = "June";
                break;
            case 7:
                monthWritten = "July";
                break;
            case 8:
                monthWritten = "August";
                break;
            case 9:
                monthWritten = "September";
                break;
            case 10:
                monthWritten = "October";
                break;
            case 11:
                monthWritten = "November";
                break;
            case 12:
                monthWritten = "December";
                break;
            default:
                System.out.println("[EXCEL] Month Not Found.");
        }
        updatedCell = sheet.getRow(3).getCell(5);
        updatedCell.setCellValue("Month: " + monthWritten);
        //Year
        updatedCell = sheet.getRow(3).getCell(6);
        updatedCell.setCellValue("Year: " + 2021);



        //***Updates "Dates" Cells***//
        //Day 1
        updatedCell = sheet.getRow(4).getCell(2);
        updatedCell.setCellValue("Date: " + Month + "/" + Day);
        //Day 2
        updatedCell = sheet.getRow(4).getCell(3);
        updatedCell.setCellValue("Date: " + Month + "/" + (Day + 1));
        //Day 3
        updatedCell = sheet.getRow(4).getCell(4);
        updatedCell.setCellValue("Date: " + Month + "/" + (Day + 2));
        //Day 4
        updatedCell = sheet.getRow(4).getCell(5);
        updatedCell.setCellValue("Date: " + Month + "/" + (Day + 3));
        //Day 5
        updatedCell = sheet.getRow(4).getCell(6);
        updatedCell.setCellValue("Date: " + Month + "/" + (Day + 4));


        //***Updates Food Item Cells***// (Based on Meal_Requests)
        //Checks Meal Requests for each day (5 days)
        int nextItem = 0;
        for(int day = 0; day < 5; day++){
            //For each day, it checks which meal requests user wanted
            for(String request : mealRequests){
                switch (request){
                    case Menus.BREAKFAST:
                        //Breaks up cell to grab by day.
                        if(day == 0){
                            //BR, Fruit/Veg
                            updatedCell = sheet.getRow(8).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //BR, Grains
                            updatedCell = sheet.getRow(9).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 1){
                            //BR, Fruit
                            updatedCell = sheet.getRow(8).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //BR, Grains
                            updatedCell = sheet.getRow(9).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 2){
                            //BR, Fruit
                            updatedCell = sheet.getRow(8).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //BR, Grains
                            updatedCell = sheet.getRow(9).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 3){
                            //BR, Fruit
                            updatedCell = sheet.getRow(8).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //BR, Grains
                            updatedCell = sheet.getRow(9).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 4){
                            //BR, Fruit
                            updatedCell = sheet.getRow(8).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //BR, Grains
                            updatedCell = sheet.getRow(9).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }
                        break;
                    case Menus.SNACK_AM:
                        //Breaks up cell to grab by day.
                        if(day == 0){
                            //S_AM, Fruit/Veg
                            updatedCell = sheet.getRow(12).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_AM, Grains
                            updatedCell = sheet.getRow(13).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_AM Proteins
                            updatedCell = sheet.getRow(14).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 1){
                            //S_AM, Fruit/Veg
                            updatedCell = sheet.getRow(12).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_AM, Grains
                            updatedCell = sheet.getRow(13).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_AM Proteins
                            updatedCell = sheet.getRow(14).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 2){
                            //S_AM, Fruit/Veg
                            updatedCell = sheet.getRow(12).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_AM, Grains
                            updatedCell = sheet.getRow(13).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_AM Proteins
                            updatedCell = sheet.getRow(14).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 3){
                            //S_AM, Fruit/Veg
                            updatedCell = sheet.getRow(12).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_AM, Grains
                            updatedCell = sheet.getRow(13).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_AM Proteins
                            updatedCell = sheet.getRow(14).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 4){
                            //S_AM, Fruit/Veg
                            updatedCell = sheet.getRow(12).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_AM, Grains
                            updatedCell = sheet.getRow(13).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_AM Proteins
                            updatedCell = sheet.getRow(14).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }
                        break;
                    case Menus.LUNCH:
                        //Breaks up cell to grab by day.
                        if(day == 0){
                            //Lunch, Fruit/Veg
                            updatedCell = sheet.getRow(17).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch, Fruit/Veg
                            updatedCell = sheet.getRow(18).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch, Grains
                            updatedCell = sheet.getRow(19).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch Proteins
                            updatedCell = sheet.getRow(20).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 1){
                            //Lunch, Fruit/Veg
                            updatedCell = sheet.getRow(17).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch, Fruit/Veg
                            updatedCell = sheet.getRow(18).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch, Grains
                            updatedCell = sheet.getRow(19).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch Proteins
                            updatedCell = sheet.getRow(20).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 2){
                            //Lunch, Fruit/Veg
                            updatedCell = sheet.getRow(17).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch, Fruit/Veg
                            updatedCell = sheet.getRow(18).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch, Grains
                            updatedCell = sheet.getRow(19).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch Proteins
                            updatedCell = sheet.getRow(20).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 3){
                            //Lunch, Fruit/Veg
                            updatedCell = sheet.getRow(17).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch, Fruit/Veg
                            updatedCell = sheet.getRow(18).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch, Grains
                            updatedCell = sheet.getRow(19).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch Proteins
                            updatedCell = sheet.getRow(20).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 4){
                            //Lunch, Fruit/Veg
                            updatedCell = sheet.getRow(17).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch, Fruit/Veg
                            updatedCell = sheet.getRow(18).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch, Grains
                            updatedCell = sheet.getRow(19).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Lunch Proteins
                            updatedCell = sheet.getRow(20).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }
                        break;
                    case Menus.SNACK_PM:
                        //Breaks up cell to grab by day.
                        if(day == 0){
                            //S_PM, Fruit/Veg
                            updatedCell = sheet.getRow(23).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_PM, Grains
                            updatedCell = sheet.getRow(24).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_PM Proteins
                            updatedCell = sheet.getRow(25).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 1){
                            //S_PM, Fruit/Veg
                            updatedCell = sheet.getRow(23).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_PM, Grains
                            updatedCell = sheet.getRow(24).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_PM Proteins
                            updatedCell = sheet.getRow(25).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 2){
                            //S_PM, Fruit/Veg
                            updatedCell = sheet.getRow(23).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_PM, Grains
                            updatedCell = sheet.getRow(24).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_PM Proteins
                            updatedCell = sheet.getRow(25).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 3){
                            //S_PM, Fruit/Veg
                            updatedCell = sheet.getRow(23).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_PM, Grains
                            updatedCell = sheet.getRow(24).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_PM Proteins
                            updatedCell = sheet.getRow(25).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 4){
                            //S_PM, Fruit/Veg
                            updatedCell = sheet.getRow(23).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_PM, Grains
                            updatedCell = sheet.getRow(24).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_PM Proteins
                            updatedCell = sheet.getRow(25).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }
                        break;
                    case Menus.SUPPER:
                        //Breaks up cell to grab by day.
                        if(day == 0){
                            //Sup, Fruit/Veg
                            updatedCell = sheet.getRow(28).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Fruit/Veg
                            updatedCell = sheet.getRow(29).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Grains
                            updatedCell = sheet.getRow(30).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Proteins
                            updatedCell = sheet.getRow(31).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 1){
                            //Sup, Fruit/Veg
                            updatedCell = sheet.getRow(28).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Fruit/Veg
                            updatedCell = sheet.getRow(29).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Grains
                            updatedCell = sheet.getRow(30).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Proteins
                            updatedCell = sheet.getRow(31).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 2){
                            //Sup, Fruit/Veg
                            updatedCell = sheet.getRow(28).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Fruit/Veg
                            updatedCell = sheet.getRow(29).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Grains
                            updatedCell = sheet.getRow(30).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Proteins
                            updatedCell = sheet.getRow(31).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 3){
                            //Sup, Fruit/Veg
                            updatedCell = sheet.getRow(28).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Fruit/Veg
                            updatedCell = sheet.getRow(29).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Grains
                            updatedCell = sheet.getRow(30).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Proteins
                            updatedCell = sheet.getRow(31).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 4){
                            //Sup, Fruit/Veg
                            updatedCell = sheet.getRow(28).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Fruit/Veg
                            updatedCell = sheet.getRow(29).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Grains
                            updatedCell = sheet.getRow(30).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //Sup, Proteins
                            updatedCell = sheet.getRow(31).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }
                        break;
                    case Menus.SNACK_LATE:
                        //Breaks up cell to grab by day.
                        if(day == 0){
                            //S_LATE, Fruit/Veg
                            updatedCell = sheet.getRow(34).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_LATE, Grains
                            updatedCell = sheet.getRow(35).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_LATE, Proteins
                            updatedCell = sheet.getRow(36).getCell(2);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 1){
                            //S_LATE, Fruit/Veg
                            updatedCell = sheet.getRow(34).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_LATE, Grains
                            updatedCell = sheet.getRow(35).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_LATE, Proteins
                            updatedCell = sheet.getRow(36).getCell(3);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 2){
                            //S_LATE, Fruit/Veg
                            updatedCell = sheet.getRow(34).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_LATE, Grains
                            updatedCell = sheet.getRow(35).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_LATE, Proteins
                            updatedCell = sheet.getRow(36).getCell(4);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 3){
                            //S_LATE, Fruit/Veg
                            updatedCell = sheet.getRow(34).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_LATE, Grains
                            updatedCell = sheet.getRow(35).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_LATE, Proteins
                            updatedCell = sheet.getRow(36).getCell(5);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }else if(day == 4){
                            //S_LATE, Fruit/Veg
                            updatedCell = sheet.getRow(34).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_LATE, Grains
                            updatedCell = sheet.getRow(35).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                            //S_LATE, Proteins
                            updatedCell = sheet.getRow(36).getCell(6);
                            updatedCell.setCellValue(menu[nextItem]);
                            nextItem++;
                        }
                        break;
                    default:
                        System.out.println("[EXCEL] Unable to write meal " +
                                "request to cell.");
                        break;
                }
            }
        }

        //Prints Signature (Bottom of Excel SpreadSheet) + Create Underline
//        updatedCell = sheet.getRow(38).getCell(2);
//        updatedCell.setCellValue("                          Lidia Ramos                           ");
//        Font font = workbook.createFont();
//        font.setUnderline(HSSFFont.U_SINGLE);
//        CellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setFont(font);
//        updatedCell.setCellStyle(cellStyle);
//        cellStyle.setAlignment(HorizontalAlignment.CENTER);
//        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//        font.setFontHeightInPoints((short) 16);

        fileInput.close();

        FileOutputStream fileOutput = new FileOutputStream(fileName);
        workbook.write(fileOutput);
        workbook.close();
        System.out.println("[x]Excel File Updated Successfully.");
    }
}
