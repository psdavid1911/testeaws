package macro;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MacroSalva{
    Robot robo;

    MacroSalva(){
        try{
            robo = new Robot();
        }catch(AWTException ex){
            System.out.println("Nao pude criar o robo");
        }
        for(int i = 0; i<=1000; i++){
            robo.mouseMove(640, 250);
            robo.delay(1000);
            robo.mouseMove(640, 512);
            robo.delay(1000);
            robo.mousePress(InputEvent.BUTTON1_MASK);
            robo.delay(500);
            robo.mouseRelease(InputEvent.BUTTON1_MASK);
            robo.mouseMove(1280, 512);
            robo.delay(1000);
            robo.mousePress(InputEvent.BUTTON1_MASK);
            robo.delay(500);
            robo.mouseRelease(InputEvent.BUTTON1_MASK);
            robo.delay(2000);
        }
        // tela
        // 1366 x 768
        // metade
        // 683  x 384
        // 1280 x 1024 >> 640 x 512
    }
}
