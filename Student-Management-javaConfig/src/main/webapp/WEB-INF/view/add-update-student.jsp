<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="/student-management/resources/Jquery Validation/Jquery.js"></script>
<script type="text/javascript" src="/student-management/resources/Jquery Validation/jquery-validation-1.19.5/dist/jquery.validate.min.js"></script>
<script type="text/javascript" src="/student-management/resources/Jquery Validation/jquery-validation-1.19.5/dist/additional-methods.min.js"></script>
<link rel="stylesheet" type="text/css" href="/student-management/resources/css/add-update-style.css">
<style>
.error {
	color: red;
	padding-left:120px;
}
</style>


<script type="text/javascript">

//student-management is a context name. it is the artifact name. in pom it will be a in finalname tag

// Add validation rule for Indian mobile number

    // replace(/\s+/g, "")
   // /\s/   This matches any whitespace character, including spaces, tabs, and line breaks.
  //  +      Tt matches one or more whitespace characters.
 //  /g      Global flag, indicates, the re should be applied to all matches in the input string, rather than stopping at the 1st match.
//replace()   remove all whitespace characters in a string by replacing them with an empty string.


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
	   }, "Please enter a valid mobile number");


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
			     password:{
			    	 required:true,
		             maxlength:10,
		             minlength:6
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
			     password:{
			    	 required:"Password is mandatory",
		             maxlength:"Maximum length is 10",
		             minlength:"Minimum length is 6"
			     },
			     mobile:{
			    	 required:"Mobile number is mandatory"
	                 
			     }
			   
			}   
	});
});
</script>


<title>Student Form</title>
</head>
<body>
	<%
	if (session.getAttribute("Sname") == null) {
		response.sendRedirect("adminLogin");
	}
	%>

	<div style="display: flex;">
		<div style="width: 250px; height: 640px; background-color: #00005C;">
	 <img alt="student image" src="/student-management/resources/images/29.png" height="150px" width="150px" 
	   style="padding-top: 20px; padding-left: 50px" /><br>
	  <center><a href="/student-management/showStudent" style="margin-top:40px" class="a">Show StudentList</a></center>
	  <center><a href="/student-management/showImport" class="a">Import Users</a></center>
	  <center><a href="/student-management/showDashboard" class="a">Dashboard</a></center>
	  <center><a href="/student-management/addStudent" class="a">Add Student</a></center>
	  <center><a href="/student-management/processLogout" class="a">Logout</a></center>	
	</div>
		<div style="width: 1100px; height: 640px; margin-left: 8px;">

			<form:form id="form" action="saveStudent" method="post" modelAttribute="student" enctype="multipart/form-data">
				<div style="float: left;" class="form">
					<form:hidden path="id" />
					<!--  for update id will be there, for add id will be 0 -->

					<div>
						<form:label path="rollno" style="padding-right:30px;">Roll No : </form:label>
						<form:input path="rollno" id="rollno" name="rollno"
							style="width:70%" />
					</div>

					<div>
						<form:label path="fname">First Name : </form:label>
						<form:input path="fname" name="fname" id="fname" />
					</div>

					<div>
						<form:label path="lname" style="padding-right:12px;">Last Name : </form:label>
						<form:input path="lname" name="lname" id="lname" />
					</div>

					<div>
						<form:label path="dob" style="padding-right:25px;">Birthday : </form:label>
						<form:input path="dob" id="dob" name="dob" style="width:70%" />
					</div>

					<div
						style="margin-top: 8px; margin-bottom: 8px; margin-right: 20px;">
						<form:label path="gender" style="padding-right:35px;">Gender : </form:label>
						Male :
						<form:radiobutton name="gender" path="gender" value="Male"
							style="margin-right:20px;" />
						Female :
						<form:radiobutton path="gender" name="gender" value="Female" /><br><br>
						<label for="gender" class="error" style="display:none;"></label>
					</div>

					<div>
						<form:label path="email" style="padding-right:40px;">Email : </form:label>
						<form:input path="email" name="email" id="email"
							style="width:71%;" />
					</div>
					
					<div>
						<form:label path="password" style="padding-right:18px;">Password : </form:label>
						<form:input path="password" name="password" id="password" type="password"
							style="width:71%;" />
					</div>

					<div>
						<form:label path="mobile" style="padding-right:38px;">Phone : </form:label>
						<form:input path="mobile" name="mobile" id="mobile"
							style="width:71%" />
					</div>

					<div>
						<form:label path="course" style="padding-right:32px;">Course : </form:label>
						<form:select path="course" id="course" name="course"
							style="width:72%">
							<form:option value="BCA" label="BCA" />
							<form:option value="BSC" label="BSC" />
							<form:option value="B.COM" label="B.COM" />
							<form:option value="BBA" label="BBA" />
							<form:option value="BBM" label="BBM" />
						</form:select>
					</div>

					<div>
						<form:label path="country" style="padding-right:24px;">Country : </form:label>
						<form:select path="country" name="country" id="country"
							style="width:72%">
							<form:option value="India" label="India" />
							<form:option value="US" label="United States" />
							<form:option value="Canada" label="Canada" />
							<form:option value="Japan" label="Japan" />
						</form:select>
					</div>
				</div>


				<div style="float: right; padding-top:25px" >
				    <h3 id="summary" align="left" style="padding-left:5px;"></h3>
					<div class="form1">
						<form:label path="multipartFile" style="padding-right:24px">Select Image : </form:label>
						<form:input type="file" path="multipartFile" name="multipartFile" id="multipartFile" onchange="loadFile(event)" />
						<label for="multipartFile" class="error" style="display:none;"></label>
						<p><img id="output" width="150" height="150" style="padding-left:20px;" src="/student-management/resources/images/${student.imageName}"/></p>
					</div>			
					<input type="submit" value="submit" style="margin-top: 10px;" />
				</div>

				
			</form:form>
            
			<script>
              var loadFile = function(event) {
	          var image = document.getElementById('output');
	          image.src = URL.createObjectURL(event.target.files[0]);
             };
         </script>

		</div>
	</div>
</body>
</html>



<%--    <img alt="student image" id="output1" src="/student-management/resources/images/${imageName}" height="300" width="300" style="padding-top: 20px; padding-left: 50px"  />
         <div style="float:right" class="form1">
 		 	<form:form id="form1"  method="POST" action="processImage" modelAttribute="file" enctype="multipart/form-data"> 
	        <label style="padding-right:24px" for="file">Select Image : </label> 
	        <input type="file"  name ="file" id="file"   onchange="loadFile(event)"/> 
	        <p><img id="output" width="200" /></p>
            <input type="submit" value="submit"  style="margin-top:20px;"/>
           </form:form>  	       		  	
		 </div> 
--%>
