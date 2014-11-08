<%@include file="includes/include.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Room Ansicht</h1>
	</div>
<!-- /.col-lg-12 -->
</div>

<a href="javascript:openEventsCenturyModal()" title="Add Century">
	                <i class="fa fa-plus-circle fa-fw"></i>Zenturie auswählen
	                	</a>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Wochenansicht
			</div>
			<div class="panel-body">
				<div id="calendar"></div>
			</div>
		</div>
	</div>
<!-- /.col-lg-12 -->
</div>
	                	
	                	
<c:import url="../includes/eventsCenturyModal.jsp"/>