package com.rognlien.ujamaa;

import net.sourceforge.stripes.action.*;

public abstract class AbstractActionBean implements ActionBean {
  private ActionBeanContext context;
  
  public ActionBeanContext getContext() { return context; }
  public void setContext(ActionBeanContext context) { 
    this.context = context; }
}