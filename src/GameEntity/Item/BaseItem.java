package GameEntity.Item;

import GameEntity.GameObject;
import javafx.scene.canvas.GraphicsContext;

public abstract class BaseItem extends GameObject {

   public BaseItem(double posX, double posY){
        this.posX = posX;
        this.posY = posY;
        this.tslX = 0d;
        this.tslY = 0d;
        this.sclX = 1d;
        this.sclY = 1d;
        this.rotX = 0d;
        this.rotY = 0d;

        this.z = 1;// fix this

        this.destroyed = false;
        this.visible = false;
   }

   public void spawn(){ // same for all items?
      this.visible = true;
      this.tslY = 10d; //fall down
   };

   public void isOutOfBounds(){
      if(this.posY > 760){ // lower than the screen
         this.destroyed = true;
      }
   }

   public abstract void onPickup();




}
