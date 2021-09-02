document.querySelector(".contact-form").addEventListener("submit", submitForm);

function submitForm(e){
    e.preventDefault();

    //get input values
    let name = document.querySelector(".name").value;
    let email = document.querySelector(".email").value;
    let message = document.querySelector(".message").value;

    //listen for a submite
    sendEmail(name, email, message);
    document.querySelector(".contact-form").reset();
}

function sendEmail(name, email, message) {
    Email.send({
        Host: "smtp.gmail.com",
        Username: "pedro.piresvieira1@gmail.com",
        Password: "swunraxichyvbhoq",
        To: 'pedro.piresvieira1@gmail.com',
        From: "pedro.piresvieira1@gmail.com",
        Subject: `${name} send you a message from your Website`,
        Body: `Name: ${name} <br/> Email: ${email} <br/>
        Message: ${message}`,
        
    }).then( message => alert("Message sucessfully sent"));
}