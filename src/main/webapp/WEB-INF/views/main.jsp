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




<%--<html>--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
    <%--<title>Пример веб-страницы</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<div class="enter">--%>
    <%--<input type="text" class="inp">--%>
    <%--<button class="btn2">Send</button>--%>
<%--</div>--%>
<%--</body>--%>
<%--<script>--%>

        <%--const Btn = document.querySelector(".btn");--%>
        <%--const Btn2 = document.querySelector(".btn2");--%>
        <%--const Inp = document.querySelector(".inp");--%>
        <%--const enter = document.querySelector(".enter");--%>
        <%--const con = new WebSocket("ws://127.0.0.1:8080/sock/chat");--%>
        <%--let  mes = "";--%>
        <%--Btn2.addEventListener("click", e =>fun());--%>

        <%--const writeLine = text => {--%>
            <%--const line = document.createElement('div');--%>
            <%--line.innerHTML = `<p>${text}</p>`;--%>
            <%--enter.appendChild(line);--%>
        <%--};--%>

        <%--con.onopen = () => {--%>
        <%--console.log('connected');--%>
        <%--};--%>
        <%--con.onclose = () => {--%>
        <%--console.log('closed');--%>
        <%--};--%>

        <%--con.onmessage = event => {--%>
            <%--writeLine(event.data);--%>
        <%--};--%>

        <%--function  fun() {--%>
        <%--con.send(Inp.value);--%>
        <%--create();--%>
        <%--}--%>

        <%--function create() {--%>
            <%--const tr = document.createElement('div');--%>
            <%--tr.innerHTML = mes;--%>

            <%--document.querySelector(".enter").appendChild(tr);--%>
        <%--}--%>


       <%--// window.addEventListener("load",e=>chatUnit.init());--%>
<%--</script>--%>
<%--</html>--%>



<html lang="en"><head>
    <title>Login V1</title>
    <meta charset="UTF-8">
</head>
<body>
<style>

    * {
        margin: 0px;
        padding: 0px;
        box-sizing: border-box;
    }

    body, html {
        height: 100%;
        font-family: Poppins-Regular, sans-serif;
    }

    /*---------------------------------------------*/

    p {
        font-family: Poppins-Regular;
        font-size: 14px;
        color: #666666;
        margin: 0px;
    }


    /*---------------------------------------------*/
    input {
        outline: none;
        border: none;
    }

    textarea {
        outline: none;
        border: none;
    }

    textarea:focus, input:focus {
        border-color: transparent !important;
    }


    /*---------------------------------------------*/
    button {
        outline: none !important;
        border: none;
        background: transparent;
    }

    button:hover {
        cursor: pointer;
    }




    .container-login100 {
        width: 100%;
        min-height: 100vh;
        flex-wrap: wrap;
        justify-content: center;
        align-items: center;
        padding: 15px;
        background: #9053c7;
        background: -webkit-linear-gradient(-135deg, #c850c0, #4158d0);
        background: -o-linear-gradient(-135deg, #c850c0, #4158d0);
        background: -moz-linear-gradient(-135deg, #c850c0, #4158d0);
        background: linear-gradient(-135deg, #c850c0, #4158d0);
    }

    .wrap-login100 {
        position: relative;
        background: #fff;
        border-radius: 50px;
        overflow: hidden;
        display: -webkit-box;
        display: -webkit-flex;
        display: -moz-box;
        display: -ms-flexbox;
        flex-wrap: wrap;
        justify-content: space-between;
        padding: 91px 138px 19px 95px;
    }
    .wrap-login10 {
        margin-top: 3%;
        background: #fff;
        border-radius: 50px;
        justify-content: center;
        padding: 0px 43px 12px 35px;
        width: fit-content;
    }

    .login100-form {
        margin-top: -62px;
        width: 290px;
    }




    /*---------------------------------------------*/
    .wrap-input100 {
        position: relative;
        width: 100%;
        z-index: 1;
        margin-bottom: 10px;
    }

    .input100 {
        font-family: Poppins-Medium;
        font-size: 15px;
        line-height: 1.5;
        color: #666666;

        display: block;
        width: 117%;
        background: #e6e6e6;
        height: 50px;
        border-radius: 25px;
        padding: 0 30px 0 68px;
    }


    .container-login100-form-btn {
        width: 100%;
        display: -webkit-box;
        display: -webkit-flex;
        display: -moz-box;
        display: -ms-flexbox;
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        padding-top: 20px;
    }

    .login100-form-btn {
        font-family: Montserrat-Bold;
        font-size: 15px;
        line-height: 1.5;
        color: #fff;
        text-transform: uppercase;

        width: 117%;
        height: 50px;
        border-radius: 25px;
        background: #57b846;
        display: -webkit-box;
        display: -webkit-flex;
        display: -moz-box;
        display: -ms-flexbox;
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 0 25px;

        -webkit-transition: all 0.4s;
        -o-transition: all 0.4s;
        -moz-transition: all 0.4s;
        transition: all 0.4s;
    }

    .login100-form-btn:hover {
        background: #333333;
    }


</style>

    <div class="container-login100">
        <div class="wrap-login100">
            <form class="login100-form">
                <div class="wrap-input100">
                    <input class="input100" type="text"  placeholder="Enter message....">
                </div>
                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" type="button">Send</button>
                </div>
            </form>
        </div>
    </div>


<script>

    const Btn = document.querySelector(".login100-form-btn");
    const Inp = document.querySelector(".input100");
    const enter = document.querySelector(".container-login100");
    const con = new WebSocket("ws://77.47.224.135:8080/sock/chat");
    let  mes = "";
    Btn.addEventListener("click", e =>fun());

    const writeLine = text => {
        const line = document.createElement('div');
        line.className = "wrap-login10";
        line.innerHTML = `${text}`;
        document.querySelector(".container-login100").appendChild(line);
    };

    con.onopen = () => {
        console.log('connected');
    };
    con.onclose = () => {
        console.log('closed');
    };

    con.onmessage = event => {
        writeLine(event.data);
    };

    function  fun() {
        con.send(Inp.value);
        create();
        //console.log('Clicl')
    }

    function create() {
        const tr = document.createElement('div');
        tr.className = "wrap-login10";
        tr.innerHTML = mes;

        document.querySelector(".container-login100").appendChild(mes);
    }


    // window.addEventListener("load",e=>chatUnit.init());
</script>
</body>
</html>

<%--<html>--%>
<%--<head>--%>
<%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
<%--<title>Пример веб-страницы</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<div class="enter">--%>
<%--<input type="text" class="inp">--%>
<%--<button class="btn2">Send</button>--%>
<%--</div>--%>
<%--</body>--%>

<%--</html>--%>
