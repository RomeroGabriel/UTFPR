%option noyywrap
%{
#include <stdio.h>
%}

DIGITO			[0-9]
IDENTIFICADOR	[a-z][a-z0-9]*
DDD	            "("0?[1-9]{2}")"|0?[1-9]{2}
CELULAR         {DDD}?[0-9]{5}"-"[0-9]{4}
NUMERO	        {DDD}?[0-9]{4}"-"[0-9]{4} 
MAXIP           [0-2][0-5]?[0-5]?
IP              [0-2][0-9]?[0-9]?"."{MAXIP}"."{MAXIP}"."{MAXIP}
%%
{NUMERO}		{
				printf("Telefone: %s\n",yytext);
				return(1);	
				}
{IDENTIFICADOR}	{
				printf("Identificador: %s\n",yytext);
				return(2);	
}
{CELULAR}       {
                printf("Celular: %s\n", yytext);
                return(3);
}
{IP}            {
                printf("IP: %s\n", yytext);
                return(4);
}

[ \n\t]  			/* Ignora espaços em branco */
"."				{ return(0); }
.				/* Ignora outros caracteres */


%%
int main(int argc, char **argv){
	if(argc > 1)
		yyin = fopen(argv[1],"r");
	else
		yyin = stdin;

int ch = yylex();

while(ch != 0){
	if(ch == 2){
		printf("Ok. Token 2. ID\n\n");
	}else if(ch ==1){
		printf("Ok.Token 1. Telefone.\n\n");
	}else if (ch == 3){
        printf("Ok. Token 3. Celular\n\n");
    }else if (ch == 4){
        printf("OK. TOKEN 4. IP:\n\n");
    }
	ch = yylex();	
}
}
