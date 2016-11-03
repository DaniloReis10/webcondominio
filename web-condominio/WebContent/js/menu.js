var listMenuItens = document.getElementsByClassName("menu-item");

var flagSubmenuCad = false;
var flagSubmenuRel = false;

var onClickMenu = function(event) {

	var menuName = event.path[0].innerHTML;

	var submenuCad = document.getElementById("submenu-cad");
	var submenuRel = document.getElementById("submenu-rel");

	if(menuName == "Cadastros") {

		if(flagSubmenuCad){
			submenuCad.style.display = "none";
			flagSubmenuCad = false;
		} else {
			submenuCad.style.display = "flex";
			flagSubmenuCad = true;
		}

		submenuRel.style.display = "none";
		submenuCad = false;

	} else if(menuName == "Relatórios") {

		if(flagSubmenuRel){
			submenuRel.style.display = "none";
			flagSubmenuRel = false;
		} else {
			submenuRel.style.display = "flex";
			flagSubmenuRel = true;
		}

		submenuCad.style.display = "none";
		flagSubmenuCad = false;

	}

}

// Add event
for (var i = 0; i < listMenuItens.length; i++) {
	listMenuItens[i].addEventListener("click", onClickMenu);
}
	

