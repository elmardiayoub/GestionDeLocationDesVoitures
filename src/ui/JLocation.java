package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JLocation extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelEntete= new JLabel();
	private JLabel jIcon= new JLabel();

	private JPanel mPanelFooter;
	private JPanel  mPanelEntete;

	
	private JButton mBtnLivreAdd,mBtnLivreEdit,mBtnLivreDel,mBtnLivreAnu,mBtnLivreFind;

	
	
	public JLocation(JFrame mFram) {
		super();
		
        this.setBackground(new Color(255, 255, 255));
		this.setLayout(new BorderLayout());
		
		
		//ENTETE :
		mPanelEntete  = new JPanel();
		mPanelEntete.setBackground(new Color(254, 161, 87));
		
		jLabelEntete.setBackground(new Color(255, 255, 255));
		jLabelEntete.setFont(new Font("Yu Mincho Light", 1, 25)); 
        jLabelEntete.setForeground(new Color(255, 255, 255));
        jLabelEntete.setText("  Espace de Gestion des Locations ");
        
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("image\\location1.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
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
