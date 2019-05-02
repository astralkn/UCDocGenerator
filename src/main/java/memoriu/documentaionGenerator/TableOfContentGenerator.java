package memoriu.documentaionGenerator;

import memoriu.person.LegalPerson;
import memoriu.person.Person;
import memoriu.project.Project;
import memoriu.project.ProjectSubType;
import memoriu.property.Property;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class TableOfContentGenerator {

    private XWPFDocument document;
    private ProjectDataExtractor projectDataExtractor;

    public TableOfContentGenerator(Project project) {
        this.projectDataExtractor =  new ProjectDataExtractor(project);
    }

    public void generateTableOfContent(){
        document = new XWPFDocument();
        File file = new File("Opis.docx");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            writeFirstSectionToDocument(fileOutputStream);
            finalParagraph();

            document.write(fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void writeFirstSectionToDocument(FileOutputStream fileOutputStream) throws IOException {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setFontSize(16);
        run.setCapitalized(true);
        run.setText("OPIS");
        tabelLucrare(document, fileOutputStream);
        paragraph.setPageBreak(true);
        run.addCarriageReturn();
    }

    private void tabelLucrare(XWPFDocument document, FileOutputStream out) throws IOException {
        XWPFTable table = document.createTable();
        setTableAlign(table, ParagraphAlignment.CENTER);
        table.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(10000));

        XWPFTableRow tableRowOne = table.getRow(0);
        tableRowOne.getCell(0).setText("Nr.Crt.");
        tableRowOne.addNewTableCell().setText("Documentul");
        tableRowOne.addNewTableCell().setText("Nr. File");

        XWPFTableRow tableRowTwo = table.createRow();
        tableRowTwo.getCell(0).setText("1");
        tableRowTwo.getCell(1).setText("Cerere Tip");
        tableRowTwo.getCell(2).setText("");

        XWPFTableRow tableRowThree = table.createRow();
        tableRowThree.getCell(0).setText("2");
        tableRowThree.getCell(1).setText("Opis");
        tableRowThree.getCell(2).setText("");

        XWPFTableRow tableRowFour = table.createRow();
        tableRowFour.getCell(0).setText("3");
        tableRowFour.getCell(1).setText("Imputernicire");
        tableRowFour.getCell(2).setText("");

        XWPFTableRow tableRowFive = table.createRow();
        tableRowFive.getCell(0).setText("4");
        tableRowFive.getCell(1).setText("Delegatie");
        tableRowFive.getCell(2).setText("");

        XWPFTableRow tableRowSix = table.createRow();
        tableRowSix.getCell(0).setText("5");
        tableRowSix.getCell(1).setText("C.I. Delegat");
        tableRowSix.getCell(2).setText("");

        XWPFTableRow tableRowSeven = table.createRow();
        tableRowSeven.getCell(0).setText("6");
        tableRowSeven.getCell(1).setText("CUI " + projectDataExtractor.getProjectDeveloper().getName() + "(proiectant)");
        tableRowSeven.getCell(2).setText("");

        int nrCrt = 7;

        for (Person p: projectDataExtractor.getInvestors()
             ) {
            XWPFTableRow tableRowEight = table.createRow();
            tableRowEight.getCell(0).setText(String.valueOf(nrCrt));
            if (p.getClass() == LegalPerson.class){
                tableRowEight.getCell(1).setText("CUI " + p.getName());
            } else {
                tableRowEight.getCell(1).setText("CI " + p.getName());
            }
            tableRowEight.getCell(2).setText("");
            nrCrt++;
        }

        for (Property p: projectDataExtractor.getProperties()
             ) {
            XWPFTableRow tableRowEight = table.createRow();
            tableRowEight.getCell(0).setText(String.valueOf(nrCrt));
            tableRowEight.getCell(1).setText(p.getPropertyActs().getType() +
                    "- " + p.getPropertyActs().getNumberAndIssueDate() + "+ " +
                    "intabulare");
            tableRowEight.getCell(2).setText("");
            nrCrt++;
        }

        for (Property p: projectDataExtractor.getProperties()
             ) {
            if (p.getAddress().getCity().equals("Bucuresti")){
                XWPFTableRow tableRowEight = table.createRow();
                tableRowEight.getCell(0).setText(String.valueOf(nrCrt));
                tableRowEight.getCell(1).setText("Planuri OCPI 1:500/1:2000 " +
                        "x2 color");
                tableRowEight.getCell(2).setText("");
                nrCrt++;
            } else {
                XWPFTableRow tableRowEight = table.createRow();
                tableRowEight.getCell(0).setText(String.valueOf(nrCrt));
                tableRowEight.getCell(1).setText("Planuri de incadrare 1:2000" +
                        "/1:5000 "+ p.getAddress().getStreet() + ", numarul " + p.getAddress().getStreetNumber()+" x2 " +
                        "color");
                tableRowEight.getCell(2).setText("");
                nrCrt++;
                XWPFTableRow tableRowNine = table.createRow();
                tableRowNine.getCell(0).setText(String.valueOf(nrCrt));
                tableRowNine.getCell(1).setText("Ortofotoplan"+p.getAddress().getStreet() + ", numarul " + p.getAddress().getStreetNumber()+" x2 color");
                tableRowNine.getCell(2).setText("");
            }

        }

        if (projectDataExtractor.getProjectType().equals(ProjectSubType.DTAD.getName())){
            XWPFTableRow tableRowEight = table.createRow();
            tableRowEight.getCell(0).setText(String.valueOf(nrCrt));
            tableRowEight.getCell(1).setText("Releveu cladiri ce urmeaza a fi" +
                    " demolate");
            tableRowEight.getCell(2).setText("");
            nrCrt++;
        }

        if (projectDataExtractor.getTotalBuildings() > 0){
            XWPFTableRow tableRowEightTwo = table.createRow();
            tableRowEightTwo.getCell(0).setText(String.valueOf(nrCrt));
            tableRowEightTwo.getCell(1).setText("Autorizatia de construire a " +
                    "cladirilor existente");
            tableRowEightTwo.getCell(2).setText("");
            nrCrt++;
        }


        XWPFTableRow tableRowNine = table.createRow();
        tableRowNine.getCell(0).setText(String.valueOf(nrCrt));
        tableRowNine.getCell(1).setText("Memoriu C.U.");
        tableRowNine.getCell(2).setText("");
        nrCrt++;

        XWPFTableRow tableRowTen = table.createRow();
        tableRowTen.getCell(0).setText(String.valueOf(nrCrt));
        tableRowTen.getCell(1).setText("Incadrare in teritoriu x2");
        tableRowTen.getCell(2).setText("");
        nrCrt++;

        XWPFTableRow tableRowEleven = table.createRow();
        tableRowEleven.getCell(0).setText(String.valueOf(nrCrt));
        tableRowEleven.getCell(1).setText("Incadrare in documentatia de " +
                "urbanism existenta" +
                " x2");
        tableRowEleven.getCell(2).setText("");
        nrCrt++;

        XWPFTableRow tableRowTwelve = table.createRow();
        tableRowTwelve.getCell(0).setText(String.valueOf(nrCrt));
        tableRowTwelve.getCell(1).setText("Plan propunere x2");
        tableRowTwelve.getCell(2).setText("");

        CTTblPr tblpro = table.getCTTbl().getTblPr();

        CTTblBorders borders = tblpro.addNewTblBorders();
        borders.addNewBottom().setVal(STBorder.SINGLE);
        borders.addNewLeft().setVal(STBorder.SINGLE);
        borders.addNewRight().setVal(STBorder.SINGLE);
        borders.addNewTop().setVal(STBorder.SINGLE);

        borders.addNewInsideH().setVal(STBorder.SINGLE);
        borders.addNewInsideV().setVal(STBorder.SINGLE);


    }

    private void setTableAlign(XWPFTable table, ParagraphAlignment align) {
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        CTJc jc = (tblPr.isSetJc() ? tblPr.getJc() : tblPr.addNewJc());
        STJc.Enum en = STJc.Enum.forInt(align.getValue());
        jc.setVal(en);
    }

    private void finalParagraph(){
        createBoldParagraph("Intocmit,",document);
        createBoldParagraph(projectDataExtractor.getDocCreator(),document);
    }

    private void createBoldParagraph(String text, XWPFDocument document) {
        XWPFParagraph paragraphOne = document.createParagraph();
        paragraphOne.setIndentationHanging(-750);
        XWPFRun run = paragraphOne.createRun();
        run.setFontSize(12);
        run.setText(text);
        run.setBold(true);
    }
}
