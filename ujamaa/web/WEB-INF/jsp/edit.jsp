<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<stripes:layout-render name="/WEB-INF/jsp/page.jsp">
  <stripes:layout-component name="contents">
    <div id="messages">
    <stripes:errors/>
    </div>
      
    <stripes:form beanclass="com.rognlien.ujamaa.action.RecordEditActionBean">
      <div>
      
        <fieldset>
          <legend>Personal</legend>
          <stripes:hidden name="record.id" />
          
          <label>Name:</label>
          <stripes:text name="record.name" size="48" />
          <br />
          
          <label>Birthday:</label>
          <stripes:text name="record.birthday" size="12" />
          <br />
        </fieldset>
        
        <fieldset>
          <legend>Address</legend>
          <label>Street:</label>
          <stripes:text name="record.address.street" size="48" />
          <br />
      
          <label>Code/place:</label>
          <stripes:text name="record.address.code" size="5" />
          <stripes:text name="record.address.place" size="20" />
          <br />
        </fieldset>
        
        <fieldset>
          <legend>Contact information</legend>
          <table>
            <c:set var="numberOfDetails" />
            <c:forEach begin="0" end="2" varStatus="loop">
              <tr>
                <td><img src="${pageContext.request.contextPath}/gfx/icon_remove.gif"/></td>
                <td><img src="${pageContext.request.contextPath}/gfx/icon_add.gif"/></td>
                <td>
                  <stripes:select name="record.details[${loop.index}].type">
                    <stripes:options-enumeration enum="com.rognlien.ujamaa.model.DetailType" />
                  </stripes:select>
                </td>
                <td><stripes:text name="record.details[${loop.index}].value" /></td>
              </tr>
            </c:forEach>
          </table>
        </fieldset>

      </div>
      <stripes:submit name="save" value="Save"/>
      <c:if test="${not empty actionBean.record.id}">
        <stripes:submit name="delete" value="Delete"/>
      </c:if>
    </stripes:form>
  </stripes:layout-component>
</stripes:layout-render>