%option noyywrap
%{
#include <stdio.h>
#define	S_NUMERO	1
#define	S_IDENTIFICADOR	2
#define	S_CPF		3
#define	S_IP		4
#define	S_PR		5
#define S_SP		6
#define	NULO		0
%}

DIGITO			[0-9]
IDENTIFICADOR		[a-z][a-z0-9]*
DDD			0?[1-9]{2}|"("0?[1-9]{2}")"
NUMERO			{DDD}?9?[0-9]{4}"-"[0-9]{4}
CPF			[0-9]{3}"."[0-9]{3}"."[0-9]{3}"-"[0-9]{2}

SEC			[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]
IP			{SEC}"."{SEC}"."{SEC}"."{SEC}

PRLETRA		A[A-Z][A-Z]|B[A-E][A-Z]
SPLETRA		B[F-Z][A-Z]|[C-F][A-Z][A-Z]|G[A-J][A-Z]|GK[A-I]
PR		{PRLETRA}"-"[0-9]{4}
SP		{SPLETRA}"-"[0-9]{4}
%%

{NUMERO}		{
			printf("Telefone:%s\n",yytext);
			return(S_NUMERO);	
			}

{IDENTIFICADOR}		{
			printf("\tIdentificador:%s\n",yytext);
			return(S_IDENTIFICADOR);	
			}
{IP}			{
			printf("\tIP:%s\n",yytext);
			return(S_IP);
			}
{CPF}			{
			printf("\tCPF:%s\n",yytext);
			return(S_CPF);
			}
{PR}			{
			printf("\tPlaca do PR. Não multar.\n");
			return(S_PR);
			}
{SP}			{
			printf("\tPlaca de SP. Multar.\n");
			return(S_SP);
			}
[ \n\t]  		/* Ignora espaços em branco*/

"."			{
			return(NULO);
			}
<<EOF>>			{
			return(NULO);
			}

.			/* ignora outros caracteres */


%%
int main(int argc, char **argv){
	if(argc > 1)
		yyin = fopen(argv[1],"r");
	else
		yyin = stdin;

	int token = yylex();

	while(token != 0){
		if(token == 2){
			printf("OK. TOKEN 2. ID.\n");
		}else if(token ==1){
			printf("OK. TOKEN 1. TELEFONE.\n");
		}

		token = yylex();	
	}
}
