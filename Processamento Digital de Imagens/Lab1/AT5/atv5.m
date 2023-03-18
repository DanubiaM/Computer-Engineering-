S = 3;
T = 3;
f = [1,5,15,1,0;14,12,10,8,2;12,10,14,7,7;8,9,0,10,11];
[M,N] = size(f);
w = [1,1,1;1,1,1;1,1,1];
g = zeros(M,N);

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

g = g(k:M+a,k:N+a)
Iaux = Iaux(k:M+a,k:N+a)
g=g/5


d = Iaux - g;



subplot(221);
imshow(f,[]);
subplot(222);
imshow(g,[]);
subplot(223);
imshow(d,[]);
