package com.android.team13.ssk1;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class DatabaseHandler {
    public DatabaseHandler(int id){
        this.id=id;
    }
    public DatabaseHandler(String t){ty=t;}
    int id;String ty;
    //Connection con;
    public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();
        String se;
        if (ty.equals("del"))
            se="select app_id from app where stat='NA';";
        else
        se="select dat from app where doc_id="+id;

        System.out.println(se);
       try{ Statement stmt = new Connect().getCon().createStatement();
        ResultSet rs = stmt.executeQuery(se);

        while (rs.next()){
            labels.add(rs.getString(1));
        }}catch (Exception e){e.printStackTrace();}
        return labels;
    }

  /*  public List<String>[] getAllLabels1(){
        List<String>[] st;
        st = new List[4];

        List<String> s1=new ArrayList<String>();
        List<String> s2=new ArrayList<String>();
        List<String> s3=new ArrayList<String>();
        List<String> s4=new ArrayList<String>();

        String se1="select nam from register"
    }*/
}
