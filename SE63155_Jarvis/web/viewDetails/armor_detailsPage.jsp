<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Armor Page</title>
        <link href="/SE63155_Jarvis/css2/armor_detailsPage.css" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script>

            function openMartialsDetails() {
                document.getElementById("materialsOverlay").style.display = "block";
            }
            ;
            function closeMartialsDetails() {
                document.getElementById("materialsOverlay").style.display = "none";
            }
            ;

            function openWeaponsDetails() {
                document.getElementById("weaponsOverlay").style.display = "block";
            }
            ;
            function closeWeaponsDetails() {
                document.getElementById("weaponsOverlay").style.display = "none";
            }
            ;

            // the selector will match all input controls of type :checkbox
            // and attach a click event handler 
            $(".radio").on('click', function () {
                // in the handler, 'this' refers to the box clicked on
                var $box = $(this);
                if ($box.is(":checked")) {
                    // the name of the box is retrieved using the .attr() method
                    // as it is assumed and expected to be immutable
                    var group = "input:checkbox[name='" + $box.attr("name") + "']";
                    // the checked state of the group/box on the other hand will change
                    // and the current value is retrieved using .prop() method
                    $(group).prop("checked", false);
                    $box.prop("checked", true);
                } else {
                    $box.prop("checked", false);
                }
            });
        </script>
    </head>
    <body>
        <p id="line1">.</p>
        <p class="form-title">Armor's details</p>
        <img id="armor-img" src="/SE63155_Jarvis/uploads/<s:property value="%{armorDTO.image}" />">
        <%@include file="armor_detailsForm.jsp" %>
        <script>
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $("#armor-img").attr("src", e.target.result);
                    }
                    reader.readAsDataURL(input.files[0]);
                }
            }
            $("#file").change(function () {
                readURL(this);
            });
        </script>
        <button onClick="openWeaponsDetails();" class="but">!</button>
    </body>
</html>


