#include <stdio.h>
#include "pilha.h"
int main(void){
	Pilha *p;
	p=inicializa();
	push(p,10);
	push(p,20);
	push(p,30);
	printf("Valor retirado do topo %d!\n",pop(p));
	printf("Valor retirado do topo %d!\n",pop(p));
	push(p,40);
	push(p,50);
	printf("Valor do topo %d!\n",top(p));
	printf("Valor retirado do topo %d!\n",pop(p));
        libera(p);
        return 0;
}