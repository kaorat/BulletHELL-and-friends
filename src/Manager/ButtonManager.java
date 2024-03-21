//package Manager;
//
//import GameEntity.UI.UIButton;
//import javafx.event.EventHandler;
//import javafx.scene.input.MouseEvent;
//
//public class ButtonManager {
//    private UIButton button; // Assume you have a reference to your UIButton
//
//    public ButtonManager(UIButton button) {
//        this.button = button;
//        // Add event handler for mouse click
//        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                // Handle button click event
//                if (button.isHovered()) {
//                    // Perform button action here
//                    System.out.println("Button clicked!");
//                }
//            }
//        });
//    }
//}
