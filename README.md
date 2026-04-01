# Spring Boot REST API – Gestione Utenti

## 📌 Descrizione

Questo progetto consiste nello sviluppo di una API REST realizzata con Spring Boot per la gestione degli utenti.

L’applicazione implementa tutte le operazioni CRUD (Create, Read, Update, Delete) e permette lo scambio di dati in formato JSON tramite endpoint REST.

La struttura del progetto segue un’architettura a livelli (Controller, Service, Repository), garantendo una chiara separazione delle responsabilità.

È stato inoltre implementato il supporto agli aggiornamenti parziali (PATCH), utilizzando la Reflection di Java per modificare dinamicamente solo i campi specificati nella richiesta.

Le API sono state testate tramite Postman per verificarne il corretto funzionamento.

## ⚙️ Funzionalità

* Recupero lista utenti
* Recupero utente per ID
* Creazione nuovo utente
* Aggiornamento completo (PUT)
* Aggiornamento parziale (PATCH)
* Eliminazione utente

## 🔗 Endpoint

GET     /api/users
GET     /api/users/{id}
POST    /api/users
PUT     /api/users/{id}
PATCH   /api/users/{id}
DELETE  /api/users/{id}

## 🛠️ Tecnologie

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* JSON
* Postman

## 🚀 Note

Il progetto rappresenta un esempio completo di API REST per la gestione utenti e costituisce un primo approccio pratico allo sviluppo backend con Spring Boot.
