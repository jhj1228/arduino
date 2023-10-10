int relay = 7
void setup() {
Serial.begin(9600);
pinMode(relay, OUTPUT);
}
 
void loop() {
 
if (Serial.available() > 0) {
    
String m = Serial.readStringUntil('\n');
if (m == "on") {
digitalWrite(relay, HIGH);
} else if (m == "off") {
digitalWrite(relay, LOW);
         }
     }
}
