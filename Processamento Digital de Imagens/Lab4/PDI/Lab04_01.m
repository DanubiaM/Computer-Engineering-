# Atividade 01 do Laboratório 04
clc;clear all;close;

S=3;
T=3;
a=((S-1)/2);
b=((T-1)/2);

Q=1;

[arq cam] = uigetfile();    #Abrir arquivo
f= imread(strcat(cam,arq)); #Importar imagem
f = rgb2gray(f);            #Definindo em escala de cinza;
[M N] = size(f);


g1=zeros(M,N);
g2=ones(M,N);
g3=ones(M,N);
g4=ones(M,N);

t0 = time;

#Realizando somatórias
for(m=((S+1)/2):1:M-((S-1)/2))
  for(n=((T+1)/2):1:N-((T-1)/2))
    for(s=-a:1:a)
      for(t=-b:1:b)
        p1=(f(m+s,n+t).^(Q+1));
        p2=(f(m+s,n+t).^Q);
        g4(m,n)+=p1/p2;
        g3(m,n)+=1/f(m+s,n+t);
        g2(m,n)*=f(m+s,n+t);
        g1(m,n)+=f(m+s,n+t);
      endfor
    endfor
  endfor
endfor

#Resultado final média Aritimética
g1*=(1/S*T)
a=1/(S*T);
#Resultado final média Geométrica
g2=g2.^a;
#Resultado final média Harmonica
g3=(S*T)./g3;

time-t0

#Imprimindo imagens
subplot(2,3,1);imshow(f,[]);
subplot(2,3,2);imshow(g1,[]);
subplot(2,3,3);imshow(g2,[]);
subplot(2,3,4);imshow(g3,[]);
subplot(2,3,5);imshow(g4,[]);

#Realizando conversão para valores entre 0 e 255
g2 = uint8((g2/max(max(g2)))*255);

g3 = uint8((g3/max(max(g3)))*255);

#Salvando imagens
imwrite(uint8(g1),"F1MediaAritmetica.png");
imwrite(g2,"F1MediaGeometrica.png");
imwrite(g3,"F1MediaHarmonica.png");
imwrite(uint8(g4),"F1MediaContraHarmonica.png");


