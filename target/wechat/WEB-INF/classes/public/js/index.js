'use strict'
function openCSS() {
    var socket = new WebSocket("ws://127.0.0.1:8084/websocket");
    socket.onerror = function(event) {
        console.log("error" + event);
    }
    socket.onopen = function(event) {
        console.log('open');
        socket.send("message from index");
    }
    socket.onmessage = function(event) {
        console.log(event.data);
    }
    socket.onclose = function(event) {
        console.log("close");
    }
}