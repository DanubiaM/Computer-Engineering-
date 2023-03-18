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



f =[1 5 15 1 0;
    14 12 10 8 2;
    12 10 14 7 7;
    8 9 0 10 11]
[M N] = size(f)
fz = zeros(M,N);
w = [0,1,0;
     1,1,1;
     0,1,0];



A = size(w,1);
k = A-((A-1)/2);
a = (A-1)/2
Iaux = zeros(M+A-1,N+A-1);
g = Iaux

Iaux(k:M+a,k:N+a) = f;   #Adicionado borda na imagem
vet = 0;
i = 1;
g1 = zeros(M,N-1)
maximo = 0;
minimo = 0;
N+a
M+a

for (x=k:1:N+a)
  for (y=k:1:M+a)
    for(s=-1:1:1)
      for(t=-1:1:1)
          #Cria um vetor com os valores que a kernel pegou
         v(i)=Iaux(y+s,x+t) * w(k+s,k+t); #Kernel
         i++;
       endfor
     endfor
          v
         #Ordena o vetor
         [vl vc] = size(v)
          i =0;
          j= 0;

         for(i=1:1:9)
          for(j=1:1:9)
            if(v(i)<v(j))
              aux=v(i);
              v(i)=v(j);
              v(j)=aux;
            endif
          endfor
        endfor
        v
        mediana = (v((10/2)+1)+v(10/2))/2
        g1(x-1,y-1) = mediana;

        maximo = max(max(v))
        minimo = min(min(v))


  endfor
endfor
g1

