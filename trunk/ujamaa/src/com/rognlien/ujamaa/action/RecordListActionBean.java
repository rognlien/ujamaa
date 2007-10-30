package com.rognlien.ujamaa.action;

import java.util.List;

import com.rognlien.ujamaa.model.Record;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;


@UrlBinding("/list.action")
public class RecordListActionBean extends AbstractActionBean {
  private RecordManager recordManager;
  
  private String query;
  private String filter;
  private String sort;
  private boolean reverse;
  
  private List<Record> records;
  
  
  public RecordListActionBean() {
    recordManager = new RecordManager();
  }
  
  
  @DefaultHandler
  public Resolution list() throws Exception {
    records = recordManager.list(filter, sort, reverse);
    return new ForwardResolution("/WEB-INF/jsp/list.jsp");
  }
  
  

  public List<Record> getRecords() {
    return records;
  }


  public void setRecords(List<Record> records) {
    this.records = records;
  }


  public String getFilter() {
    return filter;
  }


  public void setFilter(String filter) {
    this.filter = filter;
  }


  public String getSort() {
    return sort;
  }


  public void setSort(String sort) {
    this.sort = sort;
  }


  public boolean isReverse() {
    return reverse;
  }


  public void setReverse(boolean reverse) {
    this.reverse = reverse;
  }


  public String getQuery() {
    return query;
  }


  public void setQuery(String query) {
    this.query = query;
  }
}