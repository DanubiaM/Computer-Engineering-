/*
    *Título: Método de Newton-Raphson
    *Objetivo: Encontrar o valor da raiz de f(x) = e^(-x) -1 utilizando o método iterativo de Newton-Raphson.
    *Por: Danubia Macedo
    *Data: 21-10-2020
*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define e 2.7182818284590452353602874

/*                              PASSOS
    *Tenha uma função, estipule um chute inicial (x0) e uma precisao
    *derive a função
    *substitua na formula xn+1 =xn (fx)/(fx') 
    *o erro a cada iteração deve ser = |xn+1 - xn|
    *Obs.: Esse algoritmo não leva em consideração intervalos da raiz, apenas um chute inicial da raiz.
*/
float calculo_funcoes(float xn);
float newton_r(float x0, float erro);

int main(){

    float valor, estimativa_erro;

    printf("Digite o valor inicial x0: \n");
    scanf("%f", &valor);
    printf("\n Digite a estimativa de erro: \n");
    scanf("%f", &estimativa_erro);

    /* -----------> Chamada da função <------------ */
    printf("O valor da raiz aproximada é: %.4f  \n",newton_r(valor, estimativa_erro));

}
float newton_r(float x0, float erro){
    float precisao, x, xn;
    int i =0;

    xn =  x0;                           // Xn recebe o chute inicial
 
    do{
       i++;
       x = xn;                          // X recebe o Xn 
       xn = calculo_funcoes(xn);        // Xn recebe o resultado da conta  
       precisao =fabs(xn - x);               // logo a precisao vai ser xn - x
       
    }while(precisao > erro);            // ira repetir enquanto a precisao for maior que o erro aceitavel.


    printf("Após %d iterações obtivemos o resultado.\n", i);

    return xn;

}

float calculo_funcoes(float xn){
    /* --------------------> Definição da função, sua derivada e os calculos a serem realizados <-----------------*/
    //funcao e^(-x) -x   -> fx' = -e^(-x) -1
    //formula -> xn - (Fx)/(F'x)
    float val_funcao, val_derivada,resultado;

    val_funcao = (pow(e,-xn) -xn);
    val_derivada = (-pow(e,-xn) -1);

    resultado = xn - (val_funcao/val_derivada);
   
    return resultado;

}

