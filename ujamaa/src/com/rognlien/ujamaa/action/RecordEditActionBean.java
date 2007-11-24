package com.rognlien.ujamaa.action;


import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;

import com.rognlien.ujamaa.model.Record;


@UrlBinding("/edit.action")
public class RecordEditActionBean extends AbstractActionBean {
  private RecordManager recordManager;
  private Record record;
  
  
  public RecordEditActionBean() {
    recordManager = new RecordManager();
  }
  
  public Record getRecord() {
    return record;
  }

  @ValidateNestedProperties({
    @Validate(field="name", required=true, maxlength=64)
   ,@Validate(field="address.street", maxlength=20)
   ,@Validate(field="address.code", mask="\\d{4}")
   ,@Validate(field="address.street", maxlength=256)
  })
  public void setRecord(Record record) {
    this.record = record;
  }
  
  
  /* Handler methods */
  
  @DefaultHandler
  @DontValidate
  public Resolution edit() throws Exception {
    this.record = recordManager.retrieve(record.getId());
    return new ForwardResolution("/WEB-INF/jsp/edit.jsp");
  }

  
  @DontValidate
  public Resolution create() throws Exception {
    return new ForwardResolution("/WEB-INF/jsp/edit.jsp");
  }


  public Resolution save() throws Exception {
    logger.info("Saving record");
    recordManager.store(record);
    return new RedirectResolution(RecordListActionBean.class);
  }

  @DontValidate
  public Resolution delete() throws Exception {
    logger.info("Deleting record");
    recordManager.delete(record.getId());
    return new RedirectResolution(RecordListActionBean.class);
  }
  
  
  
  
  
  
  

  /* Custom validation method
  @ValidationMethod(on="reset")
  public void validateReset(ValidationErrors errors) {
    errors.addGlobalError(new SimpleError("Password please"));
  }
  */

}