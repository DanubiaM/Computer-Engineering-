/*Cren�a*/
cont(0).

/*Objetivos*/
!start.
!pensando.

/*A��o do objetivo/evento*/
+!start :true <- .print("Iniciei").

/*A��o do objetivo/evento*/
+!pensando : cont(I) & I<=10 <-
	.print("Pensando ", I);
	-+cont(I+1);
!pensando. //Necess�rio chamar o evento novamente para que entre em LOOP

/*A��o do objetivo/evento*/
+!pensando <-
.print("Sem eventos/objetivos para ser executado").
