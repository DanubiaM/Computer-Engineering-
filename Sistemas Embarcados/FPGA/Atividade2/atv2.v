module atv2(x, y, cin, a, cout);
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
