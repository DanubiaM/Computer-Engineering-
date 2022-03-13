
/*Crença*/
aberta(porta).

/* Plans */

+aberta(porta)
/*Ação do bloco Inicio <- Fim .*/
<-.print("Porta aberta. Vou fechar!!!");
-aberta(porta);
+~aberta(porta);
//+fechada(porta);
.print("Porta Fechada ...").



