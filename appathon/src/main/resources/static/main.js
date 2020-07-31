$("#search-form").submit(function(event) {
	// Disable the search button
	enableSearchButton(false);
	// Prevent the form from submitting via the browser.
	event.preventDefault();
	searchViaAjax();
});

function searchViaAjax(){
	var dis = $("#SelectDistrict").val();
	var mun = $("#SelectMunicipality").val();
	
	$.ajax({
		type: "GET",
		url: "api/distribution/"+dis+"/"+mun,
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function (data){
			display(data, mun);
		},
		error: function (e){
			console.log(e);
		},
		done: function(e){
			enableSearchButton(true);
		}
	});
}

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

function display(res, mun){
	var result = "<h4>ΨΗΦΟΦΟΡΟΙ ΔΗΜΟΥ " + mun + "</h4>\n";
	result = result + "<table>\n<tr>\n\t<th>Άνδρες</th><th>Γυναίκες</th><th>Σύνολο</th></tr>\n";
	result = result + "<tr>\n\t<td>"+res.men+"</td><td>"+res.women+"</td><td>"+res.total+"</td></tr>";
	result = result + "</table>";
	$("#result").html(result);
}