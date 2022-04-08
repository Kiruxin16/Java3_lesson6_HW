package ru.hw;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleArrWorking implements ArrWorking {
    public int[] afterFour(int[] arr) {
        int[] aftFour= null;
        if(Arrays.binarySearch(arr,4)==-1){
            throw new ArithmeticException();
        }

        for (int i =0; i <arr.length ; i++) {
            if(arr[arr.length-i-1]==4){
                aftFour=Arrays.copyOfRange(arr,arr.length-i,arr.length);
                break;
            }

        }

        return aftFour;
    }

    public boolean hasOnlyOneOrFour(int[] arr) {
        boolean hasFour=false;
        boolean hasOne=false;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]!=1&&arr[i]!=4){
                return false;
            }
            if(arr[i]==4){
                hasFour=true;
            }
            if(arr[i]==1){
                hasOne=true;
            }
        }
        return hasFour&&hasOne;
    }
}
