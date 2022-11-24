/**
 * 
 */
getall();

  	function getall(){
  		$('#t-librarians').dataTable().fnDestroy();
  		$.ajax({
  			url:"GetLibrarianServlet",
  			type: "GET",
  			dataType:"JSON",
  			
  			success:function(data){
  				$('#t-librarians').dataTable({
  					"aaData":data,
  					"scrollX":true,
  					"aoColumns":
  						[
  							{"sTitle": "ID", "mData": "id"},
  							{"sTitle": "First Name", "mData": "firstname"},
  							{"sTitle": "Last Name", "mData": "lastname"},
  							{"sTitle": "Email", "mData": "email"},
  							{"sTitle": "Country", "mData": "country"},
  							{
                                "sTitle":
                                "Edit",
                                "mData": "id",
                                "render" : function(mData,type,row,meta)
                                {
                                    return '<button class="btn btn-success" onclick="get_details('+ mData +')">Edit</button>';
                                },
                          },
                          
                          {
                                "sTitle":
                                "Delete",
                                "mData": "id",
                                "render" : function(mData,type,row,meta)
                                {
                                    return '<button class="btn btn-danger" onclick="get_delete('+ mData +')">Delete</button>';
                                },
                          },
  						]
  				});
  			}
  		});
  	}
  	
  	function viewLibrarianAddPage(){
		window.location.href = "addLibrarianPage.jsp"
	}
  	
  	function backToMainPage(){
		window.location.href = "welcomePage.jsp";
	}
	
	
		function get_details(id){
		 
		 $.ajax({
			url:"GetDetailsLibrarianServlet",
			type:"POST",
			dataType: "JSON",
			data: {"id": id},
			
			success:function(data){
				var id = null;
				var firstname = null;
				var lastname = null;
				var email = null;
				var country = null;
				
				
				for(var i=0; i<data.length; i++){
					id = data[i].id;
					firstname = data[i].firstname;
					lastname = data[i].lastname;
					email = data[i].email;
					country = data[i].country;
				}
				
				localStorage.setItem("first-name", firstname);
				localStorage.setItem("last-name",lastname);
				localStorage.setItem("e", email);
				localStorage.setItem("c", country);
				localStorage.setItem("i", id);
				
				window.location.href = "editLibrarianPage.jsp"
				
			}
		});
	}	
 	

  	function addLibrarian() {
	
		if(validation()){
			d = $("#addLibForm").serialize();
			$.ajax({
				url : "AddLibrarianServlet",
				type: "POST",
				dataType: "JSON",
				data: d
		   });
		  alert("You have successfully added a librarian");
		  getall();
		} else {
			alert("Try again to add a librarian to the system");		
		}
	}
	
	function validation(){
		var firstName = document.getElementById("firstName").value;
		var lastName = document.getElementById("lastName").value;
		var email = document.getElementById("em").value;
		var country = document.getElementById("country").value;
		
		if(firstName === '' || lastName === '' || email === '' || country === ''){
			alert("Something went wrong. Please fill all the fields");
			return false;
		} else {
			return true;
		}
	}
	
	function get_delete(id){
		
		$.ajax({
			url:"DeleteLibrarianServlet",
			type: "POST",
			dataType:"JSON",
			data: {"id": id},
			
			success:function(data){
				alert("You have successfully deleted a librarian");
				getall();
			}
		});
	}

	function editLibrarian(){
		if(validation()){
			d = $("#editLibrarianForm").serialize();
				$.ajax({
				url:"EditLibrarianServlet",
				type:"POST",
				dataType:"JSON",
				data: d,
				
				success:function(data){
					$('#firstName').val("");
                    $('#lastName').val("");
                    $('#em').val("");
                    $('#country').val("");
                   backToMainPage();
				}
			});
			alert("Record Updated Successfully")
			
		} else {
			alert("Try again to edit the librarian to the system");
		}
		
		
	}