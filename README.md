# Mentcare
Progetto mentcare, la dottoressa Kate desidera prescrivere farmaci a un paziente che frequenta una clinica. La cartella clinica
del paziente è gia visualizzata sul suo computer in modo che possa fare tutti gli interventi del caso.

# Requisiti
Le caratteristiche del sistema che deve fornire 
e i vincoli del suo funzionamento sono:

1. La dottoressa dovrà avere la possibilità di vedere i dati del paziente ed eventualmente aggiornare l'altezza, il peso e l'età.
2. La dottoressa dovrà avere la possibilità di accedere alla sezione relativa ai farmaci e visitare i farmaci attualmente prescritti al paziente. Potrà quindi decidere se modificare la dose di quest'ultimi.
3. La dottoressa dovrà avere la possibilità di aggiungere nuovi farmaci al paziente selezionando il farmaco voluto e modificandone eventualmente la dose.
4. La dottoressa dovrà avere la possibilità di aggiornare il formulario selezionando un farmaco all'interno del database, confermarmarlo e modificare eventualmente il dosaggio. Gli verrà poi chiesto di confermare le modifiche effettuate o di cambiare e tornare alla fase di prescrizione.
5. La dottoressa dovrà avere la possibilità di visionare i precedenti report che descrivono l'avanzamento della cura del paziente. Potendo osservare precedenti visite e stabilire se la cura sta avendo gli effetti desiderati o meno.

# Scenari

## Scenario 1
La dottoressa avrà la possibilità di modificare alcune informazioni variabili del paziente. Non avrà la possibilità di modificare il nome, il cognome
o il numero di tessera sanitaria. Ma potrà modificare l'età del paziente, la sua altezza o il suo peso. All'interno della cartella clinica è presente
un pulsante per poter accedere alle modifiche. Una volta inseriti i dati corretti e confermate le modifiche la dottoressa sarà
re-indirizzata alla cartella clinica del paziente dove potrà osservare che i dati modificati sono stati correttamente aggiornati.

## Scenario 2
La dottoressa della cartella clinicia può visualizzare, nella parte relativa ai farmaci, i medicinali che il paziente
attualmente ha prescritti con i relativi dosaggi. La dottoressa ha la possibilità di accedere alla pagina specifica del farmaco
e di cambiare il dosaggio. La dose è modificabile sono all'interno del parametri predisposti dal dosaggio massimo e minimo
del farmaco. Dosi maggiori o minori non sono permesse. Dopo aver cambiato la dose avrà la possibilità 
di annullare l'operazione e di confermarla tramite un pop-up che comparirà appena preme il pulsante per confermare il dosaggio. 

## Scenario 3
La dottoressa dalla cartella clinica del paziente potrà visualizzare, nella parte relativa ai farmaci, la possibilità di aggiungere un nuovo farmaco alla prescrizione del paziente. 
Tramite un menu, digiterà o selezionerà il nome del farmaco che desidera aggiungere e, se presente nel sistema, avrà la possibilità di accede alla pagine relativa alla modifica delle dose.
Arrivata sulla pagina per modificare la dose la dottoressa avrà la possibilità di vedere tutte le relative informazioni riguardo al farmaco. Potrà modificare la dose sempre rispettando
il dosaggio definito dal farmaco. Se il dosaggio risulterà inferiore o superiore a quello definito otterrà un messaggio di errore che l'avvertira se il dosaggio è troppo basso o troppo alto.
Se invece il dosaggio è correttamente inserito gli verrà chiesto di confermare la sua scelta tramite pop-up. Se rifiuta viene riportata alla pagina per la modifcia del dosaggio, 
se invece accetta la modifica del dosaggio e la relativa aggiunta del farmaco viene indirizzata sulla pagina dei farmaci
attualmente prescritti per poter verificare se il farmaco è stato inserito correttamente o meno. 

## Scenario 4
La dottoressa dalla cartella clinica del paziente potrà visualizzare, nella parte relativa ai farmaci, la possibilità di accedere al formulario.
Tramite un menu, digiterà o selezionerà il nome del farmaco che desidera aggiungere e, se presente nel sistema, avrà la possibilità di accede alla pagine relativa alla modifica delle dose.
Arrivata sulla pagina relativa ai dati del farmaco per poter verificare che la selezione effettuata sia corretta e che voglia effettivamente scegliere quel farmaco. Dopo aver confermato la sua scelta
varrà indirizzata alla pagina relativa alla dose. La dottoressa potrà modificare la dose sempre rispettando
il dosaggio definito dal farmaco. Se il dosaggio risulterà inferiore o superiore a quello definito otterrà un messaggio di errore che l'avvertira se il dosaggio è troppo basso o troppo alto.
Se invece il dosaggio è correttamente inserito gli viene richiesto di confermare la sua scelta tramite pop-up. Se non conferma la richiesta verrà re-indirizzata alla pagina relativa ai farmaci
se invece conferma il dosaggio verrà portata ad una nuova pagina di riepilogo. Nella pagina di riepilogo potrà confermare la prescrizione e quindi salvarla nel database oppure 
cmabiare la prescrizione e verrà re-indirizzata alla lista dei farmaci per poter ricreare la prescrizione.

## Scenario 5
La dottoressa dalla cartella clinica del paziente può accedere all'area relativa ai farmaci e visualizzare il report relativo all'andamento della cura.
Accedendo può selezionare, tramite una tabella, la relativa coppia paziente-farmaco e visualizzare la descrizione e il relativo orario in cui è stata fatta.
Questo permetterà alla dottoressa di avere una panoramica generale dell'andamento dell'assunzione del farmaco con il paziente. 
Finita l'osservazione potrà tornare sia alla cartella clinica che alla pagina relativa ai farmaci tramite due pulsanti.

# Copertura e selezione dei test
Per verificare la correttezza del codice realizzato sono stati realizzati i seguenti casi di test:
1. Verifica dell'esistenza dei dati relativi al paziente dal momento della messa in esecuzione del codice. Attraverso un assertFalse ho verificato se tutti i campi relativi all'utente fossero correttamente inseriti
2. Ho verificato lo scenario relativo alla modifica delle informazioni dell'utente. Dopo aver fatto l'accesso alla sezione relativa ho inserito dei dati casuali (25 anni per l'eta, 80.21kg per il peso e 1.85m per l'altezza)
e ho effettuato il submit. Dopo aver accettato la richiesta di conferma da parte dell'alert sono andato a verificare che le informazioni fossero effettivamente cambiate nel modo voluto.  
3. Ho verificato lo scenario relativo alla modifica delle informazioni dell'utente ma, in questo caso, ho impostato che venisse rifiutata la proposta di conferma da parte dell'alert. 
Questo mi ha permesso di verificare se il sistema stesse funzionando in modo corretto, facendomi rimanere sulla stessa pagina e sopratutto non modificando i dati inseriti ma non confermati.
Ho verificato poi tramite assertEquals se i dati fossere correttamente quelli precedeni o se invece erano stati in qualche modo alterati.
4. Ho testato il corretto funzionamento della funzionalità relativa alle dose attuali. Dopo aver fatto tutta la procedura per poter accedere alla pagina relativa ho inserito una dose
casuale ma corretta che rispettasse la dose massima e minima per il farmaco. Ho impostato che il test rifiutasse però la proposta di conferma da parte dell'apposito alert per verificare se in effetti 
l'utente fosse rimasto nella pagina relativa alla modifica della dose. Ho poi cambiato il valore della dose e a questo punto ho testato la conferma delle modifiche.
Quindi dopo averle accettate ho verificato che fossere stati aggiunte correttamente al relativo farmaco.
5. Ho testato lo scenario relativo all'aggiunta di nuovi farmaci. In particolare ho similutato l'ingresso nella sezione apposita, la scelta del nuovo farmaco e la relativa modifica del
dosaggio. Ho inserito inizialmente una dose fuori dai parametri consentiti e ho verificato che in effetti venisse restituito il messaggio di errore: "Dose is outside the safe range. Is too high"
ho successivamente invece inserito la corretta dose che rispettasse i parametri e ho confermato la scelta nell'apposito alert. Ho controllato infiene che la dose fosse cambiata correttamente per il farmaco indicato.
6. Ho testato lo scenario relativo all'utilizzo del formulario. Dopo aver fatto l'accesso alla sessione apposita, ho selezionato il farmaco da prescrivere e ho poi modificato la dose con un valore
accettato dal sistema, confermando poi la scelta sull'alert. Ho poi confermato la prescrizione dopo aver visualizzato il riepilogo finale. Ho utilizzato l'assert equals per verificare che la dose fosse stata modificata correttamente.
7. Ho testato lo scenario relativo all'utilizzo del formulario. In questo casoc però, rispetto al precedente, ho rifiutato la conferma della dose di farmaco. Ho verificato che in effetti ritornasse alla pagina di cambiamento della dose e 
che non mi portasse alle pagine successive.
8. Ho testato la scenario relativo all'utilizzo del report sui test effettuati. Dopo aver effettuato l'accesso alla relativa sezione ho verificato che la scelta di osservare il report di un relativo paziente e di un dato farmaco 
fossero in effetti rispettate nel momento in cui veniva mostrata la pagina con il testo sull'andamento della cura.