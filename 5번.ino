void setup() {
  Serial.begin(9600);
  pinMode(7, OUTPUT);
}
void loop() {
  
  String values[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

  if (Serial.available() > 0) {
    
    String m = Serial.readStringUntil('\n');
        if (m == "on") {
      digitalWrite(7, HIGH);
    } else if (m == "off") {
      digitalWrite(7, LOW);
    } else {
      int frequency = 0;
      int value = m.toInt();
      switch (value) {
        case 1:
          frequency = 261; 
          break;
        case 2:
          frequency = 293; 
          break;
        case 3:
          frequency = 329; 
          break;
        case 4:
          frequency = 349; 
          break;
        case 5:
          frequency = 392; 
          break;
        case 6:
          frequency = 440; 
          break;
        case 7:
          frequency = 493; 
          break;
        case 8:
          frequency = 523; 
          break;
        default:
          break;
      }

      if (frequency > 0) {
        tone(4, frequency, 500); 
      }
    }
  }
}
