
//Declara objetivo
!imprime_fatorial (5).

//A��o objetivo
+!imprime_fatorial(N): true
<- 	
	!fatorial(N,F);
	.print("Fatorial de ", N," � ",F).
//Se N igual a 0, F = 1.
+!fatorial(N,1) : N == 0.

+!fatorial (N,F) : N > 0
	<- !fatorial(N-1, F1);
	F = F1 * N.
