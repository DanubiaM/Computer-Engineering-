
%Fechar todas as janelas da execução anterior.
close all;
%Limpar o prompt de comando.
clc;
%Limpar todas as variáveis.
clear all;

#Tamanho da kernel
S=3;
T=3;
#Constantes
a=((S-1)/2);
b=((T-1)/2);
d = 5 % Constante para filtro de alfa cortada.


[arq cam] = uigetfile(); #Abrir arquivo
f= imread(strcat(cam,arq));#Importar imagem
f = rgb2gray(f);
[M N] = size(f);
fz = zeros(M,N);


A = size(w,1);
k = A-((A-1)/2);
a = (A-1)/2;
Iaux = zeros(M+A-1,N+A-1);
g = Iaux;
Iaux(k:M+a,k:N+a) = f;


for (x=k:1:N+a)
  for (y=k:1:M+a)
    soma=0;
    for(s=-1:1:1)
      for(t=-1:1:1)
          %Aplica-se correlação
         soma += Iaux(y+s,x+t) * w(k+s,k+t);
       endfor
     endfor
     g(y,x)=soma;
  endfor
endfor
