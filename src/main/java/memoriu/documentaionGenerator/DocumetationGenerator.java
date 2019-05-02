package memoriu.documentaionGenerator;

import memoriu.building.Building;
import memoriu.person.Person;
import memoriu.project.Project;
import memoriu.project.ProjectSubType;
import memoriu.project.utilities.Utilities;
import memoriu.property.Property;
import memoriu.utr.UTR;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;

public class DocumetationGenerator {

    private ProjectDataExtractor projectDataExtractor;


    public DocumetationGenerator(Project project) {
        this.projectDataExtractor =  new ProjectDataExtractor(project);
    }

    public void genereazaMemoriu() {
        XWPFDocument document = createDocument();
        File file =
                new File("Memoriu C.U.docx");

        try {
            FileOutputStream outputFileStream = new FileOutputStream(file);
            foaieDeGarda(document, outputFileStream);
            borderou(document, outputFileStream);
            capitolulUnu(document, outputFileStream);
            capitolulDoi(document, outputFileStream);
            capitolulTrei(document, outputFileStream);
            capitolulPatru(document, outputFileStream);
            capitolulCinci(document, outputFileStream);
            document.write(outputFileStream);
            outputFileStream.close();
            Desktop.getDesktop().open(new File("Memoriu C.U.docx"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private XWPFDocument createDocument() {
        return new XWPFDocument();
    }

    private void foaieDeGarda(XWPFDocument document, FileOutputStream out) throws IOException {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(16);
        run.setCapitalized(true);
        run.setText("FOAIE DE GARDA");
        tabelLucrare(document, out);
        paragraph.setPageBreak(true);
        run.addCarriageReturn();
        System.out.println("Foaie de garda written successfully");
    }

    private void borderou(XWPFDocument document, FileOutputStream out) throws IOException {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(16);
        run.setCapitalized(true);
        run.setText("BORDEROU");
        borderouLucrare(document, out);
        paragraph.setPageBreak(true);
        run.addCarriageReturn();
        System.out.println("Borderou written successfully");

    }

    private void capitolulUnu(XWPFDocument document, FileOutputStream out) throws IOException {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(16);
        run.setCapitalized(true);
        run.setText("");
        paragraph.setPageBreak(true);
        run.addCarriageReturn();
        chapterTitle("Memoriu Certificat de urbanism", document);
        chapterSubtitle("1.1 Date de recunoastere a documentatiei", document);
        tabelLucrare(document, out);
        run.addCarriageReturn();
        System.out.println("Capitolul Unu written successfully");
    }

    private void capitolulDoi(XWPFDocument document, FileOutputStream out) throws IOException {
        chapterSubtitle("1.2.Obiectul lucrarii:", document);
        createParagraph("Actuala documentatie este intocmita pentru a servi la obtinerea certificatului de urbanism, " +
                "in vederea \" " + projectDataExtractor.getTitle() + " \"  pe terenul " +
                "situat in " + projectDataExtractor.getProjectAddress() + "."
                , document);
        createParagraph("Terenul  se afla in proprietatea " + projectDataExtractor.getBeneficiari() + " conform actului de propietate: " + "___"
                        + "  . Terenul /imobilul are o  suprafata de " + projectDataExtractor.getProjectArea() + " mp" +
                        " si  este situat in " + projectDataExtractor.getGeneralAddress(),
                document);

    }

    private void capitolulTrei(XWPFDocument document, FileOutputStream out) throws IOException {
        chapterSubtitle("1.3.Incadrare in zona", document);
        createParagraph("Zona studiata se afla in " + projectDataExtractor.getProjectAddress() +
                ", nr. Cadastral: " + projectDataExtractor.getCadastralNumbers() + ".", document);
        createParagraph("Vecinatati:", document);
        createParagraph("Nord:", document);
        createParagraph("Est:", document);
        createParagraph("Sud:", document);
        createParagraph("Vest:", document);
        createParagraph("Terenul care face obiectul studiului se incadreaza in urmatoarele documentatii de urbanism:", document);
        //here here//
        for (Property p : projectDataExtractor.getProperties()) {
            createBoldParagraph(p.getAddress().toString() + ": ", document);
            for (UTR u : p.getUTRS()
            ) {
                createBoldParagraph(u.getName() + "-" + u.getDenumire() + ": ", document);
                createBoldParagraph("INDICATORI URBANISTICI EXISTENTI", document);
                createBoldParagraph("POT: " + u.getPOT() + " %", document);
                createBoldParagraph("CUT: " + u.getCUT() + " mp/ADC", document);
                createBoldParagraph("R.H. : " + u.getRegimInaltime(), document);
            }

        }
    }

    private void capitolulPatru(XWPFDocument document, FileOutputStream out) throws IOException {
        chapterSubtitle("1.4 Situatia existenta:", document);
        createBoldParagraph("SUPRAFATA TEREN = " + projectDataExtractor.getProjectArea() + " mp."
                , document);
        createBoldParagraph("Fond construit:", document);
        if (projectDataExtractor.projectHasExistingBuildings()) {
            createParagraph("In prezent zona studiata are urmatoarele " +
                    "constructii:", document);
            for (Property property : projectDataExtractor.getProperties()) {
                if (property.getBuildings().size() > 0) {
                    createParagraph("Teren n.c." + property.getCadastralNumber() +
                            ": ", document);
                    for (Building b : property.getBuildings()
                    ) {
                        createParagraph(b.getBuildingInformations(), document);
                    }
                }
            }
        } else {
            createParagraph("In prezent terenul este liber de sarcini, pe teren nu sunt constructii.", document);
        }
        createBoldParagraph("Circulatii:", document);
        createParagraph("Accesul se face prin strada " + projectDataExtractor.getMainStreet() + ".",
                document);
        createBoldParagraph("Retele edilitare:", document);
        if (projectDataExtractor.projectHasUtilities()){
            createParagraph("Terenul studiat beneficiaza de urmatoarele " +
                    "utilitati: " + projectDataExtractor.getCurrentUtilities(),document);
        } else {
            createParagraph("Terenul studiat nu este echipat cu retele tehnico-edilitare: electrica, apa, canalizare,telefonie.", document);
        }

    }

    private void capitolulCinci(XWPFDocument document, FileOutputStream out) throws IOException {
        chapterSubtitle("1.5.Situatia propusa:", document);
        createParagraph("La solicitarea beneficiarului se propune " + projectDataExtractor.getTitle() +
                ". Functionalitatea cladirii este obiectul unui studiu de optimizare a partiului, in raport cu cerintele beneficiarului si necesitatile prevazute in normele de proiectare.", document);
        createParagraph("Se va asigura o buna functionare in exploatare. Arhitectura noilor cladiri va respecta caracterul arhitectural general al zonei, înscriindu-se, înainte de toate, în scara definita de cladirile existente.", document);
        createBoldParagraph("INDICATORI URBANISTICI PROPUSI", document);
        for (Property p : projectDataExtractor.getProperties()) {
            createBoldParagraph(p.getAddress().toString() + ": ", document);
            for (UTR u : p.getNewUTRS()
            ) {
                createBoldParagraph(u.getName() + "-" + u.getDenumire() + ": ", document);
                createBoldParagraph("INDICATORI URBANISTICI PROPUSI", document);
                createBoldParagraph("POT: " + u.getPOT() + " %", document);
                createBoldParagraph("CUT: " + u.getCUT() + " mp/ADC", document);
                createBoldParagraph("R.H. : " + u.getRegimInaltime(), document);
            }

        }
        createBoldParagraph("Intocmit,",document);
        createBoldParagraph(projectDataExtractor.getDocCreator(),document);
        createBoldParagraph("Verificat,",document);
        createBoldParagraph(projectDataExtractor.getChiefDeveloper(),document);
    }

    private void tabelLucrare(XWPFDocument document, FileOutputStream out) throws IOException {
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        table.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(10000));

        XWPFTableRow tableRowOne = table.getRow(0);
        tableRowOne.getCell(0).setText("Nr.Crt.");
        tableRowOne.addNewTableCell().setText("Obiectul");
        tableRowOne.addNewTableCell().setText("-");

        XWPFTableRow tableRowTwo = table.createRow();
        tableRowTwo.getCell(0).setText("1");
        tableRowTwo.getCell(1).setText("NUMĂR PROIECT:");
        tableRowTwo.getCell(2).setText("");

        XWPFTableRow tableRowThree = table.createRow();
        tableRowThree.getCell(0).setText("2");
        tableRowThree.getCell(1).setText("DENUMIREA LUCRĂRII:");
        tableRowThree.getCell(2).setText(projectDataExtractor.getTitle());

        XWPFTableRow tableRowFour = table.createRow();
        tableRowFour.getCell(0).setText("3");
        tableRowFour.getCell(1).setText("FAZA:");
        tableRowFour.getCell(2).setText(projectDataExtractor.getProjectType());

        XWPFTableRow tableRowFive = table.createRow();
        tableRowFive.getCell(0).setText("4");
        tableRowFive.getCell(1).setText("ADRESA:");
        tableRowFive.getCell(2).setText(projectDataExtractor.getProjectAddress());

        XWPFTableRow tableRowSix = table.createRow();
        tableRowSix.getCell(0).setText("5");
        tableRowSix.getCell(1).setText("BENEFICIAR:");
        tableRowSix.getCell(2).setText(projectDataExtractor.getBeneficiari());

        XWPFTableRow tableRowSeven = table.createRow();
        tableRowSeven.getCell(0).setText("6");
        tableRowSeven.getCell(1).setText("PROIECTANT GENERAL:");
        tableRowSeven.getCell(2).setText(projectDataExtractor.getProjectDeveloper().getName());

        XWPFTableRow tableRowEight = table.createRow();
        tableRowEight.getCell(0).setText("7");
        tableRowEight.getCell(1).setText("Sef Proiecte:");
        tableRowEight.getCell(2).setText(projectDataExtractor.getChiefDeveloper());

        XWPFTableRow tableRowNine = table.createRow();
        tableRowNine.getCell(0).setText("");
        tableRowNine.getCell(1).setText("Proiectat");
        tableRowNine.getCell(2).setText(projectDataExtractor.getPrjDeveloper());

        XWPFTableRow tableRowTen = table.createRow();
        tableRowTen.getCell(0).setText("");
        tableRowTen.getCell(1).setText("Intocmit:");
        tableRowTen.getCell(2).setText(projectDataExtractor.getDocCreator());

        CTTblPr tblpro = table.getCTTbl().getTblPr();

        CTTblBorders borders = tblpro.addNewTblBorders();
        borders.addNewBottom().setVal(STBorder.SINGLE);
        borders.addNewLeft().setVal(STBorder.NONE);
        borders.addNewRight().setVal(STBorder.NONE);
        borders.addNewTop().setVal(STBorder.SINGLE);

        borders.addNewInsideH().setVal(STBorder.NONE);
        borders.addNewInsideV().setVal(STBorder.NONE);


    }

    private void borderouLucrare(XWPFDocument document, FileOutputStream out) throws IOException {
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        table.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(10000));

        XWPFTableRow tableRowOne = table.getRow(0);
        tableRowOne.getCell(0).setText("Nr.Crt.");
        tableRowOne.addNewTableCell().setText("Plansa");
        tableRowOne.addNewTableCell().setText("Scara");

        XWPFTableRow tableRowTwo = table.createRow();
        tableRowTwo.getCell(0).setText("1");
        tableRowTwo.getCell(1).setText("Documentatia Scrisa");
        tableRowTwo.getCell(2).setText("-");

        XWPFTableRow tableRowThree = table.createRow();
        tableRowThree.getCell(0).setText("2");
        tableRowThree.getCell(1).setText("Plansa incadrare in localitate");
        tableRowThree.getCell(2).setText("-");

        XWPFTableRow tableRowFour = table.createRow();
        tableRowFour.getCell(0).setText("3");
        tableRowFour.getCell(1).setText("Plansa incadrare in UTR_PUG_Bucuresti");
        tableRowFour.getCell(2).setText("-");

        XWPFTableRow tableRowFive = table.createRow();
        tableRowFive.getCell(0).setText("4");
        tableRowFive.getCell(1).setText("Plansa situatie existenta");
        tableRowFive.getCell(2).setText("1:500");

        XWPFTableRow tableRowSix = table.createRow();
        tableRowSix.getCell(0).setText("5");
        tableRowSix.getCell(1).setText("Plansa situatie propusa");
        tableRowSix.getCell(2).setText("1:500");

        XWPFTableRow tableRowSeven = table.createRow();
        tableRowSeven.getCell(0).setText("6");
        tableRowSeven.getCell(1).setText("Planuri OCPI");
        tableRowSeven.getCell(2).setText("1:500/ 1:2000");

        CTTblPr tblpro = table.getCTTbl().getTblPr();

        CTTblBorders borders = tblpro.addNewTblBorders();
        borders.addNewBottom().setVal(STBorder.SINGLE);
        borders.addNewLeft().setVal(STBorder.NONE);
        borders.addNewRight().setVal(STBorder.NONE);
        borders.addNewTop().setVal(STBorder.SINGLE);
//also inner borders
        borders.addNewInsideH().setVal(STBorder.SINGLE);
        borders.addNewInsideV().setVal(STBorder.NONE);


    }

    private void chapterSubtitle(String titlu, XWPFDocument document) throws IOException {
        XWPFParagraph paragraphTwo = document.createParagraph();
        paragraphTwo.setIndentationHanging(-1500);
        XWPFRun run = paragraphTwo.createRun();
        run.setBold(true);
        run.setFontSize(14);
        run.setCapitalized(true);
        run.setUnderline(UnderlinePatterns.SINGLE);
        run.setText(titlu);
    }

    private void chapterTitle(String titlu, XWPFDocument document) throws IOException {
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraphOne.createRun();
        run.setBold(true);
        run.setFontSize(16);
        run.setCapitalized(true);
        run.setUnderline(UnderlinePatterns.SINGLE);
        run.setText(titlu);
    }


    private void createParagraph(String text, XWPFDocument document) {
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setIndentationHanging(-750);
        XWPFRun run = paragraphOne.createRun();
        run.setFontSize(12);
        run.setText(text);
    }

    private void createBoldParagraph(String text, XWPFDocument document) {
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setIndentationHanging(-750);
        XWPFRun run = paragraphOne.createRun();
        run.setFontSize(12);
        run.setText(text);
        run.setBold(true);
    }

    private void setTableAlign(XWPFTable table, ParagraphAlignment align) {
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        CTJc jc = (tblPr.isSetJc() ? tblPr.getJc() : tblPr.addNewJc());
        STJc.Enum en = STJc.Enum.forInt(align.getValue());
        jc.setVal(en);
    }

}
