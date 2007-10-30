package com.rognlien.ujamaa.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.rognlien.ujamaa.model.Record;
import com.rognlien.ujamaa.model.RecordCreatedComparator;
import com.rognlien.ujamaa.model.RecordNameComparator;
import com.thoughtworks.xstream.XStream;

public class RecordManager {
  protected static Logger logger = Logger.getLogger("com.rognlien.ujamaa");
  
  private XStream xstream;
  private File file;
  private Map<Integer, Record> records;

  
  public RecordManager() {
    xstream = new XStream();
    try {    
      file = new File(this.getClass().getClassLoader().getResource("/records.xml").toURI());
      records = new HashMap<Integer, Record>();

      InputStream is = new FileInputStream(file);
      records = (Map<Integer, Record>) xstream.fromXML(is);
      is.close();
    }
    catch(Exception e) {
      logger.error(e);
    }
  }
  
  private void persist() {
    try {
      FileOutputStream fos = new FileOutputStream(file);
      logger.debug("Persisting to file: " + file);
      xstream.toXML(records, fos);
      fos.close();
    }
    catch (Exception e) {
      logger.error(e);
    }
  }

  

  public void store(Record record) {
    if(record.getId() < 1) {
      record.setId(records.size() + 1);
    }
    if(record.getCreated() == null) {
      record.setCreated(new Date());
    }
    
    records.put(record.getId(), record);
    persist();
  }
  
  
  public Record retrieve(int id) {
    return records.get(id);  
  }
  
  public void delete(int id) {
    records.remove(id);
    persist();
  }
  
  
  public List<Record> list(String filter, String sort, boolean reverse) throws Exception {
    ArrayList<Record> records;
    
    if(filter != null && filter.length() > 0) {
      Pattern p = Pattern.compile("^" + filter.replaceAll("\\*", ".*") + "$");
      records = new ArrayList<Record>();
      for(Record r : this.records.values()) {
        if(p.matcher(r.getName().toLowerCase()).matches()) {
          records.add(r);
        }
      }
    }
    else {
      records = new ArrayList<Record>(this.records.values());
    }
    
    
    /* Comparators */
    Class defaultComparator = RecordNameComparator.class;
    
    Map<String, Class> comparators = new HashMap<String, Class>();
    comparators.put("name", defaultComparator);
    comparators.put("created", RecordCreatedComparator.class);
    
    
    
    Comparator comparator = null;
    if(comparators.containsKey(sort)) {
      logger.debug("Creating comparator of class: " + comparators.get(sort));
       comparator = (Comparator) comparators.get(sort).newInstance();
    }
    else {
      comparator = (Comparator) defaultComparator.newInstance();
    }
    
    Collections.sort(records, comparator);
    if(reverse) {
      Collections.reverse(records);
    }
    logger.debug("Sort: " + sort);
    logger.debug("Comparator: " + comparator);
    return records;
  }
}
