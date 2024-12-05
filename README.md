Calcolatrice
-
**Questo progetto è una semplice calcolatrice con interfaccia grafica (GUI) costruita utilizzando Java e la libreria Swing. La calcolatrice offre una serie di operazioni di base, come somma, sottrazione, moltiplicazione, divisione, oltre a funzioni avanzate come esponenziazione, radice e percentuale.**

Struttura del Codice
Il codice è suddiviso in tre principali classi:

- `Calcolatrice` – La classe principale che avvia l'applicazione e applica il tema della UI.
 * La classe Calcolatrice imposta il tema grafico della calcolatrice usando FlatLaf, una libreria per un'interfaccia utente moderna.
 * La GUI viene creata nel metodo creaGUI() della classe AspettoCalcolatrice, che viene invocato nel thread dell'interfaccia utente.
- `AspettoCalcolatrice` – Gestisce l'aspetto grafico della calcolatrice, inclusa la creazione della finestra e dei bottoni
- `Stato` – Gestisce la logica delle operazioni matematiche.


