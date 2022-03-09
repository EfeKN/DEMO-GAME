package main;

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

      final int tileSize = originalTileSize*scale; //48x48 tile
      final int maxScreenCol = 16;
      final int maxScreenRow = 12;
      final int screenWidth = tileSize * maxScreenCol;
      final int screenHeight = tileSize * maxScreenRow;

      KeyHandler keyH = new KeyHandler();
      Thread gameThread;

      //spawn point
      int playerX = 100;
      int playerY = 100;
      int playerSpeed = 4;

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
            if(keyH.upPressed&&keyH.leftPressed)
            {
                  playerY -= playerSpeed;
                  playerX -= playerSpeed;
            }
            else if(keyH.upPressed&&keyH.rightPressed)
            {
                  playerY -= playerSpeed;
                  playerX += playerSpeed;
            }
            else if(keyH.downPressed&&keyH.leftPressed)
            {
                  playerY += playerSpeed;
                  playerX -= playerSpeed;
            }
            else if(keyH.downPressed&&keyH.rightPressed)
            {
                  playerY += playerSpeed;
                  playerX += playerSpeed;
            }
            else if(keyH.upPressed) {
                  playerY -= playerSpeed;
            }
            else if(keyH.downPressed) {
                  playerY += playerSpeed;
            }
            else if(keyH.leftPressed) {
                  playerX -= playerSpeed;
            }
            else if(keyH.rightPressed) {
                  playerX += playerSpeed;
            }
      }
      public void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;

            g2.setColor(Color.white);

            g2.fillRect(playerX, playerY, tileSize, tileSize);

            g2.dispose();

      }    
}
