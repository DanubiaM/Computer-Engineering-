clc;
clear all;

I = [1 5 15 1 0;14 12 10 8 2; 12 10 14 7 7; 8 9 0 10 11];
[M N] = size(I);
Q=M*N;
k=4;
q=2^k;
L=0:q-1;
h=zeros(1,q);
Hlinha=h;

for(l=1:q)
  for(m=1:M)
    for(n=1:N)
      if(I(m,n)==L(l))
        h(l)++;
      endif
    endfor
  endfor
endfor
H=h;
k=1/Q
Hlinha=k*H;

a=2;
b=2;
subplot(a,b,1)
imshow(I,[])
title("Entrada");
subplot(a,b,2)
stem(H)
title("Histograma")
subplot(a,b,3)
stem(Hlinha)
title("Histograma normalizado")
%Professor no dia 08/09/2022 Disse que poderiamos entregar o codigo dessa forma.