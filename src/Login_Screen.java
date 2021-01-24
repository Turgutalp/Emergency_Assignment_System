/*
     Taha Yuceler
     Baran Aslankan
     Turgutalp Tug

*/
import javax.swing.JOptionPane;



public class Login_Screen extends javax.swing.JFrame {

    /**
     * Creates new form Login_Screen
     */
    public Login_Screen() {
        initComponents();
        
        
    }

public static class AVLNode {
	private int element;private int infected;private int deaths;private int recovery;private String country;private int personnel;
	private AVLNode left;
	private AVLNode right;
	private int height;
	public AVLNode(int newElement, int newinfected, int newdeaths, int newrecovery, String newcountry,int newpersonnel) {
	 element= newElement;  infected=newinfected; deaths=newdeaths; recovery=newrecovery; country=newcountry; personnel=newpersonnel; //buna benzer bi sey gerekebilir
	 left= null;
	 right= null;
	 height= 0;
	}

	 public int getElement() {
			return element;
		 }
		 public void setElement(int newElement) {
			this.element = newElement;
		 }
		 public AVLNode getLeft() {
			return left;
		 }
		 public void setLeft(AVLNode newLeft) {
			this.left = newLeft;
		 }
		public AVLNode getRight() {
			return right;
		}
		public void setRight(AVLNode newRight) {
			this.right = newRight;
		}





		public int getInfected() {
			return infected;
		}
		public void setInfected(int newinfected) {
			this.infected = newinfected;
		}
		public int getDeaths() {
			return deaths;
		}
		public void setDeaths(int newdeaths) {
			this.deaths = newdeaths;
		}
		public int getRecovery() {
			return recovery;
		}
		public void setRecovery(int newrecovery) {
			this.recovery = newrecovery;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String newcountry) {
			this.country = newcountry;
		}
		
		public int getPersonnel() {
			return personnel;
		}

		public void setPersonnel(int newpersonnel) {
			this.personnel = newpersonnel;
		}

	public int getHeight()
	{
	return height;
	}
	public void setHeight(int h)
	{
	height= h;
	}
	
}

public  static class Node {//linked list node
 
 private int count;
 private Node link;
 private int day;
 private AVLTree dailyTree;
 public Node( ){
  link = null;
  dailyTree = null;
  count = 0;
 }
 
 public Node(int newDay, AVLTree newdailyTree,int newCount, Node linkValue)
 {
 setData(newDay, newdailyTree);
 count=newCount;
 link = linkValue;
 }
 public void setData(int newDay,AVLTree newdailyTree)
 {
 day = newDay;
 dailyTree= newdailyTree;
 }
 public void setLink(Node newLink)
 {
 link = newLink;
 }
 
 
 public int getCount( )
 {
 return count;
 }
 public Node getLink( )
 {
 return link;
 }

public int getDay() {
	return day;
}

public void setDay(int newday) {
	this.day = newday;
}

public AVLTree getDailyTree() {
	return dailyTree;
}

public void setDailyTree(AVLTree newdailyTree) {
	this.dailyTree = newdailyTree;
}
 
 
 
 }
public static  class LinkedList {// linked list for day relation

private Node head;
 public LinkedList( ){
 head = null;
 }
 public boolean isEmpty(){
  if(head == null)
    return true;
   else
    return false;
 }
 public void outputList(AVLTree z )
 {
 Node position = head;
 while (position != null)
 {
 System.out.println(position.getDailyTree() + " " +
 position.getCount( ));
 position = position.getLink( );
 }
 }
 
 public void addToStart(int day, AVLTree tree, int itemCount){
  head = new Node(day,tree, itemCount, head);
 }
 
 public void whichDay(int day) {
	 
 }
 public boolean search(Node head, int x) 
 { 
     Node current = head;    //Initialize current 
     while (current != null) 
     { 
         if (current.getDay() == x) 
             return true;    //data found 
         current = current.getLink(); 
     } 
     return false;    //data not found 
 } 
 
 
 public String conv(int x,int e) {
	 Node current=head;
	 while(x!=current.getDay()){
		 current=current.getLink();
			 }
	 AVLTree tree=current.getDailyTree();
	return tree.dailyCountryData(e);
	 
         
	 
 }
 
 public String convPersonnel(int x,int e) {
	 Node current=head;
	 while(x!=current.getDay()){
		 current=current.getLink();
			 }
	 AVLTree tree=current.getDailyTree();
	 return tree.assignment(e);
	 
	 
 }
 
}
public static  class AVLTree {
	private AVLNode root;
	private static final int ALLOWED_IMBALANCE= 1;
	// Construct the tree.
	public AVLTree()
	{
	root= null;
	}
	// Return the height of node a or -1 if null
	private int height(AVLNode a){
	 if(a == null)
	  return -1;
	 else
	  return a.getHeight();
	}
	
	public void insert(int x,int y,int z,int q, String ss, int pp)
	{
	root= insert(x,y,z,q,ss,pp, root);
	}
	
	private AVLNode insert(int e, int infected, int deaths, int recovery, String country,int personnel, AVLNode t)
	{
	if(t == null)
	return new AVLNode(e,infected,deaths,recovery,country,personnel);
	if(e < t.getElement())
	t.setLeft(insert(e,infected,deaths,recovery,country,personnel, t.getLeft()));
	else if(e > t.getElement())
	t.setRight(insert(e,infected,deaths,recovery,country,personnel, t.getRight()));
	else
	; //Duplicate, do nothing
	return balance(t);
	}
	
	
	private AVLNode rotateWithLeftChild(AVLNode k2)
	{
	AVLNode k1 = k2.getLeft();
	k2.setLeft(k1.getRight());
	k1.setRight(k2);
	k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight())) + 1);
	k1.setHeight(Math.max(height(k1.getLeft()), k2.getHeight()) + 1);
	return k1;
	}
	
	private AVLNode rotateWithRightChild(AVLNode k1)
	{
	AVLNode k2 = k1.getRight();
	k1.setRight(k2.getLeft());
	k2.setLeft(k1);
	k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight())) + 1);
	k2.setHeight(Math.max(height(k2.getRight()), k1.getHeight()) + 1) ;
	return k2;
	}
	
	
	private AVLNode doubleWithLeftChild(AVLNode k3)
	{
	k3.setLeft(rotateWithRightChild(k3.getLeft()));
	return rotateWithLeftChild(k3);
	}
	
	private AVLNode doubleWithRightChild(AVLNode k1)
	{
	k1.setRight(rotateWithLeftChild(k1.getRight()));
	return rotateWithRightChild(k1);
	}
	
	 
	private AVLNode balance(AVLNode t){
	if( t == null)
	return t;
	if(height(t.getLeft()) -height(t.getRight()) > ALLOWED_IMBALANCE)
	if(height(t.getLeft().getLeft()) >= height(t.getLeft().getRight()))
	t = rotateWithLeftChild(t);
	else
	t = doubleWithLeftChild(t);
	else
	if(height(t.getRight()) -height(t.getLeft()) > ALLOWED_IMBALANCE)
	if(height(t.getRight().getRight()) >= height(t.getRight().getLeft()))
	t = rotateWithRightChild(t);
	else
	t = doubleWithRightChild(t);
	t.setHeight(Math.max(height(t.getLeft()), height(t.getRight())) + 1);
	return t;
	}
	
	public void printTree()
	{
	if(root== null)
	System.out.println("Empty tree");
	else
	printTree(root);
	}
	
	private void printTree(AVLNode t){
	 if(t != null){
	   printTree(t.getLeft());
	   System.out.println(t.getElement());
	   printTree(t.getRight());
	 }
	}
	
	 public String  dailyCountryData(int e){// Prints daily COUNTRY data.
		 AVLNode current = root; // Start from the root
		 while (current.getElement() != e) {
		 if (e < current.getElement())
		 current = current.getLeft();
		 else if (e > current.getElement())
		 current = current.getRight();
	     
	 }
	 return("Country Code: " + current.getElement()+"\nCountry: " 
		  +current.getCountry()+ "\nTotal Infected : " +current.getInfected()
		  +"\nTotal Deaths: "+ current.getDeaths()+ "\nTotal Recovery: "+ current.getRecovery()+ "\nTotal Health Personnel: "
		  +current.getPersonnel());
    }
         
         
	 
	 
	 public String assignment(int e){ // Is Assignment necessary? If it is, how many HP we need?
		 AVLNode current = root; // Start from the root
		 while (current.getElement() != e) {
		 if (e < current.getElement())
		 current = current.getLeft();
		 else if (e > current.getElement())
		 current = current.getRight();
	     
	 }
	
		
		 //each personnel can handle with 10 patients.
		 if(current.getInfected()/10>current.getPersonnel()){
			 return("Number of Health Personnel to be assigned: "+(current.getInfected()/10-current.getPersonnel()));
                 }
                 else{
			return("Health Personnel assignment is NOT NECESSARY for: " + current.getCountry());
                 }
	
}
	 public int assignedHP(int e) {
		 AVLNode current = root; // Start from the root
		 while (current.getElement() != e) {
		 if (e < current.getElement())
		 current = current.getLeft();
		 else if (e > current.getElement())
		 current = current.getRight();
		 } 
		 return (current.getInfected()/10-current.getPersonnel());
	 }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        EASY_title_text = new javax.swing.JLabel();
        lbl_stayathome = new javax.swing.JLabel();
        jlbl_turkey_text = new javax.swing.JLabel();
        jbl_usa_text = new javax.swing.JLabel();
        jlbl_germany_text = new javax.swing.JLabel();
        jlbl_chine_text = new javax.swing.JLabel();
        jlabel_russia_text = new javax.swing.JLabel();
        jlbl_italy_text = new javax.swing.JLabel();
        jlbl_spain_text = new javax.swing.JLabel();
        jlbl_france_text = new javax.swing.JLabel();
        jlbl_uk_text = new javax.swing.JLabel();
        jlbl_iran_text = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        russia = new javax.swing.JLabel();
        germany = new javax.swing.JLabel();
        turkey = new javax.swing.JLabel();
        uk = new javax.swing.JLabel();
        italy = new javax.swing.JLabel();
        france = new javax.swing.JLabel();
        spain = new javax.swing.JLabel();
        iran = new javax.swing.JLabel();
        usa = new javax.swing.JLabel();
        chine = new javax.swing.JLabel();
        lbl_enter_day = new javax.swing.JLabel();
        country_number = new javax.swing.JTextField();
        lbl_enter_country = new javax.swing.JLabel();
        day_number = new javax.swing.JTextField();
        btn_show = new javax.swing.JButton();
        who_logo = new javax.swing.JLabel();

        jLabel11.setIcon(new javax.swing.ImageIcon("/Users/turgutalptug/Desktop/covid copy.png")); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/who.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EASY");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        EASY_title_text.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        EASY_title_text.setForeground(new java.awt.Color(80, 170, 236));
        EASY_title_text.setText("      Emergency Assignment System[EASY]");
        EASY_title_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 112, 112), 4));

        lbl_stayathome.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
        lbl_stayathome.setText("    # STAY  AT  HOME");
        lbl_stayathome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jlbl_turkey_text.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlbl_turkey_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_turkey_text.setText(" Turkey[1]");

        jbl_usa_text.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jbl_usa_text.setText("      Usa[10]");

        jlbl_germany_text.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlbl_germany_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_germany_text.setText("Germany[2]");

        jlbl_chine_text.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlbl_chine_text.setText("  Chine[9]");

        jlabel_russia_text.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jlabel_russia_text.setText(" Russia[3]");

        jlbl_italy_text.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlbl_italy_text.setText("  Italy[4]");
        jlbl_italy_text.setToolTipText("");

        jlbl_spain_text.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlbl_spain_text.setText("     Spain[8]");

        jlbl_france_text.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlbl_france_text.setText("    France[7]");

        jlbl_uk_text.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlbl_uk_text.setText("     Uk[5]");

        jlbl_iran_text.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlbl_iran_text.setText("      Iran[6]");

        russia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/russia.png"))); // NOI18N

        germany.setIcon(new javax.swing.ImageIcon(getClass().getResource("/germany.png"))); // NOI18N

        turkey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/turkey.png"))); // NOI18N

        uk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk.png"))); // NOI18N

        italy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/italy.png"))); // NOI18N

        france.setIcon(new javax.swing.ImageIcon(getClass().getResource("/france.png"))); // NOI18N

        spain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spain.png"))); // NOI18N

        iran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iran.png"))); // NOI18N

        usa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usa.png"))); // NOI18N

        chine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/china logo.png"))); // NOI18N

        lbl_enter_day.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lbl_enter_day.setText("Please Enter The Day:");

        country_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                country_numberActionPerformed(evt);
            }
        });

        lbl_enter_country.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lbl_enter_country.setText("Please Enter Your Country Code:");

        day_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day_numberActionPerformed(evt);
            }
        });

        btn_show.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        btn_show.setForeground(new java.awt.Color(80, 170, 236));
        btn_show.setText("SHOW");
        btn_show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_showActionPerformed(evt);
            }
        });

        who_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/who.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(germany)
                                .addComponent(russia)
                                .addComponent(jlabel_russia_text, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(turkey)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlbl_uk_text, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(uk)))
                                        .addGap(47, 47, 47))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jlbl_italy_text, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(italy))
                                        .addGap(63, 63, 63)))
                                .addComponent(jlbl_germany_text, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbl_turkey_text, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(lbl_stayathome, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(82, 82, 82))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(who_logo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(spain, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jlbl_spain_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlbl_france_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(france, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jbl_usa_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(16, 16, 16)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jlbl_chine_text, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(chine)
                                                .addComponent(usa))))
                                    .addComponent(iran, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlbl_iran_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(day_number, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_show, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(lbl_enter_day))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(country_number, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lbl_enter_country)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(EASY_title_text, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(EASY_title_text, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_stayathome)
                                .addGap(58, 58, 58)
                                .addComponent(lbl_enter_country, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbl_turkey_text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(turkey))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbl_usa_text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usa)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbl_germany_text)
                            .addComponent(jlbl_chine_text))
                        .addGap(4, 4, 4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chine)
                            .addComponent(germany))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(country_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_enter_day, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabel_russia_text)
                            .addComponent(jlbl_spain_text)
                            .addComponent(day_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spain)
                            .addComponent(russia)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btn_show)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbl_italy_text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(italy, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jlbl_uk_text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(uk))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbl_france_text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(france)
                                .addGap(29, 29, 29)
                                .addComponent(jlbl_iran_text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iran))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(who_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void country_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_country_numberActionPerformed
        
        
    
        
    }//GEN-LAST:event_country_numberActionPerformed

    private void day_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_day_numberActionPerformed
      
    }//GEN-LAST:event_day_numberActionPerformed

    private void btn_showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_showActionPerformed
        int  countryCodee1 = Integer.valueOf(this.country_number.getText());
         int insertDay1 = Integer.valueOf(this.day_number.getText());
         
         
         if(countryCodee1 >= 0 && countryCodee1 <= 10  && insertDay1>= 0   && insertDay1 <= 10){
             
         }else{
             
             JOptionPane.showMessageDialog(this,"Please enter a number between 1 and 10.");
             
         }
         
         
        
         AVLTree day1 = new AVLTree(); // creating days --> trees
		// insert(country #, total infected, deaths, discharged, country in strings)
		day1.insert(0, 2452, 65, 80, "TEST", 1500);
		day1.insert(1, 107000, 2500, 3000, "Turkey", 26480);
		day1.insert(2, 6665, 28, 22, "Germany", 4500);
		day1.insert(3, 204000, 30566, 5056, "Russia", 38004);
		day1.insert(4, 123000, 42340, 3240, "Italy", 23598);
		day1.insert(5, 94003, 24846, 5013, "UK", 3684);
		day1.insert(6, 2004, 20, 5, "Iran", 4509);
		day1.insert(7, 500, 10, 2, "France", 56412);
		day1.insert(8, 580, 18, 6, "Spain", 5446);
		day1.insert(9, 1080, 158, 86, "China", 9654);
		day1.insert(10, 580, 18, 6, "USA", 7541);

		AVLTree day2 = new AVLTree();
		// insert(country #, total infected, deaths, discharged, country in strings)
		day2.insert(0, 2452, 65, 80, "TEST", 1500);
		day2.insert(1, 107000, 2500, 3000, "Turkey", 26480);
		day2.insert(2, 6665, 28, 22, "Germany", 4500);
		day2.insert(3, 204000, 30566, 5056, "Russia", 38004);
		day2.insert(4, 123000, 42340, 3240, "Italy", 23598);
		day2.insert(5, 94003, 24846, 5013, "UK", 3684);
		day2.insert(6, 2004, 20, 5, "Iran", 4509);
		day2.insert(7, 500, 10, 2, "France", 56412);
		day2.insert(8, 580, 18, 6, "Spain", 5446);
		day2.insert(9, 1080, 158, 86, "China", 9654);
		day2.insert(10, 580, 18, 6, "USA", 7541);

		AVLTree day3 = new AVLTree();
		// insert(country #, total infected, deaths, discharged, country in strings)
		day3.insert(0, 2452, 65, 80, "TEST", 1500);
		day3.insert(1, 107000, 2500, 3000, "Turkey", 26480);
		day3.insert(2, 6665, 28, 22, "Germany", 4500);
		day3.insert(3, 204000, 30566, 5056, "Russia", 38004);
		day3.insert(4, 123000, 42340, 3240, "Italy", 23598);
		day3.insert(5, 94003, 24846, 5013, "UK", 3684);
		day3.insert(6, 2004, 20, 5, "Iran", 4509);
		day3.insert(7, 500, 10, 2, "France", 56412);
		day3.insert(8, 580, 18, 6, "Spain", 5446);
		day3.insert(9, 1080, 158, 86, "China", 9654);
		day3.insert(10, 580, 18, 6, "USA", 7541);

		AVLTree day4 = new AVLTree();
		// insert(country #, total infected, deaths, discharged, country in strings)
		day4.insert(0, 2452, 65, 80, "TEST", 1500);
		day4.insert(1, 107000, 2500, 3000, "Turkey", 26480);
		day4.insert(2, 6665, 28, 22, "Germany", 4500);
		day4.insert(3, 204000, 30566, 5056, "Russia", 38004);
		day4.insert(4, 123000, 42340, 3240, "Italy", 23598);
		day4.insert(5, 94003, 24846, 5013, "UK", 3684);
		day4.insert(6, 2004, 20, 5, "Iran", 4509);
		day4.insert(7, 500, 10, 2, "France", 56412);
		day4.insert(8, 580, 18, 6, "Spain", 5446);
		day4.insert(9, 1080, 158, 86, "China", 9654);
		day4.insert(10, 580, 18, 6, "USA", 7541);

		AVLTree day5 = new AVLTree();
		// insert(country #, total infected, deaths, discharged, country in strings)
		day5.insert(0, 2452, 65, 80, "TEST", 1500);
		day5.insert(1, 107000, 2500, 3000, "Turkey", 26480);
		day5.insert(2, 6665, 28, 22, "Germany", 4500);
		day5.insert(3, 204000, 30566, 5056, "Russia", 38004);
		day5.insert(4, 123000, 42340, 3240, "Italy", 23598);
		day5.insert(5, 94003, 24846, 5013, "UK", 3684);
		day5.insert(6, 2004, 20, 5, "Iran", 4509);
		day5.insert(7, 500, 10, 2, "France", 56412);
		day5.insert(8, 580, 18, 6, "Spain", 5446);
		day5.insert(9, 1080, 158, 86, "China", 9654);
		day5.insert(10, 580, 18, 6, "USA", 7541);

		AVLTree day6 = new AVLTree();
		// insert(country #, total infected, deaths, discharged, country in strings)
		day6.insert(0, 2452, 65, 80, "TEST", 1500);
		day6.insert(1, 107000, 2500, 3000, "Turkey", 26480);
		day6.insert(2, 6665, 28, 22, "Germany", 4500);
		day6.insert(3, 204000, 30566, 5056, "Russia", 38004);
		day6.insert(4, 123000, 42340, 3240, "Italy", 23598);
		day6.insert(5, 94003, 24846, 5013, "UK", 3684);
		day6.insert(6, 2004, 20, 5, "Iran", 4509);
		day6.insert(7, 500, 10, 2, "France", 56412);
		day6.insert(8, 580, 18, 6, "Spain", 5446);
		day6.insert(9, 1080, 158, 86, "China", 9654);
		day6.insert(10, 580, 18, 6, "USA", 7541);

		AVLTree day7 = new AVLTree();
		// insert(country #, total infected, deaths, discharged, country in strings)
		day7.insert(0, 2452, 65, 80, "TEST", 1500);
		day7.insert(1, 107000, 2500, 3000, "Turkey", 26480);
		day7.insert(2, 6665, 28, 22, "Germany", 4500);
		day7.insert(3, 204000, 30566, 5056, "Russia", 38004);
		day7.insert(4, 123000, 42340, 3240, "Italy", 23598);
		day7.insert(5, 94003, 24846, 5013, "UK", 3684);
		day7.insert(6, 2004, 20, 5, "Iran", 4509);
		day7.insert(7, 500, 10, 2, "France", 56412);
		day7.insert(8, 580, 18, 6, "Spain", 5446);
		day7.insert(9, 1080, 158, 86, "China", 9654);
		day7.insert(10, 580, 18, 6, "USA", 7541);

		AVLTree day8 = new AVLTree();
		// insert(country #, total infected, deaths, discharged, country in strings)
		day8.insert(0, 2452, 65, 80, "TEST", 1500);
		day8.insert(1, 107000, 2500, 3000, "Turkey", 26480);
		day8.insert(2, 6665, 28, 22, "Germany", 4500);
		day8.insert(3, 204000, 30566, 5056, "Russia", 38004);
		day8.insert(4, 123000, 42340, 3240, "Italy", 23598);
		day8.insert(5, 94003, 24846, 5013, "UK", 3684);
		day8.insert(6, 2004, 20, 5, "Iran", 4509);
		day8.insert(7, 500, 10, 2, "France", 56412);
		day8.insert(8, 580, 18, 6, "Spain", 5446);
		day8.insert(9, 1080, 158, 86, "China", 9654);
		day8.insert(10, 580, 18, 6, "USA", 7541);

		AVLTree day9 = new AVLTree();
		// insert(country #, total infected, deaths, discharged, country in strings)
		day9.insert(0, 2452, 65, 80, "TEST", 1500);
		day9.insert(1, 107000, 2500, 3000, "Turkey", 26480);
		day9.insert(2, 6665, 28, 22, "Germany", 4500);
		day9.insert(3, 204000, 30566, 5056, "Russia", 38004);
		day9.insert(4, 123000, 42340, 3240, "Italy", 23598);
		day9.insert(5, 94003, 24846, 5013, "UK", 3684);
		day9.insert(6, 2004, 20, 5, "Iran", 4509);
		day9.insert(7, 500, 10, 2, "France", 56412);
		day9.insert(8, 580, 18, 6, "Spain", 5446);
		day9.insert(9, 1080, 158, 86, "China", 9654);
		day9.insert(10, 580, 18, 6, "USA", 7541);

		AVLTree day10 = new AVLTree();
		// insert(country #, total infected, deaths, discharged, country in strings)
		day10.insert(0, 2452, 65, 80, "TEST", 1500);
		day10.insert(1, 107000, 2500, 3000, "Turkey", 26480);
		day10.insert(2, 6665, 28, 22, "Germany", 4500);
		day10.insert(3, 204000, 30566, 5056, "Russia", 38004);
		day10.insert(4, 123000, 42340, 3240, "Italy", 23598);
		day10.insert(5, 94003, 24846, 5013, "UK", 3684);
		day10.insert(6, 2004, 20, 5, "Iran", 4509);
		day10.insert(7, 500, 10, 2, "France", 56412);
		day10.insert(8, 580, 18, 6, "Spain", 5446);
		day10.insert(9, 1080, 158, 86, "China", 9654);
		day10.insert(10, 580, 18, 6, "USA", 7541);
                
                
                
		LinkedList t = new LinkedList();
                
		t.addToStart(1, day1, 0);
		t.addToStart(2, day2, 0);
		t.addToStart(3, day3, 0);
		t.addToStart(4, day4, 0);
		t.addToStart(5, day5, 0);
		t.addToStart(6, day6, 0);
		t.addToStart(7, day7, 0);
		t.addToStart(8, day8, 0);
		t.addToStart(9, day9, 0);
		t.addToStart(10, day10, 0);
                
                
               
                
	
        
         int insertDay = insertDay1;
        
          int countryCodee = countryCodee1;     
        
               t.conv(insertDay, countryCodee);
              
	       t.convPersonnel(insertDay, countryCodee);
        
                
             
             //Show message dialog
               
               JOptionPane.showMessageDialog(this, t.conv(insertDay, countryCodee) + 
                       "\n" + t.convPersonnel(insertDay, countryCodee));
              
		
        
        
    }//GEN-LAST:event_btn_showActionPerformed

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
            java.util.logging.Logger.getLogger(Login_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Screen().setVisible(true);
            }
        });
        
       
        
        
        

        
	       

        
		
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EASY_title_text;
    private javax.swing.JButton btn_show;
    private javax.swing.JLabel chine;
    private javax.swing.JTextField country_number;
    private javax.swing.JTextField day_number;
    private javax.swing.JLabel france;
    private javax.swing.JLabel germany;
    private javax.swing.JLabel iran;
    private javax.swing.JLabel italy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jbl_usa_text;
    private javax.swing.JLabel jlabel_russia_text;
    private javax.swing.JLabel jlbl_chine_text;
    private javax.swing.JLabel jlbl_france_text;
    private javax.swing.JLabel jlbl_germany_text;
    private javax.swing.JLabel jlbl_iran_text;
    private javax.swing.JLabel jlbl_italy_text;
    private javax.swing.JLabel jlbl_spain_text;
    private javax.swing.JLabel jlbl_turkey_text;
    private javax.swing.JLabel jlbl_uk_text;
    private javax.swing.JLabel lbl_enter_country;
    private javax.swing.JLabel lbl_enter_day;
    private javax.swing.JLabel lbl_stayathome;
    private javax.swing.JLabel russia;
    private javax.swing.JLabel spain;
    private javax.swing.JLabel turkey;
    private javax.swing.JLabel uk;
    private javax.swing.JLabel usa;
    private javax.swing.JLabel who_logo;
    // End of variables declaration//GEN-END:variables
}
