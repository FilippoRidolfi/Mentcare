# Mentcare
Progetto mentcare, la dottoressa Kate desidera prescrivere farmaci a un paziente che frequenta una clinica. La cartella clinica
del paziente è gia visualizzata sul suo computer in modo che possa fare tutti gli interventi del caso.

# Requisiti
Le caratteristiche del sistema che deve fornire 
e i vincoli del suo funzionamento sono:

1. La dottoressa dovrà avere la possibilità di vedere i dati del paziente ed eventualmente aggiornare l'altezza, il peso e l'età.
2. La dottoressa dovrà avere la possibilità di accedere alla sezione relativa ai farmaci e visitare i farmaci attualmente prescritti al paziente. Potrà quindi decidere se modificare la dose di quest'ultimi.
3. La dottoressa dovrà avere la possibilità di aggiungere nuovi farmaci al paziente selezionando il farmaco voluto e modificandone eventualmente la dose.
4. La dottoressa dovrà avere la possibilità di aggiornare il formulario selezionando un farmaco all'interno del database e modificandone eventualmente il dosaggio.
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
Arrivata sulla pagina per modificare la dose la dottoressa avrà la possibilità di vedere tutte le relative informazioni riguardo al farmaco. Potrà modificare la dose sempre rispettando
il dosaggio definito dal farmaco. Se il dosaggio risulterà inferiore o superiore a quello definito otterrà un messaggio di errore che l'avvertira se il dosaggio è troppo basso o troppo alto.
Se invece il dosaggio è correttamente inserito gli verrà chiesto di confermare la sua scelta tramite pop-up. Se rifiuta viene riportata alla pagina per la modifcia del dosaggio,
se invece accetta la modifica del dosaggio e la relativa aggiunta del farmaco viene indirizzata sulla pagina dei farmaci
attualmente prescritti per poter verificare se il farmaco è stato inserito correttamente o meno. 

# Scenario 5
La dottoressa dalla cartella clinica del paziente può accedere all'area relativa ai farmaci e visualizzare il report relativo all'andamento della cura.
Accedendo può selezionare, tramite una tabella, la relativa coppia paziente-farmaco e visualizzare la descrizione e il relativo orario in cui è stata fatta.
Questo permetterà alla dottoressa di avere una panoramica generale dell'andamento dell'assunzione del farmaco con il paziente. 
Finita l'osservazione potrà tornare sia alla cartella clinica che alla pagina relativa ai farmaci tramite due pulsanti.