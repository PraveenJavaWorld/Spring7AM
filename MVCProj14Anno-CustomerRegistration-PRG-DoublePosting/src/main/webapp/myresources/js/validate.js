function validate(frm){
	
	//empty the previous frm validation error messages
	document.getElementById("nameErr").innerHTML="";
	document.getElementById("addressErr").innerHTML="";
	document.getElementById("billErr").innerHTML="";
	
	//read the data
	let name = frm.name.value;
	let address = frm.address.value;
	let bill = frm.billAmount.value;
	
	//frm validation logic (client side)
	let flag = true;
	//for name
	if(name==""){
		document.getElementById("nameErr").innerHTML="Customer Name must be Required";
		flag = false;
	}
	else if(name.length<5){
		document.getElementById("nameErr").innerHTML="Name must have minimum 5 characters";
		flag = false;
	}
	
	//for address
	if(address==""){
		document.getElementById("addressErr").innerHTML="Customer Address must be Required";
		flag = false;
	}
	else if(address.length<8){
		document.getElementById("addressErr").innerHTML="Address must have minimum 8 characters";
		flag = false;
	}
	
	//for billAmount
	if(bill==""){
		document.getElementById("billErr").innerHTML="Bill Amount must be Required";
		flag = false;
	}
	else if(bill<=0){
		document.getElementById("billErr").innerHTML="BillAmount must be Positive Number";
		flag = false;
	}
	
	// change flag (hidden box) value to "yes" from "no"  to indicate client side frm validations are done
	frm.vflag.value="yes";
	return flag;
}