package com.rognlien.ujamaa.persist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.rognlien.ujamaa.model.Record;
import com.thoughtworks.xstream.XStream;

public class RecordXmlPersister {
  protected static Logger logger = Logger.getLogger("com.rognlien.ujamaa");
  
  
  private XStream xstream;
  private File file;
  
  public RecordXmlPersister() {
    try {
      file = new File(this.getClass().getClassLoader().getResource("/records.xml").toURI());
    }
    catch (URISyntaxException e) {
      logger.error("Could not create persister", e);
    }
    xstream = new XStream();
  }

  @SuppressWarnings("unchecked")
  public Map<Integer, Record> load() {
    Map<Integer, Record> records = new HashMap<Integer, Record>();
    try {
      
      InputStream is = new FileInputStream(file);
      records = (Map<Integer, Record>) xstream.fromXML(is);
      is.close();
    }
    catch(Exception e) {
      logger.error(e);
    }
    return records;
  }
  
  public void persist(Map<Integer, Record> records) {
    try {
      logger.debug("Persisting to file: " + file);
      FileOutputStream fos = new FileOutputStream(file);
      xstream.toXML(records, fos);
      fos.close();
    }
    catch (Exception e) {
      logger.error("Could not persist record", e);
    }
  }
}
