#include <stdio.h>
#include <string.h>
	typedef union{
		int units;
		float kgs;
		
	}amount;
	typedef struct{
		char selling [15];
		float unitprice;
		int unittype;
		amount howmuch;
	}product;
	
int main(){
	product dieselmotorbike;
	product apples;
	product *myebaystore[2];
	strcpy(dieselmotorbike.selling,"A disel moto cycle\n");
	dieselmotorbike.unitprice=5488.0;
	dieselmotorbike.unittype=1;
	dieselmotorbike.howmuch.units=4;
	strcpy(apples.selling,"Granny\n");
	apples.unitprice=0.72;
	apples.unittype=2;
	apples.howmuch.kgs=0.5;
	myebaystore[0]=&dieselmotorbike;
	myebaystore[1]=&apples;
	int nitems=2, i;
	for(i=0;i<nitems;i++){
		printf("\n%s\n",myebaystore[i]->selling);
		switch(myebaystore[i]->unittype){
			case 1:
				printf("Nos temos %d unidades para venda \n",myebaystore[i]->howmuch.units);
				break;
			case 2:
				printf("Nós temos %.2f Kg para venda \n",myebaystore[i]->howmuch.kgs);
				break;
		}
	}
}

