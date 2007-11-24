package com.rognlien.ujamaa.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.rognlien.ujamaa.model.Record;
import com.rognlien.ujamaa.model.comparator.RecordComparator;
import com.rognlien.ujamaa.model.comparator.RecordCreatedComparator;
import com.rognlien.ujamaa.model.comparator.RecordNameComparator;
import com.rognlien.ujamaa.persist.RecordXmlPersister;

public class RecordManager {
  protected static Logger logger = Logger.getLogger("com.rognlien.ujamaa");

  private Map<Integer, Record> records;
  private RecordXmlPersister persister;
  
  public RecordManager() {
    persister = new RecordXmlPersister();
    records = persister.load();
  }

  public void store(Record record) {
    if(record.getId() < 1) {
      record.setId(records.size() + 1);
    }
    if(record.getCreated() == null) {
      record.setCreated(new Date());
    }
    
    records.put(record.getId(), record);
    persister.persist(records);
  }

  public Record retrieve(int id) {
    return records.get(id);  
  }
  
  public void delete(int id) {
    records.remove(id);
    persister.persist(records);
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
    Class<? extends RecordComparator> defaultComparator = RecordNameComparator.class;
    
    Map<String, Class<? extends RecordComparator>> comparators = new HashMap<String, Class<? extends RecordComparator>>();
    comparators.put("name", defaultComparator);
    comparators.put("created", RecordCreatedComparator.class);
    
    
    
    RecordComparator comparator = null;
    if(comparators.containsKey(sort)) {
      logger.debug("Creating comparator of class: " + comparators.get(sort));
       comparator = comparators.get(sort).newInstance();
    }
    else {
      comparator = defaultComparator.newInstance();
    }
    
    
    if(reverse) {
      Collections.sort(records, Collections.reverseOrder(comparator));
    }
    else {
      Collections.sort(records, comparator);
    }
    logger.debug("Sort: " + sort);
    logger.debug("Comparator: " + comparator);
    return records;
  }
}