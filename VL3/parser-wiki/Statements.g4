// Statements.g4
// siehe https://en.wikipedia.org/wiki/Bottom-up_parsing

grammar Statements;

statements : stmt (';' stmt)* ;
stmt : assign ;
assign : var '=' sums ;
sums : products ('+' products)* ;
products : value ('*' value)* ;
value : var | Digit ;
var : Var ;

Var : [A-Z] ;
Digit : [0-9] ;
WS : [ \n\r\t] -> skip ;

