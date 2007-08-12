<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<stripes:layout-render name="/WEB-INF/jsp/page.jsp">
  <stripes:layout-component name="contents">
    <stripes:errors/>
      
    <stripes:form action="/edit.action">
      <stripes:hidden name="record.id" />
          
      <label>Name:</label>
      <stripes:text name="record.name" size="48" />
      <br />

      <stripes:submit name="save" value="Save"/>
      <!--  
      <stripes:submit name="delete" value="Delete"/>
      -->
    </stripes:form>
  </stripes:layout-component>
</stripes:layout-render>