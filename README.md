# JavaMailBot

# Prerequisites
   1. Add your email and password in the specified place.
   2. Add name of the file you wish to send at specified place in Mail.java file.
   3. Give email of the receiver in JavaMail.java file.
   4. Make sure you have a stable internet connectivity.
   5. Turn on less-secure access on for your gmail account so that the password and mailId can be authenticated.
   6. Download and connect the specified JAR files.

# Code Description   

The main method in the code is named mail, and it starts with initializing the key-value prop using the Properties class. Further, To send the mail, there was a need to configure the mail authentication, SMTP host, SMTP port, and enable TLS with true. 

To send the email via GMail, the port used is 587, and the SMTP host is smtp.gmail.com. 
In order to ensure security, the STARTTLS command is enabled. This protects the connection before issuing authentication or any login commands. The activation of a STARTTLS command is made mandatory using prop.put("mail.smtp.starttls.required", "true"); statement. The connection will fail if the server doesn't support the STARTTLS command.
Similarly, an SSL protocol, TLSv1.2, is established.

To further represent the mail session, an object in the Session class is initiated for authentication of the Username and password. The authentication process is generated using an override method that returns the username and password of the Senders mail address.
A separate method is initialized called prepareMessage, which has a return type of Message to formulate the message. Message and Session come under javax.mail package and need to be imported using import javax.mail.Message and import javax.mail.Session statements.
For the formulated message to support the MIME style, the class MimeMessage is also used, which comes under the package javax.mail.internet.MimeMessage. 
Using a transport class imported using the package javax.mail.Transport, the connection is set up, and the mail is generated to be sent to the recipients. 
In case of an exception, the method prepareMessage will return null.

In the class JavaMail, the required Email of the receiver is specified, and the class Mail is called to generate the mail.

# For the Authenticator, setup of SMTP, and the use of imported packages under javax.mail, the External JARs activation-1.1.1.jar, javax.mail.jar, and smtp-1.4.5.jar were downloaded. 

