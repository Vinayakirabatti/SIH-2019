package com.example.nustahackathon;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class Watermark extends PdfPageEventHelper {
    Font f=new Font(Font.FontFamily.HELVETICA, 30,Font.BOLD,new GrayColor(0.6f));

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        super.onEndPage(writer, document);
        PdfContentByte cb=writer.getDirectContent();
        Phrase p=new Phrase("AAAV/TMFL/VV-17046/18-19");
        ColumnText.showTextAligned(cb,Element.ALIGN_LEFT,p,30,document.bottom()-10,0);
        ColumnText.showTextAligned(writer.getDirectContentUnder(),Element.ALIGN_CENTER,new Phrase("AICH APPRAISERS AUCTIONERS AND VALUERS",f),297.5f,421,writer.getPageNumber()%2==1?45:45);
    }
}
