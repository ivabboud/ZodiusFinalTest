package com.e_steps.abraj2.utils;


public class StoredString {



    public String  DailyStrings[][] = new String [12][2];
    public String  YearlyStrings[][] = new String [12][5];
    public String  ChineseStrings[] = new String [12];
    public String  CharachterStrings[][] = new String [12][5];



    public void Store(String text , int sec , int row , int col)
    {
        switch (sec){
            case 1:
                DailyStrings [row][col] = text;
                break;
            case 2:
                YearlyStrings [row][col] = text;
                break;
            case 3:
                ChineseStrings [row] = text;
                break;
            case 4:
                CharachterStrings [row][col] = text;
                break;
        }
    }


    public String getString(int sec,int row,int col)
    {

        switch (sec){
            case 1:
                  return DailyStrings [row][col];

            case 2:
                return YearlyStrings [row][col];

            case 3:
                return ChineseStrings [row];

            case 4:
                return CharachterStrings [row][col];


        }
        return "";
    }


}
