/*
##################   Bildergalerie    ###################################
#########################################################################
#########################################################################

            Autoren: Natascha Spiess, Thomas Enry, Baris Oezcan
                        Letzer Update: 03.06.2023




 */
package Bildergalerie;



import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;

public class Bildergalerie extends javax.swing.JFrame {

public static class Url {
    // Daten für die MySQL-Verbindung
    public String Mysqllink = "jdbc:mysql://lx99.hoststar.hosting/ch354986_Bildergalerie";
    public String username = "ch354986_ITB1C";
    public String password = "Bildergalerie_1C";
}

// Erstelle eine Instanz der Klasse "Url", um auf die MySQL-Verbindungsdaten zuzugreifen
Url url = new Url();

// Extrahiere die MySQL-Verbindungsdaten aus dem Url-Objekt

// Die URL für die MySQL-Datenbankverbindung
String Mysqllink = url.Mysqllink;

// Der Benutzername für die MySQL-Datenbankverbindung
String username = url.username;

// Das Passwort für die MySQL-Datenbankverbindung
String password = url.password;


    
    
    
    public Bildergalerie() {
        initComponents();
        
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Anzeige = new javax.swing.JPanel();
        AnzeigeGallerie = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Bildpfad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TasteHochladen = new javax.swing.JLabel();
        AnzeigeVorschau = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TasteDurchsuchen = new javax.swing.JLabel();
        AnzeigeStatus = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(400, 100));
        setMaximumSize(new java.awt.Dimension(1200, 830));
        setMinimumSize(new java.awt.Dimension(1200, 830));
        setPreferredSize(new java.awt.Dimension(1200, 830));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        Anzeige.setBackground(new java.awt.Color(255, 255, 255));
        Anzeige.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(154, 174, 93)));
        Anzeige.setMaximumSize(new java.awt.Dimension(800, 800));
        Anzeige.setMinimumSize(new java.awt.Dimension(800, 800));
        Anzeige.setPreferredSize(new java.awt.Dimension(1200, 800));
        Anzeige.setLayout(null);

        AnzeigeGallerie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        AnzeigeGallerie.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        AnzeigeGallerie.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        AnzeigeGallerie.setAutoscrolls(true);
        AnzeigeGallerie.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AnzeigeGallerie.setMinimumSize(new java.awt.Dimension(0, 0));
        AnzeigeGallerie.setOpaque(true);
        AnzeigeGallerie.setPreferredSize(new java.awt.Dimension(414, 214));
        AnzeigeGallerie.setViewportView(null);
        AnzeigeGallerie.setViewportView(jPanel3);

        Anzeige.add(AnzeigeGallerie);
        AnzeigeGallerie.setBounds(70, 480, 1050, 270);

        jLabel1.setBackground(new java.awt.Color(64, 66, 88));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bildergalerie");
        jLabel1.setOpaque(true);
        Anzeige.add(jLabel1);
        jLabel1.setBounds(0, 0, 1190, 100);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Ihre Bildergalerie:");
        Anzeige.add(jLabel2);
        jLabel2.setBounds(70, 440, 230, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Bild hochladen:");
        Anzeige.add(jLabel4);
        jLabel4.setBounds(70, 210, 200, 50);

        Bildpfad.setEnabled(false);
        Bildpfad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BildpfadActionPerformed(evt);
            }
        });
        Anzeige.add(Bildpfad);
        Bildpfad.setBounds(70, 250, 400, 40);

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("by Natascha, Thomas and Baris");
        Anzeige.add(jLabel3);
        jLabel3.setBounds(940, 760, 180, 16);

        TasteHochladen.setBackground(new java.awt.Color(86, 113, 137));
        TasteHochladen.setForeground(new java.awt.Color(255, 255, 255));
        TasteHochladen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TasteHochladen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/1pencil-tool.png"))); // NOI18N
        TasteHochladen.setText("Bild Hochladen");
        TasteHochladen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TasteHochladen.setOpaque(true);
        TasteHochladen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TasteHochladenMouseClicked(evt);
            }
        });
        Anzeige.add(TasteHochladen);
        TasteHochladen.setBounds(650, 255, 140, 40);

        AnzeigeVorschau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        AnzeigeVorschau.setOpaque(true);
        Anzeige.add(AnzeigeVorschau);
        AnzeigeVorschau.setBounds(880, 130, 240, 240);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Mindestgrösse 240 x 240");
        Anzeige.add(jLabel7);
        jLabel7.setBounds(880, 370, 240, 16);

        TasteDurchsuchen.setBackground(new java.awt.Color(123, 143, 161));
        TasteDurchsuchen.setForeground(new java.awt.Color(255, 255, 255));
        TasteDurchsuchen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TasteDurchsuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/1kleinzoom.png"))); // NOI18N
        TasteDurchsuchen.setText("Durchsuchen");
        TasteDurchsuchen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TasteDurchsuchen.setOpaque(true);
        TasteDurchsuchen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TasteDurchsuchenMouseClicked(evt);
            }
        });
        Anzeige.add(TasteDurchsuchen);
        // Die "TasteDurchsuchen" JLabel-Komponente zum "Anzeige" JPanel hinzufügen
        
        TasteDurchsuchen.setBounds(500, 255, 140, 40);
        // Die Position und Größe der "TasteDurchsuchen" JLabel-Komponente auf (500, 255, 140, 40) festlegen
        
        AnzeigeStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        // Schriftart des "AnzeigeStatus" JLabels auf "Segoe UI" mit Schriftgröße 18 setzen
        
        AnzeigeStatus.setForeground(new java.awt.Color(102, 0, 153));
        // Vordergrundfarbe (Textfarbe) des "AnzeigeStatus" JLabels auf (102, 0, 153) setzen
        
        Anzeige.add(AnzeigeStatus);
        // Das "AnzeigeStatus" JLabel zum "Anzeige" JPanel hinzufügen
        
        AnzeigeStatus.setBounds(477, 326, 380, 30);
        // Die Position und Größe des "AnzeigeStatus" JLabels auf (477, 326, 380, 30) festlegen
        
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/Savin-NY-Website-Background-Web1.jpg"))); // NOI18N
        // Ein Icon (Bild) für das "jLabel5" JLabel setzen, indem die Ressource "/Bilder/Savin-NY-Website-Background-Web1.jpg" verwendet wird
        
        Anzeige.add(jLabel5);
        // Das "jLabel5" JLabel zum "Anzeige" JPanel hinzufügen
        
        jLabel5.setBounds(0, 100, 1190, 720);
        // Die Position und Größe des "jLabel5" JLabels auf (0, 100, 1190, 720) festlegen
        
        getContentPane().add(Anzeige);
        // Das "Anzeige" JPanel zum Hauptcontainer (ContentPane) des Fensters hinzufügen
        
        Anzeige.setBounds(0, 0, 2511, 1763);
        // Die Position und Größe des "Anzeige" JPanels auf (0, 0, 2511, 1763) festlegen
        

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BildpfadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BildpfadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BildpfadActionPerformed

    private void TasteDurchsuchenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TasteDurchsuchenMouseClicked
  JFileChooser fileChooser = new JFileChooser();
fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

// Zeige den Dateiauswahldialog und warte auf Benutzerinteraktion
int result = fileChooser.showOpenDialog(this);

// Überprüfe, ob der Benutzer eine Datei ausgewählt hat
if (result == JFileChooser.APPROVE_OPTION) {
    // Erhalte die ausgewählte Datei
    File selectedFile = fileChooser.getSelectedFile();
    
    // Erhalte den absoluten Dateipfad der ausgewählten Datei
    String filePath = selectedFile.getAbsolutePath();

    // Setze den Dateipfad in ein Textfeld (Bildpfad)
    JTextField textField = Bildpfad;
    textField.setText(filePath);
    
    // Lese den Bildpfad aus dem Textfeld
    String bildpfad = Bildpfad.getText();

    try {
        // Lade das Originalbild als BufferedImage
        BufferedImage originalImage = ImageIO.read(new File(bildpfad));
        
        // Skaliere das Bild auf eine Größe von 240x240 Pixel
        Image resizedImage = originalImage.getScaledInstance(240, 240, Image.SCALE_DEFAULT);
        
        // Erstelle ein ImageIcon aus dem skalierten Bild
        ImageIcon imageIcon = new ImageIcon(resizedImage);

        // Setze das ImageIcon als Icon der AnzeigeVorschau-Komponente
        AnzeigeVorschau.setIcon(imageIcon);
    } catch (IOException ex) {
        // Behandlung von Fehlern beim Laden des Bildes
        AnzeigeStatus.setText("Fehler: " + ex.getMessage());
    }



            
        }
    }//GEN-LAST:event_TasteDurchsuchenMouseClicked

    private void TasteHochladenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TasteHochladenMouseClicked
String imagePath = Bildpfad.getText();

try (Connection connection = DriverManager.getConnection(Mysqllink, username, password)) {
    // Bereite die SQL-Anweisung zum Einfügen des Bildes vor
    String sql = "INSERT INTO Bilder (Bilddatei) VALUES (?)";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        // Lese die Bilddatei in ein Byte-Array ein
        File imageFile = new File(imagePath);
        byte[] imageData = new byte[(int) imageFile.length()];
        try (FileInputStream fis = new FileInputStream(imageFile)) {
            fis.read(imageData);
        }

        // Setze das Byte-Array als Parameter für die vorbereitete Anweisung
        pstmt.setBytes(1, imageData);

        // Führe die SQL-Anweisung zum Einfügen des Bildes aus
        pstmt.executeUpdate();

        System.out.println("Bild erfolgreich in der Datenbank gespeichert.");
        AnzeigeStatus.setText("Bild erfolgreich gespeichert.");
        Bildpfad.setText("");
        AnzeigeVorschau.setIcon(null);
        
        // Erstelle einen Timer, um die AnzeigeStatus-Komponente nach 5 Sekunden zurückzusetzen
        javax.swing.Timer timer = new javax.swing.Timer(5000, (ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> {
                AnzeigeStatus.setText("");
            });
        });
        timer.setRepeats(false);
        timer.start();
    }
} catch (SQLException | IOException ex) {
    ex.printStackTrace();
    AnzeigeStatus.setText("Bild konnte nicht hochgeladen werden.");
    
    // Erstelle einen Timer, um die AnzeigeStatus-Komponente nach 5 Sekunden zurückzusetzen
    javax.swing.Timer timer = new javax.swing.Timer(5000, (ActionEvent e) -> {
        SwingUtilities.invokeLater(() -> {
            AnzeigeStatus.setText("");
        });
    });
    timer.setRepeats(false);
    timer.start();
}

Gallerieupdate();



    }//Wenn dass Fenster geöffnet wird, wird diese Funktion ausgeführt.

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
Gallerieupdate();


    }//Programmstart

  
    public static void main(String args[]) {
     
      java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        // Erzeugen Sie eine neue Instanz der Passwordkarte-Klasse
        Bildergalerie passwordkarte = new Bildergalerie();
        // Setzen Sie die Instanz sichtbar
        passwordkarte.setVisible(true);
    }
        });

        
        
        
    }

    // Variabeldeklaration
    private javax.swing.JPanel Anzeige;
    private javax.swing.JScrollPane AnzeigeGallerie;
    private javax.swing.JLabel AnzeigeStatus;
    private javax.swing.JLabel AnzeigeVorschau;
    private javax.swing.JTextField Bildpfad;
    private javax.swing.JLabel TasteDurchsuchen;
    private javax.swing.JLabel TasteHochladen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    // Ende von Variabledeklarion

private void Gallerieupdate() {

try (Connection connection = DriverManager.getConnection(Mysqllink, username, password)) {
    String sql = "SELECT Bilddatei FROM Bilder";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        try (ResultSet rs = pstmt.executeQuery()) {
            jPanel3.removeAll(); // Entferne vorhandene Labels

            int x = 0; // X-Koordinate für die Positionierung der Labels
            int y = 0; // Y-Koordinate für die Positionierung der Labels
            int labelWidth = 240; // Breite jedes Labels
            int labelHeight = 240; // Höhe jedes Labels
            int spacing = 10; // Abstand zwischen den Labels

            while (rs.next()) {
                // Lese die Bilddaten aus dem Resultset
                byte[] imageData = rs.getBytes("Bilddatei");
                if (imageData != null) {
                    // Erstelle ein ImageIcon aus dem Byte-Array
                    ImageIcon imageIcon = new ImageIcon(imageData);
                    // Skaliere das Bild, um es in die festgelegte Größe zu bringen
                    Image resizedImage = imageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(resizedImage);
                    // Erstelle ein JLabel, um das Bild als Icon anzuzeigen
                    JLabel imageLabel = new JLabel(imageIcon);
                    // Setze die Größe des Labels
                    imageLabel.setSize(labelWidth, labelHeight);
                    // Setze die Position des Labels
                    imageLabel.setLocation(x, y);
                    // Zentriere das Bild innerhalb des Labels
                    imageLabel.setHorizontalAlignment(JLabel.CENTER);
                    imageLabel.setVerticalAlignment(JLabel.CENTER);
                    // Zentriere den Text innerhalb des Labels
                    imageLabel.setHorizontalTextPosition(JLabel.CENTER);
                    imageLabel.setVerticalTextPosition(JLabel.CENTER);
                    imageLabel.setIconTextGap(0);
                    // Entferne den Rand um das Label
                    imageLabel.setBorder(BorderFactory.createEmptyBorder());
                    // Füge das Label zum jPanel3-Panel hinzu
                    jPanel3.add(imageLabel);

                    // Aktualisiere die Position für das nächste Label
                    x += labelWidth + spacing;

                    // Überprüfe, ob das nächste Label die Breite des Panels überschreitet
                    if (x + labelWidth > jPanel3.getWidth()) {
                        x = 0; // Setze die X-Koordinate zurück
                        y += labelHeight + spacing; // Gehe zur nächsten Zeile
                    }
                }
            }

            jPanel3.revalidate(); // Aktualisiere das Layout
            jPanel3.repaint(); // Neuzeichnen des Panels
         
        }
        
    }
} catch (SQLException ex) {
    // SQL Ausnahmen handling
    ex.printStackTrace();
}



}

}

