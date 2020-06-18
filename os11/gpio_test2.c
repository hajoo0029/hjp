#include <stdio.h>
#include <stdlib.h>
#include <wiringPi.h>

#define LED_R 3
#define LED_G 21
#define LED_Y 22
#define SW_R 6
#define SW_Y 6
#define SW_G 4
#define SW_W 27


int main(void){
	if(wiringPiSetup()==-1){
		puts("Error");
		exit(1);
	}
	pinMode(SW_R,INPUT);
	pinMode(SW_G,INPUT);
	pinMode(SW_Y,INPUT);
	pinMode(SW_W,INPUT);
	pinMode(LED_Y,OUTPUT);
	pinMode(LED_G,OUTPUT);
	pinMode(LED_R,OUTPUT);
	digitalWrite(LED_R,0);
	digitalWrite(LED_Y,0);
	digitalWrite(LED_G,0);
	
	while(1){
		if(digitalRead(SW_R)==0){
			digitalWrite(LED_R,1);
	}
		else if(digitalRead(SW_Y)==0){
			digitalWrite(LED_Y,1);
		}
		else if(digitalRead(SW_G)==0){
			digitalWrite(LED_Y,1);
		}
		else if(digitalRead(SW_W)==0){
			int i=0;
			while(i<3){
				digitalWrite(LED_R,1);
				delay(250);
				digitalWrite(LED_R,0);
				digitalWrite(LED_Y,1);
				delay(250);
				digitalWrite(LED_Y,0);
				digitalWrite(LED_G,1);
				delay(250);
				digitalWrite(LED_G,0);
				i++;
				}
			}
			digitalWrite(LED_R,0);
			digitalWrite(LED_G,0);
			digitalWrite(LED_Y,0);
		}
	return 0;
}
