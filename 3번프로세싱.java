void setup() {
  size(400, 400);
}

void draw() {
  background(backgroundColor);
  textSize(32);
  fill(0);
  text(key, 20, 80);
}

void keyPressed() {
  if (key == '1') backgroundColor = color(0, 255, 0);
  if (key == '2') backgroundColor = color(0, 0, 0);
}
