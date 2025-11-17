// Part B

/**
 * A GUI class to run the Virtual Pet Lab
 * Requires javax.swing and java.awt
 * @author Kim Hermans
 * Image Credit: J.P. O'Hara & Jamie O'Hara
 * @November 2024
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//public class VirtualPetGUIRunnerB extends JFrame
//{
//    // Edit this value to change speed of update
//    private final int INTERVAL_IN_SECONDS = 10;
//
//    private String info;
//    private int timerSeconds, animationTimerSeconds;
//    private boolean isEating, isPlaying;
//    private VirtualPetB pet4;
//    private Food apple, cupcake, broccoli, potato;
//    private Game coinToss, hoopJumping, simonSays;
//    private ImageIcon imageHappy, imageSad, imageEat, imagePlay;
//    private JFrame frame;
//    private JPanel petPanel, menuPanel, mainPanel, statsPanel, timerPanel;
//    private JLabel petLabel,statsLabel, messageLabel, timerLabel;
//    private JButton foodButton, playButton;
//    private JRadioButton appleButton, cupcakeButton, broccoliButton, potatoButton, coinButton, hoopButton, simonButton;
//    private ButtonGroup foodGroup, gameGroup;
//    private JMenu newPetMenu;
//    private JMenuItem petRunner3, petRunner4;
//    private JMenuBar menuBar;
//
//    public VirtualPetGUIRunnerB(String name) throws IOException
//    {
//        // Initializes VirtualPet, Food, and Game objects
//        initVirtualPetObjects(name);
//        animationTimerSeconds = -1;
//
//        // Automatically calls update after INTERVAL_IN_SECONDS time
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        scheduler.scheduleAtFixedRate(() -> { pet4.updateStatus(); }, 10, INTERVAL_IN_SECONDS, TimeUnit.SECONDS);
//
//        // Calls helper methods to initialize components of GUI
//        initTimerPanel();
//        initPetDisplayPanel();
//        initStatsPanel();
//        initFoodButtons();
//        initGameButtons();
//        initMenuPanel();
//        fillLayout();
//        initMenuBar();
//
//        // Initializes the frame
//        frame = new JFrame();
//        frame.setPreferredSize(new Dimension(400, 500));
//        frame.setTitle("Virtual Pet");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Adds all components to the frame and makes visible
//        frame.add(mainPanel);
//        frame.setJMenuBar(menuBar);
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    // Initializes VirtualPet, Food, and Game objects
//    public void initVirtualPetObjects(String name)
//    {
//        pet4 = new VirtualPetB(name);
//        apple = new Food("Apple", 2, 1, 1);
//        cupcake = new Food("Cupcake", 1, 2, 2);
//        broccoli = new Food("Broccoli", 3, -1, 1);
//        potato = new Food("Potato", 2, 0, 2);
//        coinToss = new Game("Coin Toss", 1, 0);
//        hoopJumping = new Game("Hoop Jumping", 2, 2);
//        simonSays = new Game("Simon Says", 1, 2);
//        isEating = false;
//        isPlaying = false;
//    }
//
//    // Initializes the timer that is displayed
//    public void initTimerPanel()
//    {
//        timerSeconds = 0;
//        timerLabel = new JLabel("00:00");
//        Timer timer = new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                timerSeconds++;
//                int minutes = timerSeconds / 60;
//                int remainingSeconds = timerSeconds % 60;
//                timerLabel.setText(String.format("%02d:%02d", minutes, remainingSeconds));
//                info = "<html>" + pet4.toString().replaceAll("\n", "<br>") + "</html>";
//                statsLabel.setText(info);
//                if(!isPlaying && !isEating)
//                {
//                    if((ImageIcon)petLabel.getIcon() != imageSad && (pet4.getEnergyLevel() < 5 || pet4.getHappinessLevel() < 5))
//                        petLabel.setIcon(imageSad);
//                    else if((ImageIcon)petLabel.getIcon() != imageHappy && (pet4.getEnergyLevel() >= 5 && pet4.getHappinessLevel() >= 5))
//                        petLabel.setIcon(imageHappy);
//                }
//            }
//        });
//        timer.start();
//        timerPanel = new JPanel();
//        timerPanel.add(timerLabel);
//        timerPanel.setLayout(new GridBagLayout());
//    }
//
//    // Initializes the panel that displays the VirtualPet
//    public void initPetDisplayPanel()
//    {
//        imageHappy = new ImageIcon(getClass().getResource("petHappy.gif"));
//        imageSad = new ImageIcon(getClass().getResource("petSad.gif"));
//        imageEat = new ImageIcon(getClass().getResource("petEat.gif"));
//        imagePlay = new ImageIcon(getClass().getResource("petPlay.gif"));
//
//        petLabel = new JLabel(imageHappy);
//        petPanel = new JPanel(new BorderLayout());
//        petPanel.add(petLabel);
//    }
//
//    // Initializes the panel that contains the information text
//    public void initStatsPanel()
//    {
//        info = "<html>" + pet4.toString().replaceAll("\n", "<br>") + "</html>";
//        statsLabel = new JLabel(info);
//        statsLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 0));
//
//        messageLabel = new JLabel("Happy Birthday, " + pet4.getName() + "!");
//        messageLabel.setForeground(Color.blue);
//        messageLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 0));
//
//        statsPanel = new JPanel(new GridLayout(2,1));
//        statsPanel.add(messageLabel);
//        statsPanel.add(statsLabel);
//    }
//
//    // Initializes the Food and food option buttons
//    public void initFoodButtons()
//    {
//        foodButton = new JButton("Feed");
//        foodButton.addActionListener(new FoodButtonListener());
//        foodButton.setPreferredSize(new Dimension(80, 30));
//        foodButton.setMaximumSize(new Dimension(80, 30));
//
//        appleButton = new JRadioButton("Apple");
//        cupcakeButton = new JRadioButton("Cupcake");
//        broccoliButton = new JRadioButton("Broccoli");
//        potatoButton = new JRadioButton("Potato");
//
//        foodGroup = new ButtonGroup();
//        foodGroup.add(appleButton);
//        foodGroup.add(cupcakeButton);
//        foodGroup.add(broccoliButton);
//        foodGroup.add(potatoButton);
//        appleButton.setSelected(true);
//    }
//
//    // Initializes the Game and game option buttons
//    public void initGameButtons()
//    {
//        playButton = new JButton("Play");
//        playButton.addActionListener(new PlayButtonListener());
//        playButton.setPreferredSize(new Dimension(80, 30));
//        playButton.setMaximumSize(new Dimension(80, 30));
//        coinButton = new JRadioButton("Coin Toss");
//        hoopButton = new JRadioButton("Hoop Jump");
//        simonButton = new JRadioButton("Simon Says");
//        gameGroup = new ButtonGroup();
//        gameGroup.add(coinButton);
//        gameGroup.add(hoopButton);
//        gameGroup.add(simonButton);
//        coinButton.setSelected(true);
//    }
//
//    // Initializes the menu panel that contains all buttons
//    public void initMenuPanel()
//    {
//        GridBagConstraints c = new GridBagConstraints();
//        menuPanel = new JPanel();
//        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
//        menuPanel.add(Box.createVerticalStrut(10));
//        menuPanel.add(foodButton, c);
//        menuPanel.add(appleButton, c);
//        menuPanel.add(cupcakeButton, c);
//        menuPanel.add(broccoliButton, c);
//        menuPanel.add(potatoButton, c);
//        menuPanel.add(Box.createVerticalStrut(10));
//        menuPanel.add(playButton, c);
//        menuPanel.add(coinButton, c);
//        menuPanel.add(hoopButton, c);
//        menuPanel.add(simonButton, c);
//        menuPanel.add(Box.createVerticalStrut(10));
//    }
//
//    // Initializes the Menu Bar that allows you to create a new Virtual Pet
//    public void initMenuBar()
//    {
//        petRunner3 = new JMenuItem("Activity 3");
//        petRunner3.addActionListener(new NewPet3Listener());
//        petRunner4 = new JMenuItem("Activity 4");
//        petRunner4.addActionListener(new NewPet4Listener());
//        newPetMenu = new JMenu("New Pet");
//        newPetMenu.add(petRunner3);
//        newPetMenu.add(petRunner4);
//        menuBar = new JMenuBar();
//        menuBar.add(newPetMenu);
//    }
//
//    // Organizes the layout for the main panel
//    public void fillLayout()
//    {
//        mainPanel = new JPanel();
//        mainPanel.setLayout(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//        c.fill = GridBagConstraints.BOTH;
//        c.weightx = 60;
//        c.weighty = 50;
//        c.gridx = 0;
//        c.gridy = 0;
//        mainPanel.add(petPanel, c);
//        c.weightx = 40;
//        c.gridx = 1;
//        mainPanel.add(menuPanel, c);
//        c.weightx = 60;
//        c.gridx = 0;
//        c.gridy = 1;
//        mainPanel.add(statsPanel, c);
//        c.weightx = 40;
//        c.gridx = 1;
//        mainPanel.add(timerPanel, c);
//    }
//
//    // Defines the action when the Feed button is clicked
//    class FoodButtonListener implements ActionListener
//    {
//        public void actionPerformed(ActionEvent e)
//        {
//            Food f = apple;
//            if(cupcakeButton.isSelected())
//                f = cupcake;
//            else if(broccoliButton.isSelected())
//                f = broccoli;
//            else if(potatoButton.isSelected())
//                f = potato;
//            pet4.feed(f);
//            messageLabel.setText("You have fed " + pet4.getName() + " 1 " + f.getName());
//            info = "<html>" + pet4.toString().replaceAll("\n", "<br>") + "</html>";
//            statsLabel.setText(info);
//            animationTimerSeconds = 0;
//            isEating = true;
//            petLabel.setIcon(imageEat);
//            // Timer to show eating image for 2 seconds
//            Timer animationTimer = new Timer(1000, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    animationTimerSeconds++;
//                    if(animationTimerSeconds >= 2)
//                    {
//                        if(pet4.getEnergyLevel() < 5 || pet4.getHappinessLevel() < 5)
//                            petLabel.setIcon(imageSad);
//                        else
//                            petLabel.setIcon(imageHappy);
//                        isEating = false;
//                        ((Timer) e.getSource()).stop();
//                    }
//                }
//            });
//            animationTimer.start();
//            animationTimerSeconds = -1;
//        }
//    }
//
//    // Defines the action when the Play button is clicked
//    class PlayButtonListener implements ActionListener
//    {
//        public void actionPerformed(ActionEvent e)
//        {
//            Game g = coinToss;
//            if(hoopButton.isSelected())
//                g = hoopJumping;
//            else if(simonButton.isSelected())
//                g = simonSays;
//            if(pet4.play(g))
//                messageLabel.setText("<html>You have played " + g.getName()+ " with<br>" + pet4.getName() + ", and won!</html>");
//            else
//                messageLabel.setText("<html>You have played " + g.getName()+ " with<br>" + pet4.getName() + ", and lost!</html>");
//            info = "<html>" + pet4.toString().replaceAll("\n", "<br>") + "</html>";
//            statsLabel.setText(info);
//            animationTimerSeconds = 0;
//            isPlaying = true;
//            petLabel.setIcon(imagePlay);
//            // Timer to show playing image for 2 seconds
//            Timer animationTimer = new Timer(1000, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    animationTimerSeconds++;
//                    if(animationTimerSeconds >= 2)
//                    {
//                        if(pet4.getEnergyLevel() < 5 || pet4.getHappinessLevel() < 5)
//                            petLabel.setIcon(imageSad);
//                        else
//                            petLabel.setIcon(imageHappy);
//                        isPlaying = false;
//                        ((Timer) e.getSource()).stop();
//                    }
//                }
//            });
//            animationTimer.start();
//        }
//    }
//
//    // Defines the action when a New Pet from Activity 3 is clicked
//    class NewPet3Listener implements ActionListener
//    {
//        public void actionPerformed(ActionEvent e)
//        {
//            try
//            {
//                String input = JOptionPane.showInputDialog("Enter your virtual pet's name:");
//                VirtualPetGUIRunnerB init = new VirtualPetGUIRunnerB(input);
//                frame.dispose();
//            }
//            catch(Exception err)
//            {
//                System.out.println(err);
//            }
//        }
//    }
//
//    // Defines the action when a New Pet from Activity 4 is clicked
//    class NewPet4Listener implements ActionListener
//    {
//        public void actionPerformed(ActionEvent e)
//        {
//            try
//            {
//                String input = JOptionPane.showInputDialog("Enter your virtual pet's name:");
//                VirtualPetGUIRunnerB init = new VirtualPetGUIRunnerB(input);
//                frame.dispose();
//            }
//            catch(Exception err)
//            {
//                System.out.println(err);
//            }
//        }
//    }
//
//    public static void main(String [] args) throws IOException
//    {
//        String input = JOptionPane.showInputDialog("Enter your virtual pet's name:");
//        VirtualPetGUIRunnerB init = new VirtualPetGUIRunnerB(input);
//    }
//}
