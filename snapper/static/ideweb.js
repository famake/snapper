var allTags = [];

function C(programmingLanguage) {
	return {"name": programmingLanguage, "func": null};
};

function load() {
	function alertMe(i, x) {
		alert(x);
	}

	var alle = $( "#tags > option" );
	for (var i=0; i<alle.length; i++) {
		allTags.push(alle[i].innerHTML);
	}
	$("#nextTag").autocomplete({
		source: allTags
	});
	
	var c = C("Java");
	var python = C("Python");
	
	var b = function(x) { alert ("moo " + x); };

	$("#nextTag").on("keypress", blockEnter);
	$("#nextTag").on("keyup", nextTagKey);
}

function blockEnter(e) {
	if (e.which == 13) { // enter
		return false;
	}
}

function nextTagKey(e) {
	if (e.which == 13) { // enter
		var elem = document.createElement("span");
		var tag = $("#nextTag").val();
		elem.id = "tag_" + tag;
		elem.classList.add("tag");
		elem.innerHTML = tag;
		$("#selectedTags").append(elem);
		$("#nextTag").val("");
		return false;
	}
}


$( load );