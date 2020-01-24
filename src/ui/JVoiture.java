package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class JVoiture extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabelEntete= new JLabel();
	private JLabel jIcon= new JLabel();

	private JPanel mPanelFooter;
	private JPanel  mPanelEntete;
	
	
	private JPanel mPanelVoitureForm;
	private JTextField mTxtVoitureMarque = new JTextField("",25),
			   mTxtVoitureModele= new JTextField("",20),
			   mTxtVoitureDatePrdct = new JTextField("",20),
			   mTxtVoiturePrix = new JTextField("",20);
	
	JLabel marque = new JLabel("Marque"),
		   modele= new JLabel("Modele"),
		   prod= new JLabel("Date de production"),
		   prix= new JLabel("Prix");
	
	private JPanel mPanelVoitureMilieu = new JPanel();
	
	private JPanel mPanelVoitureTable = new JPanel();
	
	private JTable mTableLivre = new JTable();
	
	private JButton mBtnLivreAdd,mBtnLivreEdit,mBtnLivreDel,mBtnLivreAnu,mBtnLivreFind;

	private JPanel Test = new JPanel();
	
	private DefaultTableModel mTableLivreModel = new DefaultTableModel()
	{
		public boolean isCellEditable(int row, int column) {return false;}
	};
	public JVoiture(JFrame mFram) {
		super();
		
        this.setBackground(new Color(255, 255, 255));
		this.setLayout(new BorderLayout());
		
		
		//ENTETE :
		mPanelEntete  = new JPanel();
		mPanelEntete.setBackground(new Color(255, 18, 18));
		
		jLabelEntete.setBackground(new Color(255, 255, 255));
		jLabelEntete.setFont(new Font("Yu Mincho Light", 1, 25)); 
        jLabelEntete.setForeground(new Color(255, 255, 255));
        jLabelEntete.setText("  Espace de Gestion des Voitures ");
        
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("image\\car7.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		jIcon.setIcon(imageIcon); 
        
        mPanelEntete.add(jLabelEntete);
        mPanelEntete.add(jIcon);
        
        
        //MILIEU :
        mPanelVoitureForm = new JPanel();
        //mPanelVoitureForm.setBackground(new java.awt.Color(179, 204, 204));
        
        mPanelVoitureForm.setLayout(new GridLayout(5,2));
        
        marque.setFont(new Font("Yu Mincho Light", 1, 13));
        marque.setForeground(new Color(255, 255, 255));
        mPanelVoitureForm.add(marque);
        mPanelVoitureForm.add(mTxtVoitureMarque);
        modele.setFont(new Font("Yu Mincho Light", 1, 13)); 
        modele.setForeground(new Color(255, 255, 255));
        mPanelVoitureForm.add(modele);
        mPanelVoitureForm.add(mTxtVoitureModele);
        prod.setFont(new Font("Yu Mincho Light", 1, 13)); 
        prod.setForeground(new Color(255, 255, 255));
        mPanelVoitureForm.add(prod);
        mPanelVoitureForm.add(mTxtVoitureDatePrdct);
		prix.setFont(new Font("Yu Mincho Light", 1, 13)); 
		prix.setForeground(new Color(255, 255, 255));
		mPanelVoitureForm.add(prix);
		mPanelVoitureForm.add(mTxtVoiturePrix);
		mPanelVoitureForm.setBackground(new Color(253,87,87));
		mPanelVoitureMilieu.setLayout(new BorderLayout());
		Test.setLayout(new FlowLayout());
		Test.add(mPanelVoitureForm);
		Test.setBackground(new Color(253,87,87));
		mPanelVoitureMilieu.setBackground(new java.awt.Color(179, 204, 204));
		mPanelVoitureMilieu.add(Test,BorderLayout.NORTH);
		
		this.add(mPanelVoitureMilieu, BorderLayout.CENTER);
		
        /// FOOTER :
		mPanelFooter = new JPanel();
		mPanelFooter.setLayout(new FlowLayout());
		 
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
        
        mPanelFooter.setBackground(new Color(251,127,127));
        mPanelVoitureMilieu.add(mPanelFooter,BorderLayout.CENTER);
        this.add(mPanelEntete, BorderLayout.NORTH);
        
        mPanelVoitureTable.setBackground(new Color(254,156,156));
        mPanelVoitureTable.setLayout(new FlowLayout());
        mPanelVoitureTable.add(new JScrollPane(mTableLivre));
        mPanelVoitureMilieu.add(mPanelVoitureTable,BorderLayout.SOUTH);
        
        mTableLivre.setModel(mTableLivreModel);
        
		mTableLivreModel.addColumn("Marque");
		mTableLivreModel.addColumn("Modèle");
		mTableLivreModel.addColumn("Date de production");
		mTableLivreModel.addColumn("Prix");
		
		mTableLivre.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{	
			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{		
				if (mTableLivre.getSelectedRow() > -1) 
				{
					mTxtVoitureMarque.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 0).toString());
					mTxtVoitureModele.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 1).toString());
					mTxtVoitureDatePrdct.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 2).toString());
					mTxtVoiturePrix.setText(mTableLivre.getValueAt(mTableLivre.getSelectedRow(), 3).toString());
					mBtnLivreAdd.setEnabled(false);
					mBtnLivreFind.setEnabled(false);
					mBtnLivreEdit.setEnabled(true);
					mBtnLivreDel.setEnabled(true);
					mBtnLivreAnu.setEnabled(true);
					
				}
			}
		});
	
        //this.add(mPanelFooter,BorderLayout.SOUTH);
	}
}
