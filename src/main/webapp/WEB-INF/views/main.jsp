<%--
  Created by IntelliJ IDEA.
  User: Maxim Turovets
  Date: 03.03.2019
  Time: 19:10
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
    <%--<style>--%>
        <%--.chatbox{--%>
         <%--display: none;--%>
        <%--}--%>
        <%--.message{--%>
            <%--background-color: #2ECCFA;--%>
            <%--width: 500px;--%>
            <%--padding: 20px;--%>
        <%--}--%>
        <%--.message .msg{--%>
            <%--background:#CEE3F6;--%>
            <%--border-radius:10px;--%>
            <%--margin-bottom: 10px;--%>
            <%--padding: 0 10px 10px 10px;--%>
            <%--overflow: hidden;--%>
        <%--}--%>
        <%--.message .msg .from {--%>
            <%--background: #F5DA81;--%>
           <%--line-height: 30px;--%>
            <%--text-align: center;--%>
            <%--color:#190714;--%>
        <%--}--%>
        <%--.message .msg .text{--%>
            <%--padding: 10px;--%>

        <%--}--%>
        <%--textarea.msg{--%>
            <%--width: 540px;--%>
            <%--padding: 10px;--%>
            <%--resize: none;--%>
            <%--border: none;--%>
            <%--box-shadow: 2px 2px 5px 0 inset;--%>
        <%--}--%>
        <%--.from{--%>
            <%--width: 476px;--%>
            <%--height: 31px;--%>
            <%--border-radius: 20px;--%>
        <%--}--%>
        <%--.text{--%>
            <%--margin: 0px;--%>
            <%--width: 461px;--%>
            <%--height: 41px;--%>
            <%--border-radius: 10px;--%>
        <%--}--%>
    <%--</style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="start">--%>
    <%--<input type="text" class="username" placeholder="enter name" value="max">--%>
    <%--<button class="btn" onclick="" type="submit">start</button>--%>
<%--</div>--%>

<%--<div class="chatbox">--%>
    <%--<div class="message">--%>

    <%--</div>--%>
    <%--<textarea class="area" cols="30" rows="10"></textarea>--%>
<%--</div>--%>

<%--<script>--%>
    <%--let chatUnit={--%>
        <%--init(){--%>
            <%--this.startbox = document.querySelector(".start");--%>
            <%--this.chatbox = document.querySelector(".chatbox");--%>
            <%--this.startBtn = document.querySelector(".btn");--%>
            <%--this.nameInput = document.querySelector(".username");--%>
            <%--this.str = this.nameInput.value;--%>

            <%--this.chatContainer = document.querySelector(".message");--%>
            <%--this.startBtn.addEventListener("click",e=>this.openSocket());--%>
            <%--this.msgTextarea = document.querySelector(".area");--%>
            <%--this.msgTextarea.addEventListener("keyup",e=>{--%>
                <%--if(e.ctrlKey && e.keyCode===13)--%>
                <%--{--%>
                    <%--alert("Test");--%>
                    <%--e.preventDefault();--%>
                    <%--this.send()--%>
                <%--}--%>
            <%--})--%>
        <%--},--%>
        <%--send(){--%>
            <%--this.sendMessage(--%>
                <%--{--%>
                    <%--name:this.name,--%>
                    <%--text:this.msgTextarea.value--%>
                <%--}--%>
            <%--);--%>
        <%--},--%>
        <%--onOpenSock(){--%>

        <%--},--%>
        <%--onMessage(msg){--%>
            <%--let msgBlock = document.createElement("div");--%>
            <%--msgBlock.className("msg");--%>
            <%--let fromBlock = document.createElement("textarea");--%>
            <%--fromBlock.className("from");--%>
            <%--fromBlock.innerText = msg.name;--%>
            <%--let textBlock = document.createElement("textarea");--%>
            <%--textBlock.className("text");--%>
            <%--textBlock.innerText = msg.name;--%>

            <%--msgBlock.appendChild(fromBlock);--%>
            <%--msgBlock.appendChild(textBlock);--%>
            <%--this.chatContainer.appendChild(msgBlock);--%>

        <%--},--%>
        <%--onClose(){--%>

        <%--},--%>
        <%--sendMessage(msg){--%>
            <%--this.ws.send(JSON.stringify(msg));--%>
        <%--},--%>
        <%--openSocket(){--%>
            <%--this.conn = new WebSocket("ws://localhost:8080/sock/chat");--%>
            <%--this.conn.onmessage = function(e){ console.log(e.data); };--%>
            <%--this.conn.onopen = () => this.conn.send(this.nameInput.value);--%>
             <%--//this.ws.onopen = ()=> this.onOpenSock();--%>
            <%--// this.ws.onmessage = (e)=>this.onMessage(JSON.parse(e.data));--%>
            <%--// this.ws.onclose = ()=>this.onClose();--%>
           <%--// this.name = document.querySelector(".from");--%>
            <%--// this.name.value=this.nameInput.value;--%>
           <%--this.startbox.style.display="none";--%>
           <%--this.chatbox.style.display="block";--%>
        <%--}--%>

    <%--}--%>

    <%--window.addEventListener("load",e=>chatUnit.init());--%>

<%--</script>--%>
<%--</body>--%>
<%--</html>--%>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Пример веб-страницы</title>
</head>
<body>

<div class="enter">
    <input type="text" class="inp">
    <button class="btn">start</button>
    <button class="btn2">connect</button>
</div>
</body>
<script>

        const Btn = document.querySelector(".btn");
        const Btn2 = document.querySelector(".btn2");
        const Inp = document.querySelector(".inp");
        const con = new WebSocket("ws://127.0.0.1:8080/sock/chat");
        Btn2.addEventListener("click", e =>fun());

        con.onopen = () => {
        console.log('connected');
        };
        con.onclose = () => {
        console.log('closed');
        };
        con.onmessage = event => {
        console.log(event.data)};

        function  fun() {
        con.send(Inp.value);
        }


       // window.addEventListener("load",e=>chatUnit.init());
</script>
</html>
