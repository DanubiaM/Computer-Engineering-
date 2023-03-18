clc
clear all
close all
S = 3;
T = 3;
f = [1,5,15,1,0;14,12,10,8,2;12,10,14,7,7;8,9,0,10,11];
[M,N] = size(f);

g = zeros(M,N);

for(m=2:1:M-1)
  for(n=2:1:N-1)
    for(s=-1:1:1)
      for(t=-1:1:1)
        g(m,n) += f(m+s, n+t);

       endfor
     endfor
  endfor
endfor


g=g/(S*T);

dif = f - g;


subplot(1,2,1);
imshow(f,[]);
subplot(1,2,2);
imshow(g,[]);
subplot(1,2,3);
imshow(dif,[]);


