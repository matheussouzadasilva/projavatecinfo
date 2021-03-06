/*
 * VisLogin.java
 *
 * Created on 02/05/2011, 20:42:00
 */
package visao;

import negocio.NegUsuario;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistencia.PerUsuario;
import util.Criptografia;
import javax.swing.ImageIcon;

/**
 * Classe VisLogin da camada de visao
 * 
 * @version 2.3 beta
 * @author Matheus Souza da Silva
 * @since 02/05/2011
 */
public class VisLogin extends javax.swing.JFrame {

    /*
    * Armazena o numero de tentativas de login invalidas
    */
    private int numeroTentativas = 0;

    /**
    *
    * Método construtor da camada de Login
    * 
    * @version 2.3 beta
    * @author Matheus Souza da Silva
    * @since 02/05/2011
    */
    public VisLogin() 
    {
        initComponents();
    }//public VisLogin() 

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTipo = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jlDica = new javax.swing.JLabel();
        jpfSenha = new javax.swing.JPasswordField();
        jlSenha = new javax.swing.JLabel();
        jtUsuario = new javax.swing.JTextField();
        jlUsuario = new javax.swing.JLabel();
        jbLogar = new javax.swing.JButton();
        jlTipo = new javax.swing.JLabel();
        jlLogo = new javax.swing.JLabel();
        jrbAdministrador = new javax.swing.JRadioButton();
        jbCadastrarse = new javax.swing.JButton();
        jrbUsuarioComum = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Detran 2.3 beta");
        setIconImage(new ImageIcon("icone.png").getImage());

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));
        jLayeredPane1.add(jlDica);
        jlDica.setBounds(10, 210, 490, 22);
        jLayeredPane1.add(jpfSenha);
        jpfSenha.setBounds(150, 90, 161, 19);

        jlSenha.setText("Senha");
        jLayeredPane1.add(jlSenha);
        jlSenha.setBounds(20, 100, 50, 15);
        jLayeredPane1.add(jtUsuario);
        jtUsuario.setBounds(150, 40, 161, 19);

        jlUsuario.setText("Usuário");
        jLayeredPane1.add(jlUsuario);
        jlUsuario.setBounds(20, 40, 60, 15);

        jbLogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/wi0126-16.png"))); // NOI18N
        jbLogar.setText("Logar");
        jbLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLogarActionPerformed(evt);
            }
        });
        jbLogar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbLogarKeyPressed(evt);
            }
        });
        jLayeredPane1.add(jbLogar);
        jbLogar.setBounds(10, 270, 120, 26);

        jlTipo.setText("Tipo");
        jLayeredPane1.add(jlTipo);
        jlTipo.setBounds(20, 150, 30, 15);
        jLayeredPane1.add(jlLogo);
        jlLogo.setBounds(330, 70, 170, 130);

        bgTipo.add(jrbAdministrador);
        jrbAdministrador.setSelected(true);
        jrbAdministrador.setText("administrador");
        jrbAdministrador.setActionCommand("administrador");
        jrbAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAdministradorActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jrbAdministrador);
        jrbAdministrador.setBounds(150, 140, 130, 23);

        jbCadastrarse.setText("Cadastrar-se");
        jbCadastrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarseActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jbCadastrarse);
        jbCadastrarse.setBounds(180, 270, 130, 25);

        bgTipo.add(jrbUsuarioComum);
        jrbUsuarioComum.setText("Usuario Comum");
        jrbUsuarioComum.setActionCommand("Usuario Comum");
        jrbUsuarioComum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbUsuarioComumActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jrbUsuarioComum);
        jrbUsuarioComum.setBounds(150, 170, 140, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    *
    * Método que tem finalidade de tentar realizar o login
    * 
    * @version 2.3 beta
    * @author Matheus Souza da Silva
    * @since 02/05/2011
    * @exception SQLException Lança uma excessao se algum erro de sql ocorrer
    */
    private void jbLogarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbLogarKeyPressed
        String senha = new String(jpfSenha.getPassword());     
        /* Código utilizado para pegar o Evento somente
        da tecla "ENTER" quando for digitada */
        if(!jtUsuario.getText().isEmpty() && !senha.isEmpty() && evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try 
            {
                this.processoLogar();
            } catch (SQLException ex) {
                Logger.getLogger(VisLogin.class.getName()).log(Level.SEVERE, null, ex);
            }//try
        } else { 
            JOptionPane.showMessageDialog(
                this,
                "você não Preencheu todos os campos",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );         
        }      
}//GEN-LAST:event_jbLogarKeyPressed

    /**
    *
    * Método que tem finalidade de tentar realizar o login
    * 
    * @version 2.3 beta
    * @author Matheus Souza da Silva
    * @since 02/05/2011
    * @exception SQLException Lança uma excessao se algum erro de sql ocorrer
    */
    private void jbLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLogarActionPerformed
       String senha = new String (jpfSenha.getPassword());
       
        if (!jtUsuario.getText().isEmpty() && !senha.isEmpty()) {
            try 
            {
                this.processoLogar();
            } catch (SQLException ex) {
                Logger.getLogger(VisLogin.class.getName()).log(Level.SEVERE, null, ex);
            }//try
        } else {
            JOptionPane.showMessageDialog(
                this,
                "você não Preencheu todos os campos",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );             
       }  
}//GEN-LAST:event_jbLogarActionPerformed

    /**
    *
    * Método que tem finalidade instanciar o interface de cadastrar usuarios
    * 
    * @version 2.3 beta
    * @author Matheus Souza da Silva
    * @since 02/05/2011
    */
    private void jbCadastrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarseActionPerformed
        VisCadastrarUsuario gcu = new VisCadastrarUsuario();
        gcu.setVisible(true);
    }//GEN-LAST:event_jbCadastrarseActionPerformed

    private void jrbAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbAdministradorActionPerformed

    private void jrbUsuarioComumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbUsuarioComumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbUsuarioComumActionPerformed

    /*
    * Metodo que verifica se o usuario e senha estão corretos.
    *
    * Esse método será chamado pelos seguintes métodos:
    * private void jbLogarActionPerformed() e
    * private void jbLogarKeyPressed() 
    * 
    * @version 2.3 beta
    * @author Matheus Souza da Silva
    * @since 02/05/2011
    * @exception Exception Lança uma excessao se algum erro ocorrer
    */
    private void processoLogar() throws SQLException
    {
        try 
        {
            jlDica.setText(this.numeroTentativas+"ª tentativa. Login inválido, tente novamente !");
            NegUsuario uc = new NegUsuario();   
            PerUsuario u = new PerUsuario();
            u.setLogin(Criptografia.criptografa(jtUsuario.getText()));
            u.setSenha(Criptografia.criptografa(new String(jpfSenha.getPassword()))); 
            u.setTipo(bgTipo.getSelection().getActionCommand());

            /* Chamando método validarSenha() e enviando
            o objeto com os dados do login para verificação
            no banco de dados */
            int opcaoMenu = uc.validarSenha(u);
        
            if (opcaoMenu != -1) {
                //Instancia o VisMenuPrincipal
                VisMenuPrincipal mp = new VisMenuPrincipal();
                mp.setVisible(true);

             /* Chama o método montaMenu e envia o número
                relacionado ao tipo de usuário */
                mp.montaMenu(opcaoMenu);

             /* Seta este objeto, ou seja, a janela de login
                com visibilidade FALSA. */
                this.setVisible(false);
            } else {
                this.numeroTentativas++;
                
                if ( this.numeroTentativas < 4) {
                    jlDica.setText(this.numeroTentativas+"ª tentativa. Login inválido, tente novamente !");
                } else {
                    System.exit(0);
                }//if (this.numeroTentativas>=3) {
                
            }//if (opcaoMenu != -1) {
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro! "+e.getMessage());
        }//try 
    }//private void processoLogar() throws SQLException
    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VisLogin().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgTipo;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton jbCadastrarse;
    private javax.swing.JButton jbLogar;
    private javax.swing.JLabel jlDica;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlSenha;
    private javax.swing.JLabel jlTipo;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JRadioButton jrbAdministrador;
    private javax.swing.JRadioButton jrbUsuarioComum;
    private javax.swing.JTextField jtUsuario;
    // End of variables declaration//GEN-END:variables
}