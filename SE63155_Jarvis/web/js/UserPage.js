
function openProfileNav() {
    document.getElementById("profileNav").style.width = "100%";
}
;

function closeProfileNav() {
    document.getElementById("profileNav").style.width = "0%";
}
;
function openMissionNav() {
    document.getElementById("missionNav").style.width = "100%";
}

function closeMissionNav() {
    document.getElementById("missionNav").style.width = "0";
}
function openArmorUseNav() {
    document.getElementById("armorUseNav").style.width = "100%";
}

function closeArmorUseNav() {
    document.getElementById("armorUseNav").style.width = "0";
}
var status = 0;
function menuControl() {
    var x = document.getElementsByClassName("cn-wrapper");
	var but = document.getElementById("cn-button");
    if (status == 1) {
		x[0].style.transform = "translateY(0px)";
		but.innerHTML="-";
		status = 0;
    } else {
		x[0].style.transform = "translateY(180px)";
		but.innerHTML="+";
		status = 1;
    }
}


