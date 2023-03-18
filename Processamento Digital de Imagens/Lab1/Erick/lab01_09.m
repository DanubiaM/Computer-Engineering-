%Imagens Aleatorias
%Fechar todas as janelas da execu¸c~ao anterior.
close all;
%Limpar o prompt de comando.
clc;
%Limpar todas as vari´aveis.
clear all;


I = [1 5 15 1 0;14 12 10 8 2; 12 10 14 7 7; 8 9 0 10 11];
[M N] = size(I);

T = [0 1 0;1 -4 1; 0 1 0];
A=size(T,1);
a=(A-1)/2;
k=A-a;
Iaux = zeros(M+A-1,N+A-1);
g=Iaux;
Iaux(k:M+a,k:N+a)=I;
t0 = time;

for(m=k:1:M+a)
for(n=k:1:N+a)
soma=0
for(t=-a:1:a)
for(s=-a:1:a)
soma+=Iaux(m-s,n-t)*T(k+s,k+t);
endfor
endfor
g(m,n)=soma;
endfor
endfor
time-t0
imwrite(g(k:M+a,k:N+a),"ResultadoLab01_07.png");
subplot(1,2,1);imshow(I,[]);
subplot(1,2,2);imshow(g(k:M+a,k:N+a),[]);