/**
 * zy@2016.4.11
 * 检验登录
 */
function validate(){
    $("#loginpassError").css("display", "none");
    $("#loginnameError").css("display", "none");
    $("#authorityError").css("display", "none");
    var result = true;
    var value_name = $("#loginname").val();
    var value_password = $("#loginpassword").val();
    var value_authority = document.getElementsByName("authority");
    var check_val = 0;
    for(var k in value_authority){
        if(value_authority[k].checked)
            check_val++;
    }
    /*根据name 获取 对应值*/
    var value_authority=$(":input[name='authority']").val();
    if(!value_password) {// 非空校验
        $("#loginpassError").css("display", "");
        $("#loginpassError").css("color", "red");
        $("#loginpassError").text("密码为空！");
        result=false;
    }
    if(!value_name){
        $("#loginnameError").css("display", "");
        $("#loginnameError").css("color", "red");
        $("#loginnameError").text("用户名为空！");
        result = false;
    }
    if(!check_val){
        $("#authorityError").css("display", "");
        $("#authorityError").css("color", "red");
        $("#authorityError").text("请选择登录身份！");
        result = false;
    }else if(check_val>1){
        $("#authorityError").css("display", "");
        $("#authorityError").css("color", "red");
        $("#authorityError").text("身份不能多选！");
        result = false;
    }
    return result;
}