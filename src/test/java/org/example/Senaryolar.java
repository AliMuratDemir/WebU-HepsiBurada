package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.base.BasePage;
import utilities.base.BaseTest;
import utilities.helper.Configuration;

public class Senaryolar extends BaseTest {
    private static Configuration config = Configuration.getInstance();
    private WebDriver driver = BaseTest.getDriver();
    private BasePage basePage = new BasePage(driver);

    public By Arabuton=By.xpath("//div[contains(text(),'ARA')]");

    @Step("Sayfayi ac")
    public void sayfayiac(){

        String url = config.getWebURLHepsiBurada();

        System.out.println("urll" + url);

        basePage.navigateTo(url);

    }

    @Step("Butona tikla ButtonID =<id>")
    public void kullanicigirisinetikla(String id){
        basePage.findElement(By.id(""+id+"")).click();
        basePage.threadSleep(2000);

    }

    @Step("Element gelene kadar bekle ButonID=<id>")
    public void elementgelenekadarbekle(String id){
        basePage.waitUntilExpectedElement(By.id(""+id+""),"30");
    }

    @Step("Text gir InputID=<id>, GirilecekInput=<inputtxt>")
    public void emailgir(String id,String inputtxt){
        basePage.fillInputField(By.id(""+id +""),inputtxt);
    }

    @Step("Kullanici Giris Dogrulama KontrolEdilcekTxt:<txt>")
    public void kullanicigirisdogrulama(String txt){
        String ekrandanalinantxt= basePage.findElement(By.xpath("//span[contains(text(),'Ali')]")).getText();
        System.out.println("Ekrandan alinan txt :"+ekrandanalinantxt);
        if (ekrandanalinantxt.equals(txt)){
            System.out.println("Kullanici giris dogru");
        }else{
            Assert.fail("Kullanici giris farkli");
        }
    }

    @Step("Urun yaz YazicakUrunismi=<uruntxt>")
    public void urunyaz(String uruntxt){
        basePage.findElement(By.xpath("//input[contains(@class,'desktopOldAutosuggestTheme-input')]")).click();
        basePage.threadSleep(2000);
        basePage.fillInputField(By.xpath("//input[contains(@class,'desktopOldAutosuggestTheme-input')]"),uruntxt);
    }

    @Step("Ara butonuna tikla")
    public void arabutonunatikla(){
        basePage.findElement(Arabuton).click();
        basePage.threadSleep(2000);
    }

    @Step("Urun Ekle UrunSayisi=<sayi>")
    public void urunekle(Integer sayi){
        basePage.hoverElement(By.xpath("(//h3[contains(@data-test-id,'product-card-name')])["+sayi+"]")," "+sayi+". urunun ustunde tutuldu");
        basePage.threadSleep(2000);
        String eklenecekurunismi=basePage.findElement(By.xpath("(//h3[contains(@data-test-id,'product-card-name')])["+sayi+"]")).getText();
        System.out.println("Ekrandan alinan urun ismi :"+eklenecekurunismi);
        DataStoreFactory.getScenarioDataStore().put(""+sayi+"urun", eklenecekurunismi);
        basePage.threadSleep(2000);

    }

    @Step("Sepete ekle butonuna tikla")
    public void sepeteeklebutonunatikla(){
        basePage.findElement(By.xpath("//div[contains(text(),'Sepete ekle')]")).click();
        basePage.threadSleep(7000);
    }

    @Step("Sepete eklenen urunlerin dogrulanması <sayibir>,<sayiiki>")
    public void sepeteeklenenurunlerindogrulanması(Integer sayibir,Integer sayiiki){
        String birinciurun = String.valueOf(DataStoreFactory.getScenarioDataStore().get(""+sayibir+"urun"));
        System.out.println("Birinciurunismi :" + birinciurun);

        String ikinciurun = String.valueOf(DataStoreFactory.getScenarioDataStore().get(""+sayiiki+"urun"));
        System.out.println("Ikinciurunismi :" + ikinciurun);

        String sepetimbirinciuruntxt=basePage.findElement(By.xpath("//a[contains(text(),'"+birinciurun+"')]")).getText();
        System.out.println("Sepetimbirinciurun :"+sepetimbirinciuruntxt);

        String sepetimikinciuruntxt=basePage.findElement(By.xpath("//a[contains(text(),'"+ikinciurun+"')]")).getText();
        System.out.println("Sepetimikinciurun :"+sepetimikinciuruntxt);

        if (birinciurun.equals(sepetimbirinciuruntxt) || ikinciurun.equals(sepetimikinciuruntxt)){
            System.out.println("Sepetteki eklenen urunler dogru");
        }else{
            Assert.fail("Sepetteki eklenen urunler yanlis");
        }




    }

    @Step("Sepetim butonuna tikla")
    public void sepetimbutonunatikla(){
        basePage.clickWithJS(By.xpath("//span[contains(@id,'shoppingCart')]"));
        basePage.threadSleep(2000);
    }

    @Step("Ekrana gelen hata mesaji kontrol <mesaj>")
    public void ekranagelenhatamesajikontrol(String mesaj){
    }


}
