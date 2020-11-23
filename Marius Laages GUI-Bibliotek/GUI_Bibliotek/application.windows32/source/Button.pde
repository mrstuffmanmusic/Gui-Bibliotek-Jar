class Button  {
  float x;
  float y;
  float w; 
  float h;
  String tekst;
  
  Action a;
  
 Button(float x, float y, float w, float h, String tekst) {

    this.x = x;this.y = y; this.w = w; this.h = h; this.tekst = tekst;
  }

  void addAction(Action a){
   this.a = a; 
  }
  
  void click(){
   if(mouseX > x && mouseX < x + w && mouseY >y && mouseY < y + h){
     a.execute();
   }
    
  }
  
  
  void display(){
    fill(255);
   rect(x,y,w,h); 
   fill(0);
   text(tekst, x+0.5*w, y+0.5*h);
  }


}
