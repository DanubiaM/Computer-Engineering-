#include <stdio.h>
#include <string.h>
int main(){
	union{
		int i;
		float f;
		char str[20];
	}dado;
	dado.i=10;
	printf("Seu inteiro: %d \n",dado.i);
	printf("TESTE FLOAT %.2f\n",dado.f);
	dado.f=34.5;
	printf("Seu rel: %.2f\n",dado.f);
	strcpy(dado.str,"Sou string");
	printf("%s",dado.str);
	return 0;
}
