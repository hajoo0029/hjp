#include <stdio.h>
#include <stdlib.h>
#include <wiringPi.h>

#define LED_R 3
#define LED_G 21
#define LED_Y 22
#define SW_R 6

int main(void){
	printf("hellow pg");
	if(wiringPiSetup()==-1){
		puts("Error");
		printf("error");
		exit(1);
	}
	pinMode(SW_R,INPUT);
	pinMode(LED_Y,OUTPUT);
	pinMode(LED_G,OUTPUT);
	pinMode(LED_R,OUTPUT);
	digitalWrite(LED_R,0);
	digitalWrite(LED_Y,0);
	digitalWrite(LED_G,0);
	printf("22");
	while(1){
		delay(500);

			digitalWrite(LED_R,1);
			digitalWrite(LED_G,1);
			digitalWrite(LED_Y,1);
		delay(500);
		digitalWrite(LED_R,0);
		digitalWrite(LED_Y,0);
		digitalWrite(LED_G,0);
		printf(" ----------------- ");
	}
	return 0;
}
