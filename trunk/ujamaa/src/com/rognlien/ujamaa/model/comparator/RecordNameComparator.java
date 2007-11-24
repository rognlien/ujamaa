package com.rognlien.ujamaa.model.comparator;

import com.rognlien.ujamaa.model.Record;


public class RecordNameComparator extends RecordComparator {
  public int compare(Record r1, Record r2) {
    return r1.getName().compareTo(r2.getName());
  }
}