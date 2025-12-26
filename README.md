# Avancerad Java – Köp & Sälj

Det är en enkel projekt  där man kan köpa - och sälj-applikation byggd i Java.
Projektet genomfårt med Spring Boot och en client Console Application.

Syftet med projektet är att visa hur en Java klient kan kommunicera med ett REST-API
och hämta data i JSON-format.

## Funktioner
- Lista alla annonser
- Server returnerar annonser som JSON
- Client hämtar annonser via HTTP
- Enkel meny i konsolen

## Tekniker
- Java
- Spring Boot
- Maven
- HTTP Client
- JSON

## Projektstruktur
- server: Spring Boot REST API
- client: Java-konsolapplikation
- annonser.json : Testdata för annonser

## Hur man kör projektet

1. Starta servern  
   Kör klassen ServerApplication.  
   Servern startar på http://localhost:8080

2. Starta clienten  
   Kör klassen ClientApplication.  
   Använd menyn i konsolen för att lista annonser.

## API-endpoints
GET /annonser – returnerar alla annonser i JSON-format

## Exempel på JSON-svar
[
{
"id": 1,
"title": "iPhone 14 – bra skick",
"pris": 5000
}
]

## Exempel på meny i client
--- Fulköpings Köp & Sälj ---
1. Lista alla annonser
0. Avsluta

## Elev
Rimouna Al Hakim