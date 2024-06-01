function validate() {

	var f = document.getElementById("form");

	var hasError1 = validateRollno(f);
	var hasError2 = validateFname(f);
	var hasError3 = validateLname(f);
	var hasError4 = validateBirthday(f);
	var hasError5 = validateEmail(f);
	var hasError6 = validateMobile(f);

	if (!hasError1 || !hasError2 || !hasError3 || !hasError4 || !hasError5 || !hasError6)
		return false;
	else
		return true;


}

function validateRollno(form) {
	var error = document.getElementById('rollerr');
	error.innerHTML = "";
	var rollno = form['rollno'].value;

	if (rollno.trim() == "") {
		error.innerHTML = "Input Roll Number";
	}
	else if (isNaN(rollno)) {
		error.innerHTML = "Only integers are allowed";
	}
	if (error.innerHTML.length > 0)
		return false;
	else
		return true;
}

function validateFname(form) {
	var error = document.getElementById('fnameerr');
	error.innerHTML = "";
	var fname = form['fname'].value;

	if (fname.trim() == "") {
		error.innerHTML = "Input Firstname";
	}
	else if ((fname.length <= 2) || (fname.length > 20)) {
		error.innerHTML = "FirstName length must be between 2 and 20";
	}
	else if (!isNaN(fname)) {
		error.innerHTML = "Only characters are allowed";
	}
	if (error.innerHTML.length > 0)
		return false;
	else
		return true;

}

function validateLname(form) {
	var error = document.getElementById('lnameerr');
	error.innerHTML = "";
	var lname = form['lname'].value;

	if (lname.trim() == "") {
		error.innerHTML = "Input Lastname";
	}
	else if ((lname.length <= 0) || (lname.length > 20)) {
		error.innerHTML = "LirstName length must be between 1 and 20";
	}
	else if (!isNaN(lname)) {
		error.innerHTML = "Only characters are allowed";
	}
	if (error.innerHTML.length > 0)
		return false;
	else
		return true;
}

function validateBirthday(form) {
	var error = document.getElementById('doberr');
	error.innerHTML = "";
	var dob = form['dob'].value;
	var pattern = /^([0-9]{2})-([0-9]{2})-([0-9]{4})$/;

	if (dob.trim() == "") {
		error.innerHTML = "Input date of birth";
	}
	else if (!pattern.test(dob)) {
		error.innerHTML = "Invalid date of birth";
	}
	if (error.innerHTML.length > 0)
		return false;
	else
		return true;
}


function validateEmail(form) {
	var error = document.getElementById('emailerr');
	error.innerHTML = "";
	var email = form['email'].value;
	var pattern1 = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

	if (email.trim() == "") {
		error.innerHTML = "Input email id";
	}
	else if (!pattern1.test(email)) {
		error.innerHTML = "Invalid email id";
	}
	if (error.innerHTML.length > 0)
		return false;
	else
		return true;
}

function validateMobile(form) {
	var error = document.getElementById('mobileerr');
	error.innerHTML = "";
	var mobile = form['mobile'].value;

	if (mobile.trim() == "") {
		error.innerHTML = "Input Mobile Number";
	}
	else if (isNaN(mobile)) {
		error.innerHTML = "Only integers are allowed";
	}
	else if (mobile.length != 10) {
		error.innerHTML = "Mobile number should be 10 digits only";
	}
	if (error.innerHTML.length > 0)
		return false;
	else
		return true;
}


function fetchFileName() {
	var f1 = document.getElementById("form1");

	var output = document.getElementById('filename');
	output.innerHTML = "";
	var file_name = f1['uploadedFile'].value;
	output.innerHTML = "file name is : " + file_name;
}




function validate1() {

	// Get form fields by id
	var rollno_input = document.getElementById('rollno');
	var fname_input = document.getElementById('fname');
	var lname_input = document.getElementById('lname');
	var dob_input = document.getElementById('dob');
	var gender_input = document.querySelector('input[name="gender"]:checked');
	var email_input = document.getElementById('email');
	var mobile_input = document.getElementById('mobile');
	var course_input = document.getElementById('course');
	var country_input = document.getElementById('country');

	//Get form values
	var rollno = rollno_input.value;
	var fname = fname_input.value;
	var lname = lname_input.value;
	var dob = dob_input.value;
	var gender = gender_input.value;
	var email = email_input.value;
	var mobile = mobile_input.value;
	var course = course_input.value;
	var country = country_input.value;

	// Validate rollno field
	if (rollno.trim() == "") {
		rollno_input.placeholder = "Input Roll Number";
		return false;
	} else if (isNaN(rollno)) {
		rollno_input.placeholder = "Only integers are allowed";
		return false;
	}


	// Validate fname field
	if (fname.trim() == "") {
		fname_input.placeholder = "Input Firstname";
		return false;
	}
	else if ((fname.length <= 2) || (fname.length > 20)) {
		fname_input.placeholder = "FirstName length must be between 2 and 20";
		return false;
	}
	else if (!isNaN(fname)) {
		fname_input.placeholder = "Only characters are allowed";
		return false;
	}


	// Validate lname field
	if (lname.trim() == "") {
		lname_input.placeholder = "Input Lastname";
		return false;
	}
	else if ((lname.length <= 0) || (lname.length > 20)) {
		lname_input.placeholder = "LirstName length must be between 1 and 20";
		return false;
	}
	else if (!isNaN(lname)) {
		lname_input.placeholder = "Only characters are allowed";
		return false;
	}


	// Validate dob field
	var pattern = /^([0-9]{2})-([0-9]{2})-([0-9]{4})$/;
	if (dob.trim() == "") {
		dob_input.placeholder = "Input date of birth";
		return false;
	}
	else if (!pattern.test(dob)) {
		dob_input.placeholder = "Invalid date of birth";
		return false;
	}


	// Validate gender field
	if (!gender) {
		alert("Please select your gender.");
		return false;
	}

	// Validate email field
	var pattern1 = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if (email.trim() == "") {
		email_input.placeholder = "Input email id";
		return false;
	}
	else if (!pattern1.test(email)) {
		email_input.placeholder = "Invalid email id";
		return false;
	}



	// Validate mobile field
	if (mobile.trim() == "") {
		mobile_input.placeholder = "Input Mobile Number";
		return false;
	}
	else if (isNaN(mobile)) {
		mobile_input.placeholder = "Only integers are allowed";
		return false;
	}
	else if (mobile.length != 10) {
		mobile_input.placeholder = "Mobile number should be 10 digits only";
		return false;
	}


	// Validate course field
	if (course == "") {
		alert("Please select a course");
		return false;
	}

	// Validate country field
	if (country == "") {
		alert("Please select a country.");
		return false;
	}


	// If form is valid, submit it
	alert("Form submitted successfully!");
	return true;
}





function validate2() {

	// Get form fields by id
	var rollno_input = document.getElementById('rollno');
	var fname_input = document.getElementById('fname');
	var lname_input = document.getElementById('lname');
	var dob_input = document.getElementById('dob');
	var gender_input = document.querySelector('input[name="gender"]:checked');
	var email_input = document.getElementById('email');
	var mobile_input = document.getElementById('mobile');
	var course_input = document.getElementById('course');
	var country_input = document.getElementById('country');

	//Get form values
	var rollno = rollno_input.value;
	var fname = fname_input.value;
	var lname = lname_input.value;
	var dob = dob_input.value;
	var gender = gender_input.value;
	var email = email_input.value;
	var mobile = mobile_input.value;
	var course = course_input.value;
	var country = country_input.value;

	// Validate rollno field
	if (rollno.trim() == "") {
		displayError(rollno_input, 'Input Roll Number');
	} else if (isNaN(rollno)) {
		displayError(rollno_input, 'Only integers are allowed');
	} else {
		removeError(rollno_input);
	}


	// Validate fname field
	if (fname.trim() == "") {
		displayError(fname_input, 'Input Firstname');
	}
	else if ((fname.length <= 2) || (fname.length > 20)) {
		displayError(fname_input, 'FirstName length must be between 2 and 20');
	}
	else if (!isNaN(fname)) {
		displayError(fname_input, 'Only characters are allowed');
	} else {
		removeError(fname_input);
	}


	// Validate lname field
	if (lname.trim() == "") {
		displayError(lname_input, 'Input Lastname');
	}
	else if ((lname.length <= 0) || (lname.length > 20)) {
		displayError(lname_input, 'LastName length must be between 1 and 20');
	}
	else if (!isNaN(lname)) {
		displayError(lname_input, 'Only characters are allowed');
	} else {
		removeError(lname_input);
	}


	// Validate dob field
	var pattern = /^([0-9]{2})-([0-9]{2})-([0-9]{4})$/;
	if (dob.trim() == "") {
		displayError(dob_input, 'Input date of birth');
	}
	else if (!pattern.test(dob)) {
		displayError(dob_input, 'Invalid date of birth');
	} else {
		removeError(dob_input);
	}


	// Validate gender field
	if (!gender) {
		alert("Please select your gender.");
	}



	// Validate email field
	var pattern1 = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if (email.trim() == "") {
		displayError(email_input, 'Input email id');
	}
	else if (!pattern1.test(email)) {
		displayError(email_input, 'Invalid email id');
	} else {
		removeError(email_input);
	}



	// Validate mobile field
	if (mobile.trim() == "") {
		displayError(mobile_input, 'Input Mobile Number');
	}
	else if (isNaN(mobile)) {
		displayError(mobile_input, 'Only integers are allowed');
	}
	else if (mobile.length != 10) {
		displayError(mobile_input, 'Mobile number should be 10 digits only');
	} else {
		removeError(mobile_input);
	}



	// Validate course field
	if (course == "") {
		alert("Please select a course");
		return false;
	}

	// Validate country field
	if (country == "") {
		alert("Please select a country.");
		return false;
	}


	// Submit the form if there are no errors
	if (document.querySelectorAll('.error').length === 0) {
		return true;
	}
	else {
		return false;
	}

}

function displayError(input, message) {
	// Check if the error message element already exists
	var error = input.nextElementSibling;
	if (error === null || !error.classList.contains('error-message')) {
		// Create a new error message element
		error = document.createElement('span');
		error.classList.add('error-message');
		input.insertAdjacentElement('afterend', error);
	}
	error.textContent = message;
}

function removeError(input) {
	// Check if the error message element exists
	var error = input.nextElementSibling;
	if (error !== null && error.classList.contains('error-message')) {
		error.remove();
	}
}