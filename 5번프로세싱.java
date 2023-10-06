void setup() {
  pinMode(ledPin, OUTPUT);
  pinMode(piezoPin, OUTPUT);
  
  Serial.begin(9600);
  
  tone(4, 523, 500);
  delay(500 * 1.3);
  tone(4, 587, 500);
  delay(500 * 1.3);
  tone(4, 659, 500);
  delay(500 * 1.3);
  tone(4, 698, 500);
  delay(500 * 1.3);
  tone(4, 783, 500);
  delay(500 * 1.3);
  tone(4, 880, 500);
  delay(500 * 1.3);
  tone(4, 987, 500);
  delay(500 * 1.3);
}

void loop() {
  if (Serial.available()) {
    String command = Serial.readString();
    command.trim();

    if (command == "on") digitalWrite(ledPin, HIGH);
    if (command == "off") digitalWrite(ledPin, LOW);
    if (command.toInt() >= 1 && command.toInt() <=8) { 
      playTone(command.toInt());
    }
  }
}
