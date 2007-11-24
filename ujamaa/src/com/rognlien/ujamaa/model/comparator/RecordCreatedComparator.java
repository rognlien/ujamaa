package com.rognlien.ujamaa.model.comparator;

import com.rognlien.ujamaa.model.Record;


public class RecordCreatedComparator extends RecordComparator {
  public int compare(Record r1, Record r2) {
    return r1.getCreated().compareTo(r2.getCreated());
  }
}