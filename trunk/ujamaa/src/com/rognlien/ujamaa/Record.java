package com.rognlien.ujamaa;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Record {
  private int id;
  private String name;
  private Date created;
  private Address address;
  private List<Detail> details;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  
  public List<Detail> getDetails() {
    return details;
  }
  public void setDetails(List<Detail> details) {
    this.details = details;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}