package com.yuanzheng.springbootvscode.codetesting;


import com.google.gson.JsonObject;

public class gsonTest {
    public static void main(String[] args) {

        JsonObject json = new JsonObject();
        json.addProperty("circuitNumber", "123-456");
        json.addProperty("dealUser", "张三");
        json.addProperty("dealTime", "2020-07-10");
        json.addProperty("resourceResult", "竣工");
        String jsonStr = json.toString();
        System.out.println(jsonStr);
    }

}