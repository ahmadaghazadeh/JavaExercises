package com.sky.finalSealed;

public class FinalExplored {
    public static void main(String[] args) {
        String xArg="This value is for top level ";
        StringBuilder stringBuilder=new StringBuilder("Main -> ");
        doXYX(xArg,16,stringBuilder);
        System.out.println(xArg);
        System.out.println(stringBuilder);


    }
    private static void doXYX(String x, int y,final StringBuilder stringBuilder){
        final String c=x+y;
        System.out.println(c);
        stringBuilder.append(c);
        x=c;
         }
}
