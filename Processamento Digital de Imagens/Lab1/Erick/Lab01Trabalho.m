%Fechar todas as janelas da execu¸c~ao anterior.
close all;
%Limpar o prompt de comando.
clc;
%Limpar todas as vari´aveis.
clear all;
M=180;
N=320;
%Imagens Aleatorias
%Fechar todas as janelas da execu¸cão anterior.
close all;
%Limpar o prompt de comando.
clc;
%Limpar todas as vari´aveis.
clear all;

M=180;
N=320;

Ibin = randi([0 1],M,N)*255;

imwrite(Ibin,"Resultado2.png");

[arq, cam, ind] = uigetfile({"*.png;*.jpg","Tipos de arquivos suportados pelo sistema:"},"Selecionar Imagem Binaria","ImagemBinaria.ext","MultiSelect","off");
Ibin =  imread(strcat(cam, arq));
caminho = strcat(cam,arq)

subplot(1,1,1);
imshow(uint8(Ibin*255),[]);
