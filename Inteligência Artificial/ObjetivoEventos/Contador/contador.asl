/*Crença*/
cont(0).

/*Objetivos*/
!start.
!pensando.

/*Ação do objetivo/evento*/
+!start :true <- .print("Iniciei").

/*Ação do objetivo/evento*/
+!pensando : cont(I) & I<=10 <-
	.print("Pensando ", I);
	-+cont(I+1);
!pensando. //Necessário chamar o evento novamente para que entre em LOOP

/*Ação do objetivo/evento*/
+!pensando <-
.print("Sem eventos/objetivos para ser executado").
