import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Gui_Bibliotek extends PApplet {

Button buttonTerning6 = new Button(30, 10, 180, 50, "Slå med 6s terning!");
Button buttonTerning10 = new Button(300, 10, 180, 50, "Slå med 10s terning!");

int sum;
int terningeKast;

public void setup() {
   

  buttonTerning6.addAction(new Action() {   
    public void execute() {
      terningeKast = PApplet.parseInt(random(1, 6));
      sum += terningeKast;
    }
  }
  );

  buttonTerning10.addAction(new Action() {   
    public void execute() {
      terningeKast = PApplet.parseInt(random(1, 10));
      sum += terningeKast;
    }
  }
  );
}

public void draw() {
  clear();
  buttonTerning6.display();
  buttonTerning10.display();
  fill(255);
  textAlign(CENTER);
  text("Du har kastet " + terningeKast, width/2, 200);
  text("Samlet sum    " + sum, width/2, 250);
}

public void mousePressed() {
  buttonTerning6.click();
  buttonTerning10.click();
}
interface Action{
public void execute();
}
class Button {
  float x; 
  float y; 
  float w;
  float h;
  String navn;
  Action a;

  Button(float x, float y, float w, float h, String navn) {

    this.x=x;
    this.y=y;
    this.w=w;
    this.h=h;
    this.navn=navn;
  }
  public void addAction(Action a) {
    this.a=a;
  }

  public void display() {

    fill(255, 255, 0);
    rect(200, 100, 100,50);
    fill(102, 51, 153);
    textSize(16);
    text("Joe Leow", 250, 130);

    fill(255, 40, 0);
    rect(x, y, w, h);

    fill(0, 255, 255);
    textSize(14);
    text("Slå terning med 6 sider", 120, 40);
    text("Slå terning med 10 sider", 390, 40);
  }

  public void click() {
    if ((mouseX>x)&&(mouseX<x+w)&&(mouseY>y)&&(mouseY<y+h)) {
      a.execute();
    }
  }
}
  public void settings() {  size(500, 300); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Gui_Bibliotek" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
