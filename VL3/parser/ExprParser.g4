// ExprParser.g4
parser grammar ExprParser;

options { tokenVocab=ExprLexer; }

expr
    : multExpr
    | expr (PLUS | MINUS) multExpr
    ;

multExpr
    : primary
    | multExpr (MUL | DIV) primary
    ;

primary
    : LPAREN expr RPAREN
    | value
    ;

value
    : (PLUS | MINUS)? Number
    ;

