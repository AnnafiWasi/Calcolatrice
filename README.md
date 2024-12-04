//La classe Main
public class Calcolatrice {
    public static void main(String[] args) {
//Qui uso la libreria FlatLaf
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            System.out.println("FlatLaf applicato");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
//Crea un'istanza della classe VistaCalcolatrice e chiama il metodo creaGUI()
        javax.swing.SwingUtilities.invokeLater(() -> new VistaCalcolatrice().creaGUI());
    }
}

//La classe dell'aspetto della calcolatrice
public class VistaCalcolatrice {
    private JFrame frame;
    private JTextField textField;
    private LogicaCalcolatrice logica;

    public VistaCalcolatrice() {
        logica = new LogicaCalcolatrice();
    }

    public void creaGUI() {
        frame = new JFrame("Calcolatrice"); //Creo una finestra con il titolo "Calcolatrice" e la assegna alla variabile frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Quando chiudo la finestra il programma finisce
        frame.setSize(350, 450); //Imposto la dimensione della finestra (pixel)
        frame.setLayout(new BorderLayout()); //Metto il layout manager della finestra a BorderLayout (NORTH, SOUTH, EAST, WEST, e CENTER)
        frame.setResizable(false); //La finestra non potrà essere ingrandita o rimpicciolita
        Image icon = new ImageIcon(this.getClass().getResource("/Wasi.jpg")).getImage(); //Creo la variabile che contiene l'icona della finestra
        frame.setIconImage(icon); //Lo imposto come icona
        textField = new JTextField(); //Crea un campo di testo
        textField.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 24)); //Metto il font grassetto e corsivo e la dimensione 24 pixel
        textField.setHorizontalAlignment(JTextField.RIGHT); //Allinea il testo dentro il campo di testo a destra.
        textField.setBackground(Color.white); //Sfondo bianco
        textField.setForeground(Color.red); //il testo in rosso
        textField.setEditable(false); //il campo di testo lo metto come non modificabile visto che uso i bottoni
        frame.add(textField, BorderLayout.NORTH); //lo aggiungo alla finestra
        JPanel pannelloBottoni = new JPanel(); //creo il pannello dei bottoni
        pannelloBottoni.setLayout(new GridLayout(5, 4, 7, 5)); //il pannello dei bottoni è 5x4 5 righe e 4 colonne e lo spazio fra i bottoni da sopra e accanto sono 7 e 5 px
        String[] bottoni = { //creo l'array con i nomi dei bottoni
            "C","n^x", "x√n", "%",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            ".", "0", "=", "+"
        };
        for (int i = 0; i < bottoni.length; i++) { //per ogni elemento dell'array dei bottoni
            JButton bottone = new JButton(bottoni[i]); //creo un bottone usando JButton
            bottone.setFont(new Font("Serif", Font.PLAIN, 20)); //imposto il font e la grandezza
            bottone.setBackground(Color.black); //lo sfondo del bottone nero
            bottone.setForeground(Color.white); //i numeri di colore bianco
            bottone.setFocusable(false); //tolgo il focus (il rettangolino che sta intorno al numero perché mi dava fastidio)
            pannelloBottoni.add(bottone); //aggiungo ogni singolo bottone al pannello
            bottone.addActionListener(new BottoneListener()); //aggiungo l'azione che dovrà fare il bottone usando BottoneListener
        }
        frame.add(pannelloBottoni, BorderLayout.CENTER); //aggiungo il pannello dei bottoni al centro
        frame.setVisible(true); //metto la finestra visibile
    }

    private class BottoneListener implements ActionListener { //Una classe interna privata chiamata BottoneListener che implementa l'interfaccia ActionListener
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = ((JButton) e.getSource()).getText(); l'input che ottengo dopo aver cliccato il bottone
            String risultato = logica.gestisciInput(input, textField.getText()); //lo mando nella classe logica che fa le operazioni
            textField.setText(risultato); //metto il risultato sul campo di testo
        }
    }
}

//La classe dove fa le operazioni

public class LogicaCalcolatrice {

    private double primoNumero = 0; //inizializzo il primo numero che verrà inserito dall'utente
    private String operazione = ""; //inizializzo l'operazione che verrà inserito dall'utente


    public String gestisciInput(String input, String numeroAttuale) {
        try { //uso try e catch per eventuali errori 
            switch (input) { //gestisco l'input dato dall'utente tramite uno switch
//i vari casi
                case "C":
                    this.primoNumero = 0; 
                    this.operazione = "";
                    return "";
                case "=": //se è un'operazione allora lo mando nel metodo calcolaRisultato 
                    return calcolaRisultato(numeroAttuale);
                case "+":
                case "-":
                case "*":
                case "/":
                case "n^x":
                case "x√n":
                case "%":
                    this.operazione = input; //l'operazione che ricevo in input
                    this.primoNumero = Double.parseDouble(numeroAttuale); //trasformo la stringa in double
                    return "";
                default:
                    return numeroAttuale + input;
            }
        } catch (NumberFormatException e) {
            return "Errore";
        }
    }

    private String calcolaRisultato(String secondoNumeroTesto) {
        try {//gestione di eventuali errori
            double secondoNumero = Double.parseDouble(secondoNumeroTesto); //trasformo la stringa in testo
            double risultato = 0;
            switch (this.operazione) {
//tutte le operazioni 
                case "+":
                    risultato = this.primoNumero + secondoNumero;
                    break;
                case "-":
                    risultato = this.primoNumero - secondoNumero;
                    break;
                case "*":
                    risultato = this.primoNumero * secondoNumero;
                    break;
                case "/":
                    if (secondoNumero != 0) {
                        risultato = this.primoNumero / secondoNumero;
                    } else {
                        return "Errore: /0";
                    }
                    break;
                case "n^x":
                    risultato = Math.pow(this.primoNumero, secondoNumero);
                    break;
                case "x√n":
                    risultato = Math.pow(this.primoNumero, 1.0 / secondoNumero);
                    break;
                case "%":
                    risultato = (this.primoNumero / 100) * secondoNumero;
                    break;
                default:
                    return"";
            }
            this.operazione = "";
            return String.valueOf(risultato); //ritorno il risultato
        } catch (NumberFormatException e) {
            return "Errore";
        }
    }
}
