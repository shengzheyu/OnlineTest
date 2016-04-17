<%--
  Created by IntelliJ IDEA.
  User: 哈哈
  Date: 2016/3/17
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript">
       function sendUserJson(){
            var saveDataAry=[];
            var data1={"userName":"哈哈","password":"gz"};
            var data2={"userName":"嘿嘿","password":"gr"};
            saveDataAry.push(data1);
            saveDataAry.push(data2);
            $.ajax({
                type:"POST",
                url:"getUserJson",
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(saveDataAry),
                success:function(data){

                }
            });
        }
    </script>
</head>
<body>
${user.userName}
<input type="button" onclick="sendUserJson();" value="异步发送json数据">
</body>
</html>
