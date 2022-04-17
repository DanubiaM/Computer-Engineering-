module atv1_tb();
	//registradores
	reg clk;
	reg[3:0] entradas;
	wire s;

	//Bloco inicial
	initial 
	begin
	   clk <= -1;
	   entradas <= -1;
	end
	//Alteração do registrador clock
	always #1 clk <= ~clk;

	//@posedge clk inidica clock de subida	
	always @(posedge clk) entradas <= entradas + 1;

	
	atv1 atv1_test(entradas[3], entradas[2], entradas[1], entradas[0], s);


endmodule
