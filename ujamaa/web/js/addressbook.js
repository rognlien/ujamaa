$(document).ready(function() {
   $("table.list tbody tr").dblclick(function() {    
     window.location = 'edit.action?_sourcePage=%2Forderlist.jsp&edit=&record.id=' + $(this).attr("id");
   });
   $("table.list tbody tr").mouseover(function() {    
     $(this).addClass("hover");
   });
   $("table.list tbody tr").mouseout(function() {    
     $(this).removeClass("hover");
   });
   
   $("input[@name=delete]").click(function() {    
     return confirm("Are you sure?");
   });
});