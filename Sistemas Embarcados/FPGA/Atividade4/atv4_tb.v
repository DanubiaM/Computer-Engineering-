module atv4_tb();
	
	reg clk;
	reg [2:0]entradas;

	wire q, qnegado;	

	initial 
	begin
	   clk <= -1;
	   entradas <= -1;
	   
	  
	end
	// Realização da alteração do clock
	always #1 clk <= ~clk;
	
	//Mudança de estado do clock na onda de subida
	always @(posedge clk) entradas <= entradas+ 1;
	
	atv4 atv4_test(entradas[2],clk ,entradas[1], entradas[0], q, qnegado);
	
endmodule

