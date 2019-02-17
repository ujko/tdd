package day2;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SmallestFreeIndex {

    public int getIndex(int[] a) {
        Set<Integer> set = new TreeSet<>();
        for(int i : a){
            if(i>0){
                set.add(i);
            }
        }
        int res = 1;
        for(int i : set){
            if(i == res){
                 res++;
            }
            else{
                break;
            }
        }
        return res;
    }

}
