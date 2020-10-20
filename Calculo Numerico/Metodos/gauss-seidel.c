#include <stdio.h>
#include <stdlib.h>
//#include <Math.h>

int main(){
    int i,j,x;
    
    printf("Digite a quantidade de linhas e colunas respectivamente: \n");
    scanf("%d%d",&i,&j);

    float matriz_sistema [i][j], vet[i], val;
 

    for(x=0; x<i; x++){
        for(int y=0; y<j; y++){            
             printf("Digite o valor na posição %d%d\n",x,y);
             scanf("%f",&val);

             matriz_sistema[i][j] = val;
        }
    }
    printf("\nDigite valor de igualdade de cada linha \n");
    for(x=0; x<i;x++){
        scanf("%f",&val);
        vet[x] = val;

    }

   



}
