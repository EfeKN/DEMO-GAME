package entity;

import java.awt.Graphics2D;
//import java.io.File;
//import java.io.IOException;
import java.awt.image.BufferedImage;
//import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Enemy extends Entity{
      
      GamePanel gp;
      KeyHandler keyH;
      public Enemy(GamePanel gp, KeyHandler keyH) {
            this.gp = gp;
            this.keyH = keyH;
            setDefaultValues();
            BufferedImage img1 = spriteSheet.grabImage(1,1,16,16);
            BufferedImage img2 = spriteSheet.grabImage(2,1,16,16);
            BufferedImage img3 = spriteSheet.grabImage(3,1,16,16); 
            
            images.add(img1);
            images.add(img2);
            images.add(img3);

            //getPlayerImage();
      }
      public void setDefaultValues() {
            x = 200;
            y = 200;
            speed = 10;
            imageNumber = 1;
      }
      /** 
      public void getPlayerImage() {
            try {
                  right1 = ImageIO.read(new File("res/enemy/ghost1.png"));
                  right2 = ImageIO.read(new File("res/enemy/ghost2.png"));
            }catch(IOException e) {
                  e.printStackTrace();
            }
      }
      */
      public void update() {

            if(keyH.upPressed&&keyH.leftPressed)
            {
                  y -= speed;
                  x -= speed;
            }
            else if(keyH.upPressed&&keyH.rightPressed)
            {
                  y -= speed;
                  x += speed;
            }
            else if(keyH.downPressed&&keyH.leftPressed)
            {
                  y += speed;
                  x -= speed;
            }
            else if(keyH.downPressed&&keyH.rightPressed)
            {
                  y += speed;
                  x += speed;
            }
            else if(keyH.upPressed&&y>=4) {
                  y -= speed;
            }
            else if(keyH.downPressed) {
                  y += speed;
            }
            else if(keyH.leftPressed) {
                  x -= speed;
            }
            else if(keyH.rightPressed) {
                  x += speed;
            }
      }
      public void draw(Graphics2D g2) {
            BufferedImage image = null;
            switch(imageNumber) {
            case 1:
                  image = images.get(0);
                  imageNumber = 2;
                  break;
            case 2:
                  image = images.get(1);
                  imageNumber = 3;
                  break;
            case 3:
                  image = images.get(2);
                  imageNumber = 1;
                  break;      
            }
            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
      }
}
