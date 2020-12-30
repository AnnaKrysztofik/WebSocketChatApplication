var client = null;
var color;


//var name = document.getElementById('showMyName');
//document.write
 //document.getElementById("wynik").innerHTML = liczba;


//
//function showMyName(user){
//    var myName = document.createElement('div');
//    myName.appendChild(document.createTextNode(user));
////    document.getElementById('showMyName').innerHTML = myName;
//
// var showName = document.getElementById('showMyName');
//    showName.appendChild(myName);
//
//
//}

function showMessage(value, user, userColor, date) {
    var newResponse = document.createElement('p');
    newResponse.style.color = userColor;

    newResponse.appendChild(document.createTextNode(date));
    newResponse.appendChild(document.createTextNode(" || "));
    newResponse.appendChild(document.createTextNode(user));
    newResponse.appendChild(document.createTextNode(": "));
    newResponse.appendChild(document.createTextNode(value));
    var response = document.getElementById('response');
    response.appendChild(newResponse);
}

function connect() {
    client = Stomp.client('ws://localhost:8080/chat');
    color = getRandomColor();
    date = getDate();
    client.connect({}, function (frame) {
        client.subscribe("/topic/messages", function(message){
            showMessage(JSON.parse(message.body).value, JSON.parse(message.body).user, JSON.parse(message.body).userColor, JSON.parse(message.body).time)
        });

    })
}

function sendMessage() {
    var messageToSend = document.getElementById('messageToSend').value;

    var user = "${name}";
    var date = getDate();
    client.send("/app/chat", {}, JSON.stringify({'value': messageToSend, 'user': user, 'userColor': color, 'time': date}) );
    document.getElementById('messageToSend').value = "";
}

function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

function getDate(){
 var today = new Date();
 var date = today.toLocaleTimeString();
// var date = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
 return date;


}