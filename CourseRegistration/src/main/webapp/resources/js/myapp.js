$(document).ready(function(){
	
	var $std_form =  $("#studentForm");

    var $login_form = $("#loginForm");
    
    if($login_form){
    	console.log("Login Validation Works: Loc "+window.location);
    	
    	$login_form.validate({
    		rules:{
    			username:{
    				required :true,
    				minlength:5,
    				remote   :{
    					type:'GET',
    					url :window.location+"/validateUsername",
    					data:{username:function(){return $("#login_username").val();}}
    				}
    			},
    			password:{
    				required:true,
    				remote  :{
    					type:'GET',
    					url :window.location+"/validatePassword",
    					data:{
    						password:function(){return $("#login_password").val();},
    						username:function(){return $("#login_username").val();}
    					}
    				}
    			}
    			
    		},
    		messages:{
    			username:{
    				required :'Please Enter Username',
    				minlength:'Username length should not be less than 5!',
    				remote   :'User Deos Not Exists!'
    			},
    			password:{
    				required:"Please Enter Password!",
    				remote  :"Password is Incorrect!"
    			}
    		}
    	});
    }

if($std_form.length){
	
	console.log("Registration Validation Works: Loc "+window.location);

	$std_form.validate({
		
		rules:{
			std_name :{
				required:true,
				minlength:3
			},
			father_name:{
				required:true,
				minlength:3
			},
			gender:{
				required:true,
			},
			contact:{
				required:true,
				minlength:11
			},
			username:{
				required:true,
				minlength:5,
				remote:{
					type:"GET",
					url :window.location+"/valid_username",
					data:{username:function(){return $("#username").val();}}
				}
			},
			password:{
				required:true,
				minlength:5,
				remote:{
					type:"GET",
					url:window.location+"/valid_password_pattern",
					data:{password:function(){return $("#pass").val();}}
				}
			},
			con_password:{
				equalTo:"#pass"
			}
		},
		messages:{
			std_name :{
				required:'Please Enter Student Name',
				minlength:'Student Name Should Not be less than 3 characters'
			},
			father_name:{
				required:'Please Enter Father Name',
				minlength:'Father Name Should Not be less than 3 characters'
			},
			gender:{
				required:'Please Select A valid Gender Choice',
			},
			contact:{
				required:'Please Enter Contact Number',
				minlength:'Mobile Number Should Not be less than 11 characters'
			},
			username :{
				required:'Please Enter Username',
				minlength:'Username Should Not be less than 5 characters',
				remote   :'Email is Already Exist'
			},
			password :{
				required :'Please Enter Password',
				minlength:'Password Should Not be less than 5 characters',
				remote   :'Password Must Contains Minimum 1 Upper Case Latter 1 Lower Case Latter 1 Digit and 1 Special Character'
			},
			con_password :{
				equalTo:'Confirm Password Did not Matched!',
				
			}
			
			
		}//,
		//errorElement:'span',
		//errorPlacement:function(error,element){
			//error.addClass('input-error');
			
			//error.insertAfterElement(element);
		//}
		
	});
}
	
});


