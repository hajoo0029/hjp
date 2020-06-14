#include <stdio.h>
#include <stdlib.h>
#include <wiringPi.h>

#define LED_R 7
#define LED_Y 8
#define LED_G 9
#define SW_Y 3
#define SW_G 4
#define SW_W 5
#define SW_R 2

int main(void){
	printf("hellow pg");
	if(wiringPiSetup()==-1){
		puts("Error");
		exit(1);
	}
	pinMode(SW_R,INPUT);
	pinMode(SW_G,INPUT);
	pinMode(SW_Y,INPUT);
	pinMode(SW_W,INPUT);
	pinMode(LED_G,OUTPUT);
	pinMode(LED_Y,OUTPUT);
	pinMode(LED_R,OUTPUT);
	digitalWrite(LED_R,0);
	int ga[1];
	int gb[2];
	int gc[3];
	int gd[4];
	int ge[5];
	ga[0]=(rand()%3)+1;
	gb[0]=(rand()%3)+1;
	gb[1]=(rand()%3)+1;
	gc[0]=(rand()%3)+1;
	gc[1]=(rand()%3)+1;
	gc[2]=(rand()%3)+1;
	gd[0]=(rand()%3)+1;
	gd[1]=(rand()%3)+1;
	gd[2]=(rand()%3)+1;
	gd[3]=(rand()%3)+1;
	ge[0]=(rand()%3)+1;
	ge[1]=(rand()%3)+1;
	ge[2]=(rand()%3)+1;
	ge[3]=(rand()%3)+1;
	ge[4]=(rand()%3)+1;

	delay(500);
	int m=1;
	while(m){
		for(int i=0; i<3; i++){
		digitalWrite(LED_R,1);
		delay(200);
		digitalWrite(LED_R,0);
		digitalWrite(LED_Y,1);
		delay(200);
		digitalWrite(LED_Y,0);
		digitalWrite(LED_G,1);
		delay(200);
		digitalWrite(LED_G,0);
		}
		m=0;
	}
	if(ga[0]==1){
		digitalWrite(LED_R,1);
		delay(300);
	}else if(ga[0]==2){
		digitalWrite(LED_Y,1);
		delay(300);
	}else if(ga[0]==2){
		digitalWrite(LED_G,1);
	}
	while(1){
		if(digitalRead(SW_R)==0){
			digitalWrite(LED_R,1);
		}
		//digitalWrite
	}
	return 0;
}
