<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<stripes:layout-definition>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  <html>
    <head>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <title>Address book</title>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath}/js/addressbook.js"></script>
      
    
    </head>
    
    <body>
    <h1>Address book</h1>
      <div>
        <stripes:layout-component name="contents"/>
      </div>
    </body>
  </html>
</stripes:layout-definition>