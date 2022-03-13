// Agent agenteteste in project teste.mas2j

/* Initial beliefs and rules */
fome.
/* Initial goals */
!comer.
!start.

/* Plans */

+!start  <- .print("hello world.").
+fome <- .print("Coomeeer").
+!comer <-.print("ALMOÇAAR").

