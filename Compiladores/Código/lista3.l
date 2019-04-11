%option noyywrap
%{
#include <stdio.h>
#define     P1     1
#define     P2     2
#define     P3     3
%}

TESTE               teste
NUMERO              [0-9]
LETRA               [a-z]
QUALQUERCARACTER    [!-~]
NDIGITOS            [1-4]*
HEXA                [1-9]|[a-f]
LETRAS2             [a-z]?
LETRAS3             [a-f]|[k-p]                
PADRAO1             {TESTE}{NUMERO}{NUMERO}?{NUMERO}?{QUALQUERCARACTER}{LETRA}{5}
PADRAO2             {LETRAS3}{NDIGITOS}?"."[a-z][a-z]{LETRAS2}{3}
PADRAO3             0x{HEXA}{HEXA}*
%%

{PADRAO1}   {
                printf("Padrao 01: %s\n", yytext);    
                return (P1);     
            }

{PADRAO2}   {
                printf("Padrao 02: %s\n", yytext);
                return (P2);
            }

{PADRAO3}   {
                printf("Padrao 03: %s\n", yytext);
                return (P3);
            }

[ \n\t]        { /*FAZ NADA COM NOVA LINHA*/}

<<EOF>>     {
                return(0);
            }
.			/* ignora outros caracteres */

%%

int main(int argc, char **argv){
    if(argc > 1)
        yyin = fopen(argv[1], "r");
    else
        yyin = stdin;

    int token = yylex();

    while (token != 0){
        if(token == 1){
            printf("PADRAO 01\n\n");
        } else if (token == 2){
            printf("PADRAO O2\n\n");
        } else if (token == 3){
            printf("PADRAO O3\n\n");
        }

        token = yylex();
    }
}
