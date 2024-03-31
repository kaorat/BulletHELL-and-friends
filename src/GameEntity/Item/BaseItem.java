package GameEntity.Item;

import GameEntity.GameObject;
import Utils.Transform;
import Utils.Utility;
import javafx.scene.canvas.GraphicsContext;

public abstract class BaseItem extends GameObject {

   public BaseItem(double posX, double posY){

       super(new Transform(posX, posY), 30+Math.random());
      this.transform.setRot(90); //downwards direction

       this.destroyed = false;

//       this.visible = false;
   }

//   public void spawn(){ // same for all items?
//      this.visible = true;
//
//   };

   public abstract void onPickup();




}
