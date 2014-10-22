<%@ include file="../includes/include.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<%-- The application's main template --%>
<!DOCTYPE html>
	<head>
		<title><tiles:insertAttribute name="title"/></title>
		
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <!-- Bootstrap Core CSS -->
	    <link href="theme/sb-admin-v2/css/bootstrap.min.css" rel="stylesheet">
	
	    <!-- MetisMenu CSS -->
	    <link href="theme/sb-admin-v2/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
	
		<!-- DataTables CSS -->
    	<link href="theme/sb-admin-v2/css/plugins/dataTables.bootstrap.css" rel="stylesheet">
	    
	    <!-- Custom CSS -->
	    <link href="theme/sb-admin-v2/css/sb-admin-2.css" rel="stylesheet">
	
	    <!-- Custom Fonts -->
	    <link href="theme/sb-admin-v2/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

		<!-- DateTimePicker CSS -->
	    <link href="css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
	
	    <!--[if lt IE 9]>
	        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	    
	    <c:import url="../includes/localization.jsp"/>
	    	
		<s:head/>
	</head>
	<body>
		<div id="wrapper">
			<c:import url="../includes/navigation.jsp" />
			
			<div id="page-wrapper">
				<!-- Content -->	
				<tiles:insertAttribute name="content"/>
            </div>
		</div>
		
		<c:import url="../includes/scripts.jsp"/>

	</body>
	
</html>
