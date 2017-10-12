package com.neu.spring;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.neu.spring.pojo.TradeOrder;

public class PdfReportView extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter pdfwriter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		TradeOrder tradeOrder = (TradeOrder) model.get("tradeOrder");
        
        doc.add(new Paragraph("Trade Order Invoice"));
         
        PdfPTable table = new PdfPTable(10);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f, 3.0f, 4.0f, 4.0f, 4.0f,4.0f,4.0f,4.0f,4.0f,4.0f});
        table.setSpacingBefore(10);
         
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
       
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        
        cell.setPadding(10);
         
        // write table header
        cell.setPhrase(new Phrase("Order Id", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Stock Id", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Buy Date", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Buy Price", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Sell date", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Sell Price", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Quantity", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Instrument", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Status", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Trigger Price", font));
        table.addCell(cell);
        
        
         
        // write table row data
        
           table.addCell(String.valueOf(tradeOrder.getOrderId()));
           table.addCell(String.valueOf(tradeOrder.getStockInfo().getStockId()));
            table.addCell(tradeOrder.getBuyDate());
           table.addCell(String.valueOf(tradeOrder.getBuyPrice()));
            table.addCell(tradeOrder.getSellDate());
            table.addCell(String.valueOf(tradeOrder.getSellPrice()));
            table.addCell(String.valueOf(tradeOrder.getQty()));
            table.addCell(String.valueOf(tradeOrder.getInstrument()));
            table.addCell(String.valueOf(tradeOrder.getStatus()));
            table.addCell(String.valueOf(tradeOrder.getTriggerPrice()));
        
         
        doc.add(table);
         
    
	}
	

}
