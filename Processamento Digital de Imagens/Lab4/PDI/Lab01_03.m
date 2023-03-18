%Imagens Aleatorias
%Fechar todas as janelas da execu�c~ao anterior.
close all;
%Limpar o prompt de comando.
clc;
%Limpar todas as vari�aveis.
clear all;

m = [1 5 15 1 0;14 12 10 8 2; 12 10 14 7 7; 8 9 0 10 11]
x=1
y=1
v=0
i=1
j=1
aux=0

for(x=1:1:4)
  for(y=1:1:5)
    v(i)=m(x,y)
    i++
  endfor
endfor
for(i=1:1:20)
  for(j=1:1:20)
    if(v(i)<v(j))
      aux=v(i)
      v(i)=v(j)
      v(j)=aux
    endif
  endfor
endfor
c=0
moda=0
for(i=1:1:20)
  aux=v(i)
  cont=0
  for(j=1:1:20)
    if(aux==v(j))
    cont++
    endif
    if(cont>c)
    c=cont
    moda=aux
    endif
  endfor
endfor
aux=0
for(i=1:1:20)
  aux += v(i)
endfor
media = aux/i
mediana = (v((i/2)+1)+v(i/2))/2
dp=sqrt(m-media)
