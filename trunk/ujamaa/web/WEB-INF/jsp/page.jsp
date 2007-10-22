<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib uri="http://packtag.sf.net" prefix="pack"%>

<stripes:layout-definition>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html>
	<head>
	  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	  <title>Address book</title>
	  <link rel="stylesheet" type="text/css" href="css/main.css" />
	  <%-- 
	  <script type="text/javascript" src="js/jquery.js"></script>
	  <script type="text/javascript" src="js/addressbook.js"></script>
	  --%>
	  
	  
	  
	  <c:set var="scripts" value="js/nrk/prototype.js:js/nrk/scriptaculous.js:js/nrk/1.11924!ticker.js:js/nrk/1.11926!logger.js:js/nrk/1.13577!tmv11.js:js/nrk/1.1655067!tmflashv11.js:js/nrk/1.4046!multimedia.js:js/nrk/1.4047!menu.js:js/nrk/1.4048!lib.js:js/nrk/1.4049!topline.js:js/nrk/1.4050!flashdetector.js:js/nrk/1.656684!flashrunner.js:js/nrk/1.880637!domLib.js:js/nrk/1.880638!domTT.js:js/nrk/1.880641!domTT_drag.js:js/nrk/1.880708!fadomatic.js" />
	  
	  <%-- 
	  <c:forTokens var="script" items="js/nrk/prototype.js:js/nrk/scriptaculous.js:js/nrk/1.11924!ticker.js:js/nrk/1.11926!logger.js:js/nrk/1.13577!tmv11.js:js/nrk/1.1655067!tmflashv11.js:js/nrk/1.4046!multimedia.js:js/nrk/1.4047!menu.js:js/nrk/1.4048!lib.js:js/nrk/1.4049!topline.js:js/nrk/1.4050!flashdetector.js:js/nrk/1.656684!flashrunner.js:js/nrk/1.880637!domLib.js:js/nrk/1.880638!domTT.js:js/nrk/1.880641!domTT_drag.js:js/nrk/1.880708!fadomatic.js" delims=":">
	    <script type="text/javascript" src="${script}"></script>
	  </c:forTokens>
	  --%>
	  
	  <script type="text/javascript" src="/compactresource/${scripts}"></script>
	  

	</head>

	<body>
	<h1>Address book</h1>
	<div class="canvas">
	  <div class="container">
	
	<stripes:form class="search left" beanclass="com.rognlien.ujamaa.RecordListActionBean">
    <stripes:text name="filter" size="16" />
    <stripes:submit name="List" value="Search"/>
	</stripes:form>
	
	<ul class="buttons right">
	  <li><stripes:link beanclass="com.rognlien.ujamaa.RecordListActionBean">List</stripes:link></li>
	  <li><stripes:link beanclass="com.rognlien.ujamaa.RecordEditActionBean" event="create">New</stripes:link></li>
	</ul>
	<br />
	
	
	

	  <stripes:layout-component name="contents" />
	  </div>
	</div>
	</body>
	</html>
</stripes:layout-definition>