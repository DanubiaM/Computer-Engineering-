/*
    *Título: Método Gauss-Seidel
    *Objetivo: Calcular os valores das incógnitas de um sistema linear através do método iterativo Gauss-Seidel. A sua grande diferença é dada na atualização da ingónita a cada iteração.
    *Por: Danubia Macedo
    *Data: 20-10-2020
*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int i,j;

void gauss_seidel (float matriz[i][j], float vetor[i]);

int main(){

  /*------------------------> Leitura da quantidade de linhas e colunas <------------*/  

    printf("Digite a quantidade de linhas e colunas respectivamente: \n");
    scanf("%d%d",&i,&j);

    if(i!=j) {                                          // Requisito.
        printf("A Matriz deve ser QUADRADA! ERRO\n");
        return 0; 
    }

    float matriz_sistema [i][j], vet[i], val;
 
 /*-------------------------> Leitura dos valores da matriz <------------------------*/  
    for(int x=0; x<i; x++){
        for(int y=0; y<j; y++){            
             printf("Digite o valor na posição %d%d\n",x,y);
             scanf("%f",&val);  
             matriz_sistema[x][y] = val;   
        }
    }
    printf("\nDigite o valor do vetor igualdade \n");
    for(int x=0; x<i; x++){
        scanf("%f",&vet[x]);
    }

    /*----> Chamada da função <----*/  
    gauss_seidel(matriz_sistema, vet);

}

void gauss_seidel(float matriz[i][j], float vetor[i]){
    float u[j], precisao, precisao_atual,u_antes, soma;
    int cont =0;

/*------------------------> Leitura dos chutes iniciais e precisão <------------*/  
    printf("Digite os  chute iniciais de u1, u2 e u3 respectivamente\n");
    for(int x = 0; x<j; x++){
        scanf("%f",&u[x]);
    }

    printf("Digite o valor da precisão\n");
    scanf("%f", &precisao);

/*------------------------> Lógica do Método  <-----------------------*/  
    do{
      for(int x=0; x<i; x++){
          u_antes=u[x];                             // guarda-se o valor de u antes de se obter o novo valor para poder calcular a precisão
          soma=0;
          for(int y = 0; y<j; y++){             
              if(x!=y){                             // se w!=b logo corresponde aos valores que não estão na diagonal principal                               
                  soma = soma + matriz[x][y]*u[y]; // entao, esses valores devem ser somados
              }
          }
          u[x]= (vetor[x] - soma)/matriz[x][x]; 
          precisao_atual= fabs(u[x] - u_antes);
         
      };
      cont++;
    }while(precisao_atual > precisao);             
    
/*------------------------> Impressão dos resultados  <-----------------------*/ 
    printf("\n Após %d iterações, obtivemos os valores: \n", cont);       
    for(int x=0; x < i; x++){ 
        printf("\nX%d = %.4f\n",x,u[x]);
    }
}

