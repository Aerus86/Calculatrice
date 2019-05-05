package calculatrice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Fenetre extends JFrame {
    //variables affichage
    private JPanel container = new JPanel();
    private JTextField affichage = new JTextField("0");
    private JPanel containerBoutons = new JPanel();
    private JPanel container1 = new JPanel();
    private JPanel container2 = new JPanel();
    private JPanel container3 = new JPanel();
    private JPanel container4 = new JPanel();
    private JOptionPane jop1 = new JOptionPane();
    private final JButton bouton1 = new JButton("1");
    private final JButton bouton2 = new JButton("2");
    private final JButton bouton3 = new JButton("3");
    private final JButton bouton4 = new JButton("4");
    private final JButton bouton5 = new JButton("5");
    private final JButton bouton6 = new JButton("6");
    private final JButton bouton7 = new JButton("7");
    private final JButton bouton8 = new JButton("8");
    private final JButton bouton9 = new JButton("9");
    private final JButton bouton0 = new JButton("0");
    private final JButton boutonVirgule = new JButton(".");
    private final JButton boutonEgal = new JButton("=");
    private final JButton boutonC = new JButton("C");
    private final JButton boutonPlus = new JButton("+");
    private final JButton boutonMoin = new JButton("-");
    private final JButton boutonMult = new JButton("*");
    private final JButton boutonDiv = new JButton("/");
    
    //variables opérations
    private double chiffreAffiche = 0.0;
    private double chiffreMem = 0.0;
    private int virguleOnOff = 0;
    private double valeurVirgule = 10.0;
    private int valeurOperateur = 0;
    
    
    public Fenetre (){
        this.setTitle("Calculator");
        this.setSize(350, 370);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        
        
        // container
        container.add(affichage);
        affichage.setHorizontalAlignment(SwingConstants.RIGHT);
        affichage.setFont(new Font("Verdana", Font.BOLD, 25));
        container.add(containerBoutons);
        
        // containerBouton
        containerBoutons.setLayout(new GridLayout(1,4,5,5));
        containerBoutons.add(container1);
        bouton1.setPreferredSize(new Dimension(70,60));
        containerBoutons.add(container2);
        containerBoutons.add(container3);
        containerBoutons.add(container4);
        
        // container1
        container1.setLayout(new GridLayout(4,1,5,5));
        container1.add(bouton1);
        bouton1.addActionListener(new bouton1Listener());
        container1.add(bouton4);
        bouton4.addActionListener(new bouton4Listener());
        container1.add(bouton7);
        bouton7.addActionListener(new bouton7Listener());
        container1.add(bouton0);
        bouton0.addActionListener(new bouton0Listener());
        
        // container2
        container2.setLayout(new GridLayout(4,1,5,5));
        container2.add(bouton2);
        bouton2.addActionListener(new bouton2Listener());
        container2.add(bouton5);
        bouton5.addActionListener(new bouton5Listener());
        container2.add(bouton8);
        bouton8.addActionListener(new bouton8Listener());
        container2.add(boutonVirgule);
        boutonVirgule.addActionListener(new boutonVirguleListener());
        
        // container3
        container3.setLayout(new GridLayout(4,1,5,5));
        container3.add(bouton3);
        bouton3.addActionListener(new bouton3Listener());
        container3.add(bouton6);
        bouton6.addActionListener(new bouton6Listener());
        container3.add(bouton9);
        bouton9.addActionListener(new bouton9Listener());
        container3.add(boutonEgal);
        boutonEgal.addActionListener(new boutonEgalListener());
        
        // container4
        container4.setLayout(new GridLayout(5,1,5,5));
        container4.add(boutonC);
        boutonC.setForeground(Color.RED);
        boutonC.addActionListener(new boutonCListener());
        container4.add(boutonPlus);
        boutonPlus.addActionListener(new boutonPlusListener());
        container4.add(boutonMoin);
        boutonMoin.addActionListener(new boutonMoinListener());
        container4.add(boutonMult);
        boutonMult.addActionListener(new boutonMultListener());
        container4.add(boutonDiv);
        boutonDiv.addActionListener(new boutonDivListener());

               
        // affichage
        affichage.setPreferredSize(new Dimension(300, 50));
        affichage.setEditable(false);// pour empecher le fait qu'on puisse editer la ligne
        //affichage.setBackground(Color.LIGHT_GRAY);
        affichage.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.setContentPane(container);
        this.setVisible(true);   
    }
    
    class bouton1Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double vBouton = 1.0;
            if (virguleOnOff == 1){
                chiffreAffiche = (((chiffreAffiche * valeurVirgule) + vBouton ) / valeurVirgule);
                valeurVirgule *= 10.0;
            }
            if (virguleOnOff == 0){
                chiffreAffiche *= 10;
                chiffreAffiche += vBouton; 
            }
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class bouton2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double vBouton = 2.0;
            if (virguleOnOff == 1){
                chiffreAffiche = (((chiffreAffiche * valeurVirgule) + vBouton ) / valeurVirgule);
                valeurVirgule *= 10.0;
            }
            if (virguleOnOff == 0){
                chiffreAffiche *= 10;
                chiffreAffiche += vBouton; 
            }
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class bouton3Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double vBouton = 3.0;
            if (virguleOnOff == 1){
                chiffreAffiche = (((chiffreAffiche * valeurVirgule) + vBouton ) / valeurVirgule);
                valeurVirgule *= 10.0;
            }
            if (virguleOnOff == 0){
                chiffreAffiche *= 10;
                chiffreAffiche += vBouton; 
            }
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class bouton4Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double vBouton = 4.0;
            if (virguleOnOff == 1){
                chiffreAffiche = (((chiffreAffiche * valeurVirgule) + vBouton ) / valeurVirgule);
                valeurVirgule *= 10.0;
            }
            if (virguleOnOff == 0){
                chiffreAffiche *= 10;
                chiffreAffiche += vBouton; 
            }
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class bouton5Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double vBouton = 5.0;
            if (virguleOnOff == 1){
                chiffreAffiche = (((chiffreAffiche * valeurVirgule) + vBouton ) / valeurVirgule);
                valeurVirgule *= 10.0;
            }
            if (virguleOnOff == 0){
                chiffreAffiche *= 10;
                chiffreAffiche += vBouton; 
            }
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class bouton6Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double vBouton = 6.0;
            if (virguleOnOff == 1){
                chiffreAffiche = (((chiffreAffiche * valeurVirgule) + vBouton ) / valeurVirgule);
                valeurVirgule *= 10.0;
            }
            if (virguleOnOff == 0){
                chiffreAffiche *= 10;
                chiffreAffiche += vBouton; 
            }
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class bouton7Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double vBouton = 7.0;
            if (virguleOnOff == 1){
                chiffreAffiche = (((chiffreAffiche * valeurVirgule) + vBouton ) / valeurVirgule);
                valeurVirgule *= 10.0;
            }
            if (virguleOnOff == 0){
                chiffreAffiche *= 10;
                chiffreAffiche += vBouton; 
            }
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class bouton8Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double vBouton = 8.0;
            if (virguleOnOff == 1){
                chiffreAffiche = (((chiffreAffiche * valeurVirgule) + vBouton ) / valeurVirgule);
                valeurVirgule *= 10.0;
            }
            if (virguleOnOff == 0){
                chiffreAffiche *= 10;
                chiffreAffiche += vBouton; 
            }
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class bouton9Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double vBouton = 9.0;
            if (virguleOnOff == 1){
                chiffreAffiche = (((chiffreAffiche * valeurVirgule) + vBouton ) / valeurVirgule);
                valeurVirgule *= 10.0;
            }
            if (virguleOnOff == 0){
                chiffreAffiche *= 10;
                chiffreAffiche += vBouton; 
            }
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class bouton0Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double vBouton = 0.0;
            if (virguleOnOff == 1){
                chiffreAffiche = (((chiffreAffiche * valeurVirgule) + vBouton ) / valeurVirgule);
                valeurVirgule *= 10.0;
            }
            if (virguleOnOff == 0){
                chiffreAffiche *= 10;
                chiffreAffiche += vBouton; 
            }
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class boutonVirguleListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            virguleOnOff = 1;
        }  
    }
    
    class boutonCListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            virguleOnOff = 0;
            valeurVirgule = 10.0;
            chiffreAffiche = 0.0;
            chiffreMem = 0.0;
            valeurOperateur = 0;
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class boutonPlusListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            virguleOnOff = 0;
            valeurVirgule = 10.0;
            valeurOperateur = 1;
            chiffreMem = chiffreAffiche;
            chiffreAffiche = 0.0;
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class boutonMoinListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            virguleOnOff = 0;
            valeurVirgule = 10.0;
            valeurOperateur = 2;
            chiffreMem = chiffreAffiche;
            chiffreAffiche = 0.0;
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class boutonMultListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            virguleOnOff = 0;
            valeurVirgule = 10.0;
            valeurOperateur = 3;
            chiffreMem = chiffreAffiche;
            chiffreAffiche = 0.0;
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class boutonDivListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            virguleOnOff = 0;
            valeurVirgule = 10.0;
            valeurOperateur = 4;
            chiffreMem = chiffreAffiche;
            chiffreAffiche = 0.0;
            affichage.setText("" + chiffreAffiche);
        }  
    }
    
    class boutonEgalListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (valeurOperateur == 1){
                chiffreMem += chiffreAffiche;
            }
            if (valeurOperateur == 2){
                chiffreMem -= chiffreAffiche;
            }
            if (valeurOperateur == 3){
                chiffreMem *= chiffreAffiche;
            }
            if (valeurOperateur == 4){
                double valeurTempon = chiffreMem;
                chiffreMem /= chiffreAffiche;
                if (chiffreMem == Double.POSITIVE_INFINITY || chiffreMem == Double.NEGATIVE_INFINITY ){
                    chiffreMem = valeurTempon;
                    jop1.showMessageDialog(null, "Division par 0 impossible!", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
            virguleOnOff = 0;
            affichage.setText("" + chiffreMem);
            chiffreAffiche = chiffreMem;
            valeurOperateur = 0;
        }  
    }
}