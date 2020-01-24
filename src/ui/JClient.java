package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JClient extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelEntete= new JLabel();
	private JLabel jIcon= new JLabel();

	private JPanel mPanelFooter;
	private JPanel  mPanelEntete;
	private JPanel mPanelVoitureForm;
	private JTextField mTxtLivreMarque = new JTextField("",20),
			   mTxtLivreModele= new JTextField("",20),
			   mTxtLivreDatePrdct = new JTextField("",20),
			   mTxtLivrePrix = new JTextField("",20);
	private JButton mBtnLivreAdd,mBtnLivreEdit,mBtnLivreDel,mBtnLivreAnu,mBtnLivreFind;

	
	
	public JClient(JFrame mFram) {
		super();
		
        this.setBackground(new Color(255, 255, 255));
		this.setLayout(new BorderLayout());
		
		
		//ENTETE :
		mPanelEntete  = new JPanel();
		mPanelEntete.setBackground(new Color(44, 237, 153));
		
		jLabelEntete.setBackground(new Color(255, 255, 255));
		jLabelEntete.setFont(new Font("Yu Mincho Light", 1, 25)); 
        jLabelEntete.setForeground(new Color(255, 255, 255));
        jLabelEntete.setText("  Espace de Gestion des Clients ");
        
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("image\\Blue1.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		jIcon.setIcon(imageIcon); 
        
        mPanelEntete.add(jLabelEntete);
        mPanelEntete.add(jIcon);
        
        

		
		
		
		
        
        /// FOOTER :
		mPanelFooter = new JPanel();
        
        mBtnLivreAdd = new JButton("Ajouter");
        mBtnLivreEdit = new JButton("Modifier");
        mBtnLivreDel= new JButton("Supprimer");
		mBtnLivreAnu= new JButton("Annuler");
		mBtnLivreFind = new JButton("Chercher");
        
        mPanelFooter.add(mBtnLivreAdd);
        mPanelFooter.add(mBtnLivreEdit);
        mPanelFooter.add(mBtnLivreDel);
        mPanelFooter.add(mBtnLivreAnu);
        mPanelFooter.add(mBtnLivreFind);

        this.add(mPanelEntete, BorderLayout.NORTH);
        this.add(mPanelFooter,BorderLayout.SOUTH);
	}
}
