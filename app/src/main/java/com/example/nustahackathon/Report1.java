package com.example.nustahackathon;

import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;

import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;

public class Report1 {
    private Button b;
    private PdfPCell cell;
    private String textAnswer;
    private Image bgImage, bgImagea, bgImageb, bgImagec, bgImaged, bgImagee, bgImagef, bgImageg, bgImageh;
    ListView list;
    private String path;
    private File dir;
    private File file;
    private static final int STORAGE_CODE = 1000;

    Context mCtx;

    Report1(Context mCtx) {
        this.mCtx = mCtx;
    }



    public void createPDF(String sReference1, String spurpose1, String sBank, String sContractno, String sRequestfrom, String sAssetMake, String sAssetModel, String sYearofmfg, String srepossessiondate, String sRCFitnessValid, String sHMRKMR, String sChassisNumber, String sEngineNumber, String srcno, String sInspector, String sLocation, String srcstatus, String sTaxStatus, String s, String sbuyer, String swarenty_coast, String stransportayion_coast, String srto_expences, String sinsurance_cost, String staxes_penalty, String srefurb_coast, String sparking_charges, String stotal_coast, String pSilencer, String cSilencer) throws FileNotFoundException, DocumentException {


            path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Trinity/PDF Files";
            dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }




        //create document file
        Document doc = new Document(PageSize.A4,36,36,40,40);
        try {

            // Log.e("PDFCreator", "PDF Path: " + path);
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            file = new File(dir, "Trinity PDF" + System.currentTimeMillis() + ".pdf");
            FileOutputStream fOut = new FileOutputStream(file);
            PdfWriter writer = PdfWriter.getInstance(doc, fOut);
            writer.setPageEvent(new Watermark());
            //writer.setPageEvent(new Watermark());
            //open the document
            doc.open();
            Rectangle rect = new Rectangle(PageSize.A4);
            rect.setBorderColor(BaseColor.BLACK);
            rect.setBorderWidth(2);
            rect.setBorder(Rectangle.BOX);
            doc.add(rect);


            PdfPTable pt = new PdfPTable(1);
            pt.setWidthPercentage(100);
            float[] fl = new float[]{50};
            pt.setWidths(fl);
            cell = new PdfPCell();
            //cell.setBorder(Rectangle.BOX);

            //set drawable in cell
            Drawable myImage = mCtx.getResources().getDrawable(R.drawable.letterhead);
            Bitmap bitmap = ((BitmapDrawable) myImage).getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] bitmapdata = stream.toByteArray();
            try {
                bgImage = Image.getInstance(bitmapdata);
                bgImage.setAbsolutePosition(900f, 850f);
                cell.addElement(bgImage);
                pt.addCell(cell);//logo added to PDF
                doc.add(pt);

                Paragraph p50 = new Paragraph(sReference1);
                p50.setAlignment(Element.ALIGN_LEFT);
                doc.add(p50);

                Paragraph p60 = new Paragraph("Date: 04.10.2018");
                p60.setAlignment(Element.ALIGN_RIGHT);
                doc.add(p60);

                PdfPTable table = new PdfPTable(4);
                table.setWidthPercentage(100);
                float[] columnWidth = new float[]{40, 40, 40, 50};
                table.setWidths(columnWidth);

                Paragraph p40 = new Paragraph("VALUATION REPORT - TATA INDIGO CS ELX CR4");
                p40.setAlignment(Element.ALIGN_CENTER);
                doc.add(p40);
                cell = new PdfPCell(new Phrase("Purpose"));
                //cell.setBackgroundColor(myColor1);

                table.addCell(cell);
                cell = new PdfPCell(new Phrase(spurpose1));
                //cell.setBackgroundColor(myColor1);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("HMR/KMR"));
                //cell.setBackgroundColor(myColor1);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(sHMRKMR));
                //cell.setBackgroundColor(myColor1);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Bank/ Valuation for"));
                //cell.setBackgroundColor(myColor1);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(sBank));
                //cell.setBackgroundColor(myColor1);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Chassis No."));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(sChassisNumber));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Contract No."));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(sContractno));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Engine No"));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(sEngineNumber));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Request from"));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(sRequestfrom));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("RC NO"));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(srcno));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Asset Make"));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(sAssetMake));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Inspector"));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(sInspector));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Asset Model"));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(sAssetModel));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Location"));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(sLocation));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Year of mfg"));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(sYearofmfg));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("RC Status"));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(""));
                table.addCell(cell);


                cell = new PdfPCell(new Phrase("Repossession Date"));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(srepossessiondate));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Inspection Date"));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(""));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("RC & Fitness Valid"));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(sRCFitnessValid));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Tax Status"));
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(sTaxStatus));
                table.addCell(cell);


                doc.add(table);

                Paragraph p1 = new Paragraph("Assessed Fair Market Realization Value Rs.0.70 Lac (Rupees Seventy Thousand only");
                /* Create Set Font and its Size */
                Font paraFont = new Font();
                paraFont.setSize(10);
                paraFont.setStyle(Font.BOLD);
                paraFont.setStyle(Font.UNDERLINE);
                p1.setAlignment(Paragraph.ALIGN_LEFT);
                p1.setFont(paraFont);

                //add paragraph to document
                doc.add(p1);

                Paragraph p3 = new Paragraph("*- Parking charges extra as applicable");
                /* Create Set Font and its Size */
                Font paraFont1 = new Font();
                paraFont1.setSize(10);
                paraFont1.setStyle(Font.BOLD);
                p3.setAlignment(Paragraph.ALIGN_LEFT);
                p3.setFont(paraFont1);

                //add paragraph to document
                doc.add(p3);


//******************cost to bidder.....

                Paragraph p5 = new Paragraph("COST TO BIDDER");
                /* Create Set Font and its Size */
                Font paraFont5 = new Font();
                paraFont5.setSize(15);
                paraFont5.setStyle(Font.BOLD);
                //paraFont.setStyle(Font.UNDERLINE);
                p5.setAlignment(Paragraph.ALIGN_LEFT);
                p5.setFont(paraFont5);

                //add paragraph to document
                doc.add(p5);

                PdfPTable pt2 = new PdfPTable(9);
                pt2.setWidthPercentage(100);
                float[] columnWidth2 = new float[]{35, 35, 30, 35, 35, 30, 25, 35, 25};
                pt2.setWidths(columnWidth2);

                cell = new PdfPCell(new Phrase("BUYER/BIDDERSMARGIN"));
                pt2.addCell(cell);

                cell = new PdfPCell(new Phrase("WARRANTY COST"));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase("TRANSPORTATION COST"));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase("RTO EXPENSES"));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase("INSURANCE COST"));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase("TAXES+PENALTY"));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase("REFURB COST"));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase("PARKING CHARGES"));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase("TOTAL COST"));
                pt2.addCell(cell);





                cell = new PdfPCell(new Phrase(sbuyer));
                Log.e("pdf",sbuyer);
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase(swarenty_coast));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase(stransportayion_coast));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase(srto_expences));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase(sinsurance_cost));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase(staxes_penalty));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase(srefurb_coast));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase(sparking_charges));
                pt2.addCell(cell);


                cell = new PdfPCell(new Phrase(stotal_coast));
                pt2.addCell(cell);

                doc.add(pt2);


//******************Asset Description.....


                Paragraph p8 = new Paragraph("Asset Description");
                /* Create Set Font and its Size */
                Font paraFont8 = new Font();
                paraFont8.setSize(15);
                paraFont8.setStyle(Font.BOLD);
                //paraFont.setStyle(Font.UNDERLINE);
                p8.setAlignment(Paragraph.ALIGN_LEFT);
                p8.setFont(paraFont8);

                //add paragraph to document
                doc.add(p8);

                PdfPTable pt3 = new PdfPTable(3);
                pt3.setWidthPercentage(100);
                float[] columnWidth3 = new float[]{50, 50, 50};
                pt3.setWidths(columnWidth3);

                cell = new PdfPCell(new Phrase("Assessors"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Parameters"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Engine"));
                cell.setRowspan(8);
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Silencer"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase(cSilencer));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Abnormal Engine Noise"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Not found"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Plugs"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Not Applicable"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Oil"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Found"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Radiator/Condenser"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Oil Leakage"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Found,Rs 1000"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Fan Belts"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Filters"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);


                cell = new PdfPCell(new Phrase("Suspension"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Suspension Noise While Driving Front & Rear"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Steering"));
                cell.setRowspan(3);
                pt3.addCell(cell);


                cell = new PdfPCell(new Phrase("Steering lock"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Available"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Wheel Alignment/Balancing/Wobbing"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Steering Operation"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Brakes"));
                cell.setRowspan(2);
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Pedal Operation"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Brakes and Hand Brake"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Transmission"));
                cell.setRowspan(2);
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Gear Engagement"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Differential and Crown Rear Wheel Drive "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition,Rs 1000/-"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Electrical"));
                cell.setRowspan(5);
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Instrumental Cluster-Warning Lights/Gauges "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase(" Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase(" Alternator"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase(" Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Fuel pump "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase(" Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Battery Condition "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase(" Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase(" Starter Motor"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase(" Average Condition "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("AC function "));
                cell.setRowspan(2);
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase(" Cooling"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Not Applicable "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Heating "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Not Applicable "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Exterior "));
                cell.setRowspan(7);
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase(" Frame/Underbody"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Wind Screen"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Wiper Blades "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Indicators"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Headlights"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Internal & Rear View Mirrors"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Tail Lights"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Interiors"));
                cell.setRowspan(8);
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Power Windows Front"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Not Applicable"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Central Locking"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Not Applicable"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Toolkit"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Not Applicable "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Power Windows Back "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Not Applicable "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Condition of Seats"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Horn"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Roof Wear & Tear "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Headlamp/Indicator Switch"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Tyre Condition"));
                cell.setRowspan(5);
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Wheel-Right Front "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Wheel-Right Rear"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Wheel-Left Front "));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Wheel-Left Rear"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Average Condition"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Wheel Stephaney"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Missing , Rs 5000/-, Servicing Rs 2000/-"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Accessories"));
                cell.setRowspan(7);
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Seat Covers"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Not Available"));
                pt3.addCell(cell);


                cell = new PdfPCell(new Phrase("Fog Lamps"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Not Available"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Music System"));
                pt3.addCell(cell);


                cell = new PdfPCell(new Phrase("Available"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Floor Mats"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Available"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Speakers"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Available"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Tipping System"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Not Applicable"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Odometer"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("NA(Battery was missing"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("Rating"));
                pt3.addCell(cell);

                cell = new PdfPCell(new Phrase("8"));
                cell.setColspan(2);
                pt3.addCell(cell);

                doc.add(pt3);

                Paragraph p9 = new Paragraph("Overall Condition of the Vehicle");
                /* Create Set Font and its Size */
                Font paraFont9 = new Font();
                paraFont9.setSize(15);
                paraFont9.setStyle(Font.BOLD);
                paraFont9.setStyle(Font.UNDERLINE);
                p9.setAlignment(Paragraph.ALIGN_LEFT);
                p9.setFont(paraFont9);

                //add paragraph to document
                doc.add(p9);

                PdfPTable pt4 = new PdfPTable(1);
                pt4.setWidthPercentage(100);
                float[] columnWidth4 = new float[]{150};
                pt4.setWidths(columnWidth4);

                cell = new PdfPCell(new Phrase("Unit was in average for transportation and plying. Unit was in operative condition since battery was misssing.Spare tyre was missing. Overall condition of the vehicle was in average condition"));
                cell.setBorder(Rectangle.BOX);
                pt4.addCell(cell);
                doc.add(pt4);

                Paragraph p10 = new Paragraph("The above mentioned unit is checked by us at UTSA PARKING (HOOGHLY) on 02.10.2018 without opening and dismantling any inner site or component(Without disturbing its present condition). In Inspection  the vehicle was in average condition. The wheels where found in average condition. For the above said (used and semi worn/torn) vehicle, the Monetary value comes in Rupees Sixty Nine Thousand Only considering the age, depreciation factors, indexes of P/M valuation , wear & tear, technical obsolescence, commercial obsolescence etc. and with the comparision of used pickup market. No descripancy is found on the chassis & engine mismatch .");
                /* Create Set Font and its Size */
                Font paraFont10 = new Font();
                paraFont10.setSize(10);
                paraFont10.setStyle(Font.BOLD);
                paraFont10.setStyle(Font.UNDERLINE);
                p10.setAlignment(Paragraph.ALIGN_LEFT);
                p10.setFont(paraFont10);

                //add paragraph to document
                doc.add(p10);

                Paragraph p11 = new Paragraph("               ");
                doc.add(p11);

                Paragraph p12 = new Paragraph("Assessed Fare Market Realization Value Rs.0.69 Lakh (Rupees Sixty Nine Thousand only).");
                /* Create Set Font and its Size */
                Font paraFont12 = new Font();
                paraFont12.setSize(10);
                paraFont12.setStyle(Font.BOLD);
                paraFont12.setStyle(Font.UNDERLINE);
                p12.setAlignment(Paragraph.ALIGN_LEFT);
                p12.setFont(paraFont12);

                //add paragraph to document
                doc.add(p12);

                Paragraph p13 = new Paragraph("      ");
                doc.add(p13);
                Paragraph p14 = new Paragraph("               ");
                doc.add(p14);

                Paragraph p15 = new Paragraph("INDRANIL AICH ");
                Font paraFont15 = new Font();
                paraFont15.setSize(12);
                p15.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p15);

                Paragraph p16 = new Paragraph("CHAIRTERED ENGINEER/APPROVED VALUER FIV 318328  ");
                Font paraFont16 = new Font();
                paraFont16.setSize(12);
                p16.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p16);

                Paragraph p17 = new Paragraph("THE INSTITUTION OF ENGINEERS (INDIA) ");
                Font paraFont17 = new Font();
                paraFont17.setSize(12);
                p17.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p17);

                Paragraph p18 = new Paragraph("BE PRODUCTION MRICS MEMBERSHIP NUMBER MIRCS1267050 ");
                Font paraFont18 = new Font();
                paraFont18.setSize(12);
                p18.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p18);

                Paragraph p19 = new Paragraph("MIE-MEMBERSHIP NUMBER M 132302-9 ");
                Font paraFont19 = new Font();
                paraFont19.setSize(12);
                p19.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p19);

                Paragraph p20 = new Paragraph("PANEL ARBITRATOR ICA UNDER FICCI  ");
                Font paraFont20 = new Font();
                paraFont20.setSize(12);
                p20.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p20);

                Paragraph p21 = new Paragraph("      ");
                doc.add(p21);
                Paragraph p22 = new Paragraph("               ");
                doc.add(p22);

                PdfPTable pt6 = new PdfPTable(1);
                pt6.setWidthPercentage(20);
                float[] f6 = new float[]{100};
                pt6.setWidths(f6);

                cell = new PdfPCell();
                Drawable myImagei = mCtx.getResources().getDrawable(R.drawable.stamp);
                Bitmap bitmapi = ((BitmapDrawable) myImagei).getBitmap();
                ByteArrayOutputStream streami = new ByteArrayOutputStream();
                bitmapi.compress(Bitmap.CompressFormat.PNG, 100, streami);
                byte[] bitmapdatai = streami.toByteArray();
                Image bgImagei = Image.getInstance(bitmapdatai);
                bgImagei.setAbsolutePosition(5000f, 100f);
                cell.addElement(bgImagei);
                cell.setBorder(Rectangle.NO_BORDER);
                pt6.addCell(cell);//image a added

                doc.add(pt6);

                Paragraph p23 = new Paragraph("Signatures________________________ ");
                Font paraFont23 = new Font();
                paraFont23.setSize(12);
                p23.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p23);


                Paragraph p24 = new Paragraph("      ");
                doc.add(p24);
                Paragraph p25 = new Paragraph("               ");
                doc.add(p25);

                Paragraph p26 = new Paragraph("Note:");
                Font paraFont26 = new Font();
                paraFont26.setSize(12);
                p26.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p26);

                Paragraph p27 = new Paragraph("               ");
                doc.add(p27);

                Paragraph p28 = new Paragraph("-  As per IVSC (International Valuation Standards Committee)2011-the standards w.e.f 01.01.2012,IVS2020 Plant and Equipment is applicabe to this asset.");
                Font paraFont28 = new Font();
                paraFont28.setSize(12);
                p28.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p28);

                Paragraph p29 = new Paragraph("-  The Valuation concludes on the same day after Physical Inspection and without Prejudice");
                Font paraFont29 = new Font();
                paraFont29.setSize(12);
                p29.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p29);

                Paragraph p30 = new Paragraph("-  The report is confidential to Tata Motors Finance Ltd. ");
                Font paraFont30 = new Font();
                paraFont30.setSize(12);
                p30.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p30);

                Paragraph p31 = new Paragraph("-The legal matter is solicited by Financier's Solicitor.");
                Font paraFont31 = new Font();
                paraFont31.setSize(12);
                p31.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p31);

                Paragraph p32 = new Paragraph("-  Financier/Banker is suggested to check the ownership and free hold interest of the equipment priority basis before approving any loan/Advance,sale of Repossessed Asset or any other activity entailing exchange of revenue ");
                Font paraFont32 = new Font();
                paraFont32.setSize(12);
                p32.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p32);

                Paragraph p33 = new Paragraph("-  The valuer is asked for Normal Physical Market Value -Only of the specified equipment, on the basis of his/their Professional Qualification & Experience.");
                Font paraFont33 = new Font();
                paraFont33.setSize(12);
                p33.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p33);

                Paragraph p34 = new Paragraph("-  Cost to bidder is an estimation only and is delinked to IVSC standard's and given on request of the financier.");
                Font paraFont34 = new Font();
                paraFont34.setSize(12);
                p34.setAlignment(Paragraph.ALIGN_LEFT);
                doc.add(p34);


                //*************images***
                doc.newPage();
                PdfPTable pt5 = new PdfPTable(2);
                pt5.setWidthPercentage(100);
                float[] f5 = new float[]{100, 100};
                pt5.setWidths(f5);

                cell = new PdfPCell();
                //cell.setBorder(Rectangle.BOX);

                //set drawable in cell
                Drawable myImagea = mCtx.getResources().getDrawable(R.drawable.a);
                Bitmap bitmapa = ((BitmapDrawable) myImagea).getBitmap();
                ByteArrayOutputStream streama = new ByteArrayOutputStream();
                bitmapa.compress(Bitmap.CompressFormat.PNG, 100, streama);
                byte[] bitmapdataa = streama.toByteArray();
                bgImagea = Image.getInstance(bitmapdataa);
                bgImagea.setAbsolutePosition(300f, 850f);
                cell.addElement(bgImagea);
                pt5.addCell(cell);//image a added

                cell = new PdfPCell();
                Drawable myImageb = mCtx.getResources().getDrawable(R.drawable.b);
                Bitmap bitmapb = ((BitmapDrawable) myImageb).getBitmap();
                ByteArrayOutputStream streamb = new ByteArrayOutputStream();
                bitmapb.compress(Bitmap.CompressFormat.PNG, 100, streamb);
                byte[] bitmapdatab = streamb.toByteArray();
                bgImageb = Image.getInstance(bitmapdatab);
                bgImageb.setAbsolutePosition(300f, 850f);
                cell.addElement(bgImageb);
                pt5.addCell(cell);//image a added


                cell = new PdfPCell();
                Drawable myImagec = mCtx.getResources().getDrawable(R.drawable.c);
                Bitmap bitmapc = ((BitmapDrawable) myImagec).getBitmap();
                ByteArrayOutputStream streamc = new ByteArrayOutputStream();
                bitmapc.compress(Bitmap.CompressFormat.PNG, 100, streamc);
                byte[] bitmapdatac = streamc.toByteArray();
                bgImagec = Image.getInstance(bitmapdatac);
                bgImagec.setAbsolutePosition(300f, 850f);
                cell.addElement(bgImagec);
                pt5.addCell(cell);//image a added

                cell = new PdfPCell();
                Drawable myImaged = mCtx.getResources().getDrawable(R.drawable.d);
                Bitmap bitmapd = ((BitmapDrawable) myImaged).getBitmap();
                ByteArrayOutputStream streamd = new ByteArrayOutputStream();
                bitmapd.compress(Bitmap.CompressFormat.PNG, 100, streamd);
                byte[] bitmapdatad = streamb.toByteArray();
                bgImaged = Image.getInstance(bitmapdatad);
                bgImaged.setAbsolutePosition(300f, 850f);
                cell.addElement(bgImaged);
                pt5.addCell(cell);//image a added

                cell = new PdfPCell();
                Drawable myImagee = mCtx.getResources().getDrawable(R.drawable.e);
                Bitmap bitmape = ((BitmapDrawable) myImagee).getBitmap();
                ByteArrayOutputStream streame = new ByteArrayOutputStream();
                bitmape.compress(Bitmap.CompressFormat.PNG, 100, streame);
                byte[] bitmapdatae = streamb.toByteArray();
                bgImagee = Image.getInstance(bitmapdatae);
                bgImagee.setAbsolutePosition(300f, 850f);
                cell.addElement(bgImagee);
                pt5.addCell(cell);//image a added

                cell = new PdfPCell();
                Drawable myImagef = mCtx.getResources().getDrawable(R.drawable.f);
                Bitmap bitmapf = ((BitmapDrawable) myImagef).getBitmap();
                ByteArrayOutputStream streamf = new ByteArrayOutputStream();
                bitmapf.compress(Bitmap.CompressFormat.PNG, 100, streamf);
                byte[] bitmapdataf = streamf.toByteArray();
                bgImagef = Image.getInstance(bitmapdataf);
                bgImagef.setAbsolutePosition(300f, 850f);
                cell.addElement(bgImagef);
                pt5.addCell(cell);//image a added

                cell = new PdfPCell();
                Drawable myImageg = mCtx.getResources().getDrawable(R.drawable.g);
                Bitmap bitmapg = ((BitmapDrawable) myImageg).getBitmap();
                ByteArrayOutputStream streamg = new ByteArrayOutputStream();
                bitmapg.compress(Bitmap.CompressFormat.PNG, 100, streamg);
                byte[] bitmapdatag = streamg.toByteArray();
                bgImageg = Image.getInstance(bitmapdatag);
                bgImageg.setAbsolutePosition(300f, 850f);
                cell.addElement(bgImageg);
                pt5.addCell(cell);//image a added

                cell = new PdfPCell();
                Drawable myImageh = mCtx.getResources().getDrawable(R.drawable.h);
                Bitmap bitmaph = ((BitmapDrawable) myImageh).getBitmap();
                ByteArrayOutputStream streamh = new ByteArrayOutputStream();
                bitmaph.compress(Bitmap.CompressFormat.PNG, 100, streamh);
                byte[] bitmapdatah = streamh.toByteArray();
                bgImageh = Image.getInstance(bitmapdatah);
                bgImageh.setAbsolutePosition(300f, 850f);
                cell.addElement(bgImageh);
                pt5.addCell(cell);//image a added

                doc.add(pt5);
                Toast.makeText(mCtx, "created PDF", Toast.LENGTH_LONG).show();


            } catch (DocumentException de) {
                Log.e("PDFCreator", "DocumentException:" + de);
            } catch (IOException e) {
                Log.e("PDFCreator", "ioException:" + e);
            } finally {
                doc.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

