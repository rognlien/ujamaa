package com.rognlien.ujamaa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

public class RecordManager {
  private static Map<Integer, Record> records = new HashMap<Integer, Record>();
  static {
    String[] names = {"¯ivind D¾hlin", "Eirik Lied", "Bendik Johansen"};
    int id = 0;
    
    for(String name : names) {
      Record r = new Record();
      r.setId(id++);
      r.setName(name);
      records.put(r.getId(), r);
    }
  }
  

  public static void store(Record record) {
    if(record.getId() < 1) {
      record.setId(records.size());
    }
    records.put(record.getId(), record);
  }
  
  
  public static Record retrieve(int id) {
    return records.get(id); /* note: autounboxing */  
  }
  
  public static List<Record> list() {
    return new ArrayList<Record>(records.values());
  }
}
