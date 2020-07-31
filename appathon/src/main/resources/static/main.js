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
			createPieChart(data, mun);
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

function createPieChart(res, mun){
	var chart = new CanvasJS.Chart("chartContainer", {
		backgroundColor: "#EAE7DC",
		animationEnabled: true,
		title: {
			text: "ΨΗΦΟΦΟΡΟΙ ΔΗΜΟΥ " + mun
		},
		subtitles: [{
			text: "Σύνολο ψηφοφόφορων: " + res.total,
			fontSize: 16
		}],
		data: [{
			type: "pie",
			indexLabelFontSize: 18,
			startAngle: 90,
			radius: 80,
			indexLabel: "{label} - {y}",
			dataPoints: [
				{ y: res.men, label: "Άνδρες" },
				{ y: res.women, label: "Γυναίκες"},
			]
		}]
	});
	chart.render();
}