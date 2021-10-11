package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objs.*;

/**
 *
 * @author Connor
 */
public class NoteServlet extends HttpServlet {
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));     
        Note note = new Note(br.readLine(),br.readLine());       
        br.close();
        
        request.setAttribute("note", note);        
        
        getServletContext().getRequestDispatcher("/WEB-INF/"+ (request.getParameter("edit") == null ? "view" : "edit") +"Note.jsp").forward(request, response);
        
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        Note note = new Note(request.getParameter("title"),request.getParameter("content"));
        
        
        printWriter.write(note.getNoteTitle() + "\n");
        printWriter.write(note.getNoteContent());        
        printWriter.close(); 
        
        request.setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
        return;
    }

}
