package GameEntity.Item;

import GameEntity.GameObject;
import Utils.Transform;

public abstract class BaseItem extends GameObject {

   public BaseItem(double posX, double posY){

       super(new Transform(posX, posY), 30+Math.random());
      this.transform.setRot(90); //downwards direction

       this.destroyed = false;

   }

   public abstract void onPickup();




}
