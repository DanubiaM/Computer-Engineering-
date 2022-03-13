
/*Crença*/
fechada(porta).

/*Planos*/

+fechada(porta)
/*Ação do bloco Inicio <- Fim .*/
<-.print("Porta Fechada.Vou abrir!!!!");
-fechada(porta);
+~fechada(porta);
//+aberta(porta);
.print("Porta Aberta").


