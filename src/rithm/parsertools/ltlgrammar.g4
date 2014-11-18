grammar ltlgrammar;
options {

}
@header {
	package rithm.parsertools;
	import java.util.HashMap;
}
@members 
{
	
}
/* A number: can be an integer value, or a decimal value */
ltl: Pred 
	| '(' ltl ')' 
	| ltl Binary ltl
	| Unary ltl
	| ltl WS;
Pred: [a-z]+ | 'T' | 'F';
Unary : '<>' | '[]'| '!';
Binary: 'U' | 'W' | '&&' | '||' | '->' | '<->';
WS : [ \t\r\n]+ -> skip ;