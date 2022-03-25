package main;

import entity.*;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
      
      //Screen Settings
      final int originalTileSize = 16;
      final int scale = 3;
      int FPS = 30;     

      public final int tileSize = originalTileSize*scale; //48x48 tile
      final int maxScreenCol = 16;
      final int maxScreenRow = 12;
      final int screenWidth = tileSize * maxScreenCol;
      final int screenHeight = tileSize * maxScreenRow;

      KeyHandler keyH = new KeyHandler();
      Thread gameThread;
      Enemy ghost = new Enemy(this,keyH);

      //spawn point
      int playerX = 100;
      int playerY = 100;
      int playerSpeed = 1;

      public GamePanel() {

            this.setPreferredSize(new Dimension(screenWidth,screenHeight));
            this.setBackground(Color.BLACK);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyH);
            this.setFocusable(true);
      }

      public void startGameThread() {
            gameThread = new Thread(this);
            gameThread.start();
      }

      @Override
      public void run() {
            //When thread starts this method will be called automatically
            double drawInterval = 100000000/FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            //Game loop goes here
            while(gameThread != null) {
                  //Update and Draw (according to updated info)
                  currentTime = System.nanoTime();

                  delta += (currentTime - lastTime)/drawInterval;

                  lastTime = currentTime;

                  if(delta>1)
                  {
                        update();
                        repaint();
                        delta--;
                  }
            }
      }

      public void update() {
            ghost.update();
      }
      public void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;

            ghost.draw(g2);

            g2.dispose();

      }    
}
