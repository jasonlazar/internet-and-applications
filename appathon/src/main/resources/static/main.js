$("#SelectDistrict").change(function(){
	$.ajax({
		type: "GET",
		url: "api/municipalities/"+$(this).val(),
		contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data){
        	var txt="";
        	data.result.forEach( function(value, index, array){
        		txt = txt + "<option value=" + value + ">"+ value +"</option>\n"
        	});
        	txt = txt + '<option value="total">ΣΥΝΟΛΟ</option>\n'
        	$("#SelectMunicipality").html(txt);
        },
		error: function (e) {
			console.log("ERROR: " + e);
		}
	});
});

