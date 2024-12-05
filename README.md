Calcolatrice
-
**Questo progetto è una semplice calcolatrice con interfaccia grafica (GUI) costruita utilizzando Java e la libreria Swing. La calcolatrice offre una serie di operazioni di base, come somma, sottrazione, moltiplicazione, divisione, oltre a funzioni avanzate come esponenziazione, radice e percentuale.**

Struttura del Codice
Il codice è suddiviso in tre principali classi:

- `Calcolatrice` – La classe principale che avvia l'applicazione e applica il tema della UI.
    * La classe `Calcolatrice` imposta il tema grafico della calcolatrice usando FlatLaf, una libreria per un'interfaccia utente moderna.
    * La `GUI` viene creata nel metodo `creaGUI()` della classe `AspettoCalcolatrice`, che viene invocato nel thread dell'interfaccia utente.
- `AspettoCalcolatrice` – Gestisce l'aspetto grafico della calcolatrice, inclusa la creazione della finestra e dei bottoni
    * `creaGUI()`: Crea la finestra con un campo di testo per visualizzare il risultato e un pannello di bottoni disposti in una griglia.
    * Ogni bottone è associato a un'azione che interagisce con la classe `Stato` per eseguire le operazioni.
    * `BottoneListener` gestisce l'evento di clic su ogni bottone e aggiorna il campo di testo con il risultato dell'operazione.
- `Stato` – Gestisce la logica delle operazioni matematiche.
    * `gestisciInput()`: Gestisce l'input dell'utente, aggiornando il numero e l'operazione in base al bottone cliccato. In caso di errore di formato, restituisce un messaggio di errore.
    * `calcolaRisultato()`: Esegue l'operazione matematica richiesta tra i due numeri (primo e secondo) e restituisce il risultato.



