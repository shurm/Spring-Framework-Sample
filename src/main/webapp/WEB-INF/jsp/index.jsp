<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix = "ex" uri = "../custom.tld"%>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Mike's Spring App</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
	    /* Pattern styles */
		.container 
		{
		  display: table;
		  width: 100%;
		}
		
		.carousel-content 
		{
		    color:white;
		    display:flex;
		    align-items:left;
		}
		
		#text-carousel 
		{
			width: 100%;
			height: auto;
		  
			padding-left:10px;
		  
			padding-top: 13px;
		}
		
		.left-half 
		{
			 position: absolute;
			 left: 0px;
			 width: 50%;
			 border-top-style:solid;
			  
			  
			 border-radius: 5px;
		}
		
		.right-half 
		{
		  	position: absolute;
		  	right: 0px;
		  	width: 50%;
		 	padding-left: 20px;
		  
		  	border-top-style:solid;
		  	border-left-style:solid;
		  
    	  	border-radius: 5px;
		}
		
		thead 
		{
			background: #395870;
			color: #fff;
		}
		
		h3
		{
			background-color: lightgrey;
		}
    </style>
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<div class="jumbotron">
		<h2 style="padding-left:20px"><b>Sample Spring boot WebApp with embedded Apache Derby Database</b></h2>   
	</div>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="container-fluid">
			    <div id="text-carousel" class="carousel slide" data-ride="carousel">
				    
				    <div class="row">
				            <div class="carousel-inner">
				                <div class="item active">
				                    <div class="carousel-content">
				                        <div>
				                            <p>Filling out field(s) and pressing Submit will insert data into Apache Derby Database using the Java Spring Framework.</p>
				                        </div>
				                    </div>
				                </div>
				                <div class="item">
				                    <div class="carousel-content">
				                        <div>
				                            <p>Database is hosted inside Eclipse, so when Web App is terminated the data will be lost.</p>
				                        </div>
				                    </div>
				                </div>
				                <div class="item">
				                    <div class="carousel-content">
				                        <div>                          
				                            <p>Simply add new fields to the Person.java class and rerun the application, to add those fields to the database</p>
				                        </div>
				                    </div>
				                </div>
				                
				            </div>
				            
				    </div>
				</div>
  			</div>
		</div>
	</div>
	
	
	
	<div class="container">
		<div class="table-responsive left-half">
			<h3>Data Inside Apache Database</h3>
			<table class="table table-striped table-bordered text-left">
				<thead>
					<tr>
					<c:forEach var="column" items="${columns}">
						<td>${fn:toUpperCase(column)}</td>
					</c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="person" varStatus = "status" items="${people}">
					 	<tr ${status.first ? 'style = "background-color:yellow"' : ''}>
						 	<c:forEach var="column" items="${columns}">
								<td><ex:Hello person = "${person}"  column = "${column}"> </ex:Hello></td>
							</c:forEach>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
		</div>
	
		<div class="right-half">
		<h3>Add a new Entry</h3>
			<form action="/" method="post">
			
				<c:forEach var="column" items="${columns}">
					<p>${fn:toUpperCase(column)}</p>
					<input type="text" name="${column}" required>
					<br>
				</c:forEach>
				<br>
				<input type="submit">
			</form> 
		</div>
	</div>
	<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
</body>
</html>
