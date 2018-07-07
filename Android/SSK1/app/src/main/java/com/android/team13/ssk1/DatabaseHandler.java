package com.android.team13.ssk1;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class DatabaseHandler {
    public DatabaseHandler(int id){
        this.id=id;
    }
    int id;
    //Connection con;
    public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();
        String se="select dat from app where doc_id="+id;
        System.out.println(se);
       try{ Statement stmt = new Connect().getCon().createStatement();
        ResultSet rs = stmt.executeQuery(se);

        while (rs.next()){
            labels.add(rs.getString(1));
        }}catch (Exception e){e.printStackTrace();}
        return labels;
    }
}
