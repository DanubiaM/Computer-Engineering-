/*
    *Título: Método Gauss-Seidel
    *Objetivo: Calcular os valores das incógnitas de um sistema linear através do método iterativo Gauss-Seidel. A sua grande diferença é dada na atualização da ingónita a cada iteração.
    *Por: Danubia Macedo.
    *Data: 20-10-2020
*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int i,j;

void gauss_seidel (float matriz[i][j], float vetor[i], float u[i], float precisao);

int main(){

  /*------------------------> Leitura da quantidade de linhas e colunas <------------*/  
    printf("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
    printf("\t\t\tCALCULO DE SISTEMAS LINEARES\t\t\t\n\n");
    printf("Digite a quantidade de linhas e colunas respectivamente: \n");
    scanf("%d%d",&i,&j);

    if(i!=j) {                                          // Requisito.
        printf("A Matriz deve ser QUADRADA! ERRO\n");
        return 0; 
    }

    float matriz_sistema [i][j], vet[i], val, u[i], precisao;
 
 /*-------------------------> Leitura dos valores da matriz <------------------------*/  
    for(int x=0; x<i; x++){
        for(int y=0; y<j; y++){            
             printf("Digite o valor na posição %d%d\n",x+1,y+1);
             scanf("%f",&val);  
             matriz_sistema[x][y] = val;   
        }
    }
    printf("\nDigite o valor de termos independentes \n");
    for(int x=0; x<i; x++){
        scanf("%f",&vet[x]);
    }

    /*------------------------> Leitura dos chutes iniciais e precisão <------------*/  
    printf("Digite %d  chutes iniciais\n", i);
    for(int x = 0; x<j; x++){
        printf("%dº valor: \n",x+1);
        scanf("%f",&u[x]);
    };

    printf("Digite o valor da precisão\n");
    scanf("%f", &precisao);


    /*----> Chamada da função <----*/  
    gauss_seidel(matriz_sistema, vet, u, precisao);

}

void gauss_seidel (float matriz[i][j], float vetor[i], float u[i], float precisao){
    double precisao_atual,u_antes, soma, erro_abs[i], max_e, max_u;
    int cont =0,x,y;

/*------------------------> Lógica do Método  <-----------------------*/  
    do{

      for( x = 0; x<i; x++){
          u_antes=u[x];                             // guarda-se o valor de u antes de se obter o novo valor para poder calcular a precisão
          soma=0;
          for( y = 0; y<j; y++){             
              if(x!=y){                             // se w!=b logo corresponde aos valores que não estão na diagonal principal                               
                  soma = soma + matriz[x][y]*u[y]; // entao, esses valores devem ser somados
              }
          }

          /*--->> CALCULO DO VETOR RESULTANTE E DO ERRO ABOSOLUTO <<------------*/
          u[x]= (vetor[x] - soma)/matriz[x][x]; 
          erro_abs[x] = fabs(u[x]-u_antes); // Calculo do erro absoluto

        
        /* --------------->Seleciona o maior valor contido no erro e no vetor resultante <--------------- */
          if(x==0) {
            max_e = erro_abs[x];
            max_u = fabs(u[x]);
          }  
          if( max_e < erro_abs[x]) max_e = erro_abs[x];
          if( max_u< fabs(u[x])) max_u = fabs(u[x]); 
          
      }             
      cont++;
      precisao_atual = max_e/max_u;   
    }while(precisao_atual > precisao );             
   
/*------------------------> Impressão dos resultados  <-----------------------*/ 
    printf("\n Após %d iterações, obtivemos os valores: \n", cont);       
    for(int x=0; x < i; x++){ 
        printf("\nX%d = %f\n",x+1,u[x]);
    }
}

