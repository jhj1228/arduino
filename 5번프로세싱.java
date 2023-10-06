import processing.net.*;
import processing.serial.*;

Server s;
Client c;
Serial myPort; 

void setup()
{
  s = new Server(this, 12345);
  String portName = Serial.list()[0];
  myPort = new Serial(this, "COM3", 9600);
}

void draw()
{
  c = s.available();
  
  if (c != null)
  {
    String input = c.readString();
    input = input.substring(0,input.indexOf("\n"));
    myPort.write(input);
    println(input); 
  }
}
