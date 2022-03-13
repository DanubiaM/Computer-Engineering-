// Agent tabuada in project Tabuada.mas2j

!tab(0,10).

+!tab(X,Y): (X<10)
<-
	.print(X+1, " * ",Y ," = ", (X+1)*Y);
	!tab(X+1, Y).
	
	
+!tab(X,Y)
<- .print("SEM EVENTOS").
