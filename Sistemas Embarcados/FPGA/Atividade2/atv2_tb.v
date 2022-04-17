module atv2_tb();
	
	reg clk;
	reg[2:0] entradas;

	wire a, cout;


	initial 
	begin
	   clk <= -1;
	   entradas <= -1;
	end
	// Realiza��o da altera��o do clock
	always #1 clk <= ~clk;
	
	//Mudan�a de estado do clock na onda de subida
	always @(posedge clk) entradas <= entradas + 1;

	
	atv2 atv2_test(entradas[2], entradas[1], entradas[0], a, cout);


endmodule
