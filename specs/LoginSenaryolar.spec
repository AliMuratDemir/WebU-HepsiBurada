Specification Heading
=====================
Created by alimurat.demir on 30/03/2022

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Dogru Email ve Sifre ile Login olma
------------------------------------------
* Sayfayi ac
* Giris Yap "test@gmail.com","test.62"
* Kullanici Giris Dogrulama KontrolEdilcekTxt:"TestAd TestSoyad"

Yanlis Email ile Login olma kontrolu
------------------------------------------
* Sayfayi ac
* Giris Yap "aa@gmail.com","test.62"
* Ekrana gelen hata mesaji kontrol "E-posta adresi eksik veya hatalı."

Yanlis Sifre ile Login olma kontrolu
------------------------------------------
* Sayfayi ac
* Giris Yap "aa@gmail.com","test.62"
* Ekrana gelen hata mesaji kontrol "Girdiğiniz şifre eksik veya hatalı."

Email alanina hiçbişey yazmadan Login olma kontrolu
------------------------------------------
* Sayfayi ac
* Giris Yap "","test.62"
* Ekrana gelen hata mesaji kontrol "E-posta adresinizi veya telefon numaranızı girmelisiniz."

Email alanina gecersiz email ile Login olma kontrolu
------------------------------------------
* Sayfayi ac
* Giris Yap "aa","test.62"
* Ekrana gelen hata mesaji kontrol "Geçerli bir e-posta adresi girmelisiniz."