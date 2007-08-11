package com.rognlien.ujamaa;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;


@UrlBinding("/list.action")
public class RecordListActionBean extends AbstractActionBean {
  private List<Record> records;
  
  
  
  @DefaultHandler
  public Resolution list() throws Exception {
    records = RecordManager.list();
    return new ForwardResolution("/WEB-INF/jsp/list.jsp");
  }


  public List<Record> getRecords() {
    return records;
  }


  public void setRecords(List<Record> records) {
    this.records = records;
  }
}