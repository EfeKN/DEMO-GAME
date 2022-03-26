package entity;
import main.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Entity {

      public int x,y;
      public int speed;
      public int imageNumber;
      public ArrayList<BufferedImage> images;
      public BufferedImage spriteSheetImage;
      public BufferedImageLoader bil;
      public SpriteSheet spriteSheet;

      public Entity() {
            bil = new BufferedImageLoader();
            try {
                  spriteSheetImage = bil.loadImage("res/enemy/spritesheet_demo2.png");
            } catch (IOException e) {
                  e.printStackTrace();
            }
            spriteSheet = new SpriteSheet(spriteSheetImage);
            images = new ArrayList<BufferedImage>();
      }

}
