package com.rognlien.ujamaa.model;

import java.util.Comparator;


public class RecordCreatedComparator implements Comparator<Record> {
  public int compare(Record o1, Record o2) {
    return o1.getCreated().compareTo(o2.getCreated());
  }
}