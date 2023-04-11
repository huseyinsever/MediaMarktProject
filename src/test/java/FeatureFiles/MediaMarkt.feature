@ParallelTest
Feature: MediaMarkt Test Otomasyon Projesi
  Background: Login İşlemleri
    Given MediaMarkt web uygulamasına git
    When  MediaMarkt hesabına giriş yap
    Then  Login olduğunu doğrula

  Scenario: MediaMarkt Test Otomasyonu
    Given Kategorideki tüm seçenekleri doğrulayın
    And   Arama bölümüne Monitör yazıp aratın
    And   Marka'dan Samsung seçin
    And   Vesa Standartı olarak Evet seçin
    And   Çözünürlük olarak dörtK UHD seçin
    And   Ekran boyutu olarak yirmiüç-sekiz seçin
    And   Çıkan sonuçlardan Lenovo Siyah Monitör'e tıklayın
    And   Sepete ekle'ye tıklayın ve  alışverişe devam edin
    And   Arama bölümüne Klavye yazıp aratın
    And   Marka'dan Logitech seçin
    And   Ürün Tipi'ni Kablosuz klavye seçin
    And   Rating'i beş sıfır seçin
    And   Çıkan sonuçlardan ilk ürünü seçin
    And   Sepete ekle'ye tıklayın ve sepete gidin
    And   Ürünlerin geldiğini doğrulayın
    And   Özet bölümündeki tüm kalemleri doğrulayın
    When  Bütün ürünleri silin ve sepetin boş olduğunu doğrulayın
    Then  Ana sayfaya dönün
    Then  Hesabınızdan çıkış yapın ve çıktığınızı doğrulayın
