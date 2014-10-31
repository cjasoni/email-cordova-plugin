var EmailComposer = function(){};
/*
cordova.addConstructor(function() {
    cordova.addPlugin("emailcomposer", new EmailComposer());
});
*/
EmailComposer.prototype.send = function (message,to){
console.log("Calling the send message");
cordova.exec(function(){ alert('Deal sent.')}, 
    function(){ alert('Deal was not sent.')}, 
    'EmailComposer', 
    'sendEmail', 
    [message,to]);
}
function sendFeedback(){
    window.EmailComposer.prototype.send("My message body","cjasonigdotw@gmail.com");
}





