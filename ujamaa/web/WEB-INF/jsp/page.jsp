<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>


<stripes:layout-definition>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html>
	<head>
	  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	  <title>Address book</title>
	  <link rel="stylesheet" type="text/css" href="css/main.css" />

	  <script type="text/javascript" src="js/jquery.js"></script>
	  <script type="text/javascript" src="js/addressbook.js"></script>

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