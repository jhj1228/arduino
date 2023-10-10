import processing.serial.*;
import processing.net.*;
Serial p;
Server s;
Client c;
void setup(){
  p = new Serial(this, "COM3", 9600);
  s = new Server(this, 12345);
}
String m="";
void draw(){
  if(p.available()>0){
    m = p.readStringUntil('\n');
    if(m!=null){
      print(m);
    }
  }
  c = s.available();
  if(c!=null){
    String w = c.readString();
    println(w);
    if (w.indexOf("GET")==0) {
      c.write("HTTP/1.1 200 OK\r\n\r\n\r\n");
      c.write(m);
    }
    c.stop();
  }
}
