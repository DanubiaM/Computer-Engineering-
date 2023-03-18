# Atividade 02 do Laboratório 04

clc;clear all;close;

S=3;
T=3;
a=((S-1)/2);
b=((T-1)/2);

Q=1;

[arq cam] = uigetfile(); #Abrir arquivo
f= imread(strcat(cam,arq));#Importar imagem
f = rgb2gray(f);
[M N] = size(f);
g1=zeros(M,N);
g2=ones(M,N);
g3=ones(M,N);
g4=ones(M,N);

t0 = time;

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
g1*=(1/S*T)
a=1/(S*T);
g2=g2.^a;
g3=(S*T)./g3;
time-t0;

g1 = uint8((g1/max(max(g1)))*255);
g2 = uint8((g2/max(max(g2)))*255);
g3 = uint8((g3/max(max(g3)))*255);
g4 = uint8((g4/max(max(g4)))*255);


#Calculando a diferença
gd1 = f - g1;
gd2 = f - g2;
gd3 = f - g3;
gd4 = f - g4;

subplot(2,3,1);imshow(f,[]);
subplot(2,3,2);imshow(gd1,[]);
subplot(2,3,3);imshow(gd2,[]);
subplot(2,3,4);imshow(gd3,[]);
subplot(2,3,5);imshow(gd4,[]);

imwrite(uint8(gd1),"F2DifMediaAritmetica.png");
imwrite(gd2,"F2DifMediaGeometrica.png");
imwrite(gd3,"F2DifMediaHarmonica.png");
imwrite(uint8(gd4),"F2DifMediaContraHarmonica.png");


