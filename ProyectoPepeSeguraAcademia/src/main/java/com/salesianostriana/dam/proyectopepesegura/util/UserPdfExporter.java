package com.salesianostriana.dam.proyectopepesegura.util;

import java.awt.Color;
import java.io.IOException;
import java.util.List;



import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;

import jakarta.servlet.http.HttpServletResponse;

public class UserPdfExporter {
	private List<Estudiante> listUsers;
    
    public  UserPdfExporter(List<Estudiante> listUsers) {
        this.listUsers = listUsers;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.CYAN);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("User ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Username", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Nombre", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Apellidos", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("correo", font));
        table.addCell(cell);     

        cell.setPhrase(new Phrase("Administrador", font));
        table.addCell(cell);     
        
      
       
    }
     
    private void writeTableData(PdfPTable table) {
        for (Estudiante user : listUsers) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getUsername());
            table.addCell(user.getNombre());
            table.addCell(user.getApellidos());
            table.addCell(user.getCorreo());
   
            

            table.addCell(String.valueOf(user.isEnabled()));
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.cyan);
         
        Paragraph p = new Paragraph("Lista de usuarios", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f,3.0f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
