<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title> Laundro-Valley|Home</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/simple-sidebar.css" rel="stylesheet">
    <link href="/css/style_table.css" rel="stylesheet">
    
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>    
    
    

</head>

<body>

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                
                    <a href="home">
                        Laundro-Valley
                    </a>
                </li>
                <li>
                    <a href="/washes">List Washes</a>
                </li>
                <li>
                    <a href="plans">Feedbacks</a>
                </li>
                <li>
                    <a href="#"></a>
                </li>
             
                <li>
                    <a href="/logout">Logout</a>
                </li>
            </ul>
        </div>
        
        
        
        <!-- /#sidebar-wrapper -->
        <!-- Page Content -->
        <div id="page-content-wrapper">
			
			<c:choose>
            	
            	
            	<c:when test="${mode=='MODE_STAFF_HOME' }">
            	
		            <div class="container-fluid">
		       
		                <h1>Simple Sidebar</h1>
		                <p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will appear/disappear. On small screens, the page content will be pushed off canvas.</p>
		                <p>Staff <code>#page-content-wrapper</code>.</p>
		        		       
		               
		                <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
		            </div>
	         	</c:when>
	         	
	         	<c:when test="${mode=='MODE_STAFF_LIST_WASH' }">
            	
		            <div class="container-fluid">
		       
		                <h1>List of Washes</h1>
		         
		         <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Student Id</th>
      <th scope="col">Scheduled Date</th>
      <th scope="col">Quantity</th>
      <th scope="col">Status</th>
	  <th scope="col">Change Status</th>
    </tr>
  </thead>
  <tbody>
   	         <c:forEach var="wash" items="${washes}">
    <tr>
     
      <th scope="row">${wash.washid}</th>
      <td>${wash.studentId}</td>
      <td>${wash.scheduledDate}</td>
      <td>${wash.quanitity}</td>
      <td>${wash.status}</td>
      <td>
      	<form method="POST" action="/change-status">
      		<input type="hidden" name="washId" value="${wash.washid}" />
      		<input type="hidden" name="studentId" value="${wash.studentId}" />
	      	<select name="status">
	  			<option value="ongoing">Ongoing</option>
	  			<option value="completed">Completed</option>
	  		</select>
	    	
	    	<button class="btn btn-outline-secondary" type="submit">Change</button>
      	</form>
      </td>
      
    
    </tr>
    </c:forEach>	       
  </tbody>
</table>
		       
		        
		        
		               
		                <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
		            </div>
	         	</c:when>
	         	
	         	</c:choose>
	         	
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Bootstrap core JavaScript -->
    <script src="/vendor/jquery/jquery.min.js"></script>
    <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body>

</html>
