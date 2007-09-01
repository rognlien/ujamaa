package com.rognlien.ujamaa;

import java.util.Comparator;


public class RecordNameComparator implements Comparator<Record> {
  public int compare(Record o1, Record o2) {
    return o1.getName().compareTo(o2.getName());
  }
}