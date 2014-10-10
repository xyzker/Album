//处理用户登陆的函数
function proLogin()
{
	//获取user、pass两个文本框的值
	var user = $.trim($("#user").val());
	var pass = $.trim($("#pass").val());
	if (user == null || user == "" 
		|| pass == null|| pass =="")
	{
		alert("必须先输入用户名和密码才能登录");
		return false;
	}
	else
	{
		//向proLogin发送异步、POST请求
		$.post("proLogin", $('#user,#pass').serializeArray(),
			function(data, status){
				$("#user,#pass").val('');	//清空输入框内容
				if(data.msg == "success"){			//登陆成功
					location.reload();
				}
				else if(data.msg == "failure"){			//登陆失败
					alert("您输入的用户名、密码不符，请重试！");
				}
			} , 
		"json");
	}
}

//切换到注册对话框
function changeRegist()
{
	//隐藏登录用的两个按钮
	$("#loginDiv").hide("500");
	//显示注册用的两个按钮
	$("#registDiv").show("500");
}

//切换到登陆对话框
function changeLogin()
{
	//隐藏注册用的两个按钮
	$("#registDiv").hide("500");
	//显示登陆用的两个按钮
	$("#loginDiv").show("500");
}

function reset()
{
	//清空user、pass两个单行文本框
	$("#user").val("");
	$("#pass").val("");
	$("#validateName").html("");
}

//处理用户注册的函数
function regist()
{
	//获取user、pass两个文本框的值
	var user = $.trim($("#user").val());
	var pass = $.trim($("#pass").val());
	if (user == null || user == "" || pass == null || pass =="")
	{
		alert("必须先输入用户名和密码才能注册");
		return false;
	}
	else
	{
		//向proRegist发送异步、POST请求
		$.post("proRegist", $('#user,#pass').serializeArray()
			, function(data){
				if(data.exists == "true"){
					alert("该用户名已存在，请更改用户名！");
				}
				else{
					alert("恭喜您，注册成功！已自动登陆");
					location.reload();
				}
			} , "json");
	}
}

//注销函数
function logout(){
	$.post("logout",function(){
		location.reload();
	},"json");
}

//验证用户名是否可用
function validateName()
{
	//获取user文本框的值
	var user = $.trim($("#user").val());
	if (user == null || user == "")
	{
		alert("您还没有输入用户名！");
		return false;
	}
	else
	{
		//向validateName发送异步、POST请求
		$.post("validateName", $('#user').serializeArray()
			, function(data){
			if(data.exists == "true"){
				$("#validateName").html(data.msg).css("color","red");
			}
			else if(data.exists == "false"){
				$("#validateName").html(data.msg).css("color","green");
			}
		} , "json");
	}
}

//打开上传窗口
function openUpload()
{
	$("#uploadDiv").show()
		.dialog(
		{
			modal: true,
			resizable: false,
			width: 450,
			height: 250,
			overlay: {opacity: 0.5 , background: "black"}
		});
}

//上传图片函数
function proUpload(){
	var image = $("#image").val();
	if(image == null || image == ""){
		$("#error").html("您还没有选择上传的图片！");
		return false;
	}
	var rightFileType = new Array("jpg", "bmp", "gif", "png","jpeg");//允许的上传类型
	var fileType = image.substring(image.lastIndexOf(".") + 1).toLowerCase(); 
	if (!in_array(fileType,rightFileType)){
		$("#error").html("只支持jpg,bmp,gif,png,jpeg等类型的文件！");
		return false;
	}
	else{	
			$("#upload").attr("disabled","true");
			$("#uploadForm").ajaxSubmit({			//异步提交
				 dataType: 'json',
				 success: function(html) {
						  if(html.msg == "too large"){
							  $("#error").html("文件太大，请重新选择文件(小于8M)!");
						  }
						   if(html.msg == "success"){
							   alert("上传成功！");
							   location.reload();
						   }
                      }
			});
	}
	
}

//判断一个元素是否在一个数组里
function in_array(needle, haystack) {  
    // 得到needle的类型  
    var type = typeof needle;  
    if(type == 'string' || type =='number') {  
        for(var i in haystack) {  
            if(haystack[i] == needle) {  
                return true;  
            }  
        }  
    }  
    return false;  
}

//显示相片
function showImg(address,title,id){
	$("#show").attr("src","upload" + address);
	$("#show").hide();
	$("#loading").show();
	$("#imageTitle").html(title);
	$("#photoId").val(id);
	$("#delete").show();
}

function viewUsers(){
	if(	$("#users").text() == ""){
		$.get("viewUsers", 
			function(data){
				for(var i in data.users){
					$("#users").append("<a href='visit?user.id=" + data.users[i].id +  "'>" + data.users[i].name + "</a>  ");
				}
				$("#users").show();
			},"json"
		);
	}
	else{
		$("#users").toggle();
	}
}

function deletePhoto(){
	var r = confirm('确认删除该照片吗？');
	if(r == true){
		$.post("deletePhoto", $('#photoId').serializeArray(),
				function(data){
					 location.reload();
				} , 
			"json");
	}
	else return false;
}

function loaded(){
	$("#loading").hide();
	$("#show").show();
}
