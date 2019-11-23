#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

enum meses_do_ano{
janeiro=1, fevereiro, marco, abril, maio, junho, julho, agosto, setembro, outubro, novembro, dezembro
}meses;

int main(){
	printf("Digite o numero do mês: \n >>");
	scanf("%d",&meses);
	if(meses>=janeiro && meses<=dezembro){
		printf("MES VALIDO!");
	}else{
		printf("MES INVALIDO!");
	}
}
