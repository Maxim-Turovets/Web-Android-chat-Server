<%--
  Created by IntelliJ IDEA.
  User: Maxim Turovets
  Date: 03.03.2019
  Time: 19:10
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Title</title>
    <style>
        .chatbox{
         display: none;
        }
        .message{
            background-color: #2ECCFA;
            width: 500px;
            padding: 20px;
        }
        .message .msg{
            background:#CEE3F6;
            border-radius:10px;
            margin-bottom: 10px;
            padding: 0 10px 10px 10px;
            overflow: hidden;
        }
        .message .msg .from {
            background: #F5DA81;
           line-height: 30px;
            text-align: center;
            color:#190714;
        }
        .message .msg .text{
            padding: 10px;

        }
        textarea.msg{
            width: 540px;
            padding: 10px;
            resize: none;
            border: none;
            box-shadow: 2px 2px 5px 0 inset;
        }
        .from{
            width: 476px;
            height: 31px;
            border-radius: 20px;
        }
        .text{
            margin: 0px;
            width: 461px;
            height: 41px;
            border-radius: 10px;
        }
    </style>
</head>
<body>
<div class="start">
    <input type="text" class="username" placeholder="enter name">
    <button class="btn" onclick="" type="submit">start</button>
</div>

<div class="chatbox">
    <div class="message">
        <div class="msg">
            <textarea class="from" id="demo">MAx</textarea>
            <textarea class="text">Hello</textarea>
        </div>
    </div>
    <textarea class="area" cols="30" rows="10"></textarea>
</div>

<script>
    let chatUnit={
        init(){
            this.startbox = document.querySelector(".start");
            this.chatbox = document.querySelector(".chatbox");
            this.startBtn = document.querySelector(".btn");
            this.nameInput = document.querySelector(".username");
            this.name = document.querySelector(".from");
            this.startBtn.addEventListener("click",e=>this.openSocket());
        },
        openSocket(){
            this.name.value=this.nameInput.value;
            this.ws.onopen = ()=> this.onOpenSock();
           this.startbox.style.display="none";
           this.chatbox.style.display="block";
        }

    }

    window.addEventListener("load",e=>chatUnit.init());

</script>
</body>
</html>
