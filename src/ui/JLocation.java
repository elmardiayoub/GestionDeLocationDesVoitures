package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



public class JLocation extends JPanel
{
	/****************************************************/
	private JTextField mTxtLivreAuteur = new JTextField("",20),
			   mTxtLivreTitre = new JTextField("",20),
			   mTxtLivrePrix = new JTextField("",20),
			   mTxtLivreAnnee = new JTextField("",20);
	private JPanel mPanelLivresForm = new JPanel();
	 private JLabel jLabel1= new JLabel();
	 private JLabel jLabel7= new JLabel();
	 private JLabel jLabel8= new JLabel();
	private JPanel mPanelEmpruntsButton = new JPanel();
	private JPanel mPanelEmpruntsimg = new JPanel();
	private JPanel mPanelEmpruntsTable = new JPanel();
	private JPanel mPanelEmpruntsTable2 = new JPanel();
	private JButton mBtnEmpruntAdd = new JButton("Louer"),
					mBtnEmpruntDel = new JButton("Rendre"),
					mBtnEmpruntAnu= new JButton("Annuler");
	private JTable mTableEmprunt = new JTable();
	private DefaultTableModel mTableEmpruntTitre = new DefaultTableModel()
	{
		public boolean isCellEditable(int row, int column) {return false;}
	};
	/****************************************************/
	public JLocation(JFrame mFram) {
		super();
		
		
		this.setBackground(new Color(255, 255, 255));
		this.setLayout(new BorderLayout());
		mTableEmprunt.setBackground(new java.awt.Color(255, 189, 136));
		mPanelEmpruntsTable.setBackground(new java.awt.Color(249, 236, 242));
		mPanelEmpruntsimg.setBackground(new Color(252, 120, 15));
		mPanelEmpruntsTable2.setBackground(new java.awt.Color(255, 189, 136));
		mPanelEmpruntsButton.setBackground(new java.awt.Color(254, 161, 87));

		
		
		mTableEmprunt.setModel(mTableEmpruntTitre);
		mTableEmpruntTitre.addColumn("Client");
		mTableEmpruntTitre.addColumn("CIN");
		mTableEmpruntTitre.addColumn("Marque");
		mTableEmpruntTitre.addColumn("Modèle");
		/* Listner Jtable */
		mTableEmprunt.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
		{	
			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{		
				if (mTableEmprunt.getSelectedRow() > -1) 
				{
					mBtnEmpruntAdd.setEnabled(false);
					mBtnEmpruntDel.setEnabled(true);
					mBtnEmpruntAnu.setEnabled(true);				
				}
			}
		});
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("image\\location1.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		jLabel8.setIcon(imageIcon); 
		
		
		 jLabel7.setBackground(new Color(255, 255, 255));
		 jLabel7.setFont(new Font("Yu Mincho Light", 1, 25)); 
		 jLabel7.setForeground(new Color(255, 255, 255));
		 jLabel7.setText("  Espace de Gestion des Locations ");
	        
        mPanelEmpruntsimg.add(jLabel7);
        mPanelEmpruntsimg.add(jLabel8);
		mPanelEmpruntsTable.add(new JScrollPane(mTableEmprunt));
		//showJtable(mBibliotheque.getmMapClientLivre());
		
		mPanelLivresForm.setLayout(new GridLayout(8,1));
		mPanelLivresForm.add(new JLabel("Livre"));
		mPanelLivresForm.add(mTxtLivreAuteur);
		
		mPanelLivresForm.add(new JLabel("Prix"));
		mPanelLivresForm.add(mTxtLivrePrix);
		mPanelLivresForm.add(new JLabel("Annee"));
		mPanelLivresForm.add(mTxtLivreAnnee);
		
		
		
		mPanelEmpruntsButton.add(mBtnEmpruntAdd);
		mPanelEmpruntsButton.add(mBtnEmpruntDel);
		mPanelEmpruntsButton.add(mBtnEmpruntAnu);
		this.add(mPanelEmpruntsimg, BorderLayout.NORTH);
		this.add(mPanelEmpruntsTable, BorderLayout.CENTER);
		//this.add(mPanelLivresForm, BorderLayout.WEST);
		this.add(mPanelEmpruntsButton, BorderLayout.SOUTH);
		/* Listner Button ajouter */
		mBtnEmpruntAdd.addActionListener(new ActionListener() 
		{	
			@Override
			
			public void actionPerformed(ActionEvent arg0) 
			{	
				//JDialog
				JDialog jd = new JDialog(mFram);
				jd.setTitle("Ajouter une Emprunt");
				jd.setLayout(new BorderLayout());
				//Panel
				JPanel mPanelNorth = new JPanel();
				JPanel mPanelCentre = new JPanel();
				JPanel mPanelBtns = new JPanel();
				//Buttons
				JButton mButtonAddAdd = new JButton("Ajouter");
				JButton mButtonAddAnu = new JButton("Annuler");
				//List
				/*JList<Client> mListClient = new JList<Client>();
				mListClient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				mListClient.setModel(new AbstractListModel<Client>() {
					
					ArrayList<Client> cl = mBibliotheque.getClientsDisponibles();
					@Override
					public Client getElementAt(int index) {
						// TODO Auto-generated method stub
						return cl.get(index);
					}

					@Override
					public int getSize() {
						// TODO Auto-generated method stub
						return cl.size();
					}
				});*/
				JScrollPane mJspClient = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				/*JList<Livre> mListLivre = new JList<Livre>();
				mListLivre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				mListLivre.setModel(new AbstractListModel<Livre>() {

					ArrayList<Livre> vd = mBibliotheque.getLivresDisponibles();
					@Override
					public Livre getElementAt(int index) {
						// TODO Auto-generated method stub
						return vd.get(index);
					}

					@Override
					public int getSize() {
						// TODO Auto-generated method stub
						return vd.size();
					}
				});*/
				JScrollPane mJspLivre= new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				//Pack
				mPanelCentre.setLayout(new FlowLayout());
				//mJspClient.setViewportView(mListClient);
				mPanelCentre.add(mJspClient);
				//mJspLivre.setViewportView(mListLivre);
				mPanelCentre.add(mJspLivre);
				
				 jLabel1.setBackground(new java.awt.Color(204, 204, 255));
			        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 14)); 
			        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
			        jLabel1.setText("  Liste  des Livres disponibles ");
				
				
				mPanelNorth.add(jLabel1);
				mPanelNorth.setBackground(new java.awt.Color(249, 236, 242));
				mPanelCentre.setBackground(new java.awt.Color(249, 236, 242));
				jd.getContentPane().add(mPanelNorth, BorderLayout.NORTH);
				jd.getContentPane().add(mPanelCentre, BorderLayout.CENTER);
				mPanelBtns.add(mButtonAddAdd);
				mButtonAddAdd.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						/*if(mListClient.isSelectionEmpty() || mListLivre.isSelectionEmpty())
						{
							JOptionPane.showMessageDialog(jd, "Vous devez choisir un client et une Livre","Erreur Emprunt",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							mBibliotheque.emprunterLivre(mListClient.getSelectedValue(), mListLivre.getSelectedValue());
							showJtable(mBibliotheque.getmMapClientLivre());
							jd.setVisible(false);
							jd.dispose();
						}*/
					}
				});
				mPanelBtns.add(mButtonAddAnu);
				mButtonAddAnu.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jd.setVisible(false);
						jd.dispose();
						
					}
				});
				jd.getContentPane().add(mPanelBtns, BorderLayout.SOUTH);
				//JDialg
				jd.setSize(600, 250);
				jd.setAlwaysOnTop(true);
				jd.setModal(true);
				jd.setVisible(true);
			}
		});
		mBtnEmpruntDel.setEnabled(false);
		mBtnEmpruntDel.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (mTableEmprunt.getSelectedRow() > -1) 
				{
					if(JOptionPane.showConfirmDialog(
							mFram,
							"Voulez vous vraiment supprimer cette Emprunt ?",
							"Supprimer",
							JOptionPane.OK_CANCEL_OPTION
						)==0
						)
					{
						//mBibliotheque.retirerEmprunt(mTableEmprunt.getValueAt(mTableEmprunt.getSelectedRow(),1).toString());
						mTableEmpruntTitre.removeRow(mTableEmprunt.getSelectedRow());
					}
				}
				
			}
		});
		mBtnEmpruntAnu.setEnabled(false);
		
		/* Listner Button annuler */
		mBtnEmpruntAnu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mBtnEmpruntAdd.setEnabled(true);
				mBtnEmpruntAnu.setEnabled(false);
				mBtnEmpruntDel.setEnabled(false);
			}
		});
		
	}
	
	
/*	private void showJtable(TreeMap<Client, Livre> mlist)
	{
		mTableEmpruntTitre.setRowCount(0);
		for (Client c : mlist.keySet()) {
			Livre v =mlist.get(c);
			mTableEmpruntTitre.addRow(
					new Object[]{
							Client.showCivilite(c.getCivilite())+" "+c.getNom()+" "+c.getPrenom(),
							c.getCIN(),
							v.getAuteur()+" "+v.getTitre()+" ("+v.getAnnee_prodction()+")",
							String.valueOf(v.getPrix())+ " Dhs/jour"
							}
					);
		}
	}
	*/
}
