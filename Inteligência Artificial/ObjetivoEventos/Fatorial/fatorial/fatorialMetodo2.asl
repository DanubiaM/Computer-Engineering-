/*Objetivo*/
!fat(0,1).

/*Plano*/
+!fat(x,y): X < 10
<- !fat(X+1, (X+1)*Y).

+!fat(X,Y) : X== 10
<- .print("fatorial ", X," == ", Y).


