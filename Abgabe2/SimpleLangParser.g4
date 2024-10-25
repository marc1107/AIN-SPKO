parser grammar SimpleLangParser;

options { tokenVocab = SimpleLangLexer; }

// Startregel
program: statement+;

// Anweisungen können Variablendeklarationen, Druckanweisungen oder Kontrollflussanweisungen sein
statement:
    declaration
    | printStatement
    | ifStatement
    ;

// Variablendeklaration
declaration: LET ID ASSIGN expression SEMI;

// Druckanweisung
printStatement: PRINT LPAREN expression RPAREN SEMI;

// If-Anweisung mit optionalem else-Zweig
ifStatement: IF LPAREN expression RPAREN LBRACE statement+ RBRACE (ELSE LBRACE statement+ RBRACE)?;

// Ausdrücke können Zahlen, Bezeichner oder arithmetische Ausdrücke sein
expression:
    ID
    | NUMBER
    | expression PLUS expression
    | expression MINUS expression
    | expression STAR expression
    | expression SLASH expression
    ;

// Vergleichsausdrücke
comparison:
    expression (EQ | NEQ | LT | GT | LE | GE) expression
    ;