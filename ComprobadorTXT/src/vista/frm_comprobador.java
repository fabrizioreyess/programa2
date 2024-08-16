/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.util.StringTokenizer;


/**
 *
 * @author pc
 */
public class frm_comprobador extends javax.swing.JFrame {

JFileChooser seleccionar=new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    /**
     * Creates new form frm_comprobador
     */
    public frm_comprobador() {
        initComponents();
    }

     public void longitud(){
    String longitud=txt_area.getText();
    int cadena=longitud.length();
        txt_long.setText(String.valueOf(cadena));
    
    }    
      public void longitudpalabras(){
    String longitud=txt_area.getText();
    StringTokenizer st= new StringTokenizer(longitud);
        txt_palab.setText(""+st.countTokens());
    
    }    
    public void primerletra(){
    String longitud=txt_area.getText();
        char cadena=longitud.charAt(0);
        txt_1letra.setText(String.valueOf(cadena));
    }    
    public void ultletra(){
    String longitud=txt_area.getText();
     int num = longitud.length();
    for (int i=0;i<=(num-1);i++){
        char cadena=longitud.charAt(i);
        txt_ultletra.setText(String.valueOf(cadena));
    }
    }       
    public void letrac(){   
    String longitud=txt_area.getText();
     int num = longitud.length();
    for (int i=0;i<=(num-1);i++){
        int j=i/2;
        char cadena=longitud.charAt(j);
        txt_letrac.setText(String.valueOf(cadena));
        }
    }   
     public void Palabracentral(String cadena, int contador){    
        String[] words = cadena.split("\\s+");
        int mitad = contador/2;
        if (contador%2!=0){
            mitad = mitad + 1;
        }
        int contador2 = mitad - 1;
        for (int i = 0; i <= mitad; i++) {
            if(i == contador2){
                words[i] = words[i].replaceAll("[^\\w]", "");
                txt_palabc.setText("" + words[i]);
            }
        }
        
    }
      public void ultimapalabra(){
    String longitud=txt_area.getText();
        int cadena=longitud.lastIndexOf(" ");
        String ult=longitud.substring(cadena);
        txt_ultpalab.setText(ult);

    }    
       public void RepeticionesletraA(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'a', 'A', 'á' -> contadorVocales++;
            }
        }
        txt_a.setText("" + contadorVocales);
    }
     public void Repeticionesletrae(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'e', 'E', 'é' -> contadorVocales++;
            }
        }
        txt_e.setText("" + contadorVocales);
    }
     
     public void Repeticionesletrai(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'i', 'I', 'í' -> contadorVocales++;
            }
        }
        txt_i.setText("" + contadorVocales);
    }
      public void Repeticionesletrao(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'o', 'O', 'ó' -> contadorVocales++;
            }
        }
        txt_o.setText("" + contadorVocales);
    }
      
     public void Repeticionesletrau(String cadena){
        int contadorVocales = 0;
        char letraArray[] = cadena.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<cadena.length(); i++){
            switch(cadena.charAt(i)){
                case 'u', 'U', 'ú' -> contadorVocales++;
            }
        }
        txt_u.setText("" + contadorVocales);
    }
    
   public void Palabrasparesimpares(String cadena, int contador){
        String[] words = cadena.split("\\s+");
        int par=0;
        int impar=0;
        for (int i = 0; i <= contador; i++) {
                words[i] = words[i].replaceAll("[^\\w]", "");
                int par_impar = words[i].length();
                System.out.println(par_impar);
                if (par_impar % 2 == 0){
                    impar += 1;
                    txt_par.setText("" + impar);
                    
                }else{
                    par += 1;
                    txt_impar.setText("" + par);
                }
                
        }
        
        
    }
    
    public String AbrirArchivo (File archivo){
        String documento="";
            try{
                entrada=new FileInputStream(archivo);
                int ascci;
                while((ascci=entrada.read())!=-1){
                    char caracter=(char)ascci;
                    documento+=caracter;
                }
            }catch(IOException e){
            }
            return documento;    
        }

    public String GuardarArchivo (File archivo,String documento){
        String mensaje=null;
        try{
            salida=new FileOutputStream(archivo);
            byte[]bytxt=documento.getBytes();
            salida.write(bytxt);
            mensaje="Archivo Guardado";
        }catch(IOException e){
        }
        return mensaje;
    }
    public void copiar(String copiar){
        StringSelection ss=new StringSelection(copiar);
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        cb.setContents(ss, null);
    }
    
    public String pegar(){
        String resultado="";
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contenido=cb.getContents(null);
        if(contenido.isDataFlavorSupported(DataFlavor.stringFlavor)){
            try {
                resultado=(String) contenido.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return resultado;
    }
    
   
    /**
     * This method is called from within the constrtxt_palab.setText(String.valueOf(st.countTokens()));
uctor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_area = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_murcielago = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_long = new javax.swing.JTextField();
        txt_palab = new javax.swing.JTextField();
        txt_1letra = new javax.swing.JTextField();
        txt_ultletra = new javax.swing.JTextField();
        txt_letrac = new javax.swing.JTextField();
        txt_1p = new javax.swing.JTextField();
        txt_palabc = new javax.swing.JTextField();
        txt_ultpalab = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_a = new javax.swing.JTextField();
        txt_e = new javax.swing.JTextField();
        txt_i = new javax.swing.JTextField();
        txt_o = new javax.swing.JTextField();
        txt_u = new javax.swing.JTextField();
        txt_par = new javax.swing.JTextField();
        txt_impar = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 0));
        jPanel1.setForeground(new java.awt.Color(102, 0, 102));

        txt_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_areaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("TRADUCCION A CLAVE MURCIELAGO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Ingrese un texto o abra un archivo");

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setText("Procesar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        jLabel3.setText("Longitud del texto");

        jLabel4.setForeground(new java.awt.Color(0, 204, 204));
        jLabel4.setText("Total de palabras");

        jLabel5.setForeground(new java.awt.Color(0, 204, 204));
        jLabel5.setText("Primera letra del texto");

        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("Ultima letra del texto");

        jLabel7.setForeground(new java.awt.Color(0, 204, 204));
        jLabel7.setText("Letra central del texto");

        jLabel8.setForeground(new java.awt.Color(0, 204, 204));
        jLabel8.setText("Primera palabra");

        jLabel9.setForeground(new java.awt.Color(0, 204, 204));
        jLabel9.setText("Palabra central");

        jLabel10.setForeground(new java.awt.Color(0, 204, 204));
        jLabel10.setText("Ultima palabra");

        jLabel11.setForeground(new java.awt.Color(0, 204, 204));
        jLabel11.setText("Repeticiones de \"A\", \"a\" ó \"á\":");

        jLabel12.setForeground(new java.awt.Color(0, 204, 204));
        jLabel12.setText("Repeticiones de \"E\", \"e\" ó \"é\":");

        jLabel13.setForeground(new java.awt.Color(0, 204, 204));
        jLabel13.setText("Repeticiones de \"I\", \"i\" ó \"í\":");

        jLabel14.setForeground(new java.awt.Color(0, 204, 204));
        jLabel14.setText("Repeticiones de \"O\", \"o\" u \"ó\":");

        jLabel15.setForeground(new java.awt.Color(0, 204, 204));
        jLabel15.setText("Repeticiones de \"U\", \"u\" ó \"ú\":");

        jLabel16.setForeground(new java.awt.Color(0, 204, 204));
        jLabel16.setText("Palabras con cantidad de caracteres par:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 255));
        jLabel18.setText("Manejo de Cadenas");

        jLabel19.setForeground(new java.awt.Color(0, 204, 204));
        jLabel19.setText("Palabras con cantidad de caracteres impar:");

        txt_impar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_imparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_murcielago)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_ultpalab))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_palabc, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txt_palab))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_1letra, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_letrac, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(txt_ultletra)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_1p, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel17))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_e, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_a, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txt_o, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_i, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_u, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_par, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                                .addGap(1, 1, 1))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(jLabel12)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(16, 16, 16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(txt_impar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel16)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel18)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_long, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_area)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_long, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_palab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txt_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_1letra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txt_i, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_ultletra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txt_o, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_letrac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txt_u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_1p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txt_par, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_palabc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(txt_impar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_ultpalab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_murcielago, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 51));

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Guardar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Guardar como");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem4.setText("Copiar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Cortar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Pegar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Buscar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Reemplazar");
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_imparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_imparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_imparActionPerformed

    private void txt_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_areaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String cadena_completa;
       cadena_completa = txt_area.getText();
       
        int contador = 1, pos;
        cadena_completa = cadena_completa.trim();                              
        if (cadena_completa.isEmpty()) { 
            contador = 0;
        } else {
                pos = cadena_completa.indexOf(" "); 
                while (pos != -1) {   //mientras que se encuentre un espacio en blanco
                       contador++;    //se cuenta una palabra
                       pos = cadena_completa.indexOf(" ", pos + 1); //se busca el siguiente espacio en blanco                       
                }                                     //a continuación del actual
        }
         
        
        
        longitud();
        longitudpalabras();
        primerletra();
        ultletra();
        letrac();
        
        StringTokenizer tokens = new StringTokenizer(cadena_completa);
        String primeraPalabra = tokens.nextToken();
        txt_1p.setText("" +primeraPalabra);
        
        String frase = txt_area.getText();
        Clave_murcielago(frase);
        
        Palabracentral(cadena_completa,contador);
        ultimapalabra();
        RepeticionesletraA(cadena_completa);
        Repeticionesletrae(cadena_completa);
        Repeticionesletrai(cadena_completa);
        Repeticionesletrao(cadena_completa);
        Repeticionesletrau(cadena_completa);
        Palabrasparesimpares(cadena_completa,contador);
         
      
    }                   
    public void Clave_murcielago(String frase){
    char[]cadena = new char [frase.length()];
    
    for(int i = 0; i < frase.length(); i++){
     switch (frase.charAt(i)){
         
         case 'M': case 'm':
             cadena[i] = 'o';
             break;
         case 'U' : case 'u':
                 cadena[i] = '1';
              break;   
         case 'R':case 'r':
             cadena[i] = '2';
             break;
         case 'C': case'c':
             cadena[i] = '3';
              break;
        case'I':case'i':
            cadena[i] = '4';
            break;
        case 'E': case 'e':
                cadena[i] = '5';
                break;
            case 'L': case 'l':
                cadena[i] = '6';
                break;
            case 'A': case 'a':
                cadena[i] = '7';
                break;
            case 'G': case 'g':
                cadena[i] = '8';
                break;
            case 'O': case 'o':
                cadena[i] = '9';
                break;
            default:
                cadena[i] = frase.charAt(i);
                break;
        }
    }
    
    // Convierte el arreglo de caracteres a una cadena y la muestra en el campo de texto
    String resultado = new String(cadena);
    txt_murcielago.setText(resultado);

     
    

            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if(seleccionar.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            archivo=seleccionar.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("txt")){
                    String documento=AbrirArchivo(archivo);
                    txt_area.setText(documento);
                }else{
                    JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
            }
        }
              
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        archivo=seleccionar.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String Documento=txt_area.getText();
                String mensaje=GuardarArchivo(archivo,Documento);
                if(mensaje!=null){
                    JOptionPane.showMessageDialog(null, mensaje);
                }else{
                JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Guardar Documento de Texto");
            }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if(seleccionar.showDialog(null, "Guardar")==JFileChooser.APPROVE_OPTION){
            archivo=seleccionar.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String Documento=txt_area.getText();
                String mensaje=GuardarArchivo(archivo,Documento);
                if(mensaje!=null){
                    JOptionPane.showMessageDialog(null, mensaje);
                }else{
                JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Guardar Documento de Texto");
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

         copiar(txt_area.getText());
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        copiar(txt_area.getText());
        txt_area.setText("");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        txt_area.setText(pegar());
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_comprobador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_comprobador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_comprobador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_comprobador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_comprobador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_1letra;
    private javax.swing.JTextField txt_1p;
    private javax.swing.JTextField txt_a;
    private javax.swing.JTextField txt_area;
    private javax.swing.JTextField txt_e;
    private javax.swing.JTextField txt_i;
    private javax.swing.JTextField txt_impar;
    private javax.swing.JTextField txt_letrac;
    private javax.swing.JTextField txt_long;
    private javax.swing.JTextField txt_murcielago;
    private javax.swing.JTextField txt_o;
    private javax.swing.JTextField txt_palab;
    private javax.swing.JTextField txt_palabc;
    private javax.swing.JTextField txt_par;
    private javax.swing.JTextField txt_u;
    private javax.swing.JTextField txt_ultletra;
    private javax.swing.JTextField txt_ultpalab;
    // End of variables declaration//GEN-END:variables
}

   
