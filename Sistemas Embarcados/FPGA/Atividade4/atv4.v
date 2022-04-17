/*
	Author: Danubia Macedo
	Date: 17/04/22
	Meta: Flip Flop Type D
*/

module atv4(d, clk, clr, pr, q, qnegado);
	input d, clk, clr, pr;

	output q, qnegado;

	wire w1, w2, w3, w4, w5, w6;

	//Nand
	assign w1 = ~(d & clk);

	//Nand
	assign w2 = ~(~d & clk);

	//Nand
	assign w3 = ~(w1 & w4 & pr);

	//Nand
	assign w4 = ~(w2 & w3 & clr);

	//Nand
	assign w5 = ~(w3 & ~clk );

	//Nand
	assign w6 = ~(w4 & ~clk);
	
	//Nand
	assign q = ~(qnegado & w5 & pr);

	//Nand
	assign qnegado = ~(q & w6 & clr);

endmodule
