Mazs prasmju pārbaudes projekts darba intervijai, lai būtu par ko diskutēt.

Lai izpildītu uzdevumu, nav nepieciešams kompilēt un darbināt šo projektu. Taču iesūtītie risinājumi tiks testēti tieši pret šo projektu.

# Uzdevums
Pats uzdevums ir aprakstīts iekš faila **Uzdevums.md**.

# Servera pusē tika izmantots:
- Oracle Java JDK 1.8.0_91 x64
- Apache Tomcat 8.0.33 x64
- Windows 10 x64

64 bitu arhitektūra nav būtiska, projekts darbosies arī uz 32 bitu mašīnas. Kā arī operētējsistēma var tikt izmantota Linux. Galvenais, lai var uzstādīt Oracle Java 8 JDK.

Java web arhīva fails **.war** tiek kompilējams ar Maven.

# Web API atbildes kļūdu saraksts
| code | message |
| --- | --- |
| 1 | Produkts nav reģistrēts noliktavā |
| 2 | Produkta daudzums noliktavā ir mazāks kā nepieciešams |
| 3 | Pasūtījumā trūkst Produkta numurs |
| 4 | Pasūtījuma daudzumam jābūt lielākam par nulli |

# Ciparu decimāldaļu atdalītājs
Decimāldaļu atdalīšanai tiek izmantots punkts.

