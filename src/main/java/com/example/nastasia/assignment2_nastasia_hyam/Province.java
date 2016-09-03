package com.example.nastasia.assignment2_nastasia_hyam;

/**
 * Created by Nastasia on 2016-02-27.
 */
import android.content.Context;
import android.content.res.TypedArray;
import java.util.ArrayList;


public class Province {

    private String name;
    private String capital;
    private int armId;


    //Province consists of a coat of arms, name and its capital city
    public Province(int resourceId, String name, String capital) {
        //corresponding arm drawable resource
        this.armId = resourceId;
        this.name = name;
        this.capital = capital;
    }

    public int getArmId(){
        return armId;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    @Override
    public String toString() {
        return name;
    }
    //Method to return array containing provinces
    public static ArrayList<Province> getProvinces(Context context) {

        String[] provincesString = context.getResources().getStringArray(R.array.provinces);
        String[] capitals = context.getResources().getStringArray(R.array.capitals);
        TypedArray arms = context.getResources().obtainTypedArray(R.array.arms);
        ArrayList<Province> provinces = new ArrayList<>();

        for (int i = 0; i < provincesString.length;i++) {
            int resourceId = arms.getResourceId(i,-1);
            provinces.add(new Province(resourceId,provincesString[i],capitals[i]));
        }
        return provinces;
    }

}