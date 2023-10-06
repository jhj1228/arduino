import processing.net.*;

Client c;

void setup() {
  size(200, 200);
  c = new Client(this, "COM3", 12345);
}

void draw() {
}

void keyPressed() {
  if (key == '1') c.write("1");
  if (key == '0') c.write("0");
}
