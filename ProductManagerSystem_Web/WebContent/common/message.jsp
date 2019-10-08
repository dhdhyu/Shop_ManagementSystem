<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>信息提示页面</title>
<meta http-equiv="refresh" content="${time };url=${location}"/>
</head>
<body>
  <h1 style="text-align:center">${info } 网站在<span id="second" style="color:red">${time }</span>后自动跳转</h1>
  <div style="text-align:center">
      <a href="${location}">如果浏览没有跳转，可以点击下面的链接跳转</a>
  </div>
  <script type="text/javascript">
       var interval = null
       window.onload = function(){
    	   interval =  setInterval(goTime,1000);
       }
       var time = ${time};
       function goTime(){
    	   time--;
    	   if(time>0){
    		  document.getElementById("second").innerHTML = time; 
    	   }else{
    		   clearInterval(interval);
    		   location.href = '${location}'
    	   }
       }
  </script>
</body>
</html>