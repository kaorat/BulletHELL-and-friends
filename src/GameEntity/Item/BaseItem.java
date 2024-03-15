package GameEntity.Item;

import GameEntity.GameObject;
import Utils.Transform;
import javafx.scene.canvas.GraphicsContext;

public abstract class BaseItem extends GameObject {

   public BaseItem(double posX, double posY){

       super(new Transform(posX, posY), 1);

       this.destroyed = false;

       this.visible = false;
   }

   public void spawn(){ // same for all items?
      this.visible = true;
      this.transform.setRot(10); //fall down - change later
   };

   public void isOutOfBounds(){
      if(this.posY > 760){ // lower than the screen
         this.destroyed = true;
      }
   }

   public abstract void onPickup();




}
