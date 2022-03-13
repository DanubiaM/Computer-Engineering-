// Agent agentecont in project ProjetoContador.mas2j

/* Initial beliefs and rules */
cont(0).
/* Initial goals */
!start.
!contar.
/* Plans */
+!start : true <- .print("Iniciei").
+!contar: cont(I) & I<=10
<-
.print("Contando...", I ," hmmm...");
-+cont(I+1);
!contar.

//Tratamento erros...
-!contar <- .print("Sem eventos para executar...").

