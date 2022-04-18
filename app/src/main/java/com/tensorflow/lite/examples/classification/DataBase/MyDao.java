package com.tensorflow.lite.examples.classification.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDao {
    private final MySQLiteHelper helper;

    public MyDao(Context context) {

        this.helper = new MySQLiteHelper(context);
    }
    public void add_user(String user_name, String user_password){

        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into "+Constants.TABLE_NAME_USER+"(user_name,user_password) values(?,? )",
                new Object[]{user_name,user_password});}
    public boolean select_username(String user_name, String user_password){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select user_name from"+Constants.TABLE_NAME_USER+" where user_name=?",
                new String[]{user_name});
        String password = null;
        if(cursor.moveToNext()){
            UserInfo info = new UserInfo();
            info.setUser_name(cursor.getString(0));
            info.setUser_password(cursor.getString(1));
            password = info.getUser_password();
        }
        cursor.close();
        if(password.equals(user_password)){
                        return true;
                    }
                    return false;
                }
//                public void add_flower(String flower){
//                    SQLiteDatabase db = helper.getWritableDatabase();
//                    String hobby = "";
//                    String objecyId="";
//
//                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
//                    String data=format.format(new Date());
//                    db.execSQL("insert into "+Constants.TABLE_NAME_FLOWER+"(objectid,data,hobby,type) values(?,? ,?,?)",
//                            new Object[]{objecyId,data,hobby,flower});}


}
