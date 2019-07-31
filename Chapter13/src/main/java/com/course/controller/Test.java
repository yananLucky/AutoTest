package com.course.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Test {

    public static void method(String[] str){
        int i=0;
        for(String str1:str){

            if(str1.equals("a")){
                i++;
            }

        }
        System.out.println("a:"+i);
    }

    public static void method2(){
        String str1="{id:" + "id1" + "," +
                "userName:" + "userName1" + "," +
                "age:" + "age1" + "," +
                "sex:" + "sex1" + "," +
                "permission:" +"permission1" + "," +
                "isDelete:" + "isDelete1" + "}";
       // System.out.println(str1);
        String str2="";

        JSONObject jsonObject=new JSONObject();
//        JSONArray jsonArray=jsonObject.getJSONObject(str2).getJSONArray("child");
        System.out.println( str2);
    }

    public static void main(String [] args){
        String [] str3={"a","b","a","c","e"};
            //Test.method(str3);
            Test.method2();

    }


}
