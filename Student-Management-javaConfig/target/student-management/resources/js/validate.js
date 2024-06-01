		// Add validation rule for Indian mobile number
		
	// replace(/\s+/g, "")
   // /\s/   This matches any whitespace character, including spaces, tabs, and line breaks.
  //  +      Tt matches one or more whitespace characters.
 //  /g      Global flag, indicates, the re should be applied to all matches in the input string, rather than stopping at the 1st match.
//   replace()   remove all whitespace characters in a string by replacing them with an empty string.

         //  /^(\+?91|0)?[6789]\d{9}$/
		//   ^           This signifies the start of the input string.
	   //   (\+?91|0)    This matches either "+91" or "0" at the beginning of the input string, or none of them at all. 
	  //    ?            The question mark after the parentheses makes the entire group optional.
	 //    [6789]        This matches the first digit of the mobile phone number, which must be a 6, 7, 8, or 9.
	//     \d{9}         This matches the remaining 9 digits of the mobile phone number. 
   //                    The \d represents any digit character,  {9} specifies that there must be exactly 9 of them.
  //       $             This signifies the end of the input string.
  
  
		   $.validator.addMethod("phoneIN", function (phone_number, element) {
		       phone_number = phone_number.replace(/\s+/g, "");
		       return this.optional(element) || phone_number.length > 9 &&
		           phone_number.match(/^(\+?91|0)?[6789]\d{9}$/);
		   }, "Please enter a valid Indian mobile number");


$(document).ready(function() {
	   $("#form").validate({
		  		 
		 //target name attibute
		   rules: {
			     rollno: {
			    	 required:true,
		             digits:true	    	 
			     },
			     fname:{
			    	 required:true,
			         lettersonly:true,
			         minlength:2,
			         maxlength:20    	 
			     },
			     lname:{
			    	 required:true,
		             lettersonly:true,
		             minlength:1,
		             maxlength:20    	 
			     },
			     dob:{
			    	 required:true,
			         date:true    	 
			     },
			     gender:{
			    	 required:true
			    	 
			     },
			     email:{
			    	 required:true,
		             email:true	  	 
			     },
			     mobile:{
			    	 required:true,
	                 phoneIN: true
			     }
			    
		      },
		    
		    invalidHandler: function(element){
		    	var validator = $("#form").validate();
		    	$("#summary").text(validator.numberOfInvalids() + " fields are invalid..");
		    },
		    	      
		   messages: {
			   
			   rollno: {
			    	 required:"Roll Number is mandatory",
		             digits:"Only digits are allowed"	    	 
			     },
			     fname:{
			    	 required:"Firstname is mandatory",
			         lettersonly:"Only letters are allowed",
			         minLength:"Length must be between 2 and 20",
			         maxLength:"Length must be between 2 and 20"    	 
			     },
			     lname:{
			    	 required:"Lastname is mandatory",
		             lettersonly:"Only letters are allowed",
		             minLength:"Length must be between 1 and 20",
		             maxLength:"Length must be between 2 and 20"    	 
			     },
			     dob:{
			    	 required:"Date of birth is mandatory",
			         date:"Invalid date of birth"    	 
			     },
			     gender:{
			    	 required:"Gender is mandatory",
			    	 
			     },
			     email:{
			    	 required:"Email is mandatory",
		             email:"Invalid email id"	  	 
			     },
			     mobile:{
			    	 required:"Mobile number is mandatory",
	                 
			     }
			   
			}   
	});
});



$(document).ready(function() {
  // get the file input field
  var inputFile = $('#fileInput');
  
  // get the URL of the previously uploaded image
  var imageUrl = 'https://example.com/image.jpg';
  
  // use the FileReader API to set the value of the file input field
  var reader = new FileReader();
  reader.onload = function(e) {
    inputFile.val(e.target.result);
  }
  reader.readAsDataURL(imageUrl);
});











$(document).ready(function() {
	
	  var inputFile = $('#multipartFile');
	  // get the URL of the previously uploaded image
	  var imageUrl = '/student-management/resources/images/${student.imageName}';  
	  // use the FileReader API to set the value of the file input field
	  var reader = new FileReader();
	  reader.onload = function(e) {
	    inputFile.val(e.target.result);
	  }
	  reader.readAsDataURL(imageUrl);
	
	  
	  
	   $("#form").validate({

		 //target name attibute
		   rules: {
			     rollno: {
			    	 required:true,
		             digits:true	    	 
			     },
			     fname:{
			    	 required:true,
			         lettersonly:true,
			         minlength:2,
			         maxlength:20    	 
			     },
			     lname:{
			    	 required:true,
		             lettersonly:true,
		             minlength:1,
		             maxlength:20    	 
			     },
			     dob:{
			    	 required:true,
			         date:true    	 
			     },
			     gender:{
			    	 required:true
			    	 
			     },
			     email:{
			    	 required:true,
		             email:true	  	 
			     },
			     password:{
			    	 required:true,
		             maxlength:10,
		             minlength:6
			     },
			     mobile:{
			    	 required:true,
	                 phoneIN: true
			     },
			     multipartFile:{
			    	 required:true
			     }
			     		    
		      },
		    
		    invalidHandler: function(element){
		    	var validator = $("#form").validate();
		    	$("#summary").text(validator.numberOfInvalids() + " fields are invalid..");
		    },
		    	      
		   messages: {
			   
			   rollno: {
			    	 required:"Roll Number is mandatory",
		             digits:"Only digits are allowed"	    	 
			     },
			     fname:{
			    	 required:"Firstname is mandatory",
			         lettersonly:"Only letters are allowed",
			         minLength:"Length must be between 2 and 20",
			         maxLength:"Length must be between 2 and 20"    	 
			     },
			     lname:{
			    	 required:"Lastname is mandatory",
		             lettersonly:"Only letters are allowed",
		             minLength:"Length must be between 1 and 20",
		             maxLength:"Length must be between 2 and 20"    	 
			     },
			     dob:{
			    	 required:"Date of birth is mandatory",
			         date:"Invalid date of birth"    	 
			     },
			     gender:{
			    	 required:"Gender is mandatory",
			    	 
			     },
			     email:{
			    	 required:"Email is mandatory",
		             email:"Invalid email id"	  	 
			     },
			     password:{
			    	 required:"Password is mandatory",
		             maxlength:"Maximum length is 10",
		             minlength:"Minimum length is 6"
			     },
			     mobile:{
			    	 required:"Mobile number is mandatory"
	                 
			     },
			     multipartFile:{
			    	 required:"image is mandatory"
			     }
			   
			}   
	});
});
