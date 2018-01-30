package com.interviewbit.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class HotelBookings{

    static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K){
        int N = arrive.size();
        
        Collections.sort(arrive);
        Collections.sort(depart);
        
        int d_pointer,vacant_rooms;
        vacant_rooms = K;
        d_pointer = 0;
        
        for(int i = 0; i < N; i++){
            while(depart.get(d_pointer) <= arrive.get(i) && d_pointer < depart.size()-1){
                d_pointer++;
                vacant_rooms++;
            }
            if(vacant_rooms > 0){
                vacant_rooms--;
            }
            else{
                return false;
            }
        }
        return true;
    }

    static boolean Test(){
        ArrayList<Integer> arrive = new ArrayList<Integer>(Arrays.asList(1, 3 ,5));
        ArrayList<Integer> depart = new ArrayList<Integer>(Arrays.asList(2, 5, 8));
        return hotel(arrive, depart, 1);
    }
}