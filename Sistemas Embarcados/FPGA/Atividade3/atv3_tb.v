module atv3_tb();
	
	reg clk;
	reg[2:0] entradas;

	wire r0, r1, r2, r3, cout0, cout1, cout2, cout3;


	initial 
	begin
	   clk <= -1;
	   entradas <= -1;
	end
	// Realização da alteração do clock
	always #1 clk <= ~clk;
	
	//Mudança de estado do clock na onda de subida
	always @(posedge clk) entradas <= entradas + 1;

	
	atv3 atv3_firstBlock(entradas[2], entradas[1], 0, r0, cout0);
	atv3 atv3_SecondBlock(entradas[2], entradas[1], cout0, r1, cout1);
	atv3 atv3_ThirdBlock(entradas[2], entradas[1], cout1, r2, cout2);
	atv3 atv3_FourthBlock(entradas[2], entradas[1], cout2, r3, cout3);


endmodule
