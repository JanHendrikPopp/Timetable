<%@ include file="include.jsp"%>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Timetable v1.0</a>
    </div>
    <!-- /.navbar-header -->

    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li class="active">
                    <a href="#"><i class="fa fa-calendar fa-fw"></i> <s:text name="nav.events"/><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="ShowEventList.action"><i class="fa fa-list fa-fw"></i> <s:text name="nav.events.overview"/></a>
                        </li>
                        <li>
                            <a href="AddEvent.action"><i class="fa fa-pencil fa-fw"></i> <s:text name="nav.events.create"/></a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li class="active">
                    <a href="#"><i class="fa fa-database fa-fw"></i> <s:text name="nav.week"/><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="ShowRoomEvents.action"><i class="fa fa-home fa-fw"></i> <s:text name="nav.rooms"/></a>
                        </li>
                       <li>
                            <a href="ShowLecturerEvents.action"><i class="fa fa-user fa-fw"></i> <s:text name="nav.lecturers"/></a>
                        </li>
                        <li>
                            <a href="ShowCenturyEvents.action"><i class="fa fa-users fa-fw"></i> <s:text name="nav.centuries"/></a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li class="active">
                    <a href="#"><i class="fa fa-database fa-fw"></i> <s:text name="nav.data"/><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="ShowRoomList.action"><i class="fa fa-home fa-fw"></i> <s:text name="nav.rooms"/></a>
                        </li>
                       <li>
                            <a href="ShowLecturerList.action"><i class="fa fa-user fa-fw"></i> <s:text name="nav.lecturers"/></a>
                        </li>
                        <li>
                            <a href="ShowCenturyList.action"><i class="fa fa-users fa-fw"></i> <s:text name="nav.centuries"/></a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>