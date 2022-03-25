package entity;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Enemy extends Entity{
      
      GamePanel gp;
      KeyHandler keyH;

      public Enemy(GamePanel gp, KeyHandler keyH) {
            this.gp = gp;
            this.keyH = keyH;
            setDefaultValues();
            getPlayerImage();
      }
      public void setDefaultValues() {
            x = 200;
            y = 200;
            speed = 2;
            imageNumber = 1;
      }
      public void getPlayerImage() {
            try {
                  right1 = ImageIO.read(new File("res/enemy/ghost1.png"));
                  right2 = ImageIO.read(new File("res/enemy/ghost2.png"));
            }catch(IOException e) {
                  e.printStackTrace();
            }
      }

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
            else if(keyH.upPressed) {
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
                  image = right1;
                  imageNumber = 2;
                  break;
            case 2:
                  image = right2;
                  imageNumber = 1;
                  break;
            }
            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
      }
}
