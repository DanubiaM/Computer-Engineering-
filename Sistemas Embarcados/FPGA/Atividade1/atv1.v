
module atv1(a, b, c, d, s);
	//Entradas
	input a, b, c, d;

	//Saídas
	output s;

	//Fios
	wire w1, w2;

	//Xor negada A
	assign w1 = ~a ^ b;
       
	//Nand 
	assign w2 = ~(w1 & c);

	//And
        assign s =  w2 & d;

endmodule