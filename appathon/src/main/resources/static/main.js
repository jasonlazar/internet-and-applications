$("#search-form").submit(function(event) {
	// Disable the search button
	enableSearchButton(false);
	// Prevent the form from submitting via the browser.
	event.preventDefault();
	console.log($("#SelectDistrict").val());
	console.log($("#SelectMunicipality").val());
});

$("#SelectDistrict").change(function(){
	$.ajax({
		type: "GET",
		url: "api/municipalities/"+$(this).val(),
		contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data){
        	var txt="";
        	data.result.forEach( function(value, index, array){
        		txt = txt + '<option value="' + value + '">'+ value +"</option>\n"
        	});
        	txt = txt + '<option value="total">ΣΥΝΟΛΟ</option>\n'
        	$("#SelectMunicipality").html(txt);
        },
		error: function (e) {
			console.log("ERROR: " + e);
		}
	});
});

function enableSearchButton(flag) {
	$("#btn-search").prop("disabled", flag);
}