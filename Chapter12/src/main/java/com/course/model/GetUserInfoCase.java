package com.course.model;


import lombok.Data;

@Data
public class GetUserInfoCase {
    private int userId;
    private String expected;

/*    public static void main(String[] args) {
        String str="welcome to shui&di";
       System.out.println(str.length()+str.substring(11,15)+str.substring(16,18));
        //String str1=null;
        StringBuffer buffer=new StringBuffer();

        for(int i=str.length()-1;i>=0;i--){
            buffer.append(str.charAt(i));
        }
        System.out.println(buffer.toString());

    }*/
}
