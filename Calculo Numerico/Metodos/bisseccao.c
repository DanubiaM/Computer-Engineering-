/*
    *Title: Bisection Method
    *Date: 01-10-2020
    *by: Danubia Macedo
*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define e 2.7182818284590452353602874

float calculo_da_funcao(float r);
float bisseccao(float xi, float xu, float tol_erro, float it);
int main(){
    float xi, xu, tol_erro, it,raiz;

    printf("Digite o numero de itarações que deseja: \n");
    scanf("%f", &it);
    printf("\n Digite o intervalo inferior: \n");
    scanf("%f", &xi);
    printf("\n Digite o intervalo superior: \n");
    scanf("%f", &xu);
    printf("Digite o valor da tolerancia de erro: \n");
    scanf("%f", &tol_erro);
    

    if(calculo_da_funcao(xi)*calculo_da_funcao(xu)>0){ //passo 1
        return 0;
    }
    raiz = bisseccao(xi,xu,tol_erro,it);
    printf("O valor da raiz encontrada é: %.4f", raiz);

}
float calculo_da_funcao(float r){
    float result, cosseno, euler, resultado;

    result = sqrt(2000 - pow((r/10),2));

    cosseno = cos(result * 0.05);
    euler = pow(e, ((r*-0.05)/10));

    resultado = (euler*cosseno) - 0.01;
    return resultado;


}
float bisseccao(float xi, float xu, float tol_erro, float it){
    float xr, f_xu, f_xi, f_xr, produto, i, tol_atual;
    i=1;    

    f_xi= calculo_da_funcao(xi);

    while(i<=it){
        
        xr=(xi+xu)/2; //passo 2

        f_xr= calculo_da_funcao(xr); //passo 3
       
       
        if(f_xi*f_xr < 0){
            xu=xr;
        }
        if(f_xi*f_xr > 0 ){
            xi=xr;
        }
        if((f_xr > (tol_erro *-1) && f_xr < tol_erro) || ((xu-xi)/2) < tol_erro){
            printf("Numero de iterações: %.1f", i);
            return xr;
        }

        i++;
    }

    return -1;

}

