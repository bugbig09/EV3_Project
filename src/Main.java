import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.Brick;

 public class Main {

 public static void main (String args[]){
 //Löschen vorheriger Anzeigen auf dem LCD
 LCD.clear();
 //Ausgeben des Strings auf de, LCD in Spalte 0 und Zeile 5
 LCD.drawString("Hallo", 0, 5);
 //Warten, bis irgendeine Taste gedrückt wird
 Button.waitForAnyPress();
 //Löschen und Aktualisieren der Anzeige,
 //nachdem eine Taste gedrückt wurde
 LCD.clear();
 LCD.refresh();
 }

 }