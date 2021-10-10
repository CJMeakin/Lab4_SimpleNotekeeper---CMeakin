<%-- 
    Document   : viewNote
    Created on : Oct 10, 2021, 8:37:02 AM
    Author     : Connor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <title>Lab 4 - CPRG352</title>
        <style>

            body{

                font-family: 'Montserrat', sans-serif;
                background: #443c3c;
                color: white;
                align-items: center;
                padding: 200px;
                display: flex;
                flex-direction: column;

            }
            .note{                
                color: black;
                font-size: 20px;
            }
            .edit{
                color: black;
                display: flex;
                flex-direction: column;
                align-items: center;
                font-size: 25px;
                font-weight: bold;
            }            
            .pad{
                display: flex;
                flex-direction: column;
                min-width: 300px; 
                max-width: 400px;
                padding: 2rem;
                box-shadow: inset 0 0 0 4px #000, inset -4px -4px 0 6px #d1c7ab;
                background-color: #f2ead5;
            }
            input[type=text] {
                background-color: #f2ead5;
                align-content: center; 
                color: black;
            }
            input[type=submit] {
                background-color: #f2ead5;
                align-content: center; 
                color: black;
                font-size: 30px;
            }
           
        </style>

    </head>
    <body>
        <h1>Note Keeper</h1>       
        <div class="note pad">         
            Title: &nbsp;${note.noteTitle}
            <br>
            Contents: &nbsp;${note.noteContent}
        </div> 
            
        <form class ="edit pad" method ="POST">
           <input type="submit" value="Edit">
        </form>
      
    </body>
</html>
