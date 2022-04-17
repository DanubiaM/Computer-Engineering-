module atv4_tb();
	
	reg clk;
	reg [2:0]entradas;

	wire q, qnegado;	

	initial 
	begin
	   clk <= -1;
	   entradas <= -1;
	   
	  
	end
	// Realiza��o da altera��o do clock
	always #1 clk <= ~clk;
	
	//Mudan�a de estado do clock na onda de subida
	always @(posedge clk) entradas <= entradas+ 1;
	
	atv4 atv4_test(entradas[2],clk ,entradas[1], entradas[0], q, qnegado);
	
endmodule

