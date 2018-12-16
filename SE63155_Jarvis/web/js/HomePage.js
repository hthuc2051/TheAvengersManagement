function loadContent(i){
		var content = document.getElementsByClassName("insinde-content");
		var menu_bar = document.getElementById("menu-bar");
		var icon = document.getElementsByClassName("icon");
		if(i == 1){
			content[0].style.transform="translateX(0px)";
			menu_bar.style.backgroundColor="rgba(0,0,0,0)";
			icon[0].style.filter="opacity(100%)";
			icon[1].style.filter="opacity(50%)";
			icon[2].style.filter="opacity(50%)";			
		
		}else if(i==2){
			content[0].style.transform="translateX(-1190px)";
			menu_bar.style.backgroundColor="rgba(0,0,0,0.8)";
			icon[0].style.filter="opacity(50%)";
			icon[1].style.filter="opacity(100%)";
			icon[2].style.filter="opacity(50%)";
		
		}else if(i==3){
			content[0].style.transform="translateX(-2380px)";
			menu_bar.style.backgroundColor="rgba(0,0,0,0.8)";
			icon[0].style.filter="opacity(50%)";
			icon[1].style.filter="opacity(50%)";
			icon[2].style.filter="opacity(100%)";
	
		}
	
	};