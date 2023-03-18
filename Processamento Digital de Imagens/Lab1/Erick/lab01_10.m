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

a=2;
b=2;
subplot(a,b,1)
imshow(I,[])
title("Entrada");
subplot(a,b,2)
stem(H)
title("Histograma")