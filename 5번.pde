import processing.net.*;
import processing.serial.*;
Server s;
Client c;
Serial p;
void setup() {
  s = new Server(this, 12345);
  p = new Serial(this, "COM3", 9600);
}
String msg="hi";
void draw() {
  c = s.available();
  if (c!=null) {
    
    String m = c.readString();
    if (m.indexOf("GET /")==0) {
      c.write("HTTP/1.1 200 OK\r\n\r\n");
      c.write(msg);
    }
    if (m.indexOf("PUT /")==0) {
      int n = m.indexOf("\r\n\r\n")+4; 
      m = m.substring(n); 
      m += '\n';         
      p.write(m);
      print(m);
    }
  }
  if (p.available()>0) { 
    String m = p.readStringUntil('\n');
    if (m!=null)  msg = m;
    print(msg);
  }
}
