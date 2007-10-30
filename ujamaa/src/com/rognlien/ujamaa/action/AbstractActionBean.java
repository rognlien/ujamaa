package com.rognlien.ujamaa.action;

import org.apache.log4j.Logger;

import net.sourceforge.stripes.action.*;

public abstract class AbstractActionBean implements ActionBean {
  protected static Logger logger = Logger.getLogger("com.rognlien.ujamaa");
  
  private ActionBeanContext context;
  
  public ActionBeanContext getContext() { return context; }
  public void setContext(ActionBeanContext context) { 
    this.context = context; }
}