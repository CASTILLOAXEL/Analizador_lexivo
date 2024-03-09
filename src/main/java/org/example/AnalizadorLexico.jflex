%{
package com.example; // Reemplaza esto con el paquete de tu aplicación
import java.io.IOException;
%}

// Definición de tokens
%class Lexer
%unicode
%public
%type Token
%cup

%token ID         { <ID> }
%token NUM        { <NUM> }
%token OPER       { <OPER> }
%token ASSIGN     { <ASSIGN> }
%token REL_OP     { <REL_OP> }
%token SYMBOL     { <SYMBOL> }
%token STRING     { <STRING> }
%token RESERVED   { <RESERVED> }

// Ignorar espacios en blanco y saltos de línea
%ignore [ \t\r\n]

// Definición de reglas
%%
[a-zA-Z][a-zA-Z0-9]{0,14}    { return new Token(sym.ID, yytext()); }
[0-9]|[1-9][0-9]|100          { return new Token(sym.NUM, yytext()); }
"+"|"-"|"*"|"/"               { return new Token(sym.OPER, yytext()); }
":="                          { return new Token(sym.ASSIGN, yytext()); }
">="|"<="|">"|"<"|"="|"<>"    { return new Token(sym.REL_OP, yytext()); }
"{"|"}"|"["|"]"|"("|")"|","|";"|".." { return new Token(sym.SYMBOL, yytext()); }
("b"|"f"|"h"|"j"|"k")+        { return new Token(sym.STRING, yytext()); }
"if"                         { return new Token(sym.RESERVED, yytext()); }
"else"                       { return new Token(sym.RESERVED, yytext()); }
"for"                        { return new Token(sym.RESERVED, yytext()); }
"print"                      { return new Token(sym.RESERVED, yytext()); }
"int"                        { return new Token(sym.RESERVED, yytext()); }
.                            { System.err.println("Caracter no reconocido: " + yytext()); }
%%

// Código Java adicional, si es necesario