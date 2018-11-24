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
                    <a href="#">Dashboard</a>
                </li>
                <li>
                    <a href="plans">Subscribe Plan</a>
                </li>
                <li>
                    <a href="#">My Plan</a>
                </li>
                <li>
                    <a href="/feedback">Provide Feedback</a>
                </li>
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Services</a>
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
            	
            	
            	<c:when test="${mode=='MODE_HOME' }">
            	
		            <div class="container-fluid">
		       
		                <h1>Simple Sidebar</h1>
		                <p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will appear/disappear. On small screens, the page content will be pushed off canvas.</p>
		                <p>Make sure to keep all page content within the <code>#page-content-wrapper</code>.</p>
		        		       
		                ${stud.id }
		                <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
		            </div>
	         	</c:when>
	         	
	         	
	         	<c:when test="${mode=='MODE_HOME_FEEDBACK' }">
            	
		            <div class="container-fluid">
		       
		                <h1>We have Saved your Responses</h1>
		                <p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will appear/disappear. On small screens, the page content will be pushed off canvas.</p>
		                <p>Make sure to keep all page content within the <code>#page-content-wrapper</code>.</p>
		        		       
		                ${stud.id }
		                <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
		            </div>
	         	</c:when>
	         	
	         	
	         	 
	         	
	         <c:when test="${mode=='MODE_PROVIDE_FEEDBACK' }">
	         <div class="container-fluid">
		                <h1>Please Provide your Valuable Feedback</h1>
		                <form class="form-horizontal" method="POST" action="savefeedback">
		                <div class="form-group">
		                <label class="control-label col-md-3">Description</label>
		                </div>
		                <div class="col-md-3">
							<input type="text" class="form-control" name="description" required placeholder="Provide your feedback here">
		                </div>
		               
		                <div>
		               Your Feedback is very Important, it will help us in improving our services.
		                
		                
		                
		                </div>
		                <div>
		                <input type="submit" class="btn btn-primary" value="Submit Feedback">
		                </div> 
		                </form>
		                
		                
		                <br>
		                <br>
		                <br>
		        
		                <br>
		                <br>
		               
		                
		                <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
		            </div>
			</c:when>
	         
            
            
            	<c:when test="${mode=='MODE_LIST_PLANS' }">
		            <div class="container-fluid">
		                <h1>List of Plans</h1>
		           
				<!-- Plans -->
    <section id="plans">
        <div class="container">
            <div class="row">

                <!-- item -->
                
                <c:forEach var="plan" items="${plans}">
                <div class="col-md-4 text-center">
                    <div class="panel panel-danger panel-pricing">
                        <div class="panel-heading">
                            <i class="fa fa-desktop"></i>
                            <h3>Plan ${plan.id}</h3>
                        </div>
                        <div class="panel-body text-center">
                            <p><strong>INR ${plan.amount} / Month</strong></p>
                        </div>
                        <ul class="list-group text-center">
                            <li class="list-group-item"><i class="fa fa-check"></i> ${plan.type}</li>
                            <li class="list-group-item"><i class="fa fa-check"></i> ${plan.type}</li>
                            <li class="list-group-item"><i class="fa fa-check"></i> ${plan.type}</li>
                        	
                        </ul>
                        <div class="panel-footer">
                            <a class="btn btn-lg btn-block btn-danger" href="/plans/${plan.id}">Details</a>
                        </div>
                    </div>
                </div>
                <!-- /item -->
				</c:forEach>


            </div>
        </div>
    </section>
    <!-- /Plans -->
				
							
		                
		                <br/><br/><br/>
		                <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
		            </div>
	         	
	         	
	         	</c:when>
	         	
	         
	         	
	         	<c:when test="${mode=='MODE_SUBSCRIBE_PLAN' }">
		            <div class="container-fluid">
		                <h1>Subscribe Plan</h1>
		           
				<!-- Plan -->
			    <section id="plans">
			        <div class="container">
			            <div class="row">

                <!-- item -->
                
                
	                <div class="col-md-4 text-center">
	                    <div class="panel panel-danger panel-pricing">
	                        <div class="panel-heading">
	                            <i class="fa fa-desktop"></i>
	                            <h3>Plan ${plan.id}</h3>
	                        </div>
	                        <div class="panel-body text-center">
	                            <p><strong>INR ${plan.amount} / Month</strong></p>
	                        </div>
	                        <ul class="list-group text-center">
	                            <li class="list-group-item"><i class="fa fa-check"></i> ${plan.type}</li>
	                            <li class="list-group-item"><i class="fa fa-check"></i> ${plan.type}</li>
	                            <li class="list-group-item"><i class="fa fa-check"></i> ${plan.type}</li>
	                        	
	                        </ul>
	                        
	                    </div>
	                </div>
                
                <!-- /item -->
                
                <div class="col-md-4 text-center">
                
                <div class="container-fluid">
		                <h1>Simple Sidebar</h1>
		                <p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will appear/disappear. On small screens, the page content will be pushed off canvas.</p>
		                <p>Make sure to keep all page content within the <code>#page-content-wrapper</code>.</p>
		               
		         <!--  <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>-->

		      
			 	<form class="form-horizontal" method="POST" action="/subscribe-plan">
								
						<div class="form-group">
							<label class="control-label col-md-3"></label>
							<div class="col-md-7">
								<input type="hidden" class="form-control" name="planId"
									value="${plan.id }" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-3"></label>
							<div class="col-md-7">
								<input type="hidden" class="form-control" name="studentId"
									value="${stud.id}" />
							</div>
						</div>						
						
						<c:if test="${subscribed=='true' }">
						<div class="input-group mb-3">
						  <input type="text" name="duration" class="form-control" placeholder="Duration in Months" aria-label="Recipient's username" aria-describedby="basic-addon2">
						  <div class="input-group-append">
						    <button class="btn btn-outline-secondary" type="submit">Buy Now</button>
						  </div>
						</div>
						</c:if>
						
						<c:if test="${subscribed=='false' }">
						<p>You are already subscribed </p>
						</c:if>
						
	
				</form>
		      
		                
		            </div>
                
                </div>
				

            </div>
        </div>
    </section>
    <!-- /Plans -->
				
							
		                
		                <br/><br/><br/>
		                <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>

		            </div>
	         	
	         	
	         	</c:when>
	         
	         
	         
	         
            	<c:when test="${mode=='MODE_MY_PLAN' }">
		            <div class="container-fluid">
		                <h1>Simple Sidebar</h1>
		                <p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will appear/disappear. On small screens, the page content will be pushed off canvas.</p>
		                <p>Make sure to keep all page content within the <code>#page-content-wrapper</code>.</p>
		               
		                ${stud.id }
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
