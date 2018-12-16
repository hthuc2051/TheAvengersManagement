
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Untitled Document</title>
        <link href="/SE63155_Jarvis/css2/mission_detailsPage.css" rel="stylesheet" type="">
        <script>

            function checkDate()
            {
                var x = document.getElementsByName("startDate")[0].value;
                var y = document.getElementsByName("endDate")[0].value;
                if (x > y) {
                    document.getElementById("dateStatus").style.display = "block";
                    event.preventDefault();
                } else {
                    document.getElementById("dateStatus").style.display = "none";
                }

            }
            function openWeaponsDetails() {
                document.getElementById("weaponsOverlay").style.display = "block";
            }
            ;
            function closeWeaponsDetails() {
                document.getElementById("weaponsOverlay").style.display = "none";
            }
            ;
        </script>
    </head>
    <body>
        <p id="line1">.</p>
        <p id="line2">.</p>
        <p class="form-title">Mission's details</p>
        <%@include file="mission_detailsForm.jsp" %>
        <p id="dateStatus" >*Start date must > End date</p>	
        <button onClick="openWeaponsDetails();" class="but" id="but-Details">!</button>
    </body>
</html>
