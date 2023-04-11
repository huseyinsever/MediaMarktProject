Feature: MediaMarkt Login İşlemleri
  Scenario: MediaMarkt Login Olma İşlemi
    Given MediaMarkt web uygulamasına git
    When  MediaMarkt hesabına giriş yap
    Then  Login olduğunu doğrula
