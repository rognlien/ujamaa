<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<stripes:layout-render name="/WEB-INF/jsp/page.jsp">
  
  <stripes:layout-component name="contents">
    <stripes:errors/>
        
    <ul class="tabs narrowtabs">
      <li class="${actionBean.filter == '*' ? 'selected' : ''}">
        <stripes:link beanclass="com.rognlien.ujamaa.RecordListActionBean">All
          <stripes:param name="filter">*</stripes:param>
          <stripes:param name="sort" value="${actionBean.sort}"/>
          <stripes:param name="reverse" value="${actionBean.reverse}" />
        </stripes:link>
      </li>
      <c:forTokens items="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,æ,ø,å" delims="," var="letter">
        <c:set var="filter" value="${letter}*"/>
        <li class="${actionBean.filter == filter ? 'selected' : ''}">
          <stripes:link beanclass="com.rognlien.ujamaa.RecordListActionBean">${letter}
            <stripes:param name="filter">${letter}*</stripes:param>
            <stripes:param name="sort" value="${actionBean.sort}"/>
            <stripes:param name="reverse" value="${actionBean.reverse}" />
          </stripes:link>
        </li>
      </c:forTokens>
    </ul>
    <br />

    <div class="content">

    <table class="list">
      <thead>
        <tr>
          <th>
            <stripes:link class="${actionBean.reverse?'desc':'asc'}" beanclass="com.rognlien.ujamaa.RecordListActionBean">
              <stripes:param name="sort" value="name"/>
              <stripes:param name="filter" value="${actionBean.filter}" />
              <stripes:param name="reverse" value="${!actionBean.reverse}" />
              Name
            </stripes:link>
          </th>
          <th>Address</th>
          <th>
            <stripes:link class="${actionBean.reverse?'desc':'asc'}" beanclass="com.rognlien.ujamaa.RecordListActionBean">
              <stripes:param name="sort" value="created"/>
              <stripes:param name="filter" value="${actionBean.filter}" />
              <stripes:param name="reverse" value="${!actionBean.reverse}" />
              Created
            </stripes:link>
          </th>
          <th></th>
        </tr>
      </thead>
      
      <tbody>
      
      <c:forEach items="${actionBean.records}" var="r" varStatus="loop">
        <tr class="${loop.count%2==0 ? '' : 'odd'}" id="${r.id}">
          <td class="f">${r.name}</td>
          <td>${r.address.street} ${r.address.code} ${r.address.place}</td>
          <td>${r.created}</td>
          <td>
            <stripes:link href="/edit.action">Edit
              <stripes:param name="record.id" value="${r.id}" />
            </stripes:link>
          </td>
          
          
        </tr>
      </c:forEach>
      </tbody>
    </table>
    </div>
    
  </stripes:layout-component>
</stripes:layout-render>