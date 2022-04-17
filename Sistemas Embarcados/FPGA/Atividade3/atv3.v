/*
	Author: Danubia Macedo
	Date: 17/04/22
	Meta: Somador completo de 4 bits
*/

module atv3(x, y, cin, a, cout);
	input x, y, cin;
	output a, cout;
	wire p, r, s;

	//Xor
	assign p = x ^ y;
        
	//Xor
	assign a =p ^ cin;

	//And 
        assign r =  p & cin;

	//And
	assign s = x & y;

	//Or
	assign cout = r | s;

endmodule
