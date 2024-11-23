package com.sky.collections;

import java.util.*;

public class EnumCollections {
    enum WeekDay { SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY };
    public static void main(String[] args) {
        List<WeekDay> weekDayList=new ArrayList<>(List.of(WeekDay.FRIDAY, WeekDay.SATURDAY, WeekDay.SUNDAY));

        System.out.println("-".repeat(70));
        var annsDaySet= EnumSet.copyOf(weekDayList);
        System.out.println(annsDaySet);

        System.out.println("-".repeat(70));
        Set<WeekDay> newPersonDays= EnumSet.complementOf(annsDaySet);
        System.out.println(newPersonDays);

        System.out.println("-".repeat(70));
        Set<WeekDay> businessDays= EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        System.out.println(businessDays);

        System.out.println("-".repeat(70));
        Map<WeekDay,String[]> employeeMap=new EnumMap<>(WeekDay.class);
        employeeMap.put(WeekDay.FRIDAY, new String[]{"Ali","Abbas"});
        employeeMap.put(WeekDay.MONDAY, new String[]{"Ali","Abbas","Ahmad"});
        employeeMap.forEach((k,v)->System.out.println(k+" "+Arrays.toString(v)));
    }
}
