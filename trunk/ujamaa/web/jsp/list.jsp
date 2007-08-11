<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<stripes:layout-render name="/WEB-INF/jsp/page.jsp">

  
  <stripes:layout-component name="contents">
    <stripes:errors/>
    <table>
      <thead>
        <tr><th>Id</th><th>Name</th></tr>
      </thead>
      
      <tbody>
      <c:forEach items="${actionBean.records}" var="r" varStatus="loop">
        <tr class="${loop.count%2==0 ? '' : 'odd'}">
          <td>${r.id}</td>
          <td>${r.name}</td>
          <td>
            <stripes:link href="/edit.action">Edit
              <stripes:param name="record.id" value="${r.id}" />
            </stripes:link>
          </td>
          <td><img src="${pageContext.request.contextPath}/gfx/icon_remove.gif"/></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

    
    <stripes:form action="/edit.action">
      <stripes:submit name="create" value="Add a new record"/>
    </stripes:form>
  </stripes:layout-component>
</stripes:layout-render>