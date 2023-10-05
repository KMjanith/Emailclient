**Email Client Application**

**Description:**

This repository contains a command-line based email client application that allows users to manage two types of recipients: official and personal. The recipient details are stored in a text file, and the application provides functionalities to add new recipients, send birthday greetings, and keep track of emails sent.

**Features:**

1. **Recipient Management:**
   - The application supports official and personal recipients.
   - Recipient details (name, email, designation, and birthday for office friends) are stored in a text file.
   - Users can add new recipients via the command line.

2. **Birthday Greetings:**
   - On the recipient's birthday, the application sends personalized birthday messages.
   - Official friends receive a message: "Wish you a Happy Birthday, \<your name\>."
   - Personal recipients receive a message: "Hugs and love on your birthday, \<your name\>."

3. **Email Sending:**
   - Users can send emails to recipients through the command line.
   - All sent emails are saved on the hard disk using object serialization.

4. **Email Tracking:**
   - Users can retrieve information about emails sent on a specific date.
   - Command-line options are available to print recipient names with birthdays set to the current date.
   - Users can print details (subject and recipient) of all emails sent on a date specified by user input.

5. **Recipient Count:**
   - The application maintains a count of recipient objects using static members.


6. **File Handling:**

- Recipient details are stored in a text file.
- Sent emails are saved on the hard disk using object serialization.

**Note:**
- This application focuses on sending messages and does not implement the logic to receive messages.

Feel free to explore and contribute to the development of this email client application!
