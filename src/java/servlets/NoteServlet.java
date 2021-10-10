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
    
    Note note;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("here 1");
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));     
        note = new Note();
        note.setNoteTitle(br.readLine());
        note.setNoteContent(br.readLine());
        
        request.setAttribute("note", note);

        br.close();
        getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        request.setAttribute("note", note);             
        getServletContext().getRequestDispatcher("/WEB-INF/editNote.jsp").forward(request, response);
        if(request.getParameter("Save").equals("save")){
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");            
            File file = new File(path);            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(request.getParameter("title"));
            bw.newLine();
            bw.write(request.getParameter("content"));
            bw.flush();
            bw.close();
            fw.close();
            note.setNoteTitle(request.getParameter("title"));
            note.setNoteContent(request.getParameter("content"));
            request.setAttribute("note", note);
            System.out.println("here 2");
            
        }
        System.out.println("here 3");
        getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);  
        return;
    }

}
