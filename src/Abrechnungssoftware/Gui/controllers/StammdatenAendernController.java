package Abrechnungssoftware.Gui.controllers;

import Abrechnungssoftware.DB.DB_CON;
import Abrechnungssoftware.DB.Stammdaten;
import Abrechnungssoftware.Gui.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class StammdatenAendernController
{
    @FXML
    private AnchorPane stammdatenAendern;

    @FXML
    private TextField firma, vorname, nachname, strasse, nummer, ort, plz, telefon, telefax, website, mail, bank;
    @FXML
    private TextField iban, bic, inhaber, steuernr;

    @FXML
    private Label meldung;


    private MainController mainController;

    public void injectMainController(MainController mainController)
    {
        this.mainController = mainController;
    }

    public AnchorPane getStammdatenAendern()
    {
        return stammdatenAendern;
    }


    public void DatensaetzeEinsetzen()
    {

        try
        {
            DB_CON db = mainController.getDb();
            Stammdaten stammdaten = mainController.getStammdaten();
            db.LoadStammdaten(stammdaten);

            firma.setText(stammdaten.getFirma());
            vorname.setText(stammdaten.getVorname());
            nachname.setText(stammdaten.getNachname());
            strasse.setText(stammdaten.getStr());
            nummer.setText(stammdaten.getHsnr());
            ort.setText(stammdaten.getOrt());
            plz.setText(stammdaten.getPlz());
            telefon.setText(stammdaten.getTelefon());
            telefax.setText(stammdaten.getTelefax());
            website.setText(stammdaten.getWeb());
            mail.setText(stammdaten.getEmail());
            steuernr.setText(stammdaten.getSteuernummer());
            bank.setText(stammdaten.getBankname());
            inhaber.setText(stammdaten.getKontoinhaber());
            iban.setText(stammdaten.getIban());
            bic.setText(stammdaten.getBic());

        } catch (Exception e)
        {
            e.printStackTrace();
            meldung.setText("Fehler beim Lesen!");
        }
    }

    public void DatensaetzeAendern()
    {
        try
        {
            DB_CON db = mainController.getDb();
            Stammdaten stammdaten = mainController.getStammdaten();
            db.LoadStammdaten(stammdaten);

            stammdaten.setFirma(firma.getText());
            stammdaten.setVorname(vorname.getText());
            stammdaten.setNachname(nachname.getText());
            stammdaten.setStr(strasse.getText());
            stammdaten.setHsnr(nummer.getText());
            stammdaten.setOrt(ort.getText());
            stammdaten.setPlz(plz.getText());
            stammdaten.setTelefon(telefon.getText());
            stammdaten.setTelefax(telefax.getText());
            stammdaten.setWeb(website.getText());
            stammdaten.setEmail(mail.getText());
            stammdaten.setSteuernummer(steuernr.getText());
            stammdaten.setBankname(bank.getText());
            stammdaten.setKontoinhaber(inhaber.getText());
            stammdaten.setIban(iban.getText());
            stammdaten.setBic(bic.getText());

            mainController.getDb().SaveStammdaten(stammdaten);

            meldung.setText("Änderungen gespeichert!");
            meldung.setTextFill(Color.GREEN);
        } catch (Exception e)
        {
            e.printStackTrace();
            meldung.setText("Fehler beim Speichern!");
        }
    }


}
