%�O octave realiza uma c�pia de uma imagem especificada, para isso usa-se imread.

close all;
clc;
%Imagem bin�ria
Ibin = imread('binImage.png');

%Imagem monocrom�tica
Imono = imread('monoImage.jpg');

%Imagem colorida RGB
Irgb = imread('rgbImage.jpg');

 
%Imprimindo conteudo na tela
Ibin;
Imono;
Irgb;

%Dimensao das imagens 
size(Ibin)
size(Imono)
size(Irgb)
%subplot(x,y,z) onde x e  y � a Matriz M x N (2 x 2)
%z Gr�fico de uma posicao no intervalo de 1 a M.N ( das 4 posicoes pode escolher 
% de 1 a 4)
%imshow mostra uma imagem da matriz informada no parametro,sendo o colchete o
% intervalo de exibicao
imshow(Ibin,[]);
subplot(2,2,2);
imshow(Imono,[]);
subplot(2,2,3);
imshow(Irgb,[]);
subplot(2,2,3);

